package ut5.kevin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TGrafoKevinBacon extends TGrafoNoDirigido implements IGrafoKevinBacon {
  
    public TGrafoKevinBacon(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVerticeKevinBacon vert = new TVerticeKevinBacon(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    // @Override
    // public int numBacon(Comparable actor) {
    //     TVerticeKevinBacon kevin = (TVerticeKevinBacon) getVertices().get("Kevin_Bacon");
    //     TVerticeKevinBacon objetivo = (TVerticeKevinBacon) getVertices().get(actor);
    //     kevin.beatrizBacon(objetivo.getEtiqueta());
        
    //     return objetivo.getBacon();
    // }
    @Override
    public int numBacon(Comparable actor) {
        TVerticeKevinBacon kevin = (TVerticeKevinBacon) getVertices().get("Kevin_Bacon");
        kevin.beatrizBacon(actor);
        TVerticeKevinBacon objetivo = (TVerticeKevinBacon) getVertices().get(actor);
        return objetivo.getBacon();
    }

    // public int numBacon3(Comparable actor) {
    //     // obtener los tvertices
    //     TVertice kevin = getVertices().get("Kevin_Bacon");
    //     // bea a partir de Kevin y retornar resultado
    //     return kevin.beatrizBacon(Comparable actor);
    // }

}
