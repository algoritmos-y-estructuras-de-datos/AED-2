package UT4PD2;

import UT4PD2.TVertice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernesto
 */
public interface IAdyacencia {

    double getCosto();

    TVertice getDestino();

    Comparable getEtiqueta();
    
}
