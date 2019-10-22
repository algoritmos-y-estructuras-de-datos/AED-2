
import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class TGrafoAerolinea extends TGrafoDirigido implements IGrafoAerolinea {

    public TGrafoAerolinea(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public LinkedList<TVertice> menosEscalas(Comparable origen, Comparable destino) {
        TVertice verticeO = buscarVertice(origen);
        TVertice verticeD = buscarVertice(destino);
        LinkedList<TVertice> col = new LinkedList<>();
        if (verticeO != null) {
            verticeO.bea(col,verticeD);
        }
        return col;
    }

}
