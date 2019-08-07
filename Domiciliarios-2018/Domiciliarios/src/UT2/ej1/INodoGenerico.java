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
public interface INodoGenerico {
    
    public INodoGenerico buscar (Comparable etiqueta);
    
    public INodoGenerico getPrimHijo();

    public void setPrimHijo(INodoGenerico primHijo);

    public INodoGenerico getHerDer();

    public void setHerDer(INodoGenerico herDer);

    public Object getDato();

    public void setDato(Object dato);

    public Comparable getEtiqueta();
    
    public void tamaño(int[] cont);
    
    public void altura(int[] cont);
    
    public boolean insertar (Comparable etiqueta, Comparable padre);
    
    public void listarIndentado (String espacios);
}
