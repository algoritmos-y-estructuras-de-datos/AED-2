package ut2.pd;

public interface IArbolGenerico {
    
    public INodoGenerico buscar (Comparable etiqueta);
    
    public INodoGenerico getRaiz();

    public void setRaiz(INodoGenerico raiz);
    
    public int tamaño();
    
    public int altura();
    
    public boolean insertar (Comparable etiqueta, Comparable padre);
    
    public void listarIndentado ();
}
