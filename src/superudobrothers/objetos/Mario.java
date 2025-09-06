package superudobrothers.objetos;

import superudobrothers.Mapa;
import superudobrothers.SuperUDOBrothers;

public class Mario extends Objeto
{
	
	//Atributos
	
	private int forma, fuego, tSalto, tInvulnerable, vidas, monedas, puntos, tiempo, xfinal;
	private boolean invencible, arriba, abajo, der, izq, saltando, sprint, salto;
	private final Vector vel, acel;
	
	//Constructores
        
	public Mario(int f, double x, double y)
	{
	super(x, y, 0, (float)f - ((float)0.1f*f), (float) 0.675f + ((float) 0.125f*(f-1)), false, true, 1, true);
	
	if(f==3)
	{
            this.solido.setAlto(1.8f);
            this.solido.setAncho(0.8f);
	}
        
        vidas = 3;
        puntos = 0;
        monedas = 0;
	tiempo = 0;
	xfinal = 0;
        
	forma = f;
	fuego = 0;				//Indica el numero de bolas de fuego activas.
	tSalto = 0;
            
	invencible = false;
	arriba = false;
	abajo = false;
	izq = false;
	der = false;
	saltando = false;
	sprint = false;
	salto = false;
	
	vel = new Vector(0,0);
	acel = new Vector(0.002,0.004);   //Dado que las acceleraciones son constantes, no requieren del metodo set, y como el unico objeto que requiere estas constantes es uno de esta clase, tampoco requiere un metodo get.
	}                               //Nota adicional: el atributo "x" de acel represente la aceleracion normal del objeto, y el atributo "y" la aceleracion corriendo. 
 
	//Metodos get
        
	public int getVidas()
	{
		return vidas;
	}
        
	public int getPuntos()
	{
		return puntos;
	}
        
	public int getMonedas()
	{
		return monedas;
	}
        
	public int getForma()
	{
		return forma;
	}
	
	public int getFuego()
	{
		return fuego;
	}
	
	public int getTiempo()
	{
		return tiempo;
	}
	
	public boolean getInv()
	{
		return invencible;
	}
	
	public boolean getUp()
	{
		return arriba;
	}
	
	public boolean getDown()
	{
		return abajo;
	}
	
	public boolean getIzq()
	{
		return izq;
	}
	
	public boolean getDer()
	{
		return der;
	}
	
	public boolean getSalt()
	{
		return saltando;
	}
	
	public boolean getSprint()
	{
		return sprint;
	}
	
	public Vector getVel()
	{
		return vel;
	}
	
	public boolean getSalto()
	{
		return salto;
	}

	//Metodos set
	
	public void setVidas(int v)
	{
		this.vidas = v;
	}
	
	public void setPuntos(int v)
	{
		this.puntos = v;
	}
	
	public void setMonedas(int v)
	{
		this.monedas = v;
	}
	
	public void setForma(int f)
	{
		this.forma = f;
	}
	
	public void setFuego(int f)
	{
		this.fuego = f;
	}
        
        public void setTiempo(int t)
        {
            this.tiempo = t;
        }
        
        public void subTiempo()
        {
            this.tiempo--;
        }
	
	public void setInv(boolean inv)
	{
		this.invencible = inv;
	}
	
	public void setUp(boolean up)
	{
		this.arriba = up;
	}
	
	public void setDown(boolean down)
	{
		this.abajo = down;
	}
	
	public void setIzq(boolean izq)
	{
		this.izq = izq;
	}
	
	public void setDer(boolean der)
	{
		this.der = der;
	}
	
	public void setSalt(boolean s)
	{
		this.saltando = s;
	}
	
	public void setSalto(boolean s)
	{
		this.salto = s;
	}
	
	public void setSprint(boolean s)
	{
		this.sprint = s;
	}
	
        public void setControles()
        {
            this.arriba = false;
            this.abajo = false;
            this.der = false;
            this.izq = false;
            this.salto = false;
            this.sprint = false;
        }
        
