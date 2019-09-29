
import java.util.HashMap;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class MedicionPredecirHashMap extends Medible {

    private HashMap hashMap;

    public MedicionPredecirHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                for(Object linea : hashMap.keySet()){
                    ((String)linea).startsWith(palabra);
                }
                
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.hashMap;
    }
    
}
