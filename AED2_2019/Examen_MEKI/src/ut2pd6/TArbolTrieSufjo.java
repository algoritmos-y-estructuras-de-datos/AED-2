/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2pd6;

import java.util.LinkedList;
import ut2pd2.*;

/**
 *
 * @author Meki
 */
public class TArbolTrieSufjo {
    
    private TNodoTrieSufijo raiz;
    
    public void insertar(String palabra, int inicioSufijo){
        if(raiz == null){
            raiz = new TNodoTrieSufijo();           
        }
        raiz.insertar(palabra, inicioSufijo);
    }
    
    public void imprimir(){
        if(raiz != null){
            raiz.imprimir();
        }
    }
    
//    public int buscar(String palabra){     
//       if (raiz!=null)
//        {
//            return raiz.buscar(palabra, 0 , 0);
//        }
//        return 0;
//    }
//        public void paginasDePalabra(String palabra) {
//        if (raiz != null) {
//            System.out.println(raiz.paginasDePalabra(palabra));
//        }        
//    }
//        public void insertarConPaginas(String palabra, int pagina){
//        if(raiz == null){
//            raiz = new TNodoTrieSufijo();           
//        }
//        raiz.insertarConPaginas(palabra, pagina);
//    }
        
        //metodo del deber
        public LinkedList<Integer> ubicaciónPrefijo(String prefijo) {
        LinkedList<Integer> inicios = new LinkedList<>();
        raiz.prefijoUbicación(prefijo, inicios);
        return inicios;
    }
        
    
    
    
    
}
