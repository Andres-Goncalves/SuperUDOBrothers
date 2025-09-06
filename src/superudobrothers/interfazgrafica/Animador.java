package superudobrothers.interfazgrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import superudobrothers.Motor;
import superudobrothers.SuperUDOBrothers;
import superudobrothers.cargadores.Graficos;
import superudobrothers.cargadores.LectorArchivos;

public class Animador extends Panel
{
    //Atributos
    
    private boolean fin, completo, iNombre;
    private final Graficos recursos;
    private String nombre;
    private int cNombre;
    
    //Contructor
    
    public Animador(String f)
    {
	super(f);

	opaco = 255;
	xOverlay = 0;
	yOverlay = 0;
                
        xFondo = -400; 
        yFondo = -120;
	wFondo = 3000;
	hFondo = 760;
                       
	tiempo = -120;
        
        fin = false;
        completo = false;
        nombre = "____________";
        cNombre = 0;
        iNombre = false;
        
        recursos = new Graficos();      
    }
    
    //Metodos get y set
    
    public void setFin(boolean f)
    {
        this.fin = f;
    }
    
    public boolean getFin()
    {
        return this.fin;
    }
    
    public void setCompleto(boolean c)
    {
        this.completo = c;
    }
    
    public boolean getCompleto()
    {
        return this.completo;
    }
    
    //inicio del nivel, HUD, y final del nivel
    
    public void inicio(Graphics g)
    {
        g.setFont(new Font("Press Start 2P", Font.PLAIN, 16));
        if(!Motor.getSelectM().equals("2.txt"))
        {
            g.setColor(Color.BLACK);
        }
        else
        {
            g.setColor(Color.WHITE);
        }
        g.drawString("Puntuación",5,20);
        g.drawString(String.format("%010d", SuperUDOBrothers.getMotor().getMario().getPuntos()),6,38);
        g.drawString("Tiempo", 840,20);
        g.drawString(String.format("%03d", SuperUDOBrothers.getMotor().getMario().getTiempo()),872,38);
        if(!this.fin && !this.completo)
        {
            recursos.dibujar(g, 280, 4, 304, 34, 16, 368, 32, 384, 0, 1);
        }
        g.drawString("X",304,32);
        g.drawString(String.format("%02d", SuperUDOBrothers.getMotor().getMario().getMonedas()),320,32);
        g.setFont(new Font("Press Start 2P", Font.PLAIN, 16));
        
        if(!SuperUDOBrothers.getMotor().getPausa() && !this.fin && !this.completo)
        {
            g.setColor(new Color(255,255,255,opaco));
            g.drawString("Puntuación",6,20);
            g.drawString(String.format("%010d", SuperUDOBrothers.getMotor().getMario().getPuntos()),6,38);
            g.drawString("Nivel",550,20);
            switch(Motor.getSelectM())
            {
                case "1.txt":
                {
                    g.drawString("1",582,38);
                }
                break;
                case "2.txt":
                {
                    g.drawString("2",582,38);
                }
                break;
                case "3.txt":
                {
                    g.drawString("3",582,38);
                }
                break;
                default:
            }
            g.drawString("Tiempo", 840,20);
            g.drawString(String.format("%03d", SuperUDOBrothers.getMotor().getMario().getTiempo()),872,38);
            g.drawString("X",304,32);
            g.drawString(String.format("%02d", SuperUDOBrothers.getMotor().getMario().getMonedas()),320,32);
            if(opaco >200)
            {
                recursos.dibujar(g, 420, 270, 452, 302, 80, 34, 96, 50, 0, 0);
                g.drawString("X" + SuperUDOBrothers.getMotor().getMario().getVidas(), 456,300);
            }
        }
        
        if(fin)
        {
            if(SuperUDOBrothers.getMotor().getTGameOver()<249)
            {
                g.setColor(new Color(255,255,255,opaco));
            }
            else
            {
                if(SuperUDOBrothers.getMotor().getTGameOver() >= 249 && (300 - SuperUDOBrothers.getMotor().getTGameOver())*5 > 0)
                {
                    g.setColor(new Color(255,255,255,(300 - SuperUDOBrothers.getMotor().getTGameOver())*5));
                }
            }
            g.setFont(new Font("Press Start 2P", Font.PLAIN, 40));
            g.drawString("Game Over",300,305);
        }
        
        if(completo)
        {
            g.setColor(new Color(255,255,255,opaco));
            g.setFont(new Font("Press Start 2P", Font.PLAIN, 40));
            g.drawString("Nivel Completado",160,205);
            g.setFont(new Font("Press Start 2P", Font.PLAIN, 24));
            g.drawString("Puntuación: ",216,250);
            g.drawString(String.format("%010d", SuperUDOBrothers.getMotor().getMario().getPuntos()),504,250);
            if(SuperUDOBrothers.getMotor().getMario().sumarPuntos())
            {
                g.drawString("Ingrese un Nombre",276,350);
                g.drawString(nombre,336,400);
                if(!iNombre)
                {
                    iNombre = true;
                }
            }
        }
    }
	
