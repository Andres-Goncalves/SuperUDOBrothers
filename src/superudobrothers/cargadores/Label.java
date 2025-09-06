package superudobrothers.cargadores;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Label extends JLabel
{
	public Label(String texto, int alinear, int x, int y, int w, int h, int t, Color c)
	{
		super(texto, alinear);
		setBounds(x,y,w,h);
		setFont(new Font("Press Start 2P", Font.PLAIN, t));
		setForeground(c);
	}
	
	public Label(String texto, int x, int y, int w, int h, int t, Color c)
	{
		super(texto);
		setBounds(x,y,w,h);
		setFont(new Font("Press Start 2P", Font.PLAIN, t));
		setForeground(c);
	}
}