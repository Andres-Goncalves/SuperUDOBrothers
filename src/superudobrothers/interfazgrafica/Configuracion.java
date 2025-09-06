package superudobrothers.interfazgrafica;

import superudobrothers.cargadores.Label;
import superudobrothers.Motor;
import superudobrothers.cargadores.Boton;
import superudobrothers.SuperUDOBrothers;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Configuracion extends Panel implements ActionListener, ChangeListener
{
        //Atributos
    
	private final Boton volver;
	private final Label volumen, der, izq, zKey, xKey, esc, tituloC, vol;
        private final JSlider sonido;
	
        //Constructor
        
	public Configuracion()
	{
		super("Configuracion.png");
		opaco = 255;
                
                xFondo = -5; 
                yFondo = 0;
		wFondo = 950;
		hFondo = 600;
		
                tiempo = 0;
		setLayout(null);
		
		volver = new Boton(2,"Menú",28);
		volver.setBounds(10,10,190,49);
		add(volver);
		volver.addActionListener(this);
		
                volumen = new Label("Volumen",250,20,160,30,20,Color.WHITE);
		add(volumen);
                
                sonido = new JSlider(JSlider.HORIZONTAL, 0, 10, SuperUDOBrothers.getMotor().getAudio().getVol());
                sonido.setBounds(400,10,440,60);
                sonido.setBorder(null);
                sonido.setBackground(new Color(0,0,0,0));
                sonido.setFocusable(false);
		add(sonido);
                sonido.addChangeListener(this);
		
		vol = new Label(""+this.sonido.getValue(),850,20,64,30,20,Color.WHITE);
		add(vol);
		
		der = new Label("    Derecha",244,224,200,30,16,Color.WHITE);
		add(der);
		
		izq = new Label("    Izquierda",244,320,300,30,16,Color.WHITE);
		add(izq);
		
		zKey = new Label("    Correr",544,224,200,30,16,Color.WHITE);
		add(zKey);
		
		xKey = new Label("    Saltar",544,320,200,30,16,Color.WHITE);
		add(xKey);
		
		esc = new Label("    Pausa",544,416,200,30,16,Color.WHITE);
		add(esc);
		
		tituloC = new Label("Controles",JLabel.CENTER,135,100,680,40,32,Color.WHITE);
		add(tituloC);
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
		g.fillRoundRect(135,80,680,440,40,40);
		
		g.setColor(Color.WHITE);
		g.drawRoundRect(220,206,64,64,24,24);
		g.drawRoundRect(220,302,64,64,24,24);
		g.drawRoundRect(520,206,64,64,24,24);
		g.drawRoundRect(520,302,64,64,24,24);
		g.drawRoundRect(520,398,64,64,24,24);
		
		g.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
		g.drawString('\u2192'+"",244,249);
		g.drawString('\u2190'+"",244,345);
		g.drawString("X",544,248);
		g.drawString("Z",544,345);
		g.setFont(new Font("Press Start 2P", Font.PLAIN, 16));
		g.drawString("esc",530,438);
		
		vol.setText(""+this.sonido.getValue());
		
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

    @Override
    public void stateChanged(ChangeEvent e)
    {
        if(e.getSource() == sonido)
        {
            SuperUDOBrothers.getMotor().getAudio().setVolumen(this.sonido.getValue());
        }
    }
}