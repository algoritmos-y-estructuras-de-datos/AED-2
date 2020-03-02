
import java.util.LinkedList;

public class TOrdenador {

    public Comparable[] heapSort(Comparable[] datos) {
        for (int i = (datos.length - 1) / 2; i >= 0; i--) {
            heapify(datos, i, datos.length - 1);
        }
        for (int i = datos.length - 1; i >= 1; i--) {
            intercambiar(datos, 0, i);
            heapify(datos, 0, i - 1);
        }
        return datos;
    }

    private void heapify(Comparable[] datos, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) {
                    if (datos[r].compareTo(datos[r * 2]) < 0) {
                        intercambiar(datos, r, 2 * r);
                    }
                    r = ultimo;
                } else {
                    int posicionIntercambio = 0;
                    if (datos[2 * r].compareTo(datos[2 * r + 1]) > 0) {
                        posicionIntercambio = 2 * r + 1;
                    } else {
                        posicionIntercambio = 2 * r;
                    }
                    if (datos[r].compareTo(datos[posicionIntercambio]) > 0) {
                        intercambiar(datos, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }

    private void intercambiar(Comparable[] vec, int pos1, int pos2) {
        Comparable temp = vec[pos2];
        vec[pos2] = vec[pos1];
        vec[pos1] = temp;
    }

    public static Automovil buscar(LinkedList<Automovil> lista, String cod) {
        for (Automovil p : lista) {
            if (p.getID().equals(cod)) {
                return p;
            }
        }
        return null;
    }

    public boolean estaOrdenado(Comparable[] datosParaVerificar) {
        for (int i = 0; i < datosParaVerificar.length - 1; i++) {
            if (datosParaVerificar[i].compareTo(datosParaVerificar[i + 1]) != 0) {
                System.out.println(String.format("%d (índice %d) > %d (índice %d)", datosParaVerificar[i], i, datosParaVerificar[i + 1], (i + 1)));
                return false;
            }
        }
        return true;
    }

}
