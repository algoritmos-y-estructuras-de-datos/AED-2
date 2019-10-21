/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparacion2parcial;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Meki
 */
public class preparacion2parcialGND {
     public static void main(String[] args) {
         
         System.out.println("***************************PRUEBA DE PUNTOS DE ARTICULACION***************************");
         TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
                "src/preparacion2parcial/pruebaA.txt",
                "src/preparacion2parcial/pruebaB.txt",
                false, TGrafoNoDirigido.class);
         LinkedList<TVertice> lista = gnd.puntosArticulacion("g");
        for (TVertice tVertice : lista) {
            System.out.println(tVertice.getEtiqueta());
        }
        
        
        System.out.println("***************************PRUEBA DE PRIM Y KRUSKAL***************************");
        TGrafoNoDirigido gnd2 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/preparacion2parcial/verticesBEA.txt", "./src/preparacion2parcial/aristasBEA.txt",false, TGrafoNoDirigido.class);
        
        TGrafoNoDirigido gndKruskal = gnd2.Kruskal();
        TGrafoNoDirigido gndPrim = gnd2.Prim();
        
         System.out.println("AAM CON KRUSKAL");
        for (TArista arista: gndKruskal.lasAristas) {     
            System.out.println(arista.etiquetaOrigen + " - " + arista.etiquetaDestino +" ("+arista.getCosto()+")");
        }
        System.out.println("AAM CON PRIM");
        for (TArista arista: gndPrim.lasAristas) {     
            System.out.println(arista.etiquetaOrigen + " - " + arista.etiquetaDestino +" ("+arista.getCosto()+")");
        }
        
        
        TGrafoNoDirigido gnd3 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/preparacion2parcial/verticesBEA.txt", "./src/preparacion2parcial/aristasBEA.txt",false, TGrafoNoDirigido.class);
        System.out.println("***************************PRUEBA DE BEA***************************");
         System.out.println("BEA DESDE A");
        Collection<TVertice> bea = gnd3.bea("a");
         for (TVertice tVertice : bea) {
             System.out.println(tVertice.getEtiqueta());
             
         }
         
         System.out.println("BEA DESDE B");
        Collection<TVertice> beaB = gnd3.bea("b");
         for (TVertice tVertice : beaB) {
             System.out.println(tVertice.getEtiqueta());
             
         }
         
         
        System.out.println("BEA DESDE F");
        Collection<TVertice> beaF = gnd3.bea("f");
         for (TVertice tVertice : beaF) {
             System.out.println(tVertice.getEtiqueta());
             
         }
         System.out.println("***************************PRUEBA 1 DE NUMERO DE BACON***************************");
        
        TGrafoNoDirigido gnd4 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/preparacion2parcial/actores.csv",
                "./src/preparacion2parcial/en_pelicula.csv",false, TGrafoNoDirigido.class); 
         
        int numeroBeacon = gnd4.numBacon1("Djimon_Hounsou");
        System.out.println("Num Bacon: Djimon_Hounsou "+ numeroBeacon); 
        int numeroBeacon1 = gnd4.numBacon1("John_Goodman");
        System.out.println("Num Bacon: John_Goodman "+ numeroBeacon1);
        int numeroBeacon2 = gnd4.numBacon1("Tom_Cruise");
        System.out.println("Num Bacon: Tom_Cruise "+ numeroBeacon2);
        int numeroBeacon3 = gnd4.numBacon1("Jason_Statham");
        System.out.println("Num Bacon: Jason_Statham "+ numeroBeacon3);
        int numeroBeacon4 = gnd4.numBacon1("Lukas_Haas");
        System.out.println("Num Bacon: Lukas_Haas "+ numeroBeacon4);
        
        System.out.println("***************************PRUEBA 2 DE NUMERO DE BACON***************************");
        
        
        gnd4.beaBacon("Kevin_Bacon");
        
        String[] exit = {
            "John_Goodman "+String.valueOf(gnd4.numBacon2("John_Goodman")),
            "Tom_Cruise "+String.valueOf(gnd4.numBacon2("Tom_Cruise")),
            "Jason_Statham "+String.valueOf(gnd4.numBacon2("Jason_Statham")),
            "Lukas_Haas "+String.valueOf(gnd4.numBacon2("Lukas_Haas")),
            "Djimon_Hounsou "+String.valueOf(gnd4.numBacon2("Djimon_Hounsou"))};
        
        ManejadorArchivosGenerico mda = new ManejadorArchivosGenerico();
        mda.escribirArchivo("src/preparacion2parcial/salida.txt",exit);
        
         for (int i = 0; i < exit.length; i++) {
             
             System.out.println(exit[i]);
             
         }
        
     }
}