	//Metoos adicionales:
        
        public void resetSalto()
        {
            this.tSalto = 0;
        }
	
	public void addForma()
	{
            if(forma == 1) //Solo tiene 2 formas
            {
		this.forma++;
                this.solido.setAlto(1.8f);
                this.solido.setAncho(0.8f);
            }
	}
	
	public void subForma()
	{
		this.forma--;
                this.getSolido().setSol(false);
                
                if(this.forma > 0)
                {
                    this.tInvulnerable = 150;
                }
                
                switch(this.forma)
                {
                    case 0:
                    SuperUDOBrothers.getMotor().setGameOver(true);
                    this.vel.set(0, 0);
                    break;
                    case 1:
                    this.solido.setAlto(0.8f);
                    this.solido.setAncho(0.675f);
                    SuperUDOBrothers.getMotor().getAudio().pley(27, 3);
                    break;
                    default:
                }
	}
        
        public void reset()
        {
            this.solido.setAlto(0.8f);
            this.solido.setAncho(0.675f);
            this.solido.setSol(true);
            
            this.posicion.setDir(0);
                    
            this.vidas = 3;
            this.puntos = 0;
            this.monedas = 0;
            this.tiempo = 0;
            this.xfinal = 0;
        
            this.forma = 1;
            this.fuego = 0;				//Indica el numero de bolas de fuego activas.
            this.tSalto = 0;
            
            this.invencible = false;
            this.arriba = false;
            this.abajo = false;
            this.izq = false;
            this.der = false;
            this.saltando = false;
            this.sprint = false;
            this.salto = false;
        }
        
        public void addPuntos(int p)
        {
            this.puntos += p;
        }
        
        public void addMonedas(int m)
        {
            this.monedas += m;
        }
	
	public void addFuego()
	{
		this.fuego++;
	}
	
	public void subFuego()
	{
		this.fuego--;
	}
	
