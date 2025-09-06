package superudobrothers.interfazgrafica;

import superudobrothers.SuperUDOBrothers;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class Panel extends JPanel
{
	//atributos
	
	protected Image fondo, cambioImg;
	protected int tiempo,  fTiempo, opaco, xFondo, yFondo, wFondo, hFondo, xOverlay, yOverlay, xDebug, yDebug;
	protected boolean cambio, ap;
        protected Color debugC;

	//Constructor
	
	public Panel(String f)
	{
		super();
		
		cambio = false;
		fTiempo = 0;
                
                xDebug = 5;
                yDebug = 15;
                debugC = new Color(247,94,37);
		
		setLayout(null);
		
		try
		{
                    cambioImg = ImageIO.read(new File("recursos/imagenes/MenuCambio.png"));
                    fondo = ImageIO.read(new File("recursos/imagenes/" + f));
		}
		catch(IOException e)
		{
                    System.out.println("Error:" + e);
		}
	}
	
	//Graficos
	
	@Override
	public void paintComponent(Graphics g) //Se sobreescribe paintComponent dentro de panel, se hace para introducir un drawImage de Graphics que sea llamado cada vez que se necesite dibujar el panel
	{
            super.paintComponent(g);
		
            g.drawImage(fondo,xFondo,yFondo,wFondo,hFondo,null);
		
            repintar(g);
	}
	
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
	
        cambioMenu(g);
        
        if(SuperUDOBrothers.getMotor().getPausa())
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Press Start 2P", Font.PLAIN, 48));
            g.drawString("PAUSA",353,278);
            g.setColor(Color.WHITE);
            g.drawString("PAUSA",350,280);
        }
        
        if(this.getClass().getSimpleName().equals("Animador"))
        {
            ((Animador) this).inicio(g);
        }
        
        if(Ventana.getDebug())
        {
            debugM(g);
        }
    }
	
    public abstract void repintar(Graphics g);
    
    //Se encarga de la animacion de cambio de menú
    
    public void cambioMenu(Graphics g)
    {
        Color c = new Color(0,0,0,opaco);
        g.setColor(c);
        g.fillRect(xOverlay,yOverlay,960,600);
        
        if(cambio)
        {
            g.drawImage(cambioImg,xOverlay,yOverlay-110,960,200,null);
        }
    }
    
    //Datos que fueron útiles para hacer al juego trabajar (Se pueden Mostrar precionando F3)
        
    public void debugM(Graphics g)
    {   
        g.setColor(debugC);
        g.setFont(new Font("Unicode", Font.PLAIN, 16));
        g.drawString("t:" + tiempo + " o:" + opaco + " Pausa: " + SuperUDOBrothers.getMotor().getPausa() + " GameOver:" + SuperUDOBrothers.getMotor().getGameOver() + " TGameOver:" + SuperUDOBrothers.getMotor().getTGameOver() + "NC" + SuperUDOBrothers.getMotor().getNivelCompletado()  ,xDebug,yDebug);
        g.drawString("inputs: Up:" + SuperUDOBrothers.getMotor().getMario().getUp() + " Down:" + SuperUDOBrothers.getMotor().getMario().getDown() + " Izq:" + SuperUDOBrothers.getMotor().getMario().getIzq() + " Der:" + SuperUDOBrothers.getMotor().getMario().getDer() + " Sprint:" + SuperUDOBrothers.getMotor().getMario().getSprint()+ " Salto:" + SuperUDOBrothers.getMotor().getMario().getSalto(),xDebug,yDebug + 18);
        g.drawString("mx:" + SuperUDOBrothers.getMotor().getMario().getPos().getX() + " my:" + SuperUDOBrothers.getMotor().getMario().getPos().getY() + " mvx:" + SuperUDOBrothers.getMotor().getMario().getVel().getX(), xDebug, yDebug + 36);
        g.drawString("imgID:" + SuperUDOBrothers.getMotor().getMario().getSprite().getImgID() + " subID:" + SuperUDOBrothers.getMotor().getMario().getSprite().getSubID(), xDebug, yDebug + 54);
        g.drawString("mvx:" + SuperUDOBrothers.getMotor().getMario().getVel().getX(), xDebug, yDebug + 72);
    }
            
    //Metodos set

    public void setFondo(String f)
    {
	try
	{
            fondo = ImageIO.read(new File(f));
	}
        catch(IOException e)
        {
            System.out.println("Error:" + e);
	}
    }
	
    public void setTiempo(int t)
    {
	tiempo = t;
    }
	
    //Metodos get
	
    public int getTiempo()
    {
	return tiempo;
    }
	
    public int getOpaco()
    {
	return opaco;
    }
}