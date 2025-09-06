package superudobrothers.objetos;

import superudobrothers.Mapa;
import superudobrothers.SuperUDOBrothers;

public class Bloque extends Objeto
{
	//Atributos

	private boolean reaccion, usado, daño, temp; //Propiedades de los bloques
	private int reacID, tReact, tframes, usos; //Identificador del bloque

	//Constructores:

	public Bloque() 
	{
		reaccion = false;
		usado = false;
		daño = false;
		reacID = -1;
                tReact = 0;
                temp = false;
                tframes = 0;
                usos = 0;
	}

	public Bloque(boolean r, boolean e, boolean d, int ID)
	{
		super();
		reaccion = r;
		usado = e;
		daño = d;
		reacID = ID;
                tReact = 0;
                temp = false;
                tframes = 0;
                usos = 0;
	}

	public Bloque(float al, float an, boolean des, boolean so, int imgID, boolean vis, boolean r, boolean e, boolean d, int ID)
	{
		super(al, an, des, so, imgID, vis);
		reaccion = r;
		usado = e;
		daño = d;
		reacID = ID;
                tReact = 0;
                temp = false;
                tframes = 0;
                usos = 0;
	}

	public Bloque(double x, double y, float al, float an, boolean des, boolean so, int imgID, boolean vis, boolean r, boolean e, boolean d, int ID)
	{
		super(x, y, al, an, des, so, imgID, vis);
		reaccion = r;
		usado = e;
		daño = d;
		reacID = ID;
                tReact = 0;
                temp = false;
                tframes = 0;
                usos = 0;
	}

	public Bloque(double x, double y, int dir, float al, float an, boolean des, boolean so, int imgID, boolean vis, boolean r, boolean e, boolean d, int ID)
	{
		super(x, y, dir, al, an, des, so, imgID, vis);
		reaccion = r;
		usado = e;
		daño = d;
		reacID = ID;
                tReact = 0;
                temp = false;
                tframes = 0;
                usos = 0;
	}

	public Bloque(Vector v, float al, float an, boolean des, boolean so, int imgID, boolean vis, boolean r, boolean e, boolean d, int ID)
	{
		super(v, al, an, des, so, imgID, vis);
		reaccion = r;
		usado = e;
		daño = d;
		reacID = ID;
                tReact = 0;
                temp = false;
                tframes = 0;
                usos = 0;
	}

	//Metodos get:
	
	public boolean getReaccion()
	{
		return reaccion;
	}
	
	public boolean getUsado()
	{
		return usado;
	}
	
	public boolean getDaño()
	{
		return daño;
	}
	
	public int getReacID()
	{
		return reacID;
	}

	public int getTF()
	{
		return tframes;
	}
        
	public boolean getTemp()
	{
		return temp;
	}
	
	//Metodos set:
	
	public void setReaccion(boolean r)
	{
		this.reaccion = r;
	}
	
	public void setUsado(boolean e)
	{
		this.usado = e;
	}
	
	public void setDaño(boolean d)
	{
		this.daño = d;
	}
	
	public void setReacID(int r)
	{
		this.reacID = r;
	}

	public void setTemp(boolean t)
	{
		temp = t;
	}

	public void setTF(int tf)
	{
		tframes = tf;
	}

	public void setUsos(int u)
	{
		usos = u;
	}
	
	//Mas metodos
	
        @Override
	public void actualizar(Mapa m)
	{
            //actualizacion grafica
            
            if(!this.usado)
            {
                switch(this.reacID)
                {
                    case 0:
                    {
                        if(this.tReact > 0)
                        {
                            this.posicion.mover(0, (double) (this.tReact - 9)/100);
                            this.tReact--;
                        }
                        break;
                    }
                    case 1:
                    this.getSprite().roam(12, 3, 5);
                    break;
                    case 3:
                    this.getSprite().roam(12, 3, 5);
                    break;
                    case 4:
                    {
                        if(this.tReact > 0)
                        {
                            this.posicion.mover(0, (double) (this.tReact - 9)/100);
                            this.tReact--;
                        }
                        break;
                    }
                    default:
                }
            }
            
            if(this.temp)
            {
                this.tframes--;
            }
        }

    public void reaccion(Mapa m, int d, Mario M)
    {
        if(!this.usado)
        {
            switch(this.reacID)
            {
                case -1:
                if(d==1)
                {
                    SuperUDOBrothers.getMotor().getAudio().pley(13, 3);
                }
                case 0: //Ladrillos FX
                if(d==1)
                {
                    if(M.getForma()<2)
                    {
                        this.tReact = 17 - this.tReact;
                        SuperUDOBrothers.getMotor().getAudio().pley(13, 3);
                        break;
                    }
                    else
                    {
                        SuperUDOBrothers.getMotor().getAudio().pley(22, 3);
                        this.temp = true;
                        this.tframes = 5;
                        this.getSprite().setImgID(20);
                        this.getSolido().setSol(false);
                    }
                }
                break;
                case 1: //BSorpreza m FX
                if(d==1)
                {
                    SuperUDOBrothers.getMotor().getAudio().pley(18, 3);
                    m.insertar(new Item(this.getPos().getX()+0.1875, this.getPos().getY()+1, 0.875f, 0.625f, false, false, 1, true, false, 0, 0, 0, true, 20, false));
                    this.getSprite().setImgID(19);
                    this.usado = true;
                    M.addPuntos(200);
                    M.addMonedas(1);
                }
                break;
                case 3: //BSorpresa p FX
                if(d==1)
                {
                    SuperUDOBrothers.getMotor().getAudio().pley(25, 3);
                    m.insertar(new Item(this.getPos().getX(), this.getPos().getY()+1, 1, 1, false, false, 5, true, true, 1, 0.05, 0, false, 0, true));
                    this.getSprite().setImgID(19);
                    this.usado = true;
                }
                break;
                case 4: //Ladrillos moneda
                if(d==1)
                {
                    SuperUDOBrothers.getMotor().getAudio().pley(18, 3);
                    m.insertar(new Item(this.getPos().getX()+0.1875, this.getPos().getY()+1, 0.875f, 0.625f, false, false, 1, true, false, 0, 0, 0, true, 8, true));
                    M.addPuntos(200);
                    M.addMonedas(1);
                    this.usos--;
                    this.tReact = 17;
                    if(this.usos == 0)
                    {
                        this.getSprite().setImgID(19);
                        this.usado = true;
                    }
                }
                break;
                case 5: //Asta
                {
                    if(!SuperUDOBrothers.getMotor().getNivelCompletado() && (d==0 || d==2))
                    {
                        meta(m, M);
                    }
                    break;
                }
                case 6: //Tope
                {
                    if(!SuperUDOBrothers.getMotor().getNivelCompletado() && (d==0 || d==2 || d==3))
                    {
                        meta(m, M);
                    }
                    break;
                }
                default:
            }
        }
    }
        
    public void meta(Mapa m, Mario M)
    {
        int  x, y, p = 1;
        x = (int) Math.round(this.getPos().getX());
        y = (int) Math.round(this.getPos().getY());
        
        for(int j = y-1; j>0 && j>=y-9;j--)
        {
            if(m.checkObj(j, x))
            {
                if(m.getTipo(j, x).equals("Bloque"))
                {
                    if(m.getBloque(j, x).reacID == 5)
                    {
                        p++;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }
            
        M.addPuntos(p*500);
            
        SuperUDOBrothers.getMotor().setNivelCompletado(true);
    }
}