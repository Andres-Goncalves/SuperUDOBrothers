package superudobrothers.interfazgrafica;

import superudobrothers.SuperUDOBrothers;
import superudobrothers.Motor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements KeyListener
{
	//Atributos
	
	private Panel p;
        private static boolean DEBUG;
	
	//Constructor
	
	public Ventana()
	{
		setTitle("UDO Project: Super UDO Brothers");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("recursos/imagenes/Icono.png");
		setIconImage(icon.getImage());
		
		setBounds(0,0,960,600);
		setLocationRelativeTo(null);
		setResizable(false);
                addKeyListener(this);
                setFocusable(true);
                
		p = new Intro();
		add(p);
		
		setVisible(true);
	}
	
	//Metodos set y get
	
	public Panel getPanel()
	{
		return p;
	}
        
        public static void setDebug(boolean d)
        {
            DEBUG = d;
        }
        
        public static boolean getDebug()
        {
            return DEBUG;
        }
	
	//Metodos de cambio de estado
	
	public void setIntro()
	{
		remove(p);
		p = new Intro();
		add(p);
		revalidate();
		repaint();
	}
	
	public void setMenu(boolean intro)
	{
		remove(p);
		p = new Menu(intro);
		add(p);
		revalidate();
		repaint();
	}
	
	public void setPuntuacion()
	{
		remove(p);
		p = new Puntuaciones();
		add(p);
		revalidate();
		repaint();
	}
	
	public void setConfiguracion()
	{
		remove(p);
		p = new Configuracion();
		add(p);
		revalidate();
		repaint();
	}
	
	public void setSelectorNivel()
	{
		remove(p);
		p = new SelectorNivel();
		add(p);
		revalidate();
		repaint();
	}
	
	public void setAnimador()
	{
		remove(p);
                if(Motor.getSelectM().equals("2.txt"))
                {
                    p = new Animador("negro.png");
                }
                else
                {
                    p = new Animador("background_extendido.png");
                }
                add(p);
		revalidate();
		repaint();
	}
        
        public void setCreditos()
        {
            remove(p);
            p = new Creditos();
            add(p);
            revalidate();
            repaint();
        }

    @Override
    public void keyTyped(KeyEvent e)
    {
        if(p.getClass().getSimpleName().equals("Animador") && SuperUDOBrothers.getMotor().getNivelCompletado())
        {
            ((Animador) p).inputNombre(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_F3)
        {
            DEBUG = !DEBUG;
        }
        
        if(e.getKeyCode()==KeyEvent.VK_F1 && Motor.getEstado().equals("Menu") && p.getClass().getSimpleName().equals("Menu"))
        {
            ((Menu) p).creditos();
        }
        
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE && Motor.getEstado().equals("Creditos") && p.getClass().getSimpleName().equals("Creditos"))
        {
            ((Creditos) p).salirCreditos();
        }
        
        if(e.getKeyCode()==KeyEvent.VK_ENTER && p.getClass().getSimpleName().equals("Animador") && SuperUDOBrothers.getMotor().getNivelCompletado())
        {
            ((Animador) p).guardar();
        }
        
        if(p.getClass().getSimpleName().equals("Animador"))
        {
            if(p.getOpaco() < 40 || SuperUDOBrothers.getMotor().getPausa())
            {
                if(e.getKeyCode()==KeyEvent.VK_UP)
                {
                    SuperUDOBrothers.getMotor().getMario().setUp(true);
                }
            
                if(e.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    SuperUDOBrothers.getMotor().getMario().setDown(true);
                }
            
                if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    SuperUDOBrothers.getMotor().getMario().setDer(true);
                }
            
                if(e.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    SuperUDOBrothers.getMotor().getMario().setIzq(true);
                }
            
                if(e.getKeyCode()==KeyEvent.VK_X)
                {
                    SuperUDOBrothers.getMotor().getMario().setSprint(true);
                }
            
                if(e.getKeyCode()==KeyEvent.VK_Z)
                {
                    SuperUDOBrothers.getMotor().getMario().setSalto(true);
                }
            
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
                {
                    SuperUDOBrothers.getMotor().pausa();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(Motor.getEstado().equals("Juego"))
        {
            if(e.getKeyCode()==KeyEvent.VK_UP)
            {
                SuperUDOBrothers.getMotor().getMario().setUp(false);
            }
            
            if(e.getKeyCode()==KeyEvent.VK_DOWN)
            {
                SuperUDOBrothers.getMotor().getMario().setDown(false);
            }
            
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                SuperUDOBrothers.getMotor().getMario().setDer(false);
            }
            
            if(e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                SuperUDOBrothers.getMotor().getMario().setIzq(false);
            }
            
            if(e.getKeyCode()==KeyEvent.VK_X)
            {
                SuperUDOBrothers.getMotor().getMario().setSprint(false);
            }
            
            if(e.getKeyCode()==KeyEvent.VK_Z)
            {
                SuperUDOBrothers.getMotor().getMario().setSalto(false);
            }
        }
        
    }
}