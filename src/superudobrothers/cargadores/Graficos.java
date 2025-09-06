package superudobrothers.cargadores;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import superudobrothers.SuperUDOBrothers;
import superudobrothers.objetos.Objeto;

public class Graficos
{
    //Atributos
    
    private Image jugador, sprites;
    
    //Constructor
    
    public Graficos()
    {
        try
        {
            jugador = ImageIO.read(new File("recursos/imagenes/Mario.png"));
            sprites = ImageIO.read(new File("recursos/imagenes/Sprites.png"));
	}
	catch(Exception e)
	{
            System.out.println("Error al cargar la hoja de sprites:" + e);
	}
    }
    
    //Metodos
    
    public void dibujar(Graphics g, Objeto o)
    {
        if(o.getSprite().getVis())
        {
            IndiceSprite in = new IndiceSprite(o);
            
            int dx1, dx2, dy1, dy2, sx1, sx2, sy1, sy2;
            
            dx1 = (int) ((double) o.getPos().getX() * 40) -5;
            dx2 = (int) ((double) ((double) o.getPos().getX() + o.getSolido().getAncho()) * 40) -5;
            dy1 = ((SuperUDOBrothers.getMotor().getMapAct().getAlto() * 40) - ((int) ((double)((double) o.getPos().getY() + o.getSolido().getAlto()) * 40)));
            dy2 = ((SuperUDOBrothers.getMotor().getMapAct().getAlto() * 40) - ((int) ((double) o.getPos().getY() * 40)));
            
            if(SuperUDOBrothers.getMotor().getMario().getPos().getX() > 6)
            {
                if(SuperUDOBrothers.getMotor().getMario().getPos().getX() < SuperUDOBrothers.getMotor().getMapAct().getAncho() - 18)
                {
                    dx1 -= (int) ((double)(SuperUDOBrothers.getMotor().getMario().getPos().getX() - 6) * 40);
                    dx2 -= (int) ((double)(SuperUDOBrothers.getMotor().getMario().getPos().getX() - 6) * 40);
                }
                else
                {
                    dx1 -= (int) ((double)(SuperUDOBrothers.getMotor().getMapAct().getAncho() - 24) * 40);
                    dx2 -= (int) ((double)(SuperUDOBrothers.getMotor().getMapAct().getAncho() - 24) * 40);
                }
            }
            
            if(SuperUDOBrothers.getMotor().getMario().getPos().getY() > 14)
            {
                if(SuperUDOBrothers.getMotor().getMario().getPos().getY() < SuperUDOBrothers.getMotor().getMapAct().getAlto() - 9)
                {
                    dy1 -= (int) ((double) ((double) SuperUDOBrothers.getMotor().getMapAct().getAlto() - SuperUDOBrothers.getMotor().getMario().getPos().getY()-1) * 40);
                    dy2 -= (int) ((double) ((double) SuperUDOBrothers.getMotor().getMapAct().getAlto() - SuperUDOBrothers.getMotor().getMario().getPos().getY()-1) * 40);
                }
            }
            else
            {
                dy1 -= ((SuperUDOBrothers.getMotor().getMapAct().getAlto() * 40) - 600);
                dy2 -= ((SuperUDOBrothers.getMotor().getMapAct().getAlto() * 40) - 600);
            }
            
            sx1 = in.getX();
            sx2 = in.getX() + in.getW();
            sy1 = in.getY();
            sy2 = in.getY() + in.getH();
            
            if(o.getPos().getDir() == 2)
            {
                int dxt;
                dxt = dx1;
                dx1 = dx2;
                dx2 = dxt;
            }
            
            if(o.getPos().getDir() == 3)
            {
                int dyt;
                dyt = dy1;
                dy1 = dy2;
                dy2 = dyt;
            }
            
            g.drawImage(hoja(in.getTipo()), dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
            //System.out.println("x1:" + dx1 + " y1:" + dy1 + " x2:" + dx2 + " y2:" + dy2 + " sx1:" + sx1 + " sy1:" + sy1 + " sx2:" + sx2 + " sy2:" + sy2 + " id:" + o.getSprite().getImgID());
        }
    }
    
    public void dibujar(Graphics g, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, int dir, int i)
    {
        if(dir == 2)
        {
            int dxt;
            dxt = dx1;
            dx1 = dx2;
            dx2 = dxt;
        }
            
        if(dir == 3)
        {
            int dyt;
            dyt = dy1;
            dy1 = dy2;
            dy2 = dyt;
        }
            
        g.drawImage(hoja(i), dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
    }
    
    public Image hoja(int i)
    {
        switch(i)
        {
            case 0:
            return jugador;
            case 1:
            return sprites;
            default:
            return null;
        }
    }
}
