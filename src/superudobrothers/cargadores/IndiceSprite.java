package superudobrothers.cargadores;

import superudobrothers.Motor;
import superudobrothers.objetos.Objeto;

public class IndiceSprite
{
    //Atributos
    
    private int x, y, w, h, tipo, ug;
    
    //Constructor
    
    public IndiceSprite(Objeto o)
    {
        ug = 0;
        if(Motor.getSelectM().equals("2.txt"))
        {
            ug = 1;
        }
        switch(o.getClass().getSimpleName())
        {
            case "Mario":
            tipo = 0;
            indiceMario(o);
            break;
            case "Bloque":
            tipo = 1;
            indiceBloque(o);
            break;
            case "Enemigo":
            tipo = 1;
            indiceEnemigo(o);
            break;
            case "Item":
            tipo = 1;
            indiceItem(o);
            break;
            default:
            System.out.println("Tipo de objeto invalido"); //Personalmente, no se como esto popdría ocurir.
        }
    }
    
    //Métodos get
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getW()
    {
        return w;
    }
    
    public int getH()
    {
        return h;
    }
    
    public int getTipo()
    {
        return tipo;
    }
    
    //Subindices
    
    public void indiceMario(Objeto o)
    {
        switch(o.getSprite().getImgID())
        {
            case 1: //base f1
            x = 82;
            y = 34;
            w = 12;
            h = 16;
            break; 
            case 2: //caminar1 f1
            x = 99;
            y = 34;
            w = 12;
            h = 16;
            break; 
            case 3: //caminar2 f1
            x = 116;
            y = 34;
            w = 12;
            h = 16;
            break; 
            case 4: //caminar3 f1
            x = 133;
            y = 34;
            w = 12;
            h = 16;
            break; 
            case 5: //saltar f1
            x = 167;
            y = 34;
            w = 12;
            h = 16;
            break;
            case 6: //base f2
            x = 80;
            y = 1;
            w = 16;
            h = 32;
            break;
            case 7: //caminar1 f2
            x = 97;
            y = 1;
            w = 16;
            h = 32;
            break;
            case 8: //caminar2 f2
            x = 114;
            y = 1;
            w = 16;
            h = 32;
            break;
            case 9: //caminar3 f2
            x = 131;
            y = 1;
            w = 16;
            h = 32;
            break;
            case 10: //saltar f2
            x = 165;
            y = 1;
            w = 16;
            h = 32;
            break;
            case 11: //Derrape f1
            x = 150;
            y = 34;
            w = 12;
            h = 16;
            break;
            case 12: //Derrape f2
            x = 148;
            y = 1;
            w = 16;
            h = 32;
            break;
            case 13: //Gameover
            x = 184;
            y = 34;
            w = 12;
            h = 16;
            break;
            case 14: //bandera 1 f1
            x = 201;
            y = 34;
            w = 14;
            h = 16;
            break;
            case 15: //bandera 1 f2
            x = 201;
            y = 3;
            w = 14;
            h = 30;
            break;
            case 16:
            break;
            case 17: //bandera 2 f1
            x = 217;
            y = 34;
            w = 14;
            h = 16;
            break;
            case 18: //bandera 2 f2
            x = 217;
            y = 1;
            w = 14;
            h = 29;
            break;
            default:
        }
    }
    
