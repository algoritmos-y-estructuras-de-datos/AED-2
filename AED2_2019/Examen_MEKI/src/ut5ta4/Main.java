/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta4;
 
import java.util.Collection;
import java.util.LinkedList;
 

/**
 *
 * @author Meki
 */
public class Main {
    
    public static void main(String[] args) {

         System.out.println("***************************PRUEBA DE PUNTOS DE ARTICULACION***************************");
         TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
                "src/ut5ta4/pruebaA.txt",
                "src/ut5ta4/pruebaB.txt",
                false, TGrafoNoDirigido.class);
         LinkedList<TVertice> lista = gnd.puntosArticulacion("g");
        for (TVertice tVertice : lista) {
            System.out.println(tVertice.getEtiqueta());
        }
    
}
}
