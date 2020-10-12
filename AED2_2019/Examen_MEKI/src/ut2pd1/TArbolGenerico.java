/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2pd1;

/**
 *
 * @author Meki
 */
public class TArbolGenerico {
    
    private TNodoGenerico raiz;
    
    public TArbolGenerico(){
        
        raiz = null;
        
    }
    public TNodoGenerico getRaiz(){
        
        return this.raiz;
    }
    
    public void setRaiz( TNodoGenerico nuevaRaiz){
        
        this.raiz = nuevaRaiz;
    }
    
    public TNodoGenerico buscar (Comparable etiqueta){
        
        if (this.getRaiz() != null){
            return this.getRaiz().buscar(etiqueta);
        }
        else{
            return null;
        }     
    }

    public int tamaño() {
        int[] cont = new int[1];
        if (this.getRaiz() != null) 
        {
            this.getRaiz().tamaño(cont);
            return cont[0];
        }
        else {return 0;}
    }
    
        public boolean insertar (Comparable etiqueta, Comparable padre)
    {
        if (raiz == null){
            TNodoGenerico aux = new TNodoGenerico(etiqueta);
            raiz=aux;
            return true;
        }
        else if (padre.compareTo("")==0){
            TNodoGenerico aux = new TNodoGenerico(etiqueta);
            aux.setPrimHijo(raiz);
            raiz=aux;
            return true;
        }
        else {
            return raiz.insertar(etiqueta, padre);
        }
    }
    public void listarIndentado() {
        if (this.raiz != null) {
            raiz.listarIndentado("");
        } else {
            System.out.println("Arbol vacío.");
        }
    }

    public void listarIndentadoYNivel() {
        if (this.raiz != null) {
            raiz.listarIndentadoYNivel(1);
        } else {
            System.out.println("Arbol vacío.");
        }
    }
}
