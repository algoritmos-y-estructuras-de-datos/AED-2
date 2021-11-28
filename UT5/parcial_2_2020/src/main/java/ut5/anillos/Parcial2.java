package ut5.anillos;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

public class Parcial2 {

    public static void main(String[] args) {
        
        
        // CREAR EL GRAFO CON PERSONAS.TXT y CONTACTOS.TXT
        
        TGrafoContagios grafoTrazabilidad = (TGrafoContagios) UtilGrafos.cargarGrafo(
                "UT5/parcial_2_2020/src/main/java/ut5/anillos/personasPANCETEADAS.txt",
                "UT5/parcial_2_2020/src/main/java/ut5/anillos/amistadesPANCETEADAS.txt",
                false, TGrafoContagios.class);

        int distanciaMax = 4;
        // TAnillosContagio anillosContagios = grafoTrazabilidad.anillosDeProbablesContagiados("Marianito", distanciaMax);
        TAnillosContagio anillosContagios = grafoTrazabilidad.anillosDeProbablesContagiadosEntreDos("Marianito",2, distanciaMax);
       
        
        TreeSet<String> arbolito = anillosContagios.obtenerAnillo(distanciaMax-1);
        // System.out.println(arbolito.toString());
        
        /*
        1 LINEA INDICANDO “DISTANCIA de CONTACTO: <valor>”
        seguida de los nombres de las personas en ese conjunto, ordenados alfabéticamente, indentados 2
        espacios. Ejemplo:
            DISTANCIA de CONTACTO: 1:
        Nombre persona1
        Nombre persona 2
        DISTANCIA de CONTACTO: 2
        Nombre persona 3
        */
    
        
        

        
        int contadorLineas = 0;
        for(Integer key : anillosContagios.keySet()){
            contadorLineas++;
            for(String contenido : anillosContagios.get(key)){
                contadorLineas++;
            }
        }
        int i = 0;
        String[] impresion = new String[contadorLineas];
        
        for(Integer key : anillosContagios.keySet()){
            impresion[i] = ("Distancia de contacto: " + (key + 1));
            i++;
            for(String contenido : anillosContagios.get(key)){
                impresion[i] = contenido;
                i++;
            }
        }
        
        
        for(String linea : impresion){
            System.out.println(linea);
        }
        ManejadorArchivosGenerico.escribirArchivo("anillos.txt", impresion);
        
         // EMITIR EL ARCHIVO "ANILLOS.TXT", CON EL FORMATO INDICADO EN LA LETRA, 
         // CON LOS CONJUNTOS DE CONTACTOS HASTA UNA DISTANCIA MENOR O IGUAL A LA INDICADA
         // EN EL PIZARRÓN: distMaxParaArchivoListado
        
        
        

        // emitir por consola la cantidad de contactos que se encuentran a la distancia
        // de la personaCOVID indicada EN EL PIZARRÓN: distAnilloBuscar
        //  int distAnilloBuscar = SE INDICARA EN EL PIZARRÓN
        // TAnillosContagio anillosContagiosCtd = grafoTrazabilidad.anillosDeProbablesContagiados("Fabian", 2);
        // System.out.println("Emitir por consola la cantidad de contactos que se encuentran a la distancia de la personaCOVID indicada EN EL PIZARRÓN: Cantidad" + anillosContagiosCtd.size());
                  
        
        TGrafoDirigido grafo = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "UT5/parcial_2_2020/src/main/java/ut5/anillos/personasPANCETEADAS.txt",
                "UT5/parcial_2_2020/src/main/java/ut5/anillos/amistadesPANCETEADAS.txt",
                false, TGrafoDirigido.class);
        
        // grafo
    }
}
