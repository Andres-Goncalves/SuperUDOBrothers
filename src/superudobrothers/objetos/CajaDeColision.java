package superudobrothers.objetos;

public class CajaDeColision 
{
	//Atributos
	
	private float alto, ancho;
	private boolean destruible, solido;
	
	//Constructores:
	
	public CajaDeColision()
	{
		alto = 0f;
		ancho = 0f;
		destruible = false;
		solido = false;
	}
	
	public CajaDeColision(float al, float an)
	{
		alto = al;
		ancho = an;
		destruible = false;
		solido = false;
	}
	
	public CajaDeColision(float al, float an, boolean des, boolean so)
	{
		alto = al;
		ancho = an;
		destruible = des;
		solido = so;
	}
	
	//Metodos get:
	
	public float getAlto()
	{
		return alto;
	}
	
	public float getAncho()
	{
		return ancho;
	}
	
	public boolean getDes()
	{
		return destruible;
	}
	
	public boolean getSol()
	{
		return solido;
	}
	
	//Metodos set:
	
	public void setAlto(float al)
	{
		this.alto = al;
	}
	
	public void setAncho(float an)
	{
		this.ancho = an;
	}
	
	public void setDes(boolean des)
	{
		this.destruible = des;
	}
	
	public void setSol(boolean so)
	{
		this.solido = so;
	}
}