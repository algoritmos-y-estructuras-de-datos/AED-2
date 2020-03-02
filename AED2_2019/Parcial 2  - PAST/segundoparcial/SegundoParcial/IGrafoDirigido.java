/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import UT05.*;
import java.util.Collection;

/**
 *
 * @author diego
 */
public interface IGrafoDirigido {

    Collection bpf(Comparable etiquetaOrigen);

   

    /**
     * @return Etiqueta del centro del grafo
     */
    Comparable centroDelGrafo();

    boolean contieneCiclos();

    /**
     * M�todo encargado de eliminar una adyacencia dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     */
    boolean eliminarAdyacencia(Comparable nomVerticeOrigen, Comparable nomVerticeDestino);

    /**
     * M�todo encargado de eliminar un v�rtice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     */
    boolean eliminarVertice(Comparable nombreVertice);

    /**
     * M�todo encargado de verificar la existencia de una adyacencia. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    boolean existeAdyacencia(Comparable etiquetaOrigen, Comparable etiquetaDestino);

    /**
     * M�todo encargado de verificar la existencia de un v�rtice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    boolean existeVertice(Comparable unaEtiqueta);

    Double[][] floyd();

    /**
     * M�todo encargado de insertar una adyacencia en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la adyacencia sea
     * v�lida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por par�metros son v�lidas.- 2) Los v�rtices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una adyacencia ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    boolean insertarAdyacencia(Comparable etiquetaOrigen, Comparable etiquetaDestino, Double costo);

    /**
     * M�todo encargado de insertar un v�rtice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    boolean insertarVertice(Comparable unaEtiqueta,int duracion);

    Comparable obtenerExcentricidad(Comparable etiquetaVertice);

    /**
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param comparadorCaminos
     * @return Un array con las claves de los vertices que componen el mejor
     * camino, en caso de que exista
     */
    //TCaminosImpl todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino);

    Boolean[][] warshall();
    
}
