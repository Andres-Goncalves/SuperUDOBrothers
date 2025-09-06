package superudobrothers.objetos;

import superudobrothers.Mapa;
import superudobrothers.SuperUDOBrothers;

public class Item extends Objeto
{
	//Atributos
	
	private boolean powerUP, temp, gravedad;
	private int itemID, PUID, tframes;
	private Vector vel;

	//Constructores:

	public Item()
	{
		super();
		powerUP = false;
		itemID = -1;
		PUID = -1;
		vel = new Vector();
                tframes = 0;
                temp = false;
                gravedad = false;
	}

	public Item(boolean p, int ID, double vx, double vy)
	{
		super();
		powerUP = p;
		vel = new Vector(vx,vy);
                tframes = 0;
                temp = false;
                gravedad = false;

		if(p==true)
		{
			PUID = ID;
		}
		else
		{
			itemID = ID;
		}
	}
	
	public Item(float al, float an, boolean des, boolean mo, int imgID, boolean vis, boolean p, int ID, double vx, double vy)
	{
		super(al, an, des, mo, imgID, vis);
		powerUP = p;
		vel = new Vector(vx,vy);
                tframes = 0;
                temp = false;
                gravedad = false;

		if(p==true)
		{
			PUID = ID;
		}
		else
		{
			itemID = ID;
		}
	}
	
	public Item(double x, double y, float al, float an, boolean des, boolean mo, int imgID, boolean vis, boolean p, int ID, double vx, double vy, boolean t, int tf, boolean g)
	{
		super(x, y, al, an, des, mo, imgID, vis);
		powerUP = p;
		vel = new Vector(vx,vy);
                tframes = tf;
                temp = t;
                gravedad = g;

		if(p==true)
		{
			PUID = ID;
		}
		else
		{
			itemID = ID;
		}
	}
	
	public Item(double x, double y, int dir, float al, float an, boolean des, boolean mo, int imgID, boolean vis, boolean p, int ID, double vx, double vy, boolean t, int tf)
	{
		super(x, y, dir, al, an, des, mo, imgID, vis);
		powerUP = p;
		vel = new Vector(vx,vy);
                tframes = tf;
                temp = t;
                gravedad = false;

		if(p==true)
		{
			PUID = ID;
		}
		else
		{
			itemID = ID;
		}
	}
	
	public Item(Vector v, float al, float an, boolean des, boolean mo, int imgID, boolean vis, boolean p, int ID, double vx, double vy)
	{
		super(v, al, an, des, mo, ID, vis);
		powerUP = p;
		vel = new Vector(vx,vy);
                tframes = 0;
                temp = false;
                gravedad = false;

		if(p==true)
		{
			PUID = ID;
		}
		else
		{
			itemID = ID;
		}
	}

	//Metodos get:

	public boolean getPowUP()
	{
		return powerUP;
	}
        
	public boolean getTemp()
	{
		return temp;
	}

	public int getItemID()
	{
		return itemID;
	}

	public int getPUID()
	{
		return PUID;
	}

	public int getTF()
	{
		return tframes;
	}

	//Metodos set:

	public void setPowUP(boolean p)
	{
		powerUP = p;
	}

	public void setTemp(boolean t)
	{
		temp = t;
	}

	public void setItemID(int i)
	{
		itemID = i; 
	}

	public void setPUID(int p)
	{
		PUID = p;
	}

	public void setTF(int tf)
	{
		tframes = tf;
	}
	
	//Mas metodos
	
        @Override
	public void actualizar(Mapa m)
	{
		//Leyendo posicion inicial
		
		int  x, y;
		double vx;
		x = (int) Math.round(this.getPos().getX());
		y = (int) Math.round(this.getPos().getY());
		vx = this.vel.getX();
		
                
                if(this.gravedad)
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
                }
                
		//Coliciones con objetos (horizontal)
		
		m.colisionHor(y,x,this.vel,this);
		
		//movimiento
		
		this.posicion.mover(vel); //Modifica la pocicion del Item.
		
		if(this.vel.getX() != vx) //Cambio de direccion
		{
			this.vel.setX(-vx);
		}
		
		if(!powerUP && m.getPiso(y,x,this)) //Frenar items que no sean powerUps
		{
			this.vel.setX(0);
		}
			
		m.actualizarPos(y,x,this); //Actualiza la pocicion del Item en el Mapa.
                
                
            //actualizacion grafica
            
            if(this.temp)
            {
                this.tframes--;
            }
            
            if(this.powerUP)
            {
                switch(this.PUID)
                {
                    default:
                }  
            }
            else
            {
                switch(this.itemID)
                {
                    case 1:
                    {
                        this.getSprite().roam(12, 1, 4);
                    }
                    break;
                    default:
                }
            }
	}
    
    public void reaccion(Mario m)
    {
        if(!this.powerUP)
        {
            switch(this.itemID)
            {
                case 1:
                {
                    this.temp = true;
                    m.addPuntos(200);
                    m.addMonedas(1);
                    SuperUDOBrothers.getMotor().getAudio().pley(18, 3);
                }
                default:
            }
        }
        else
        {
            switch(this.PUID)
            {
                case 1:
                {
                    this.temp = true;
                    m.addPuntos(1000);
                    m.addForma();
                    SuperUDOBrothers.getMotor().getAudio().pley(21, 3);
                }
                default:
            }
        }
    }
}