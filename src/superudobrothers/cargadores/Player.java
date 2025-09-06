package superudobrothers.cargadores;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Player
{
//Atributos
    
    private File f;
    private AudioInputStream ais;
    private FloatControl ganancia;
    private BooleanControl mute;
    private int volumen=10;
    
    private final String[] rutas = {"title.wav","overworld.wav","underground.wav","athletic.wav","clearlevel.wav","gameover.wav",
	"star.wav","playerdown.wav","click1.wav","rollover1.wav","switch1.wav","switch2.wav","aplastar.wav","bloquesolido.wav"
	,"bowsercae.wav","bowserfire.wav","fireball.wav","lowtime.wav","moneda.wav","patada.wav","pause.wav","powerup.wav"
	,"rompebloques.wav","saltogrande.wav","saltopequeno.wav","spawnpowerup.wav","spawntrepadora.wav","tuberia.wav","vidaplus.wav"};
    
    private int cantSonidos = rutas.length-1;
    private Clip[] cliq = new Clip[rutas.length];
    
        //0 Title
	//1 Overworld
	//2 Underground
	//3 Athletic
	//4 Nivel Completado
	//5 Fin del juego
	//6 PowerUP Estrella
	//7 Mario caido
	//8 Fx de clic
	//9 Fx de pasar raton por encima 1
	//10 Fx de interruptor 1
	//11 Fx de interruptor 2
        //12 Fx de Aplastar enemigo
	//13 Fx de impacto contra bloque irrompible
	//14 Fx de Bowser cayendo
	//15 Fx de Bowser atacando con fuego
	//16 Fx de bola de fuego
	//17 Poco tiempo restante
	//18 Fx de recoger moneda
	//19 Fx de patear enemigo
	//20 Pausa
	//21 Mario recibe powerup
	//22 Fx de bloque rompiendose
	//23 Fx de salto con Mario grande
	//24 Fx de salto de Mario pequeño
	//25 Fx de generacion de item powerup
	//26 Fx de generacion de planta para ser trepada
	//27 Fx de entrar en tuberia
	//28 Fx de ganar vida extra
   
//Constructor
    
    public Player()
    {
        for(int i=0; i<=cantSonidos; i++)
        {
            try
            {    
                f = new File ("recursos/audio/" + rutas[i]); //Guarda el sonido como un objeto de tipo archivo  
                ais =  AudioSystem.getAudioInputStream(f); //Guarda el archivo de musica como un AudioInputStream
                cliq[i] = AudioSystem.getClip(); //Algo relacionado a abrir mezcladores del sistema ???, es necesario
                cliq[i].open(ais); //Abre efectivamente el clip de audio, en este caso leyendo los datos binarios de un AudioInputStream  
                ais.close();
            }
            catch(IOException e)
            {
                System.out.println("Error leyendo el archivo:" + e);  
            }
            catch(LineUnavailableException e)
            {
                System.out.println("Linea de audio no disponible:" + e);  
            }
            catch(UnsupportedAudioFileException e)
            {
                System.out.println("Archivo de Audio no soportado:" + e);
            }
        }
            
        try
        {
            LectorArchivos ajustes = new LectorArchivos("ajustes.txt");
            volumen = ajustes.leer("volumen",2);
        }
        catch(Exception e)
        {
                System.out.println("Error de audio c: " + e);
                volumen = 6;
        }
    }
    
    //Metodos
    
    public int getVol()
    {
        return this.volumen;
    }
    
    public void pley(int i, int j) 
            
    //El Primer parametro indica la pista a reproducir
    //El segundo parametro indica si va a reproducir desde: 
    //El principio (0), desde donde quedó (1), en loop (2), concurrentemente (3)
            
    {
        switch(j)
        {
            //Reproduce desde 0
            
            case 0: 
            {
                try 
                {
                    cliq[i].setMicrosecondPosition(0);
                    cliq[i].start();
                }       
                catch(Exception e) 
                {
                    System.out.println("Error:" + e);
                }    
                break;
            }
            
            //Reproduce desde donde se quedó o desde donde se estableció por ultima vez
            //Cuando un clip finaliza no podra reproducirse con este metodo sin antes "rebobinarlo" con playtime
            //Sin embargo es util para reanudar reproducciones detenidas con stop(x)
            
            case 1:
            {
                try
                {
                    cliq[i].start();
                }
                catch(Exception e) 
                {
                    System.out.println("Error:" + e);
                }
                break;
            }
            
            //Reproduccion en loop
            
            case 2:
            {
                try
                {
                    cliq[i].setMicrosecondPosition(0);
                    cliq[i].loop(Clip.LOOP_CONTINUOUSLY);
                }
                catch(Exception e) 
                {
                    System.out.println("Error:" + e);
                }
                break;
            }          
            
            //Reproduccion Concurrente
            
            case 3:
            {
                try
                {
                    if(cliq[i].getMicrosecondPosition()!= 0)
                    {
                        try
                        {    
                            f = new File ("recursos/audio/" + rutas[i]); //Guarda el sonido como un objeto de tipo archivo  
                            ais =  AudioSystem.getAudioInputStream(f); //Guarda el archivo de musica como un AudioInputStream
                            cliq[i] = AudioSystem.getClip(); //Algo relacionado a abrir mezcladores del sistema, es necesario
                            cliq[i].open(ais); //Abre efectivamente el clip de audio, en este caso leyendo los datos binarios de un AudioInputStream  
                            ais.close();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error:" + e);  
                        }
                    }
                    
                    ajustarVolumen(i);
                    cliq[i].start();
                }       
                catch(Exception e)
                {
                    System.out.println("Error:" + e);
                }
                break;
            }
            
            default:
            {
                System.out.println("Parametro Invalido");
            }
        }
    }
    
    //Detiene la reproduccion
    
    public void stop(int i) 
    {
        try
        {
            cliq[i].stop();
        }
        catch(Exception e) 
        {
            System.out.println("Error:" + e);
        }
    }
    
    //Permite establecer la posicion en milisegundos de la reproduccion
    //El primer parametro recibe al clip que será establecido y el segundo la posicion en ms
    
    public void playtime(int i, int j) 
    {
        cliq[i].setMicrosecondPosition(j);
    }
    
    public void actualizar()
    {
        for(int i=0;i<=cantSonidos;i++)
        {
            ajustarVolumen(i);
        }
        
        LectorArchivos.guardarAjustes(volumen);
    }
    
    public void setVolumen(int i)
    {
        if(volumen>=0 || volumen<=10 )
        {
            volumen = i;
            this.actualizar();
        }
        else
        {
            System.out.println("Valor incorrecto, rango del 0 al 10");
        }
    } 
    
    public void ajustarVolumen(int i)
    {
        try
        {
            mute = (BooleanControl) cliq[i].getControl(BooleanControl.Type.MUTE);
            ganancia = (FloatControl) cliq[i].getControl(FloatControl.Type.MASTER_GAIN);
            ganancia.setValue((10-volumen)*-4);
            if(volumen == 0)
            {
                mute.setValue(true);
            }
            else
            {
                mute.setValue(false);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error de audio: " + e);
        }
    }
}
