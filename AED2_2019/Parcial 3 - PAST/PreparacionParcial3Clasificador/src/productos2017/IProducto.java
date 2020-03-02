package productos2017;

public interface IProducto {
    long getCodigo();
    String getDescripcion();
    double getPrecio();
    int getCantidad();
    
    double valor();
    
}
