/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd3;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Meki
 */
public class main {
    
    public static void main(String[] args){
   
    DiccMapHash DMH = new DiccMapHash();
    
        System.out.println("PARTE 1");
        Integer[] valor = {1,10,23,null,3,2,18,null};
        Integer[] keys = {1,10,23,11,3,2,18,15};
        for (int i = 0; i < keys.length; i++) {
            DMH.mapa.put(keys[i], valor[i]);
        }
        System.out.println("Tamaño mapa: " + DMH.mapa.size());
        DMH.eliminarNulos();
        if(DMH.verificarFuncionamientoEliminarNulos()){
            System.out.println("Se han eliminado todos los elementos nulos del mapa!");
            System.out.println("Nuevo tamaño del mapa: " + DMH.mapa.size());
        }
        else{
            System.out.println("Error, no se han eliminado correctamente los elementos nulos");
        }
        System.out.println(" ");
        
        System.out.println("PARTE 2");
        
        String[] valor2 = {"hola","chau","bienvenido","welcome","hello","hi"};
        String[] keys2 = {"1","2","3","4","5","6"};
        for (int i = 0; i < valor2.length; i++) {
            DMH.mapaString.put(keys2[i], valor2[i]);
        }
        Set<Map.Entry<String,String>> elementos = DMH.mapaString.entrySet();
        for(Map.Entry<String,String> elemento : elementos){
            System.out.println("Clave: " + elemento.getKey() + " , Valor: "+ elemento.getValue());
        }
        DMH.intercambiarKeysValue();
        Set<Map.Entry<String,String>> elementosPosterior = DMH.mapaString.entrySet();
        System.out.println("Luego de invertir:");
        for(Map.Entry<String,String> elemento : elementosPosterior){            
            System.out.println("Clave: " + elemento.getKey() + " , Valor: "+ elemento.getValue());
        }
 
        System.out.println(" ");
        
        System.out.println("PARTE 3");
        String[] palabrasParaOrdenar = {"hola","chau","bienvenido","welcome","hello","hi","ya","jaja","balcon","jugaran"};
        DMH.obtenerOrdenadoLongitud(palabrasParaOrdenar);
        DMH.imprimir();
        
        System.out.println(" ");
        
        System.out.println("PARTE 4");        
        
        DMH.imprimirRandom("src/ut3pd3/libro.txt", 2);
        
    }
    
}
