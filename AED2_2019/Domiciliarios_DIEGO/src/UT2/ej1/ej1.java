package UT2.ej1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolGenerico arbol = new ArbolGenerico();
        arbol.insertar("RECTORIA", "");
        arbol.insertar("VICERRECTORIA ADMINISTRATIVA", "RECTORIA");
        arbol.insertar("VICERRECTORIA ACADEMICA", "RECTORIA");
        arbol.insertar("VICERRECTORIA DEL MEDIO UNIVERSITARIO", "RECTORIA");
        arbol.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE INGENIERIA Y TECNOLOGIAS", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORIA ACADEMICA");
        arbol.insertar("DEPARTAMENTO DE MATEMTICAS","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        arbol.insertar("DEPARTAMENTO DE INFORMATICA Y CIENCIAS DE LA COMPUTACIÓN","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        arbol.listarIndentado();
    }
    
}
