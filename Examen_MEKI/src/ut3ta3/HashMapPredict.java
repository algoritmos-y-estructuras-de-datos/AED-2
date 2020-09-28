package ut3ta3;


import java.util.HashMap;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante.fit
 */
public class HashMapPredict extends HashMap<Object, Object>  {
    
    public LinkedList<String> predict(String prefijo){
        LinkedList<String> salida = new LinkedList<>();
        for (Object palabras : this.keySet())
        {
            String palabra = String.valueOf(palabras);
            if (palabra.length() >= prefijo.length() && palabra.substring(0,prefijo.length()).equalsIgnoreCase(prefijo)){
                salida.add(palabra);
            }
        }
        return salida;
    }
    
}
