/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.ej1;

/**
 *
 * @author Diego
 */
public class ArbolGenerico  implements IArbolGenerico{
    
    private INodoGenerico raiz;

    public ArbolGenerico() {
        raiz=null;
    }

    @Override
    public INodoGenerico getRaiz() {
        return raiz;
    }

    @Override
    public void setRaiz(INodoGenerico raiz) {
        this.raiz = raiz;
    }

    
    @Override
    public INodoGenerico buscar(Comparable etiqueta) {
        if (this.getRaiz() != null){return this.getRaiz().buscar(etiqueta);}
        else {return null;}
    }

    @Override
    public int tamaño() {
        int[] cont = new int[1];
        if (this.getRaiz() != null) 
        {
            this.getRaiz().tamaño(cont);
            return cont[0];
        }
        else {return 0;}
    }

    @Override
    public int altura() {
        int[] cont = new int[1];
        if (this.getRaiz() != null) 
        {
            this.getRaiz().altura(cont);
            return cont[0];
        }
        else {return 0;}
    }
    
    @Override
    public boolean insertar (Comparable etiqueta, Comparable padre)
    {
        if (raiz == null){
            NodoGenerico aux = new NodoGenerico(etiqueta);
            raiz=aux;
            return true;
        }
        else if (padre.compareTo("")==0){
            NodoGenerico aux = new NodoGenerico(etiqueta);
            aux.setPrimHijo(raiz);
            raiz=aux;
            return true;
        }
        else {
            return raiz.insertar(etiqueta, padre);
        }
    }

    @Override
    public void listarIndentado() {
        if (this.raiz != null){raiz.listarIndentado("");}
        else{System.out.println("Arbol vacío.");}
    }
}
