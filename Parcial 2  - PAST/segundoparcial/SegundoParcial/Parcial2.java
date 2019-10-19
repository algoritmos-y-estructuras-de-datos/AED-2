/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

/**
 *
 * @author Usuario
 */
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      TGrafoDirigido grafo = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/SegundoParcial/cursos.txt",
             "src/SegundoParcial/previas.txt", false);
      TCaminos todos=grafo.caminoCritico();
      todos.imprimir();
    }
    
}
