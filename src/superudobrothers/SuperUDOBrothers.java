package superudobrothers;

public class SuperUDOBrothers
{
    //Atributos
    
    private static Motor JUEGO;
    
    //Constructor

    public SuperUDOBrothers() 
    {
        JUEGO = new Motor();
    }

    //Metodo Main

    public static void main(String[] args)
    {
        SuperUDOBrothers J = new SuperUDOBrothers();
        J.start();
    }

    //Arranque
    
    public void start()
    {
        JUEGO.indiceEstado();
    }
    
    //Metodo usado para enviar informacion desde las interfaces al motor.
    
    public static Motor getMotor()
    {
        return JUEGO;
    }
}