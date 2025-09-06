package superudobrothers.objetos;

public class SpriteManager
{
	//Atributos
	
	private int imgID, subID; //Determina el sprite del objeto
	private boolean visible; //Determina si el objeto es visible
	
	//Constructores:
		
	public SpriteManager()
	{
		imgID = 0;
		visible = false;
	}
	
	public SpriteManager(int ID, boolean vis)
	{
		imgID = ID;
		visible = vis;
	}
	
	//Metodos get:
	
	public int getImgID()
	{
		return imgID;
	}
        
	public int getSubID()
	{
		return subID;
	}
	
	public boolean getVis()
	{
		return visible;
	}
	
	//Metodos set:
	
	public void setImgID(int ID)
	{
		imgID = ID;
	}
        
	public void setSubID(int ID)
	{
		subID = ID;
	}
	
	public void setVis(boolean vis)
	{
		visible = vis;
	}
	
	/*El metodo roam es un metodo que permite "agrupar" ID's consecutivas y relacionadas, para cambiar facilmente entre ellas.*
	 *Por ejemplo, los estados de un bloque rompiendose.																	  *
	 *Estamos considerando otros metodos para hacer esto.																	  *
	 *Así que es posible que en futuros avances este metodo sea eliminado.                                                    */    
	
	public void roam(int c, int l1, int l2)
	{
            if((this.imgID < l1 || this.imgID >l2) && this.subID > 0)
            {
                this.imgID = l1;
            }
            
            if(this.subID >= c)
            {
                if(this.imgID == l2)
                {
                    this.imgID = l1;
                }
                else
                {
                    this.imgID++;
                }
                
                this.subID = 0;
            }
            
            this.subID++;
	}
}