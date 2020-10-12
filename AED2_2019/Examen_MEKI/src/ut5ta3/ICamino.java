/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta3;

import ut5pd1.*;
import ut5ta6.*;

/**
 *
 * @author Meki
 */
public interface ICamino {
        boolean agregarAdyacencia(TAdyacencia adyacenciaActual);

    TCamino copiar();

    boolean eliminarAdyacencia(TAdyacencia adyacenciaActual);


    String imprimirEtiquetas();
    
}
