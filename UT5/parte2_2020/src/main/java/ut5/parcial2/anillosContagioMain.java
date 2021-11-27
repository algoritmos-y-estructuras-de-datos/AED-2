package ut5.parcial2;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class anillosContagioMain {
    public static void main(String[] args) {
        TGrafoNoDirigido grafitoNoDirigidito = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("UT5/parte2_2021/src/main/java/ut4/parcial/personas.txt", "UT5/parte2_2021/src/main/java/ut4/parcial/amistades.txt",
                false, TGrafoNoDirigido.class);
        
        
        grafitoNoDirigidito.desvisitarVertices();
        
        AnillosContagio mapita = grafitoNoDirigidito.anillosDeProbablesContagiados2Secundario(grafitoNoDirigidito.getVertices().get("Fabian"), 3);
        
        
        LinkedList<LinkedList<TVertice>> test = mapita.test;
        LinkedHashMap<TVertice,Integer> aux = mapita.sortedMap;
        // System.out.println(mapita.sortedMap);
        // System.out.println(aux.entrySet());
        
        for(LinkedList<TVertice> auxList : test){
            for(TVertice vertAux : auxList){
                System.out.println(vertAux.getEtiqueta() + "Distancia -> " + vertAux.numBacon);
            }
        }

        // System.out.println(mapita.entrySet());
        
        // LinkedHashMap<TVertice,Integer> resultado = new LinkedHashMap<>();
        // for(TVertice auxSecundario : aux.keySet()){
        //     // resultado.put(auxSecundario, auxSecundario.numBacon);
        //     System.out.println(auxSecundario.getEtiqueta() + " Distancia -> " + auxSecundario.numBacon);
        // }

       
        // for(TVertice auxSecundario2 : resultado.keySet()){
        //     System.out.println(auxSecundario2.getEtiqueta() + " Distancia -> " + auxSecundario2.numBacon);
        // }


    }

   
    
}