        @Override
	public void actualizar(Mapa m)
	{
            //Leyendo posicion inicial
            
            int  x, y;
            x = (int) Math.round(this.posicion.getX());
            y = (int) Math.round(this.posicion.getY());
            
            Vector tVel = new Vector(this.vel);
            
            //Lee si mario es invulnerable
            
            if(this.tInvulnerable > 0)
            {
                if(this.tInvulnerable % 2 == 0)
                {
                    this.getSprite().setVis(!this.getSprite().getVis());
                }
                
                this.tInvulnerable--;
                
                if(this.tInvulnerable == 0)
                {
                    this.getSolido().setSol(true);
                    this.getSprite().setVis(true);
                }
            }
                
            //Verificando si el personaje está en el aire para hacer que la gravedad le afecte o si está en el suelo para permitirle saltar
	
            if(!m.getPiso(y,x,this))
            {
		if(this.vel.getY() - Vector.getGravedad() >= -0.5)
		{
                    this.vel.mover(0,Vector.getGravedad());
		}
		else
		{
                    this.vel.setY(-0.5);
		}
		this.saltando = true;
            }
            else
            {
		this.vel.setY(0);
		this.saltando = false;
            	this.tSalto = 0;
            }
		
            if(!SuperUDOBrothers.getMotor().getGameOver() && !SuperUDOBrothers.getMotor().getNivelCompletado())
            {
		
		//Salto
		
		if(salto)
		{
                    if(tSalto == 0)
                    {
                        if(forma == 1)
                        {
                            SuperUDOBrothers.getMotor().getAudio().pley(24, 3);
                        }
                        else
                        {
                            SuperUDOBrothers.getMotor().getAudio().pley(23, 3);
                        }
                    }
                    
                    if(!this.saltando)
                    {
			this.vel.mover(0,0.28);
			tSalto++;
                    }
                    else
                    {
			if(tSalto<=8)
			{
                            this.vel.mover(0,-Vector.getGravedad());
                            tSalto++;
			}
                    }
		}
		else
		{
			if(this.saltando)
			{
				tSalto = 9;
			}
		}
		
		//Coliciones con objetos (vertical)
		
		m.colisionVer(y,x,this.vel,this);
		
		//Movimiento horizontal
		
		if(der)
		{
			this.posicion.setDir(0);
		}
		else
		{
			if(izq)
			{
				this.posicion.setDir(2);
			}
		}
		
		if(izq^der)
		{
			if(!sprint)
			{
				if(der && (vel.getX() < 0.2))
				{
					if(vel.getX() >= 0)
					{
						this.vel.aceVel(acel.getX(), 0.2);
					}
					else
					{
						this.vel.mover(0.05,0);
					}
				}
				else
				{
					if(izq && (vel.getX() > -0.2))
					{
						if(vel.getX() <= 0)
						{
							this.vel.aceVel(-acel.getX(), -0.2);
						}
						else
						{
							this.vel.mover(-0.05,0);
						}
					}
				}
			}
			else
			{
				if(der && (vel.getX() < 0.24))
				{
					if(vel.getX() >= 0)
					{
						this.vel.aceVel(acel.getY(), 0.24);
					}
					else
					{
						this.vel.mover(0.08,0);
					}
				}
				else
				{
					if(izq && (vel.getX() > -0.24))
					{
						if(vel.getX() <= 0)
						{
							this.vel.aceVel(-acel.getY(), -0.24);
						}
						else
						{
							this.vel.mover(-0.08,0);
						}
					}
				}
			}
		}
			
		if(!sprint)
		{
			if(vel.getX() < -0.2)
			{
				this.vel.setX(-0.2);
			}
			else
			{
				if(vel.getX() > 0.2) 
				{
					this.vel.setX(0.2);
				}
			}	
		}
		
		if((!der && !izq) || (der && izq))
		{
			if((vel.getX() > 0))
			{
				vel.deAceVel(-0.01);
			}
			else
			{
                            if((vel.getX() < 0))
                            {
				vel.deAceVel(0.01);
                            }	
			}
		}
		
		//Coliciones con objetos (horizontal)
		
		m.colisionHor(y,x,this.vel,this);
            }
            
            //verificaciones
            
            if(SuperUDOBrothers.getMotor().getGameOver() && (this.vel.getX() != 0 || this.vel.getY() != 0))
            {
               this.vel.set(0, 0);
            }
            
            if(SuperUDOBrothers.getMotor().getNivelCompletado())
            {
                xfinal = (int) this.posicion.getX();                
                if(m.checkObj(y-1, xfinal))
                {
                    if(m.getTipo(y-1, xfinal).equals("Bloque"))
                    {
                        if(m.getBloque(y-1, xfinal).getReacID() == 6)
                        {
                            xfinal--;
                        }
                    }
                }
                
                this.vel.set(tVel.getX(), tVel.getY());
            }
		
            //reposicionamiento.
		
            this.posicion.mover(vel); //mueve a Mario su nueva posicion
                
            //actualizacion  grafica
            
            actualizarGraficos();
            
            //Actualizacion en mapa
                
            if(!SuperUDOBrothers.getMotor().getGameOver())
            {
		m.actualizarPos(y,x,this);
            }
	}
        
    public void actualizarGraficos()
    {
        switch(this.forma)
        {
            case 0:
            this.solido.setAlto(0.8f);
            this.solido.setAncho(0.675f);
            actualizarSprite(13, 13, 13, 13, 13);
            break;
            case 1:
            actualizarSprite(5, 1, 11, 2, 4);
            break;
            case 2:
            actualizarSprite(10, 6, 12, 7, 9);
        }
    }
        
    public void actualizarSprite(int s, int p, int c, int l1, int l2)
    {
        if((salto || (this.getSprite().getImgID()==s))&&(saltando))
        {
            this.getSprite().setImgID(s);
        }
        else
        {
            if(this.vel.getX()==0)
            {
                this.getSprite().setImgID(p);
            }
            else
            {
                if((der && this.vel.getX()<0) || (izq && this.vel.getX()>0))
                {
                    this.getSprite().setImgID(c);
                    this.getSprite().setSubID(-6);
                }
                else
                {
                    this.getSprite().roam((int) ((double) 10 - Math.abs((double)this.vel.getX() * 30)),l1,l2);
                }
            }
        }
    }
    
