/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Meki
 */
public class DiccMapHash {
     Map<Object, Object> mapa;
    Map<Object, Object> mapaNuevo;
    Map<String,String> mapaString;
    TreeMap<Integer,TreeSet<String>> arbolMapa;

    public DiccMapHash() {
        mapa = new HashMap();
        mapaNuevo = new HashMap();
        mapaString = new HashMap();
        arbolMapa = new TreeMap();
    }

    public void eliminarNulos() {

        for (Map.Entry<Object, Object> elemento : mapa.entrySet()) {
            if (elemento.getValue() != null) {
                mapaNuevo.put(elemento.getKey(), elemento.getValue());
            }
        }
        mapa = mapaNuevo;
    }

    public boolean verificarFuncionamientoEliminarNulos() {
        for (Map.Entry<Object, Object> elemento : mapa.entrySet()) {
            if (elemento == null) {
                return false;
            }
        }
        return true;
    }

    public void intercambiarKeysValue() {
        Map<String, String> mapaNuevo = new HashMap();
        for (Map.Entry<String, String> elemento : mapaString.entrySet()) {
            String key = elemento.getKey();
            String value = elemento.getValue();
            mapaNuevo.put(value, key);
        }
        mapaString = mapaNuevo;
    }
    
     public void obtenerOrdenadoLongitud(String[] palabras) {
        
        for (String palabra : palabras) {
            if (arbolMapa.containsKey(palabra.length())) {
                arbolMapa.get(palabra.length()).add(palabra);
            }
            else{
                TreeSet arbolOrdenadoLexicograficamente = new TreeSet();
                arbolOrdenadoLexicograficamente.add(palabra);
                arbolMapa.put(palabra.length(), arbolOrdenadoLexicograficamente);               
            }            
        }
        
    }
    public void imprimir(){
        
        for (Map.Entry<Integer, TreeSet<String>> entrySet : arbolMapa.entrySet()) {            
            TreeSet<String> palabras = entrySet.getValue();            
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        }
    }
    
        
    public void imprimirRandom(String nombreArchivo, int cantidadLineasAimprimir){
        Random random = new Random();
        List<String> lineas = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for (int i = 0; i < cantidadLineasAimprimir; i++) {
            Integer valorRandom = random.nextInt(lineas.size() -1);
            System.out.println(lineas.get(valorRandom));
        }   
    }

}
