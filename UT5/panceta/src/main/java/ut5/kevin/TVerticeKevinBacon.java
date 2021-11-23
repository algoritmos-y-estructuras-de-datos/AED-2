package ut5.kevin;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVerticeKevinBacon extends TVertice implements IVerticeKevinBacon {

    private int bacon;

    public TVerticeKevinBacon(Comparable nombreActor) {
        super(nombreActor);

        if (nombreActor.compareTo("Kevin_Bacon") == 0) {
            setBacon(0);
        } else {
            bacon = Integer.MAX_VALUE;
        }
    }

    @Override
    public int getBacon() {
        return bacon;
    }

    @Override
    public void setBacon(int newBacon) {
        this.bacon = newBacon;
    }

    public void beatrizBacon(Comparable actorDestino) {
        Queue<TVerticeKevinBacon> vertices = new LinkedList<>();
        vertices.add(this);
        this.setVisitado(true);

        int baconActual = 1;

        salir: // Label para poder salir cuando se encuentra el actor destino
        while (!vertices.isEmpty()) {
            TVertice verticeX = vertices.poll();
            LinkedList<TAdyacencia> ady = verticeX.getAdyacentes();

            for (TAdyacencia y : ady) {
                TVertice verticeY = y.getDestino();
                if (!verticeY.getVisitado()) {
                    verticeY.setVisitado(true);
                    verticeY.setBacon(baconActual);
                    if (verticeY.getEtiqueta().compareTo(actorDestino) == 0) {
                        break salir;
                    }

                    vertices.add(verticeY);
                }
            }
            baconActual++;
        }
    }
}
