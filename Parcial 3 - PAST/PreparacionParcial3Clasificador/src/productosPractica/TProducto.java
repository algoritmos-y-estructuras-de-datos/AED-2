/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public class TProducto implements IProducto {

    public TProducto(long codigo, String descripcion, double precio, int cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    private long codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    

    @Override
    public long getCodigo() {
        return codigo;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Product: " + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + valor();
    }

    @Override
    public int getCantidad() {
    return cantidad; }

    @Override
    public double valor() {
       return (this.cantidad * this.precio);
    }
    
    
            
}
