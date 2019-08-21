/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.ej4;

import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author usuario
 */
public class Lector {
    
    private HashMap<String,Integer> palabras;

    public Lector() {
        this.palabras = new HashMap<>();
    }
    
    public void ingresarTexto (String[] lineas)
    {
        for(String linea : lineas)
        {
           for (String palabra2 : linea.split(" "))
           {
               String  palabra = palabra2.replaceAll("[^\\dA-Za-z]","").toLowerCase(); 
               if (palabras.containsKey(palabra) & (palabra.compareTo("")!=0)){
                   int aux = palabras.get(palabra) +1;
                   palabras.put(palabra, aux);
               }
               else if ((palabra.compareTo("")!=0 )){
                   palabras.put(palabra,1);
               }
           }
        }
    }
    public String hash (){
        return palabras.toString();}
    
    
    
}
