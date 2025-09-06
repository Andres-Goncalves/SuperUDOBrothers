package superudobrothers.cargadores;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LectorArchivos
{
	//Atributos

	private char archivo[][];

	//Constructor

	public LectorArchivos(String ruta) //Este constructor lee linea por linea un archivo de texto, y lo guarda como una matriz de caracteres.
	{
		try
		{
			FileInputStream file = new FileInputStream("recursos/mapas_y_puntuacion/" + ruta);
			BufferedReader lector = new BufferedReader(new InputStreamReader(file));
			String linea = lector.readLine();
			int i=0, j=0;
			while(linea!=null && i<300 && !linea.equals(""))	//Comprobar tamaño del archivo.
			{
				if(linea!=null)
				{
					if(j<linea.length())
					{
						j=linea.length();
					}
				}
				i++;
				linea = lector.readLine();
			}
			file.close();
			lector.close();
			archivo = new char[i][j];
                        
			for(int k=0; k<i;k++)		//Llena con blacos el arreglo para evitar problemas.
			{
 				for(int l=0; l<j; l++)
				{
					archivo[k][l] = ' ';
				}
			}
                        
			file = new FileInputStream("recursos/mapas_y_puntuacion/" + ruta);
			lector = new BufferedReader(new InputStreamReader(file));
			i=0;
			linea = lector.readLine();
                        
			while(linea!=null && i<300 && !linea.equals(""))	//Guarda las lineas leidas desde el achivo como caracteres individuales en la matriz
			{
				archivo[i] = linea.toCharArray();
				i++;
				linea = lector.readLine();
			}
			file.close();
			lector.close();
		}
		catch(Exception e)
		{
			System.out.println("Error:" + e);
		}
	}

	//Metodos

	public int leer(String b, int d)	// El metodo leer busca una palabra en la primera linea del archivo, si esta existe, devuelve un numero que se encuentre una posicion a la derecha de este, se requiere que se ingrese el tamaño del numero.
	{
		int n = b.length() + d + 1, cont=0, valor = 0;
		char c[] = b.toCharArray(), v[] = new char[d];
		
		for(int i = 0; i+n <= this.archivo[0].length; i++)
		{
			for(int j=0; j < n; j++)
			{
				if(this.archivo[0][i+j] == c[j])
				{
					cont++;
					if(cont == b.length())
					{
						for(int k=0; k<d; k++)
						{
							v[k] = this.archivo[0][i+j+k+2];
						}
						String valorS = new String(v);
						try
						{
							valor = Integer.parseInt(valorS);
						}
						catch(Exception e)
						{
							System.out.println("Error:" + e);
						}
						return valor;
					}
				}
				else
				{
					cont=0;
					break;
				}
			}
		}
		return -1;
	}
	
	public char getTipo(int x,int y)
	{
		return archivo[y][x];
	}
	
	public String getLinea(int l)
	{
		if(archivo != null)
		{
			if(archivo[l] != null)
			{
				String linea = new String(archivo[l]);
				return linea;
			}
		}
		return "Error 404, puntaje deconocido";
	}
        
        public void guardarPuntuacion(String[] puntos)
        {
            FileWriter fichero = null;
            PrintWriter escritor = null;
            
            try
            {
                fichero = new FileWriter("recursos/mapas_y_puntuacion/Puntuaciones.txt");
                escritor = new PrintWriter(fichero);

                for (int i = 0; i < 10; i++)
                {
                    escritor.println(puntos[i]);
                }
            } 
            catch (Exception e)
            {
                System.out.println("Error: " + e);
            }
            finally
            {
                try
                {
                    if (null != fichero)
                    {
                        fichero.close();
                    }
                } 
                catch (Exception e2)
                {
                    System.out.println("Error: " + e2);
                }
            }
        }
        
        public static void guardarAjustes(int volumen)
        {
            FileWriter fichero = null;
            PrintWriter escritor = null;
            
            try
            {
                fichero = new FileWriter("recursos/mapas_y_puntuacion/ajustes.txt");
                escritor = new PrintWriter(fichero);

                
                escritor.println("volumen=" + String.format("%02d",volumen));
            } 
            catch (Exception e)
            {
                System.out.println("Error: " + e);
            }
            finally
            {
                try
                {
                    if (null != fichero)
                    {
                        fichero.close();
                    }
                } 
                catch (Exception e2)
                {
                    System.out.println("Error: " + e2);
                }
            }
        }
}