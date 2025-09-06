package superudobrothers;

import superudobrothers.cargadores.LectorArchivos;
import superudobrothers.objetos.Vector;
import superudobrothers.objetos.Objeto;
import superudobrothers.objetos.Mario;
import superudobrothers.objetos.Bloque;
import superudobrothers.objetos.Item;
import superudobrothers.objetos.Enemigo;

public class Mapa
{
	//Atributos
	
	private int alto=0, ancho=0, tiempo;
	private Objeto terreno[][];
	
	//Constructor
	
	public Mapa(String m, Mario p)
	{
		LectorArchivos l;
		l = new LectorArchivos(m);
                try
                {
                    alto = l.leer("alto",3);
                    ancho = l.leer("ancho",3);
                    tiempo = l.leer("tiempo", 3);
                    terreno = new Objeto[alto][ancho];
                }
                catch(Exception e)
                {
                    System.out.println("Error en la creacion de mapas: " + e);
                }
                    
		//Este constructor traduce el archivo de texto guardado anteriormente y lo traduce a un mapa de objetos dentro de una matriz.
		
		for(int j=0; j < alto; j++)
		{
			for(int i=0; i < ancho; i++)
			{
				switch(l.getTipo(i,alto-j))
				{
					case 'a': //piedra
					terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 1, true, false, false, false, -1);
					break;
					case 'b': //ladrillos
					terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 2, true, true, false, false, 0);
					break;
					case 'c': //Muro
                                        terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 15, true, false, false, false, -1);
					break;
					case 'd': //ladrillos sin bordes
					terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 21, true, true, false, false, 0);
					break;
					case 'e': //ladrillos sin bordes
					terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 21, false, true, false, false, 0);
                                        ((Bloque) terreno[j][i]).setTemp(true);
                                        ((Bloque) terreno[j][i]).setTF(150);
					break;
					case 'f': //ladrillo moneda
                                        terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 2, true, true, false, false, 4);
                                        ((Bloque) terreno[j][i]).setUsos(10);
					break;
					case 'g': //Goomba
                                        terreno[j][i] = new Enemigo(i, j, 2, 1, 1, true, true, 1, true, 1, 1, -0.03, 0);
					break;
					case 'h': //Koopa verde
                                        terreno[j][i] = new Enemigo(i, j, 0, 1.5f, 1, true, true, 4, true, 2, 2, -0.03, 0);
					break;
					case 'i': //Koopa rojo
                                        terreno[j][i] = new Enemigo(i, j, 0, 1.5f, 1, true, true, 7, true, 2, 3, -0.03, 0);
					break;
					case 'j':
					break;
					case 'k':
					break;
					case 'l':
					break;
					case 'm': //mario
					terreno[j][i] = p;
					terreno[j][i].getPos().setX(i);
					terreno[j][i].getPos().setY(j);
                                        p.setTiempo(tiempo);
					break;
					case 'n':
					break;
					case 'o':
					break;
					case 'p': //Bloque sorpresa on power up
                                        terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 3, true, true, false, false, 3);
					break;
					case 'q': //moneda g
                                        terreno[j][i] = new Item(i+0.1875, j, 0.875f, 0.625f, false, false, 1, true, false, 1, 0, 0, false, -1, true);
					break;
					case 'r': //moneda
                                        terreno[j][i] = new Item(i+0.1875, j, 0.875f, 0.625f, false, false, 1, true, false, 1, 0, 0, false, -1, false);
					break;
					case 's': //bloque sorpresa con moneda
                                        terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 3, true, true, false, false, 1);
					break;
					case 't': //tubería pequeña
                                        terreno[j][i] = new Bloque(i, j, 2, 2, false, true, 6, true, false, false, false, 2);
					break;
					case 'u': //tubería extension
                                        terreno[j][i] = new Bloque(i, j, 1, 2, false, true, 7, true, false, false, false, -1);
					break;
					case 'v': //plataforma
					terreno[j][i] = new Bloque(i,(double) j + 0.5, 0.5f, 1, false, true, 22, true, false, false, false, -1);
					break;
					case 'w': //pataforma verde 1
					terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 24, true, false, false, false, -1);
					break;
					case 'x': //pataforma verde 2
					terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 25, true, false, false, false, -1);
					break;
					case 'y': //pataforma verde 3
					terreno[j][i] = new Bloque(i, j, 1, 1, false, true, 26, true, false, false, false, -1);
					break;
					case 'z':
					break;
					case 'A': //Castillo pared 1
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 8, true, false, false, false, -1);
					break;
					case 'B': //Castillo puerta 1
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 9, true, false, false, false, -1);
					break;
					case 'C': //Castillo puerta 2
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 10, true, false, false, false, -1);
					break;
					case 'D': //Castillo terrasa 1
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 11, true, false, false, false, -1);
					break;
					case 'E': //Castillo terrasa 2
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 12, true, false, false, false, -1);
					break;
					case 'F': //Castillo ventana 1
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 13, true, false, false, false, -1);
					break;
					case 'G': //Castillo ventana 2
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 14, true, false, false, false, -1);
					break;
					case 'H': //Asta
					terreno[j][i] = new Bloque((double)i+0.4375, j, 1, 0.125f, false, true, 16, true, true, false, false, 5); 
					break;
					case 'I': //Tope
					terreno[j][i] = new Bloque((double)i+0.25, j, 0.5f, 0.5f, false, true, 17, true, true, false, false, 6); 
					break;
					case 'J': //Bandera
					terreno[j][i] = new Bloque((double)i+0.4375, j, 1, 1, false, false, 18, true, false, false, false, -1); 
					break;
					case 'K': //tronco
					terreno[j][i] = new Bloque(i, j, 1, 1, false, false, 23, true, false, false, false, -1);
					break;
                                        
					default:
				}
			}
		}
	}
	
	//Metodos get
	
	public int getAlto()
	{
		return this.alto;
	}
	
	public int getAncho()
	{
		return this.ancho;
	}
	
	//Metodos
	
	public boolean checkObj(int y, int x)
	{
		if(terreno[y][x]!=null)
		{
			return true;
		}
		return false;
	}
	
	public String getTipo(int y, int x)
	{
		return terreno[y][x].getClass().getSimpleName();
	}
	
	public Bloque getBloque(int y, int x)
	{
		return (Bloque)terreno[y][x];
	}
	
	public Mario getMario(int y, int x)
	{
		return (Mario)terreno[y][x];
	}
	
	public Item getItem(int y, int x)
	{
		return (Item)terreno[y][x];
	}
	
	public Enemigo getEnemigo(int y, int x)
	{
		return (Enemigo)terreno[y][x];
	}
        
        public Objeto getObj(int y, int x)
        {
            return terreno[y][x];
        }
	
	public void actualizarPos(int y, int x, Objeto o)
	{
		int nx, ny;
		nx = (int) Math.round(o.getPos().getX());
		ny = (int) Math.round(o.getPos().getY());
                if((nx>=0&&nx<ancho)&&(ny>=0&&ny<alto))
                {
                    if((x!=nx||y!=ny)&&(terreno[ny][nx]==null))
                    {
                        terreno[ny][nx] = o;
                        for(int j = y-15; j <= y+15; j++)
                        {
                            if(j<0 || j>=this.getAlto())
                            {
				continue;
                            }
                            
                            for(int i = x-24; i <= x+24; i++)
                            {
				if(i<0 || i>=this.getAncho())
				{
					continue;
				}
                                
				if(nx == i && ny == j)
				{
					continue;
				}
                                
                                if(terreno[j][i] == o)
                                {
                                    terreno[j][i] = null;
                                }
                            }
                        }
                    }
                }
	}
	
	public boolean getPiso(int y, int x, Objeto o) //esto se podría hacer con un solo if masivo, pero como es un proyecto y quiero que sea más ameno para el lector lo de puse como un if anidado. Posiblemente una de las condiciones se convierta en un metodo.
	{
		for(int j = y-1; j >= y-5; j--)
		{
			if(j<0 || j>=this.getAlto())
			{
				continue;
			}
                        
			for(int i = x+1; i >= x-5; i--)
			{
				if(i<0 || i>=this.getAncho())
				{
					continue;
				}
                                
				if(this.checkObj(j,i))
				{
                                    if(this.getObj(j,i).getSolido().getSol())
                                    {
					if(o != this.getObj(j,i) && this.getTipo(j,i).equals("Bloque"))
					{
                                            if(!redCap(o))
                                            {
						if((this.getObj(j,i).getPos().getX() - o.getSolido().getAncho() < o.getPos().getX()) && (this.getObj(j,i).getPos().getX() + this.getObj(j,i).getSolido().getAncho() > o.getPos().getX()))
						{
							if(this.getObj(j,i).getPos().getY() + this.getObj(j,i).getSolido().getAlto() == o.getPos().getY())
							{
								return true;
							}
						}
                                            }
                                            else
                                            {
						if((this.getObj(j,i).getPos().getX() < o.getPos().getX()) && (this.getObj(j,i).getPos().getX() + this.getObj(j,i).getSolido().getAncho() > o.getPos().getX()))
						{
							if(this.getObj(j,i).getPos().getY() + this.getObj(j,i).getSolido().getAlto() == o.getPos().getY())
							{
								return true;
							}
						}
                                            }
					}
                                    }
				}
			}
		}
		return false;
	}
	
	public void colisionVer(int y, int x, Vector v, Objeto o)
	{
            if((o.getPos().getY() + v.getY() >= 0)&&(o.getPos().getY() + v.getY() + o.getSolido().getAlto() < alto))
            {
		for(int j = y-5; j <= y+2; j++)
		{
			if(v.getY() == 0)
			{
				break;
			}
                        
			if(j<0 || j>=this.getAlto())
			{
				continue;
			}
			
			for(int i = x-5; i <= x+2; i++)
			{
				if(i<0 || i>=this.getAncho())
				{
					continue;
				}
                                
				if(this.getObj(j, i) == o)
				{
					continue;
				}
				
				if(this.checkObj(j,i))
				{
                                    if((this.getTipo(j, i).equals("Item") || this.getObj(j,i).getSolido().getSol()))
                                    {
					if(o != this.getObj(j,i) /*this.getTipo(j,i).equals("Bloque"*/)
					{
						if((this.getObj(j,i).getPos().getX() - o.getSolido().getAncho() < o.getPos().getX()) && (this.getObj(j,i).getPos().getX() + this.getObj(j,i).getSolido().getAncho() > o.getPos().getX()))
						{
							if(o.getPos().getY()-this.getObj(j,i).getPos().getY()>0)
							{
								if(o.getPos().getY() + v.getY() < this.getObj(j,i).getPos().getY() + this.getObj(j,i).getSolido().getAlto())
								{
                                                                    if(!(this.getTipo(j, i).equals("Item")) && !(o.getClass().getSimpleName().equals("Item") && this.getTipo(j, i).equals("Enemigo")))
                                                                    {
                                                                        o.getPos().setY(this.getObj(j,i).getPos().getY() + this.getObj(j,i).getSolido().getAlto());
                                                                    	v.setY(0);
                                                                    }    
                                                                    
                                                                    if(o.getClass().getSimpleName().equals("Mario") && this.getTipo(j, i).equals("Enemigo"))
                                                                    {
                                                                        this.marioGana(o, this.getObj(j, i));
                                                                    }
                                                                    else
                                                                    {
                                                                        if(this.getObj(j,i).getSolido().getSol())
                                                                        {
                                                                            this.marioPierde(o, this.getObj(j, i));
                                                                        }
                                                                    }
                                                                    
                                                                    reactBlock(o,this.getObj(j, i),3);
                                                                    
                                                                    reactItem(o,this.getObj(j, i));
                                                                    
                                                                    colisionEnemigo(o,this.getObj(j, i));
								}
							}
							else
							{
                                                            if(o.getPos().getY()-this.getObj(j,i).getPos().getY()<0)
                                                            {
								if(o.getPos().getY() + v.getY() > this.getObj(j,i).getPos().getY() - o.getSolido().getAlto())
								{
                                                                    if(!(this.getTipo(j, i).equals("Item")) && !(o.getClass().getSimpleName().equals("Item") && this.getTipo(j, i).equals("Enemigo")))
                                                                    {
									o.getPos().setY(this.getObj(j,i).getPos().getY() - o.getSolido().getAlto());
									v.setY(0);
                                                                    }   
                                                                    
                                                                    if(o.getClass().getSimpleName().equals("Mario") && this.getTipo(j, i).equals("Enemigo"))
                                                                    {
                                                                        if(o.getSolido().getSol())
                                                                        {
                                                                            this.marioPierde(o, this.getObj(j, i));
                                                                        }
                                                                    }
                                                                    else
                                                                    {
                                                                        this.marioGana(o, this.getObj(j, i));
                                                                    }
                                                                        
                                                                    reactBlock(o,this.getObj(j, i),1);
                                                                    
                                                                    reactItem(o,this.getObj(j, i));
                                                                    
                                                                    colisionEnemigo(o,this.getObj(j, i));
								}
                                                            }
							}
						}
					}
                                    }
				}
			}
		}
            }
            else
            {
                if(!o.getClass().getSimpleName().equals("Mario"))
                {
                    o.getSprite().setVis(false);
                    o.getPos().set(0,alto - 2);
                }
                else
                {
                    if(o.getPos().getY() + v.getY() < 0)
                    {
                        SuperUDOBrothers.getMotor().setGameOver(true);
                    }
                    else
                    {
                        o.getPos().setY((double) alto - o.getSolido().getAlto());
                        v.setY(0);
                    }
                }
            }
	}
	
	public void colisionHor(int y, int x, Vector v, Objeto o)
	{
            if((o.getPos().getX() + v.getX() >= 0)&&(o.getPos().getX() + v.getX() + o.getSolido().getAncho() < ancho))
            {
		for(int i = x+2; i >= x-5; i--)
		{
			if(v.getX() == 0)
			{
				break;
			}
			
			if(i<0 || i>=this.getAncho())
			{
				continue;
			}
			
			for(int j = y-5; j <= y+2; j++)
			{
				if(j<0 || j>=this.getAlto())
				{
					continue;
				}
                                
				if(this.getObj(j, i) == o)
				{
					continue;
				}
				
				if(this.checkObj(j,i))
				{
                                    if((this.getTipo(j, i).equals("Item") || this.getObj(j,i).getSolido().getSol()) && (o.getSolido().getSol() || !this.getTipo(j, i).equals("Enemigo") || this.cap(this.getObj(j, i))))
                                    {
					if(o != this.getObj(j,i))
					{
						if((this.getObj(j,i).getPos().getY() < o.getSolido().getAlto() + o.getPos().getY()) && (this.getObj(j,i).getPos().getY() + this.getObj(j,i).getSolido().getAlto() > o.getPos().getY()))
						{
							if(v.getX() > 0)
							{
                                                            if(o.getPos().getX() < this.getObj(j,i).getPos().getX())
                                                            {
                                                                if(o.getPos().getX() + v.getX() > this.getObj(j,i).getPos().getX() - o.getSolido().getAncho())
								{
                                                                    if(!this.getTipo(j, i).equals("Item") && !((o.getClass().getSimpleName().equals("Enemigo") && this.cap(this.getObj(j, i))) || (this.cap(o) && this.getTipo(j, i).equals("Enemigo"))) && !((this.cap(o) && this.getTipo(j, i).equals("Mario")) || (o.getClass().getSimpleName().equals("Mario") && this.cap(this.getObj(j, i)))) && !(o.getClass().getSimpleName().equals("Item") && this.getTipo(j, i).equals("Enemigo")))
                                                                    {
                                                                        o.getPos().setX(this.getObj(j,i).getPos().getX() - o.getSolido().getAncho());
                                                                        v.setX(0);
                                                                    }
                                                                    
                                                                    reactEnemigo(o,this.getObj(j,i),0);
                                                                        
                                                                    reactBlock(o,this.getObj(j, i),0);
                                                                    
                                                                    reactItem(o,this.getObj(j, i));
                                                                    
                                                                    colisionEnemigo(o,this.getObj(j, i));
								}
                                                            }
							}
							else
							{
                                                            if(o.getPos().getX() > this.getObj(j,i).getPos().getX())
                                                            {
								if(o.getPos().getX() + v.getX() < this.getObj(j,i).getPos().getX() + this.getObj(j,i).getSolido().getAncho())
								{
                                                                    if(!this.getTipo(j, i).equals("Item") && !((o.getClass().getSimpleName().equals("Enemigo") && this.cap(this.getObj(j, i))) || (this.cap(o) && this.getTipo(j, i).equals("Enemigo"))) && !((this.cap(o) && this.getTipo(j, i).equals("Mario")) || (o.getClass().getSimpleName().equals("Mario") && this.cap(this.getObj(j, i))))  && !(o.getClass().getSimpleName().equals("Item") && this.getTipo(j, i).equals("Enemigo")))
                                                                    {
                                                                        o.getPos().setX(this.getObj(j,i).getPos().getX() + this.getObj(j,i).getSolido().getAncho());
                                                                        v.setX(0);
                                                                    }
                                                                    
                                                                    reactEnemigo(o,this.getObj(j,i),2);
                                                                        
                                                                    reactBlock(o,this.getObj(j, i),2);
                                                                    
                                                                    reactItem(o,this.getObj(j, i));
                                                                    
                                                                    colisionEnemigo(o,this.getObj(j, i));
								}
                                                            }
							}
						}
					}
                                    }
				}
			}
		}
            }
            else
            {
                if(o.getPos().getX() + v.getX() < 0)
                {
                    o.getPos().setX(0);
                    v.setX(0);
                }
                else
                {
                    o.getPos().setX((double) ancho - o.getSolido().getAncho());
                    v.setX(0);
                }
            }
	}
	
	public void actualizarEntorno(Mario m)
	{
		int x, y;
		x = (int) Math.round(m.getPos().getX());
		y = (int) Math.round(m.getPos().getY());

		for(int j = y-16; j <= y+16; j++)
		{
			if(j<0 || j>=this.getAlto())
			{
				continue;
			}
			
			for(int i = x-24; i <= x+24; i++)
			{
				if(i<0 || i>=this.getAncho())
				{
					continue;
				}
				
				if(this.getObj(j, i) == m)
				{
					continue;
				}
                                
                                if(this.checkObj(j, i))
                                {
                                    if(this.getTipo(j, i).equals("Item"))
                                    {
                                        if(this.getItem(j, i).getTemp() && this.getItem(j, i).getTF() <= 0)
                                        {
                                            this.terreno[j][i] = null;
                                        }
                                        else
                                        {
                                            this.terreno[j][i].actualizar(this);
                                        }
                                    }
                                    else
                                    {
                                        if(this.getTipo(j, i).equals("Bloque"))
                                        {
                                            if(this.getBloque(j, i).getTemp() && this.getBloque(j, i).getTF() <= 0)
                                            {
                                                this.terreno[j][i] = null;
                                            }
                                            else
                                            {
                                                this.terreno[j][i].actualizar(this);
                                            }
                                        }
                                        else
                                        {
                                            this.terreno[j][i].actualizar(this);
                                        }
                                    }
                                }
			}
		}
	}
        
        //Mario vs Enemigo (Hor = pierde) (VerDown = pierde) (VerUp = gana)
        
        public void marioPierde(Objeto o1, Objeto o2)
        {
            if((o1.getClass().getSimpleName().equals("Mario") && o2.getClass().getSimpleName().equals("Enemigo")) || (o1.getClass().getSimpleName().equals("Enemigo") && o2.getClass().getSimpleName().equals("Mario")))
            {
                if(o2.getClass().getSimpleName().equals("Enemigo"))
                {
                    ((Mario) o1).subForma();
                }
                else
                {
                    ((Mario) o2).subForma();
                }
            }
        }
        
        public void marioGana(Objeto o1, Objeto o2)
        {
            if((o1.getClass().getSimpleName().equals("Mario") && o2.getClass().getSimpleName().equals("Enemigo")) || (o1.getClass().getSimpleName().equals("Enemigo") && o2.getClass().getSimpleName().equals("Mario")))
            {
                if(o1.getClass().getSimpleName().equals("Enemigo"))
                {
                    ((Enemigo) o1).subVida(false);
                    ((Mario) o2).getVel().setY(0.24);
                    ((Mario) o2).resetSalto();
                    ((Mario) o2).addPuntos(200);
                }
                else
                {
                    ((Enemigo) o2).subVida(false);
                    ((Mario) o1).getVel().setY(0.24);
                    ((Mario) o1).resetSalto();
                    ((Mario) o1).addPuntos(200);
                }
            }
        }
        
        public void reactEnemigo(Objeto o1, Objeto o2, int d)
        {
            if((o1.getClass().getSimpleName().equals("Mario") && o2.getClass().getSimpleName().equals("Enemigo")) || (o1.getClass().getSimpleName().equals("Enemigo") && o2.getClass().getSimpleName().equals("Mario")))
            {
                if(o2.getClass().getSimpleName().equals("Enemigo"))
                {
                    if(((Enemigo) o2).getEID() > 1)
                    {
                        if(((Enemigo) o2).getVida() < 2)
                        {
                            if(((Enemigo) o2).getVel().getX() != 0 && o1.getSolido().getSol())
                            {
                                ((Mario) o1).subForma();
                            }
                            
                            if(((Enemigo) o2).getVel().getX() == 0)
                            {
                                if(d == 0)
                                {
                                    ((Enemigo) o2).getVel().setX(0.24);
                                    ((Mario) o1).getVel().mover(-0.01, 0);
                                }
                                else
                                {
                                    ((Enemigo) o2).getVel().setX(-0.24);
                                    ((Mario) o1).getVel().mover(0.01, 0);
                                }
                            }
                                
                            if(((Mario) o1).getForma() > 0)
                            {
                                SuperUDOBrothers.getMotor().getAudio().pley(19, 3);
                            }
                        }
                        else
                        {
                            if(o1.getSolido().getSol())
                            {
                                marioPierde(o1,o2);
                            }
                        }
                    }
                    else
                    {
                        if(o1.getSolido().getSol())
                        {
                            marioPierde(o1,o2);
                        }
                    }
                }
                else
                {
                    if(((Enemigo) o1).getEID() > 1)
                    {
                        if(((Enemigo) o1).getVida() < 2)
                        {
                            if(((Enemigo) o1).getVel().getX() != 0 && o2.getSolido().getSol())
                            {
                                ((Mario) o2).subForma();
                            }
                            
                            if(((Enemigo) o1).getVel().getX() == 0)
                            {
                                if(d == 0)
                                {
                                    ((Enemigo) o1).getVel().setX(0.24);
                                    ((Mario) o2).getVel().mover(-0.01, 0);
                                }
                                else
                                {
                                    ((Enemigo) o1).getVel().setX(-0.24);
                                    ((Mario) o2).getVel().mover(0.01, 0);
                                }
                            }
                                
                            if(((Mario) o2).getForma() > 0)
                            {
                                SuperUDOBrothers.getMotor().getAudio().pley(19, 3);
                            }
                        }
                        else
                        {
                            if(o2.getSolido().getSol())
                            {
                                marioPierde(o1,o2);
                            }
                        }
                    }
                    else
                    {
                        if(o2.getSolido().getSol())
                        {
                            marioPierde(o1,o2);
                        }
                    }
                }
            }
        }
        
        public void reactBlock(Objeto o1, Objeto o2, int d)
        {
            if(o1.getClass().getSimpleName().equals("Mario") && o2.getClass().getSimpleName().equals("Bloque"))
            {
                if(((Bloque) o2).getReaccion() && ((Bloque) o2).getReacID() >= 0)
                {
                    ((Bloque) o2).reaccion(this,d, (Mario) o1);
                }
            }
        }
        
        public void reactItem(Objeto o1, Objeto o2)
        {
            if((o1.getClass().getSimpleName().equals("Mario") && o2.getClass().getSimpleName().equals("Item")) || (o2.getClass().getSimpleName().equals("Mario") && o1.getClass().getSimpleName().equals("Item")))
            {
                if(o1.getClass().getSimpleName().equals("Mario"))
                {
                    ((Item) o2).reaccion((Mario) o1);
                }
                else
                {
                    ((Item) o1).reaccion((Mario) o2);
                }
            }
        }
        
        public void colisionEnemigo(Objeto o1, Objeto o2)
        {
            if(o1.getClass().getSimpleName().equals("Enemigo") && o2.getClass().getSimpleName().equals("Enemigo"))
            {
                if(((Enemigo) o1).getEID() > 1)
                {
                    if(((Enemigo) o1).getVida() < 2)
                    {
                        ((Enemigo) o2).subVida(true);
                        SuperUDOBrothers.getMotor().getMario().addPuntos(400);
                        SuperUDOBrothers.getMotor().getAudio().pley(19, 3);
                    }
                }
            }
        }
        
        //Medotodos especiales
        
        public boolean redCap(Objeto o)
        {
            if(o.getClass().getSimpleName().equals("Enemigo"))
            {
                if(((Enemigo) o).getEID() == 3)
                {
                    return true;
                }
            }
            return false;
        }
        
        public boolean cap(Objeto o)
        {
            if(o.getClass().getSimpleName().equals("Enemigo"))
            {
                if(((Enemigo) o).getEID() > 1)
                {
                    return true;
                }
            }
            return false;
        }
                
	public void insertar(Objeto o)
        {
            int  x, y;
            x = (int) Math.round(o.getPos().getX());
            y = (int) Math.round(o.getPos().getY());
            
            if(terreno[y][x]==null)
            {
                terreno[y][x] = o;
            }
        }
        
        public void moverEspecial(int y, int x, Objeto o)
        {
            if((x>=0&&x<ancho)&&(y>=0&&y<alto))
            {
                if(terreno[y][x]==null)
                {
                    terreno[y][x] = o;
                    for(int j = y-15; j <= y+15; j++)
                    {
                        if(j<0 || j>=this.getAlto())
                        {
                            continue;
                        }
                            
                        for(int i = x-24; i <= x+24; i++)
                        {
                            if(i<0 || i>=this.getAncho())
                            {
				continue;
                            }
                                
                            if(x == i && y == j)
                            {
				continue;
                            }
                                
                            if(terreno[j][i] == o)
                            {
                                terreno[j][i] = null;
                            }
                        }
                    }
                }
            }
        }
}