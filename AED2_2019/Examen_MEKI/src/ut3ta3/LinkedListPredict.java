package ut3ta3;

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
public class LinkedListPredict extends LinkedList<String>{
    
    
    public LinkedList predecir(String prefijo) {
        LinkedList salida = new LinkedList();
        Object[] array = this.toArray();
        for (Object palabras : array)
        {
            String palabra = String.valueOf(palabras);
            if (palabra.length() >= prefijo.length() && palabra.substring(0,prefijo.length()).equalsIgnoreCase(prefijo)){
                salida.add(palabra);
            }
        }
        return salida;
    }
}
