package superudobrothers.objetos;

import superudobrothers.Mapa;
import superudobrothers.SuperUDOBrothers;

public class Enemigo extends Objeto
{
	//Atributos

	private int vida, EnemiID, t0vida;
	private Vector vel;

	//Constructores

	public Enemigo()
	{
		super();
		vida = 0;
		EnemiID = 0;
		this.vel = new Vector();
                t0vida = -1;
	}

	public Enemigo(int h, int ID, double vx, double vy)
	{
		super();
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vx,vy);
                t0vida = -1;
	}
	
	public Enemigo(int h, int ID, Vector vel)
	{
		super();
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vel);
                t0vida = -1;
	}

	public Enemigo(float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, double vx, double vy)
	{
		super(al, an, des, mo, imgID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vx,vy);
                t0vida = -1;
	}
	
	public Enemigo(float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, Vector vel)
	{
		super(al, an, des, mo, imgID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vel);
                t0vida = -1;
	}

	public Enemigo(double x, double y, float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, double vx, double vy)
	{
		super(x, y, al, an, des, mo, imgID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vx,vy);
                t0vida = -1;
	}
	
	public Enemigo(double x, double y, float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, Vector vel)
	{
		super(x, y, al, an, des, mo, imgID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vel);
                t0vida = -1;
	}

	public Enemigo(double x, double y, int dir, float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, double vx, double vy)
	{
		super(x, y, dir, al, an, des, mo, imgID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vx,vy);
                t0vida = -1;
	}
	
	public Enemigo(double x, double y, int dir, float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, Vector vel)
	{
		super(x, y, dir, al, an, des, mo, imgID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vel);
                t0vida = -1;
	}

	public Enemigo(Vector v, float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, double vx, double vy)
	{
		super(v, al, an, des, mo, ID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vx,vy);
                t0vida = -1;
	}
	
	public Enemigo(Vector v, float al, float an, boolean des, boolean mo, int imgID, boolean vis, int h, int ID, Vector vel)
	{
		super(v, al, an, des, mo, ID, vis);
		vida = h;
		EnemiID = ID;
		this.vel = new Vector(vel);
                t0vida = -1;
	}

	//Metodos get:
	
	public int getEID()
	{
		return EnemiID;
	}
	
	public int getVida()
	{
		return vida;
	}
	
	public Vector getVel()
	{
		return vel;
	}

	//Metodos set:
	
	public void setEID(int ID)
	{
		this.EnemiID = ID;
	}
	
	public void setVida(int vida)
	{
		this.vida = vida;
	}
	
	public void setVel(Vector v)
	{
		this.vel = v;
	}
        
        //Mas metodos
	
        public void subVida(boolean m)
        {
            this.vida--;
            
            if(this.EnemiID > 1)
            {
                
                
                this.getSolido().setAlto(0.875f);
                
                if(this.vida == 0)
                {
                    SuperUDOBrothers.getMotor().getAudio().pley(19, 3);
                    vida++;
                }
                else
                {
                    SuperUDOBrothers.getMotor().getAudio().pley(12, 3);
                }
                
                if(this.vel.getX() != 0.0)
                {
                    this.vel.setX(0.0);
                }
                else
                {
                    this.vel.setX(0.24);
                }
                
                if(m)
                {
                    this.vida = 0;
                }
            }
            else
            {
                SuperUDOBrothers.getMotor().getAudio().pley(12, 3);
            }
            
            if(this.vida <= 0)
            {
                this.t0vida = 10;
                this.getSolido().setSol(false);
            }
        }
        
        @Override
	public void actualizar(Mapa m)
	{
		//Leyendo posicion inicial
		
		Vector iniPos = new Vector(this.posicion);
		int  x, y;
		double vx;
		x = (int) Math.round(this.getPos().getX());
		y = (int) Math.round(this.getPos().getY());
		vx = this.vel.getX();
                
            if(this.vida > 0)
            {
		//comprobar si hay piso
		
		if(!m.getPiso(y,x,this))
		{
			if(this.vel.getY() - Vector.getGravedad() >= -0.15)
			{
				this.vel.mover(0,Vector.getGravedad());
			}
			else
			{
				this.vel.setY(-0.15);
			}
		}
		else
		{
			this.vel.setY(0);
		}
		
		//Coliciones con objetos (vertical)
		
		m.colisionVer(y,x,this.vel,this);
		
		//Coliciones con objetos (horizontal)
		
		m.colisionHor(y,x,this.vel,this);
		
		//movimiento 
				
		this.posicion.mover(vel); //Modifica la posicion del Enemigo.
		
		if(this.vel.getX() != vx) //Cambio de direccion
		{
			this.vel.setX(-vx);
                        this.getPos().invertir();
		}
		
		if(!m.getPiso(y, x,this) && this.EnemiID == 3 && this.vida == 2) //Evita que un tipo de enemigo en específico se caiga de las plataformas al caminar.
		{
			this.posicion.set(iniPos);
			this.vel.setX(-vx);
                        this.getPos().invertir();
		}
            }
            else
            {
                if(this.vel.getX() != 0)
                {
                    this.vel.set(0, 0);
                }
                this.t0vida--;
            }
            
            //Actualizar la pocicion del Enemigo en el Mapa.
		
            m.actualizarPos(y,x,this); 
                
            //actualizacion grafica
                
            switch(this.EnemiID)
            {
                case 1:
                if(this.vida > 0)
                {
                    this.getSprite().roam(15, 1, 2);
                }
                else
                {
                    this.getSprite().setImgID(3);
                }
                break;
                case 2:
                {
                    if(vida > 1)
                    {
                        this.getSprite().roam(15, 4, 5);
                    }
                    else
                    {
                        this.getSprite().setImgID(6);
                    }
                    break;
                }
                case 3:
                {
                    if(vida > 1)
                    {
                        this.getSprite().roam(15, 7, 8);
                    }
                    else
                    {
                        this.getSprite().setImgID(9);
                    }
                    break;
                }
                default:
            }
                
            if(this.t0vida == 4)
            {
                this.getSprite().setVis(false);
            }
	}
}