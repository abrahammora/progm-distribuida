/**
 *
 * @author Miguelito
 */
 
public class Cifrado implements java.io.Serializable
{
    private final String alfabeto = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789 áéíóúÁÉÍÓÚ";
    
    private int busca_posicion(char letra)
    {
        int i=0;
        boolean encontrado = false;
        
        while ((i<alfabeto.length()) && (!encontrado))
        {
            if (alfabeto.charAt(i) == letra)
                encontrado = true;
            i++;
        }
        
        if (encontrado)
           return i-1;
        else
           return -1;  
    } // fin busca_posicion
    
    
    public String Cifrar(String cadena, int llave){    
       int posicion, nueva_posicion;
       String cadena_cifrada = "";
       char letra;
       
       for (int i=0; i<cadena.length(); i++)
       {    
           posicion = busca_posicion(cadena.charAt(i));
           if (posicion != -1)
           {
              nueva_posicion = (posicion + llave) % alfabeto.length();
              letra = alfabeto.charAt(nueva_posicion);
           }
           else
              letra = cadena.charAt(i); 
           cadena_cifrada = cadena_cifrada + letra;
       }
       return cadena_cifrada;
    }  // fin Cifrar
    
    
    public String Descifrar(String cadena, int llave)
    {
       int posicion, nueva_posicion;
       String cadena_descifrada = "";
       char letra;
       
       for (int i=0; i<cadena.length(); i++)
       {    
           posicion = busca_posicion(cadena.charAt(i));
           if (posicion != -1)
           {
              nueva_posicion = (posicion + alfabeto.length() - llave) % alfabeto.length();
              letra = alfabeto.charAt(nueva_posicion);
           }
           else
              letra = cadena.charAt(i);
           cadena_descifrada = cadena_descifrada + letra;
       }
       return cadena_descifrada;
    } // fin Descifrar
    
}
