package superudobrothers;

import superudobrothers.cargadores.Player;
import superudobrothers.interfazgrafica.Animador;
import superudobrothers.interfazgrafica.Ventana;
import superudobrothers.objetos.Mario;

public class Motor 
{
	//Aquí van a haber varios atributos de los que todavía no estamos seguros, puesto que esta clase manejará es script del juego, tambein se encargará de manejar el resto de clases y llamar a los metodos pertinentes cuando corresponda.
	
	private long tAnterior;
        private final int FPS;
	private int tGameOver, tNivelCompletado;
	private final Mario m;
	private Mapa mapAct;
	private static String ESTADO, SELECTM;
	private final Ventana v;
	private boolean intro, pausa, gameover, nivelCompletado;
        private final Player salidaAudio = new Player();
	
	//Constructor
	
	public Motor() 
	{
                gameover = false;
                nivelCompletado = false;
                pausa = false;
                tGameOver = 0;
                tNivelCompletado = 0;
		tAnterior = 0;
		FPS = 60;
		m = new Mario(1,-1,-1);
		mapAct = null;
		ESTADO = "Inicio";
		v = new Ventana();
		intro = true;
	}
	
	//Set y get de lo que haga falta
	
	public static void setEstado(String estado)
	{
		ESTADO = estado;
	}
	
	public static String getEstado()
	{
		return ESTADO;
	}
	
	public static void setSelectM(String mapa)
	{
		SELECTM = mapa;
	}
	
	public static String getSelectM()
	{
		return SELECTM;
	}
        
        public Mario getMario()
        {
            return m;
        }
        
        public Mapa getMapAct()
        {
            return mapAct;
        }
        
        public void pausa()
        {
            if(!gameover && !nivelCompletado)
            {
                salidaAudio.pley(20, 3);
                
                char aux[] = SELECTM.toCharArray();
                int i = Character.getNumericValue(aux[0]);
                
                if(pausa)
                {  
                    salidaAudio.pley(i, 1);
                }
                else
                {
                    salidaAudio.stop(i);
                }
                
                pausa = !pausa;
            }
        }
        
        public boolean getPausa()
        {
            return pausa;
        }
        
        public void setGameOver(boolean g)
        {
            gameover = g;
        }
        
        public boolean getGameOver()
        {
            return gameover;
        }
        
        public void setTGameOver(int t)
        {
            tGameOver = t;
        }
        
        public int getTGameOver()
        {
            return tGameOver;
        }
        
        public void setNivelCompletado(boolean nc)
        {
            nivelCompletado = nc;
        }
        
        public boolean getNivelCompletado()
        {
            return nivelCompletado;
        }
        
        public void setTNivelCompletado(int t)
        {
            tNivelCompletado = t;
        }
        
        public int getTNivelCompletado()
        {
            return tNivelCompletado;
        }
        
        public Player getAudio()
        {
            return salidaAudio;
        }
        
	//Cuando el estado del juego es cambiado, este metodo se encarga de enviarlo a a su nuevo estado.
	
	public void indiceEstado()
	{
		while(true)
		{
			switch(ESTADO)
			{
				case "Inicio":
				inicio();
				break;
				case "Menu":
				menu();
				break;
				case "Puntuacion":
				puntuacion();
				break;
				case "Configuracion":
				configuracion();
				break;
				case "SelectorNivel":
				selectorNivel();
				break;
				case "Juego":
				juego();
				break;
				case "Creditos":
				creditos();
				break;
				default:
				System.out.println("Error catastrófico del sistema satisfactoriamente completado, por favor, vuelva más tarde, si el problema persiste, decista.");
				System.exit(0);
			}
		}
	}
	
	//Metodos de estado
        
	//Intro del juego
	
	public void inicio()
	{
            if(!intro)
            {
                v.setIntro();
            }
            
		while(ESTADO.equals("Inicio"))
		{	
                    if(v.getPanel().getTiempo() == 120)
                    {
                        salidaAudio.actualizar();
                    }
                    
                    if(v.getPanel().getTiempo()>=360)
                    {
                        salidaAudio.pley(0, 2);
                        ESTADO = "Menu";
                    }
			
                    esperarFrame();
		}
		
            intro = true;
	}
	
	//Menú principal 
	
	public void menu()
	{		
		v.setMenu(intro);
		intro = false;
		
		while(ESTADO.equals("Menu"))
		{
			esperarFrame();
		}
	}
	
	//Tabla de puntuaciones
	
	public void puntuacion()
	{
		v.setPuntuacion();
		
		while(ESTADO.equals("Puntuacion"))
		{
			esperarFrame();
		}
	}
	
	//Configuracion
	
	public void configuracion()
	{
		v.setConfiguracion();
		
		while(ESTADO.equals("Configuracion"))
		{
			esperarFrame();
		}
	}
	
