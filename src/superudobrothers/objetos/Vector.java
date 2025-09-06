package superudobrothers.objetos;

public class Vector 
{
	//Atributos
	
	private double x, y;
	private int dir; //Dirección
	private static double GRAVEDAD = -0.02;
	
	/* Direccion a la que apunta el objeto:
	         o——————o
	         |    ^1   |
	         | 2< O >0 |
	         |   3v    |   	              
	         o——————o                    */
	
	//Contructores:

	public Vector()
	{
		x = 0;
		y = 0;
		dir = 0;
	}

	//Vector en 0
	
	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
		dir = 0;
	}
	
	//Vector a partir de coordenadas
	
        public Vector(double x, double y, int dir)
	{
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	//Vector a partir de coordenadas y direccion

	public Vector(Vector i)
	{
		this.x = i.x;
		this.y = i.y;
		this.dir = i.dir;
	}
	
	//Vector a partir de otro vector
	
	//Fin constructores
		
	//Metodos get:
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public int getDir()
	{
		return dir;
	}
	
	public static double getGravedad()
	{
		return GRAVEDAD;
	}
	
	//Fin get
	
	//Metodos set:
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public void setDir(int dir)
	{
		this.dir = dir;
	}
	
	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void set(double x, double y, int dir)
	{
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void set(Vector i)
	{
		this.x = i.x;
		this.y = i.y;
		this.dir = i.dir;
	}
	
	//Fin set
	
	//El metodo mover, permite incrementar o decrementar las coordenadas de un vector. 
	
	public void mover(double x, double y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void mover(double x, double y, int dir)
	{
		this.x += x;
		this.y += y;
		this.dir = dir;
	}
	
	public void mover(Vector i)
	{
		this.x += i.x;
		this.y += i.y;
	}
	
	public void aceVel(double acel, double l) //Metodo añadido para resumir el metodo "atualizar" de la clase Mario.
	{
		if(Math.abs(this.getX() + acel) < Math.abs(l) )
		{
			this.mover(acel,0);
		}
		else
		{
			this.setX(l);
		}
	}
	
	public void deAceVel(double deAcel) //Al igual que el anterior es un metodo añadido para resumir el metodo "atualizar" de la clase Mario.
	{
		if(Math.abs(this.getX()) + deAcel > 0)
		{
			this.mover(deAcel,0);
		}
		else
		{
			this.setX(0);
		}
	}
	
	//Devuelve la magnitud del vertor, posblemente al afinal no lleguemos a usarla, pero puede servirnos en las pruebas.
	
	public void invertir()
	{
            if(this.dir > 0)
            {
                this.dir = 0;
            }
            else
            {
                this.dir = 2;
            }
	}
}