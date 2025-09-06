package superudobrothers.interfazgrafica;

import superudobrothers.Motor;
import superudobrothers.cargadores.Boton;
import java.awt.event.*;
import java.awt.Graphics;
import superudobrothers.SuperUDOBrothers;

public class SelectorNivel extends Panel implements ActionListener
{
        //Atributos
    
        private int pCambio;
	private final Boton volver, mapa1, mapa2, mapa3;
	
        //Contructor
        
	public SelectorNivel()
	{
		super("background_extendido.png");
		
		opaco = 255;
		xOverlay = 0;
		yOverlay = 0;
                
                xFondo = 0; 
                yFondo = 0;
		wFondo = 3000;
		hFondo = 600;
                
		tiempo = 0;
					
		setLayout(null);
		
		volver = new Boton(0,"Menú",28);
		volver.setBounds(40,500,190,49);
		add(volver);
		volver.addActionListener(this);
		
		mapa1 = new Boton(3,"",18);
		mapa1.setBounds(20,20,290,290);
		add(mapa1);
		mapa1.addActionListener(this);
		
		mapa2 = new Boton(4,"",14);
		mapa2.setBounds(330,20,290,290);
		add(mapa2);
		mapa2.addActionListener(this);
		
		mapa3 = new Boton(5,"",28);
		mapa3.setBounds(640,20,290,290);
		add(mapa3);
		mapa3.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
            
		if(tiempo > 40)
		{
                    if(e.getSource() == volver)
                    {
			cambio = true;
			pCambio = 0;
                        SuperUDOBrothers.getMotor().getAudio().pley(11, 3);
                    }
                    
                    if(e.getSource() == mapa1)
                    {
			cambio = true;
			pCambio = 1;
                        SuperUDOBrothers.getMotor().getAudio().pley(18, 3);
                    }
                    
                    if(e.getSource() == mapa2)
                    {
                        cambio = true;
                        pCambio = 2;
                        SuperUDOBrothers.getMotor().getAudio().pley(18, 3);
                    }
                    
                    if(e.getSource() == mapa3)
                    {
			cambio = true;
			pCambio = 3;
                        SuperUDOBrothers.getMotor().getAudio().pley(18, 3);
                    }
		}
	}
	
	
	@Override
	public void repintar(Graphics g)
	{
		xFondo--;
		if(xFondo<=-1380)
		{
                        xFondo=-400;
		}
		
		//System.out.println("t:" + tiempo + " o:" + opaco);
		
		if(tiempo < 60 && !cambio)
		{
			if(opaco>0)
			{
				opaco-=5;
			}
		}
		
		tiempo++;
		
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
                    if(pCambio != 0)
                    {
                        SuperUDOBrothers.getMotor().getAudio().stop(0);
                    }
                    
                    switch(pCambio)
                    {
                        case 0:
                        Motor.setEstado("Menu");
                        break;
                        case 1:
                        Motor.setSelectM("1.txt");
                        Motor.setEstado("Juego");
                        break;
                        case 2:
                        Motor.setSelectM("2.txt");
                        Motor.setEstado("Juego");
                        break;
                        case 3:
                        Motor.setSelectM("3.txt");
                        Motor.setEstado("Juego");
                        break;
                        default:
                        Motor.setEstado("Menu");
                    }
		}
	}
}