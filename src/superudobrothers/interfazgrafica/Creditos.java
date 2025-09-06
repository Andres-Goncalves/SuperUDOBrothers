package superudobrothers.interfazgrafica;

import java.awt.Graphics;
import superudobrothers.Motor;

public class Creditos extends Panel
{
    public Creditos()
    {
        super("Credits2.png");
        
        opaco = 255;
                
        xFondo = 0; 
        yFondo = 0;
	wFondo = 950;
	hFondo = 600;
	
        tiempo = 0;
	setLayout(null);
    }
    
    @Override
    public void repintar(Graphics g)
    {	
        tiempo++;
        
        if(opaco>0&&!cambio)
	{
            opaco-=5;
	}
	
	if(cambio)
	{
            if(yOverlay == 0)
            {
		yOverlay = 710;
		opaco = 255;
            }
	
            yOverlay-=15;
            fTiempo++;
	}
		
	if(fTiempo == 48)
	{
            Motor.setEstado("Menu");
	}
    }
    
    public void salirCreditos()
    {
        if(tiempo > 60)
        {
            cambio = true;
        }
    }
}
