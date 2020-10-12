/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta6;

/**
 *
 * @author Meki
 */
public class Main {
    
    public static void main(String[] args) {
        
        TGrafoNoDirigido gnd2 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/ut5ta6/verticesBEA.txt", "./src/ut5ta6/aristasBEA.txt",false, TGrafoNoDirigido.class);
        
        TGrafoNoDirigido gndKruskal = gnd2.Kruskal();
        System.out.println("AAM CON KRUSKAL");
        for (TArista arista: gndKruskal.lasAristas) {     
            System.out.println(arista.etiquetaOrigen + " - " + arista.etiquetaDestino +" ("+arista.getCosto()+")");
        }
    }
    
}
