/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta5;

import ut5ta6.*;

/**
 *
 * @author Meki
 */
public class Main {
    
    public static void main(String[] args) {
        
        TGrafoNoDirigido gnd4 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/ut5ta5/actores.csv",
                "./src/ut5ta5/en_pelicula.csv",false, TGrafoNoDirigido.class); 
         
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
        
        for(String actor : exit){
            
            System.out.println(actor);
        }
    }
    
}
