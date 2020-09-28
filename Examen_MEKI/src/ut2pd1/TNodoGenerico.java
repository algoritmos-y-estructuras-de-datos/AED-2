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
class TNodoGenerico {
    
    private TNodoGenerico primHijo;
    private TNodoGenerico herDer;

    private Comparable etiqueta;

    
    public TNodoGenerico getHerDer() {
        return herDer;
    }

    public void setHerDer(TNodoGenerico herDer) {
        this.herDer = herDer;
    }
    public TNodoGenerico getPrimHijo() {
        return primHijo;
    }

    public void setPrimHijo(TNodoGenerico primHijo) {
        this.primHijo = primHijo;
    }


    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    TNodoGenerico(Comparable etiqueta) {
       this.primHijo = null;
        this.herDer = null;
        this.etiqueta = etiqueta;
    }

    TNodoGenerico buscar(Comparable etiqueta) {
        if (this.etiqueta == etiqueta) {
            return this;
        } else {
            TNodoGenerico hijo = this.getPrimHijo();
            while (hijo != null) {
                TNodoGenerico resultante = hijo.buscar(etiqueta);
                if (resultante != null) {
                    return resultante;
                } else {
                    hijo = hijo.getHerDer();
                }
            }
        }
        return null;
    }

    public void tamaño(int[] cont) 
    {
        cont[0]++;
        TNodoGenerico unHijo = this.getPrimHijo();
        while (unHijo != null)
        {
            unHijo.tamaño(cont);
            unHijo=unHijo.getHerDer();
        }    
    }   


    public boolean insertar (Comparable etiqueta, Comparable padre){
    
        if (this.etiqueta.compareTo(padre)==0){
            TNodoGenerico aux = new TNodoGenerico(etiqueta);
            aux.setHerDer(this.getPrimHijo());
            this.setPrimHijo(aux);
            return true;
        }
        if (this.primHijo != null){
            this.primHijo.insertar(etiqueta, padre);
        }
        if (this.herDer != null){
            this.herDer.insertar(etiqueta, padre);
        }
        return false;
    }
    
     public void listarIndentado(String espacios) {
        System.out.println(espacios + etiqueta);
        if (this.herDer != null){
            this.herDer.listarIndentado(espacios);
        }
        if (this.primHijo != null){
            this.primHijo.listarIndentado(espacios + " " );
        }
                
    }    

       public void listarIndentadoYNivel(int nivel) {
        System.out.println( nivel+")"+ etiqueta);
        if (this.herDer != null){
            this.herDer.listarIndentadoYNivel(nivel);
        }
        if (this.primHijo != null){
            this.primHijo.listarIndentadoYNivel(nivel+1);
        }
                
    }  
    
}
