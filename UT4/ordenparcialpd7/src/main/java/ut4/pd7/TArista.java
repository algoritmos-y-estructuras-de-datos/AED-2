package ut4.pd7;
public class TArista implements IArista {

    protected Comparable etiquetaOrigen;
    protected Comparable etiquetaDestino;
    protected double costo;

    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, double costo) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        this.costo = costo;
    }

    
    

    public Comparable getEtiquetaOrigen() {
        return etiquetaOrigen;
    }

 
    public void setEtiquetaOrigen(Comparable etiquetaOrigen) {
        this.etiquetaOrigen = etiquetaOrigen;
    }

   
    public Comparable getEtiquetaDestino() {
        return etiquetaDestino;
    }

  
    public void setEtiquetaDestino(Comparable etiquetaDestino) {
        this.etiquetaDestino = etiquetaDestino;
    }

    
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    @Override
    public TArista aristaInversa (){
        return new TArista(this.getEtiquetaDestino(), this.getEtiquetaOrigen(),this.getCosto());
    }
}
