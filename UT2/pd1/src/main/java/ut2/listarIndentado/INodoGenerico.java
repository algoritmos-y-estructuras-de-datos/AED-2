package ut2.listarIndentado;

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