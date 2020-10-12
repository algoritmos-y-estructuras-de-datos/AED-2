/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta3;

import java.util.Collection;
 

/**
 *
 * @author Meki
 */
public class Main {
    
    public static void main(String[] args) {

        TGrafoNoDirigido gnd3 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/ut5ta3/verticesBEA.txt", "./src/ut5ta3/aristasBEA.txt",false, TGrafoNoDirigido.class);
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
    }
    
}
