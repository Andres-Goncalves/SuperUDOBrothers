package superudobrothers.interfazgrafica;

import superudobrothers.cargadores.Label;
import superudobrothers.cargadores.LectorArchivos;
import superudobrothers.cargadores.Boton;
import superudobrothers.Motor;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JLabel;
import superudobrothers.SuperUDOBrothers;

public class Puntuaciones extends Panel implements ActionListener
{
        //Atributos
    
	private final Boton volver;
	private final Label tabla[], tituloP; 
	
        //Contructor
        
	public Puntuaciones()
	{
		super("bgPuntuacion.png");
		opaco = 255;
		
		xFondo = -5;
                yFondo = 0;
		wFondo = 950;
		hFondo = 600;
		
                tiempo = 0;
		setLayout(null);
		
		volver = new Boton(1,"Menú",28);
		volver.setBounds(10,10,190,49);
		add(volver);
		volver.addActionListener(this);
		
		tituloP = new Label("High Score",JLabel.CENTER,250,100,460,40,40,Color.WHITE);
		add(tituloP);

		tabla = new Label[10];
		
		LectorArchivos lector = new LectorArchivos("Puntuaciones.txt");
		
		for(int i = 0; i < 10; i++)
		{
			tabla[i] = new  Label(lector.getLinea(i),JLabel.CENTER,168,170+(i*30),620,40,20,Color.WHITE);
			add(tabla[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
            if(e.getSource() == volver && tiempo > 40)
            {
                cambio = true;
                SuperUDOBrothers.getMotor().getAudio().pley(11, 3);
            }
	}
	
	@Override
	public void repintar(Graphics g)
	{
		tiempo++;
		
		Color c = new Color(0,0,0,160);
                g.setColor(c);
		g.fillRoundRect(135,80,680,410,40,40);
			
		//System.out.println("t:" + tiempo + " o:" + opaco);
		
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
}