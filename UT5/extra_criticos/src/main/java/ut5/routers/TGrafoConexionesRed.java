package ut5.routers;

import java.util.Collection;
import java.util.LinkedList;

public class TGrafoConexionesRed extends TGrafoNoDirigido implements IGrafoConexionesRed {

    public TGrafoConexionesRed(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        //TODO Auto-generated constructor stub
    }

    @Override
    public LinkedList<TVertice> routersCriticos(Comparable etRouter) {
        this.desvisitarVertices();
        LinkedList<TVertice> respuesta = new LinkedList<>();
        LinkedList<TVertice> visitados = new LinkedList<>();
        if(this.existeVertice(etRouter)){
            TVertice vertice = getVertices().get(etRouter);
            vertice.setNumBajo(1);
            vertice.numerarBP(visitados);
            desvisitarVertices();
            vertice.routersCriticos(vertice, respuesta);
        }
        return respuesta;
    }
    
}
