/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.PD5;

import Grafos.TArista;
import Grafos.TGrafoDirigido;
import Grafos.TVertice;
import java.util.Collection;

/**
 *
 * @author usuario
 */
public class GrafoConexo extends TGrafoDirigido{
    
    public GrafoConexo(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }
    
    public boolean esConexo()
    {
        
        return false;
    }
}
