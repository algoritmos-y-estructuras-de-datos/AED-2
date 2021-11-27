package ut5.parcial2;

import java.util.LinkedList;

public class Persona {
    private Comparable nombre;
    private Integer distanciaContacto;
    

    public Persona(Comparable nom){
        nombre = nom;
        distanciaContacto = 0;
    }

    public Comparable getNombre(){
        return nombre;
    }

    public void setDistanciaContacto(int dist){
        distanciaContacto = dist;
    }

    public int getDistanciaContacto(){
        return distanciaContacto;
    }

    }
