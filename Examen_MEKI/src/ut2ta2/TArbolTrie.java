/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2ta2;

/**
 *
 * @author Meki
 */
public class TArbolTrie {
    
    private TNodoTrie raiz;
    
    public void insertar(String palabra){
        if(raiz == null){
            raiz = new TNodoTrie();           
        }
        raiz.insertar(palabra);
    }
    
    public void imprimir(){
        if(raiz != null){
            raiz.imprimir();
        }
    }
    
    public int buscar(String palabra){     
       if (raiz!=null)
        {
            return raiz.buscar(palabra);
        }
        return 0;
    }

    
    
}