    @Override
    public void repintar(Graphics g)
    {
        if(!SuperUDOBrothers.getMotor().getPausa())
        {    
            if(SuperUDOBrothers.getMotor().getMario().getVel().getX()>0 && SuperUDOBrothers.getMotor().getMario().getPos().getX()>6 && SuperUDOBrothers.getMotor().getMario().getPos().getX() < SuperUDOBrothers.getMotor().getMapAct().getAncho() - 18)
            {
                xFondo--;
            }
            else
            {
                if(SuperUDOBrothers.getMotor().getMario().getVel().getX()<0 && SuperUDOBrothers.getMotor().getMario().getPos().getX()>6 && SuperUDOBrothers.getMotor().getMario().getPos().getX() < SuperUDOBrothers.getMotor().getMapAct().getAncho() - 18)
                {
                    xFondo++;
                }
            }
        
            if(SuperUDOBrothers.getMotor().getMario().getVel().getY()>0 && yFondo <= -80 && SuperUDOBrothers.getMotor().getMario().getPos().getY() > 15)
            {
                yFondo++;
            }
            else
            {
                if(SuperUDOBrothers.getMotor().getMario().getVel().getY()<0 && yFondo >= -120 && SuperUDOBrothers.getMotor().getMario().getPos().getY() > 8)
                {
                    yFondo--;
                }
            }
        
            if(xFondo<=-1380)
            {
                xFondo=-400;
            }
        
            if(xFondo>=580)
            {
                xFondo=-400;
            }
        }
            
	if(tiempo>20&&tiempo<80&&!cambio)
	{
            if(opaco>0)
            {
		opaco-=5;
            }
	}
	
	tiempo++;
        
        for(int i = (int) Math.round(SuperUDOBrothers.getMotor().getMario().getPos().getX()) + 24; i > (int) Math.round(SuperUDOBrothers.getMotor().getMario().getPos().getX()) - 24; i--)
        {
            if(i<0 || i>=SuperUDOBrothers.getMotor().getMapAct().getAncho())
            {
                continue;
            }
            
            for(int j = (int) Math.round(SuperUDOBrothers.getMotor().getMario().getPos().getY()) - 15; j < (int) Math.round(SuperUDOBrothers.getMotor().getMario().getPos().getY()) + 15;j++)
            {                
		if(j<0 || j>=SuperUDOBrothers.getMotor().getMapAct().getAlto())
		{
                    continue;
                }
                
                if(SuperUDOBrothers.getMotor().getMapAct().checkObj(j, i))
                {
                    recursos.dibujar(g, SuperUDOBrothers.getMotor().getMapAct().getObj(j, i));   
                }
            }
        }
        
        if(SuperUDOBrothers.getMotor().getPausa())
        {
            opaco = 127;
        }
        else
        {
            if(opaco == 127)
            {
                opaco = 0;
            }
        }
        
        if(SuperUDOBrothers.getMotor().getGameOver())
        {
            if(opaco<255)
            {
		opaco+=5;
            }
        }
        
        if(completo)
        {
            if(SuperUDOBrothers.getMotor().getTNivelCompletado() >= 580)
            {
                if(opaco<255)
                {
                    opaco+=5;
                }
            }
        }
    }

    //los siguientes 2 metodos se encargan de recibir el nombre y añadirlo a la tabla de puntuaciones si corresponde.
    
    public void guardar()
    {
        if(iNombre)
        {
            if(!nombre.equals("____________") && nombre.length() == 12)
            {
                LectorArchivos puntuaciones = new LectorArchivos("Puntuaciones.txt");
                String tabla[] = new String[10];
                int valor = 0, pos = tabla.length;
                
                for(int i = tabla.length-1; i>=0; i--)
                {
                    try
                    {
                        valor = Integer.parseInt(puntuaciones.getLinea(i).substring(19));
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error:" + e);
                    }
                    
                    tabla[i] = puntuaciones.getLinea(i);
                    
                    if(valor < SuperUDOBrothers.getMotor().getMario().getPuntos())
                    {
                        pos--;
                    }
                }
                
                if(pos < tabla.length)
                {
                    
                    while(nombre.length() < 12)
                    {
                        nombre += '_';
                    }
                    
                    char aux[] = this.nombre.toCharArray();
                    
                    for(int i=11;i>=0;i--)
                    {
                        if(aux[i] == '_')
                        {
                            aux[i] = '.';
                        }
                        else
                        {
                            break;
                        }
                    }
                    
                    String aux2 = new String(aux);
                    
                    for(int i = tabla.length-1; i>=pos; i--)
                    {
                        if(i==pos)
                        {
                            tabla[i] = aux2 + "......." + String.format("%012d", SuperUDOBrothers.getMotor().getMario().getPuntos());
                        }
                        else
                        {
                            tabla[i] = tabla[i-1];
                        }
                    }
                }
                
                puntuaciones.guardarPuntuacion(tabla);
            }
            SuperUDOBrothers.getMotor().setTNivelCompletado(1002);
        }
    }
    
    public void inputNombre(KeyEvent e)
    {
        if(iNombre)
        {
            if(e.getKeyChar() != '\u007f' && KeyEvent.getExtendedKeyCodeForChar(e.getKeyChar()) != 8 && KeyEvent.getExtendedKeyCodeForChar(e.getKeyChar()) != KeyEvent.VK_ESCAPE && this.cNombre < 12)
            {
                char aux[] = this.nombre.toCharArray();
                aux[this.cNombre] = e.getKeyChar();
                this.nombre = new String(aux);
                this.cNombre++;
            }
            
            if((e.getKeyChar() == '\u007f' || KeyEvent.getExtendedKeyCodeForChar(e.getKeyChar()) == 8) && this.cNombre > 0)
            {
                char aux[] = this.nombre.toCharArray();
                aux[this.cNombre - 1] = '_';
                this.nombre = new String(aux);
                this.cNombre--;
            }
        }
    }
}
 