package ut5.parcial2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class AnillosContagio {

    public Map<TVertice, Integer> listaContactos = new HashMap<>();
    public LinkedHashMap<TVertice, Integer> sortedMap = new LinkedHashMap<>();
    public LinkedList<LinkedList<TVertice>> test = new LinkedList<LinkedList<TVertice>>();

    public void agregarContagio(int distanciaContacto, TVertice laPersona) {
        this.listaContactos.put(laPersona, distanciaContacto);
        
        if(test.get(distanciaContacto) == null){
            test.add(distanciaContacto, new LinkedList<TVertice>());
            test.get(distanciaContacto).add(laPersona);
        }else{
            test.get(distanciaContacto).add(laPersona);
        }

        listaContactos.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

    }

    // public void agregarContagioSecundario(int distanciaContacto, TVertice laPersona) {
    //     this.listaContactos.put(laPersona, distanciaContacto);
        
    //     Collections.sort(listaContactos.entrySet(),listaContactos.values());
        
    //     ;

    // }
}
