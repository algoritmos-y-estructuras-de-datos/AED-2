/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.ej4;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lector aux = new Lector();
        
        aux.ingresarTexto(ManejadorArchivosGenerico.leerArchivo("src/UT3/ej4/prueba.txt"));
        System.out.println(aux.hash());
    }
    
}
