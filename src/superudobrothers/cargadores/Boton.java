package superudobrothers.cargadores;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Boton extends JButton
{
	
	//Atributos
	
	private Icon img1, img2;
	
	//Contructor
	
	public Boton(int tipo, String text, int t)
	{
		super(text);
		
		switch(tipo)
		{
			case 0:
			img1 = new ImageIcon("recursos/imagenes/green_button00.png");
			img2 = new ImageIcon("recursos/imagenes/yellow_button00.png");
			break;
			case 1:
			img1 = new ImageIcon("recursos/imagenes/purple_button00.png");
			img2 = new ImageIcon("recursos/imagenes/blue_button00.png");
			break;
			case 2:
			img1 = new ImageIcon("recursos/imagenes/brown_button00.png");
			img2 = new ImageIcon("recursos/imagenes/yellow_button00.png");
			break;
			case 3:
			img1 = new ImageIcon("recursos/imagenes/Selec1.png");
			img2 = new ImageIcon("recursos/imagenes/BloqueSorpresaM.png");
			break;
			case 4:
			img1 = new ImageIcon("recursos/imagenes/Selec2.png");
			img2 = new ImageIcon("recursos/imagenes/BloqueSorpresaM.png");
			break;
			case 5:
			img1 = new ImageIcon("recursos/imagenes/Selec3.png");
			img2 = new ImageIcon("recursos/imagenes/BloqueSorpresaM.png");
			break;
			default:
			System.out.println("Ocurrió un error al cargar las imágenes, puede que alguna de estas no sea acesible.");
		}
		
		setIcon(img1);
		setRolloverIcon(img2);
		setBorder(null);
		setBackground(new Color(0,0,0,0));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setFocusable(false);
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		setFont(new Font("Press Start 2P", Font.PLAIN, t));
		setForeground(Color.WHITE);
	}
	
	//Metodos Set
}