	//Selector nivel
	
	public void selectorNivel()
	{
		v.setSelectorNivel();
		
		while(ESTADO.equals("SelectorNivel"))
		{
			esperarFrame();
		}
	}
	
	//Seccion de la parte jugable, aún en desarrollo.
	
	public void juego()
	{	
		seleccionarMapa(SELECTM);
		v.setAnimador();
		
		while(ESTADO.equals("Juego"))
		{
                    if(!gameover && !nivelCompletado && v.getPanel().getOpaco() == 60)
                    {
                        char aux[] = SELECTM.toCharArray();
                        int i = Character.getNumericValue(aux[0]);
                        salidaAudio.pley(i, 2);
                    }
                    
                    if(!pausa && !gameover && !nivelCompletado)
                    {
                        actualizarJuego();
                        verificarTiempo();
                    }
                    
                    if(gameover)
                    {
                        m.actualizar(mapAct);
                        
                        if(SuperUDOBrothers.getMotor().getMario().getVidas() == 0)
                        {
                            ((Animador) v.getPanel()).setFin(true);
                        }
                        
                        if(tGameOver == 0)
                        {
                            if(m.getVidas() > 0)
                            {
                                salidaAudio.pley(7, 0);
                            }
                            else
                            {
                                salidaAudio.pley(5, 0);
                            }
                            char aux[] = SELECTM.toCharArray();
                            int i = Character.getNumericValue(aux[0]);
                            salidaAudio.stop(i);
                        }
                        
                        tGameOver++;
                    }
                    
                    if(nivelCompletado && tNivelCompletado <=1000)
                    {
                        if(tNivelCompletado == 0)
                        {
                            salidaAudio.pley(4, 0);
                            char aux[] = SELECTM.toCharArray();
                            int i = Character.getNumericValue(aux[0]);
                            salidaAudio.stop(i);
                        }
                        
                        m.completarNivel(mapAct, tNivelCompletado);
                        
                        tNivelCompletado++;
                        
                        if(tNivelCompletado == 580)
                        {
                            ((Animador) v.getPanel()).setCompleto(true);
                        }
                    }
                    
                    esperarFrame();
                    
                    if(nivelCompletado && tNivelCompletado == 1002)
                    {
                        nivelCompletado();
                    }
                    
                    if(gameover && tGameOver >=120)
                    {
                        if(m.getVidas() > 0)
                        {
                            gameOver();
                        }
                        else
                        {
                            if(tGameOver == 300)
                            {
                                gameOver();
                            }
                        }
                    }
		}
	}
        
        //creditos
        
        public void creditos()
        {
            v.setCreditos();
            
            while(ESTADO.equals("Creditos"))
            {
                esperarFrame();
            }
        }
	
	//Metodos utiles
	
	public void actualizarJuego()
	{
		m.actualizar(mapAct);
		mapAct.actualizarEntorno(m);   //Altamente experimental, esta parte del codigo todavía no es usada por el programa y no se a depurado.
	}
	
	public void seleccionarMapa(String n) //el metodo lo dice todo?
	{
		mapAct = new Mapa(n, m);
	}
	
	//Tiempo de espera entre frames para evitar que el juego se ejecute demasiado rapido.
	
	public void esperarFrame()
	{
		v.repaint();
		while(System.nanoTime() - tAnterior < (float)1000000000/FPS)
		{

		}
		tAnterior = System.nanoTime();
	}
        
        //Verifica si el tiempo de juego llega a 0
        
    public void verificarTiempo()
    {
        if(v.getPanel().getTiempo() >= 60 && (v.getPanel().getTiempo() % 60 == 0) && m.getTiempo() > 0)
        {
            m.subTiempo();
        }
        
        if(m.getTiempo() == 0)
        {
            gameover = true;
            m.setForma(0);
        }
    }
    
    //reinicia el nivel o el juego dependiendo de las vidas restantes de mario.
    
    public void gameOver()
    {
        m.setForma(1);
        m.getSolido().setSol(true);
        gameover = false;
        m.setControles();
        m.setPuntos(0);
        m.setMonedas(0);
        m.getPos().setDir(0);
        m.getSolido().setAlto(0.8f);
        m.getSolido().setAncho(0.675f);
        
        if(SuperUDOBrothers.getMotor().getMario().getVidas() > 0)
        {
            v.getPanel().setTiempo(-80);
            seleccionarMapa(SELECTM);
            m.setVidas(m.getVidas()-1);
        }
        else
        {
            Motor.setEstado("Inicio");
            m.reset();
        }
            
        tGameOver = 0;
    }
    
    //completa el nivel

    public void nivelCompletado()
    {
        nivelCompletado = false;
        tNivelCompletado = 0;
        m.reset();
        Motor.setEstado("Inicio");
    }
}