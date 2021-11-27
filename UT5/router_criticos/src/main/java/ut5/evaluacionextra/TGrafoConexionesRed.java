package ut5.evaluacionextra;

import java.util.Collection;
import java.util.LinkedList;


public class TGrafoConexionesRed extends TGrafoNoDirigido implements IGrafoConexionesRed {

    public TGrafoConexionesRed(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public LinkedList<TVertice> routersCriticos(Comparable etRouter) {
        desvisitarVertices();
        LinkedList<TVertice> respuesta = new LinkedList<>();
        LinkedList<TVertice> visitados = new LinkedList<>();
        if(this.existeVertice(etRouter)){
            TVertice vertice = getVertices().get(etiqueta);
            vertice.setNumBajo(1);
            vertice.numerarBP(visitados);
            desvisitarVertices();
            vertice.routersCriticos(vertice, respuesta);
        }
        return respuesta;
    }

  

}
