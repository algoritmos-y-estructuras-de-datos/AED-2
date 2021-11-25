package ut5.panceta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {

        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    public TGrafoNoDirigido Prim2() {
        int costoPrim = 0;
        LinkedList<Comparable> verticesU = new LinkedList<>();
        LinkedList<Comparable> verticesV = new LinkedList<>();
        TAristas aristasAAM = new TAristas();
        TArista tempArista;

        if (this.getVertices().isEmpty()) {
            return null;
        }

        for (TVertice verticeOriginal : this.getVertices().values()) {
            verticesV.add(verticeOriginal.getEtiqueta());
        }

        verticesU.add(verticesV.remove(0));

        while (!verticesV.isEmpty()) {
            tempArista = this.getLasAristas().buscarMin(verticesU, verticesV);
            if (tempArista == null) {
                System.out.println("Grafo no conexo");
                return null;
            }

            aristasAAM.add(tempArista);
            Comparable destino = tempArista.getEtiquetaDestino();
            verticesV.remove(destino);
            verticesU.add(destino);
            costoPrim += tempArista.getCosto();
        }
        System.out.println("Costo Prim: " + costoPrim);

        return new TGrafoNoDirigido(this.getVertices().values(), aristasAAM);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {

        return null;
    }

    public TGrafoNoDirigido KruskalSecundario() {
        LinkedList<TArista> aristasKruskal = new LinkedList(); // Aqui se almacenaran las aristas seleccionadas.
        Map<Comparable, TVertice> vertices = getVertices();

        if (!vertices.isEmpty()) {
            desvisitarVertices();
            HashMap<Comparable, LinkedList<TVertice>> colecciones = new HashMap(vertices.size());
            LinkedList<TVertice> colTemp;

            // Creamos una "coleccion" para cada arista
            for (TVertice v : vertices.values()) {
                colTemp = new LinkedList();
                colTemp.add(v);
                colecciones.put(v.getEtiqueta(), colTemp);
            }

            // Ordenamos todas las aristas del grafo de menor costo a mayor
            LinkedList<TArista> aristasOrdenadas = new LinkedList();
            forAristas: for (TArista a : lasAristas) {
                if (aristasOrdenadas.isEmpty() || aristasOrdenadas.getFirst().getCosto() > a.getCosto()) {
                    aristasOrdenadas.addFirst(a);
                    continue;
                }
                for (int i = 1; i < aristasOrdenadas.size(); i++) {
                    if (aristasOrdenadas.get(i).getCosto() > a.getCosto()) {
                        aristasOrdenadas.add(i - 1, a);
                        continue forAristas;
                    }
                }
                aristasOrdenadas.add(a);
            }

            // Conectamos las colecciones de vertices (no conectados) mediante la arista de
            // menor costo posible
            TArista menorArista;
            LinkedList<TVertice> colOrigen, colDestino;
            while (!aristasOrdenadas.isEmpty()) {
                menorArista = aristasOrdenadas.pollFirst();
                colOrigen = colecciones.get(menorArista.etiquetaOrigen);
                colDestino = colecciones.get(menorArista.etiquetaDestino);
                if (colOrigen != colDestino) {
                    colOrigen.addAll(colDestino);
                    for (TVertice v : colDestino) {
                        if (colecciones.get(v.getEtiqueta()) != colOrigen) {
                            colecciones.replace(v.getEtiqueta(), colOrigen);
                        }
                    }
                    aristasKruskal.add(menorArista);
                }
            }
        }

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices.values(), aristasKruskal);
        return grafo;
    }

    // CHECKEAR
    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        Collection<TVertice> etiquetas = new LinkedList<TVertice>();
        TVertice verticeOrigen = this.getVertices().get(etiquetaOrigen);
        if (verticeOrigen != null) {
            verticeOrigen.bea(etiquetas);
            return etiquetas;
        }
        return etiquetas;
    }

    @Override
    public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean esConexo() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea() {
        return null;
    }

    @Override
    public int numBacon(Comparable actor) {
        desvisitarVertices();
        Collection<TVertice> lista = new LinkedList<>();
        TVertice vertice = getVertices().get(actor);
        int numeroBeacon = Integer.MAX_VALUE;
        if (vertice != null) {
            numeroBeacon = vertice.numBacon(lista);
        }
        return numeroBeacon;
    }
}
