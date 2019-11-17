package productos2017;
import java.util.ArrayList;

public class TProducto implements IProducto {
    private long codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    private int interno;

    public TProducto(long codigo, String descripcion, double precio, int cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getInterno(){
        return this.interno;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public long getCodigo() {
        return this.codigo;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public int getCantidad() {
        return this.cantidad;
    }

    @Override
    public double valor() {
       return this.cantidad * this.precio;
    }
    
    public static TProducto existeProducto(ArrayList<TProducto> lista, long cod){
        TProducto aux = null;
        for(TProducto p : lista){
            if(p.getCodigo()==cod){
                aux = p;
                break;
            }
        }
        return aux;
    }
}
