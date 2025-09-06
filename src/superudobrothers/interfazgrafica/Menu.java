package superudobrothers.interfazgrafica;

import superudobrothers.Motor;
import superudobrothers.cargadores.Boton;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import superudobrothers.SuperUDOBrothers;

public class Menu extends Panel implements ActionListener
{
	//Atributos
	
	private final Boton jugar, puntuaciones, configuracion, salir;
	private int ytitulo, pCambio;
	private Image tituloImg;
	
	//Constructor
	
	public Menu(boolean intro)
	{
		super("background_extendido.png");
		
		try
		{
			tituloImg = ImageIO.read(new File("recursos/imagenes/SuperUDOBrothers.png"));
		}
		catch(IOException e)
		{
			System.out.println("Error en la carga del título:" + e);
		}
		
		opaco = 255;
		xOverlay = 0;
		yOverlay = 0;
		
		if(!intro)
		{
			ytitulo = 80;
		}
                
                xFondo = 0; 
                yFondo = 0;
		wFondo = 3000;
		hFondo = 600;
                tiempo = 0;
					
		setLayout(null);
		
		jugar = new Boton(0,"Jugar",28);
		jugar.setBounds(40,500,190,49);
		add(jugar);
		jugar.addActionListener(this);
		
		puntuaciones = new Boton(0,"Puntuación",18);
		puntuaciones.setBounds(270,500,190,49);
		add(puntuaciones);
		puntuaciones.addActionListener(this);
		
		configuracion = new Boton(0,"Configuración",14);
		configuracion.setBounds(500,500,190,49);
		add(configuracion);
		configuracion.addActionListener(this);
		
		salir = new Boton(0,"Salir",28);
		salir.setBounds(720,500,190,49);
		add(salir);
		salir.addActionListener(this);
	}
	
	//ActionListener
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
            if(tiempo > 60)
            {
		if(e.getSource() == jugar)
		{
                    cambio = true;
                    pCambio = 0;
                    SuperUDOBrothers.getMotor().getAudio().pley(11, 3);
		}
		
		if(e.getSource() == puntuaciones)
		{
                    cambio = true;
                    pCambio = 1;
                    SuperUDOBrothers.getMotor().getAudio().pley(11, 3);
		}
		
		if(e.getSource() == configuracion)
                {
                    cambio = true;
                    pCambio = 2;
                    SuperUDOBrothers.getMotor().getAudio().pley(11, 3);
		}
            }
			
            if(e.getSource() == salir)
            {
                System.exit(0);
                SuperUDOBrothers.getMotor().getAudio().pley(11, 3);
            }
	}
	
        public void creditos()
        {
            if(!this.cambio && tiempo > 60)
            {
                cambio = true;
                pCambio = 3;
                SuperUDOBrothers.getMotor().getAudio().pley(11, 3);
            }
        }
        
	//Graficos
	
	@Override
	public void repintar(Graphics g)
	{
		g.drawImage(tituloImg,150,ytitulo,600,140,null);
		
		xFondo--;
		if(xFondo<=-1380)
		{
			xFondo=-400;
		}
		
		if(tiempo>20&&tiempo<80&&!cambio)
		{
			if(opaco>0)
			{
				opaco-=5;
			}
		}

		if(tiempo < 180 && ytitulo != 80)
		{
			ytitulo = tiempo-100;
		}
		
		tiempo++; //Si ocurre un rebalse de enteros, el titulo del juego se irá al infinito hacia arriba, pero esto solo sube 60 veces por segundo (en el mejor de los casos), 2147483647/60=35791394 segundos, 35791394/60=596523 minutos, 596523/60=9942 horas, 9942/24=414 dias, podría resolverlo con un if, pero me hizo gracia dejarlo como una peculiaridad del codigo.   
		
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
		
		if(fTiempo == 47)
		{
			switch(pCambio)
			{
				case 0:
				Motor.setEstado("SelectorNivel");
				break;
				case 1:
				Motor.setEstado("Puntuacion");
				break;
				case 2:
				Motor.setEstado("Configuracion");
                                break;
                                case 3:
                                Motor.setEstado("Creditos");
                                break;
                                default:
			}
		}
	}
}