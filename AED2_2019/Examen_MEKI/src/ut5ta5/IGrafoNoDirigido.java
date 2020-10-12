/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut5ta5;

import ut5ta6.*;
import java.util.Collection;

/**
 *
 * @author Meki
 */
interface IGrafoNoDirigido {
      public Collection <TVertice> bea();
     public Collection <TVertice> bea(Comparable etiquetaOrigen);
    public TGrafoNoDirigido Prim();

    public TGrafoNoDirigido Kruskal();
}