    public void completarNivel(Mapa m, int tnc)
    {
        int  x, y;
        x = (int) Math.round(this.posicion.getX());
        y = (int) Math.round(this.posicion.getY());
        
        if(tnc == 0)
        {
            m.moverEspecial(y, x-3, this);
        }
        
        if(tnc < 30)
        {
            if(this.vel.getY() - Vector.getGravedad() >= 0)
            {
                this.vel.mover(0,Vector.getGravedad());
            }
            else
            {
                this.vel.setY(0);
            }
        }
        
        if(this.vel.getX() > 0)
        {
            if(this.posicion.getX() + this.vel.getX() > (double) this.xfinal + 0.9 && tnc < 60)
            {
                if(this.forma >= 2)
                {
                    this.posicion.setX((double) this.xfinal + 0.8);
                }
                else
                {
                    this.posicion.setX((double) this.xfinal + 1.05);
                }
                this.vel.set(0, 0);
                this.getSprite().setImgID(13 + this.forma);
                SuperUDOBrothers.getMotor().setTNivelCompletado(30);
            }
        }
        else
        { 
            if(this.posicion.getX() + this.vel.getX() < (double) this.xfinal - 0.1 && tnc < 60)
            {
                if(this.forma >= 2)
                {
                    this.posicion.setX((double) this.xfinal - 0.2);
                    this.posicion.setDir(0);
                }
                else
                {
                    this.posicion.setX((double) this.xfinal + 0.05);
                    this.posicion.setDir(0);
                }
                this.vel.set(0, 0);
                this.getSprite().setImgID(13 + this.forma);
                SuperUDOBrothers.getMotor().setTNivelCompletado(30);
            }
        }
        
        if(tnc == 60)
        {
            this.vel.setY(-0.1);
        }
        
        if(m.checkObj(y-1, x))
        {
            if(m.getTipo(y-1, x).equals("Bloque"))
            {
                if(m.getBloque(y-1, x).getSprite().getImgID() != 16)
                {
                    if(this.posicion.getY() + this.vel.getY() < m.getBloque(y-1, x).getPos().getY() + m.getBloque(y-1, x).getSolido().getAlto())
                    {
                        this.vel.setY(0);
                        this.posicion.setY(m.getBloque(y-1, x).getPos().getY() + 1);
                    }
                }
            }
        }
        
        if(m.getPiso(y,x,this) && this.vel.getY() == 0 && tnc < 499 && tnc > 60)
        {
            this.getSprite().setImgID(16 + this.forma);
            SuperUDOBrothers.getMotor().setTNivelCompletado(499);
        }
        
        if(tnc == 530)
        {
            this.vel.setX(0.1);
        }
        
        if(tnc >= 530)
        {
            actualizarGraficos();
        }
        
        if(tnc >=539)
        {
            if(!m.getPiso(y,x,this))
            {
		{
                    this.vel.setY(-0.3);
		}
            }
            else
            {
		this.vel.setY(0);
            }
            
            m.colisionVer(y, x, this.vel, this);
        }
        
        if(this.posicion.getX() + this.vel.getX() > this.xfinal + 9)
        {
            this.posicion.setX((double)this.xfinal + 9.1);
            this.vel.setX(0);
        }
        
        this.posicion.mover(this.vel);
    }
    
    public boolean sumarPuntos()
    {
        if(this.tiempo != 0)
        {
            this.puntos += 150;
            this.tiempo--;
        }
        
        if(this.vidas != 0)
        {
            this.puntos += 4000;
            this.vidas--;
        }
        
        if(this.vidas == 0 && this.tiempo == 0)
        {
            return true;
        }
        return false;
    }
}