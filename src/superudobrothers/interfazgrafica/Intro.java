package superudobrothers.interfazgrafica;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Intro extends Panel
{
	//Constructor

	public Intro()
	{
		super("Intro.png");
		opaco = 255;
		xFondo = -120;
                yFondo = 0;
		wFondo = 1200;
                hFondo = 600;
		tiempo = 0;
		setLayout(null);
	}
	
	//Graficos
	
	@Override
	public void repintar(Graphics g)
	{
		if(tiempo>60&&tiempo<120)
		{
			if(opaco>0)
			{
				opaco-=5;
			}
		}
		else
		{
			if(tiempo>300)
			{	
				if(opaco<255)
				{
					opaco+=5;
				}
			}
		}
		
		tiempo++;
		
		
		g.setColor(new Color(0,0,0,255));
		g.setFont(new Font("Press Start 2P", Font.PLAIN, 12));
		g.drawString("Version 1.0",5,560);
		
		Color c = new Color(0,0,0,opaco);
                g.setColor(c);
                g.fillRect(0,0,960,600);
	}
}