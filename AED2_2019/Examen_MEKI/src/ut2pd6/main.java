/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2pd6;

/**
 *
 * @author Meki
 */
public class main {
    
    public static void main(String[] args) {
        
        String[] texto = ManejadorArchivosGenerico.leerArchivo("src/ut2pd6/secuencia.txt");
        
        TArbolTrieSufjo arbolito = new TArbolTrieSufjo();
        
        String secuencia = texto[0].trim();
        
        for (int i = 0; i < secuencia.length(); i++) {
            arbolito.insertar(secuencia.substring(i), i);          
        }
        //arbolito.imprimir();
        
        String p1 = "aacct"; 
        String p2 = "ccta";
        String p3 = "ggtca";
        
        System.out.println("prefijo "+ p1+ " aparece " + arbolito.ubicaciónPrefijo(p1).size()+ " veces y se ubica en " + arbolito.ubicaciónPrefijo(p1));
        System.out.println("prefijo "+ p2+ " aparece " + arbolito.ubicaciónPrefijo(p2).size()+ " veces y se ubica en " + arbolito.ubicaciónPrefijo(p2));
        System.out.println("prefijo "+ p3+ " aparece " + arbolito.ubicaciónPrefijo(p3).size()+ " veces y se ubica en " + arbolito.ubicaciónPrefijo(p3));
        
        
    }
    
}
