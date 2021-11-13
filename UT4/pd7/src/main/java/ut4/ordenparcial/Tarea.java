/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernesto
 */
public class Tarea {

    private String nombre;
    private int duracion;

    public Tarea(String unaEtiqueta, int unaDuracion) {
        nombre = unaEtiqueta;
        duracion = unaDuracion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

}
