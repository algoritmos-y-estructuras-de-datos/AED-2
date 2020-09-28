/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ernesto
 */
public class Producto {
    private final int codigo;
    private int stock;

    public Producto(int codigo, int stock) {
        
        this.codigo = codigo;
        this.stock = stock;
    }

    
    
    public int getCodigo() {
        return this.codigo;
    }

    
    public int getStock() {
        return this.stock;
    }

       

}
