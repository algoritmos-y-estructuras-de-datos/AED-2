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
    private long codigo;
    private String descripcion;
    private double precio;
    private int cantidad;

    
    public TProducto(long cod, String desc, double prec, int cant){
        codigo = cod;
        descripcion = desc;
        precio = prec;
        cantidad = cant;
    }
            
    @Override
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public long getCodigo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return codigo;
    }

    @Override
    public String getDescripcion() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return descripcion;
    }

    @Override
    public double getPrecio() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return precio;
    }

    @Override
    public int getCantidad() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return cantidad;
    }

    @Override
    public double valor() {
       return (this.cantidad * this.precio);
    }
    
    
            
}
