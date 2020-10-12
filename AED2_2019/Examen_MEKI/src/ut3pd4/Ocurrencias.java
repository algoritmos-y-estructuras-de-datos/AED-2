/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Meki
 */
public class Ocurrencias {
    
    HashMap<String, Integer> mapa;
    TreeMap<Integer, String> mapaTree;

    public Ocurrencias() {
        mapa = new HashMap();
        mapaTree = new TreeMap();
    }

    public HashMap insertConOcurrencias(String[] lineas){    
        for(String linea : lineas){
            String[] palabras = linea.split(" ");
            for(String palabra : palabras){
                palabra = palabra.toLowerCase();
                palabra = palabra.replaceAll("[^a-z\\s]", "");               
                if(mapa.containsKey(palabra)){
                   
                    int ocurrencia = mapa.get(palabra);
                    ocurrencia++;                    
                    mapa.put(palabra, ocurrencia);
                    
                    
                }
                else{
                    
                    mapa.put(palabra,1);
                }
            }
        }
        return mapa;
    }

    public void imprimirConOcurrencias() {
        /**
         * Imprimo cada clave con sus ocurrencias
         */
        for (Map.Entry<String, Integer> elemento : mapa.entrySet()) {
            String key = elemento.getKey();
            Integer valor = elemento.getValue();
            System.out.println("Key: " + key + " -> Valor : " + valor.toString());
            mapaTree.put(valor, key);

        }
    }

    public String[] escribirReady (){
        
        /**
         * Paso a excel para obtener 10 mejores y graficar.
         */
        String[] paraEscribir = new String[mapa.entrySet().size()];
        int contador = 0;
        for(Map.Entry<Integer,String> elemento : mapaTree.entrySet()){
            paraEscribir[contador] = elemento.getValue() + ";" + elemento.getKey();
            contador++;
        }      
        return paraEscribir;
    }    
    
    
}