    public void indiceBloque(Objeto o)
    {
        switch(o.getSprite().getImgID())
        {
            case 1: //piedra
            x = 16;
            y = 752 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 2: //ladrillo
            x = 32;
            y = 752 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 3: //Bloque s1
            x = 96;
            y = 112 + 16 * ug;
            w = 16;
            h = 16;
            break;
            case 4: //Bloque s2
            x = 112;
            y = 112 + 16 * ug;
            w = 16;
            h = 16;
            break;
            case 5: //Bloque s3
            x = 128;
            y = 112 + 16 * ug;
            w = 16;
            h = 16;
            break;
            case 6: //Tubería
            x = 16;
            y = 880;
            w = 32;
            h = 32;
            break; //Tubería 2
            case 7:
            x = 16;
            y = 896;
            w = 32;
            h = 16;
            break;
            case 8: //Castillo pared 1
            x = 224;
            y = 752 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 9: //Castillo puerta 1
            x = 224;
            y = 768 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 10: //Castillo puerta 2
            x = 208;
            y = 768 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 11: //Castillo terrasa 1
            x = 192;
            y = 752 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 12: //Castillo terrasa 2
            x = 192;
            y = 768 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 13: //Castillo ventana 1
            x = 208;
            y = 752 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 14: //Castillo ventana 2
            x = 240;
            y = 752 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 15: //Muro
            x = 16;
            y = 768 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 16: //Asta
            x = 279;
            y = 896 + 32 * ug;
            w = 2;
            h = 16;
            break;
            case 17: //Tope
            x = 276;
            y = 888 + 32 * ug;
            w = 8;
            h = 8;
            break;
            case 18: //Bandera
            x = 144 + 144 * ug;
            y = 304;
            w = 16;
            h = 16;
            break;
            case 19: //Bloque s gastado
            x = 144;
            y = 112 + 16 * ug;
            w = 16;
            h = 16;
            break;
            case 20: //Ladrillo roto
            x = 320;
            y = 112 + 16 * ug;
            w = 16;
            h = 16;
            break;
            case 21: //Ladrillo sin borde
            x = 48;
            y = 752 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 22: //plataforma
            x = 80;
            y = 400;
            w = 16;
            h = 8;
            break;
            case 23: //tronco
            x = 96;
            y = 768;
            w = 16;
            h = 16;
            break;
            case 24: //pataforma verde 1
            x = 96;
            y = 880;
            w = 16;
            h = 16;
            break;
            case 25: //pataforma verde 2
            x = 112;
            y = 880;
            w = 16;
            h = 16;
            break;
            case 26: //pataforma verde 3
            x = 128;
            y = 880;
            w = 16;
            h = 16;
            break;
            default:
        }
    }
    
    public void indiceEnemigo(Objeto o)
    {
        switch(o.getSprite().getImgID())
        {
            case 1: //Goomba1
            x = 16;
            y = 624 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 2: //Goomba2
            x = 32;
            y = 624 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 3: //Goomba apalstado
            x = 48;
            y = 624 + 32 * ug;
            w = 16;
            h = 16;
            break;
            case 4: // koopa verde 1
            x = 112;
            y = 616 + 32 * ug;
            w = 16;
            h = 24;
            break;
            case 5: // koopa verde 2
            x = 128;
            y = 616 + 32 * ug;
            w = 16;
            h = 24;
            break;
            case 6: // koopa verde caparazon
            x = 176;
            y = 625 + 32 * ug;
            w = 16;
            h = 14;
            break;
            case 7: // koopa rojo 1
            x = 112;
            y = 680;
            w = 16;
            h = 24;
            break;
            case 8: // koopa rojo 2
            x = 128;
            y = 680;
            w = 16;
            h = 24;
            break;
            case 9: // koopa rojo caparazon
            x = 176;
            y = 688;
            w = 16;
            h = 14;
            break;
            default:
        }
    }
    
    public void indiceItem(Objeto o)
    {
        switch(o.getSprite().getImgID())
        {
            case 1: //Moneda 1
            x = 19 + 144 * ug;
            y = 370;
            w = 10;
            h = 14;
            break;
            case 2: //Moneda 2
            x = 35 + 144 * ug;
            y = 370;
            w = 10;
            h = 14;
            break;
            case 3: //Moneda 3
            x = 51 + 144 * ug;
            y = 370;
            w = 10;
            h = 14;
            break;
            case 4: //Moneda 4
            x = 67 + 144 * ug;
            y = 370;
            w = 10;
            h = 14;
            break;
            case 5: //Champiñon
            x = 16;
            y = 288;
            w = 16;
            h = 16;
            break;
            default:
        }
    }
}
