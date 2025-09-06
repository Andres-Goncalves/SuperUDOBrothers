package superudobrothers.objetos;

import superudobrothers.Mapa;

public abstract class Objeto
{
	//Atributos
	
	//Los atributos son protected para poder acceder a ellos desde las clases a las que da herencia.
	
	protected Vector posicion;
	protected CajaDeColision solido;
	protected SpriteManager sprite;
	
	public Objeto()
	{
		posicion = new Vector();
		solido = new CajaDeColision();
		sprite = new SpriteManager();
	}
	
	public Objeto(double x, double y)
	{
		posicion = new Vector(x,y);
		solido = new CajaDeColision();
		sprite = new SpriteManager();
	}
	
	public Objeto(double x, double y, int dir)
	{
		posicion = new Vector(x,y,dir);
		solido = new CajaDeColision();
		sprite = new SpriteManager();
	}
	
	public Objeto(Vector v)
	{
		posicion = new Vector(v);
		solido = new CajaDeColision();
		sprite = new SpriteManager();
	}
	
	public Objeto(float al, float an)
	{
		posicion = new Vector();
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager();
	}
	
	public Objeto(double x, double y, float al, float an)
	{
		posicion = new Vector(x,y);
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager();
	}
	
	public Objeto(double x, double y, int dir, float al, float an)
	{
		posicion = new Vector(x,y,dir);
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager();
	}
	
	public Objeto(Vector v, float al, float an)
	{
		posicion = new Vector(v);
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager();
	}
	
	public Objeto(float al, float an, boolean des, boolean so)
	{
		posicion = new Vector();
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager();
	}
	
	public Objeto(double x, double y, float al, float an, boolean des, boolean so)
	{
		posicion = new Vector(x,y);
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager();
	}
	
	public Objeto(double x, double y, int dir, float al, float an, boolean des, boolean so)
	{
		posicion = new Vector(x,y,dir);
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager();
	}
	
	public Objeto(Vector v, float al, float an, boolean des, boolean so)
	{
		posicion = new Vector(v);
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager();
	}
	
	public Objeto(int ID, boolean vis)
	{
		posicion = new Vector();
		solido = new CajaDeColision();
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(double x, double y, int ID, boolean vis)
	{
		posicion = new Vector(x,y);
		solido = new CajaDeColision();
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(double x, double y, int dir, int ID, boolean vis)
	{
		posicion = new Vector(x,y,dir);
		solido = new CajaDeColision();
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(Vector v, int ID, boolean vis)
	{
		posicion = new Vector(v);
		solido = new CajaDeColision();
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(float al, float an, int ID, boolean vis)
	{
		posicion = new Vector();
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(double x, double y, float al, float an, int ID, boolean vis)
	{
		posicion = new Vector(x,y);
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(double x, double y, int dir, float al, float an, int ID, boolean vis)
	{
		posicion = new Vector(x,y,dir);
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(Vector v, float al, float an, int ID, boolean vis)
	{
		posicion = new Vector(v);
		solido = new CajaDeColision(al,an);
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(float al, float an, boolean des, boolean so, int ID, boolean vis)
	{
		posicion = new Vector();
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(double x, double y, float al, float an, boolean des, boolean so, int ID, boolean vis)
	{
		posicion = new Vector(x,y);
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(double x, double y, int dir, float al, float an, boolean des, boolean so, int ID, boolean vis)
	{
		posicion = new Vector(x,y,dir);
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager(ID, vis);
	}
	
	public Objeto(Vector v, float al, float an, boolean des, boolean so, int ID, boolean vis)
	{
		posicion = new Vector(v);
		solido = new CajaDeColision(al,an,des,so);
		sprite = new SpriteManager(ID, vis);
	}
	
	//Metodos abstractos
	
	public abstract void actualizar(Mapa m);
	
	//Metodos no abstractos
	
	public Vector getPos()
	{
		return posicion;
	}
	
	public SpriteManager getSprite()
	{
		return sprite;
	}
	
	public CajaDeColision getSolido()
	{
		return solido;
	}
}