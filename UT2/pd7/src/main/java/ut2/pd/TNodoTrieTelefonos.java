package ut2.pd;

import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private static final int CANT_CHR_ABECEDARIO = 10;
    private TNodoTrieTelefonos[] hijos;
    private TAbonado nombre;
    private boolean esTelefono;

    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[CANT_CHR_ABECEDARIO];
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos buscado = buscarNodo(primerosDigitos);
        this.buscarTelefonos(primerosDigitos, abonados, buscado);
    }

    private TNodoTrieTelefonos buscarNodo(String telefono) {
        TNodoTrieTelefonos nodo = this;
        char[] caracteresTelefonicos = telefono.toCharArray();

        for (int i = 0; i < caracteresTelefonicos.length; i++) {
            int indice = Character.getNumericValue(caracteresTelefonicos[i]);
            if (nodo.hijos[indice] == null) {
                return null;
            } else {
                nodo = nodo.hijos[indice];
            }
        }
        return nodo;
    }

    private void buscarTelefonos(String paisArea, LinkedList<TAbonado> listaAbonados, TNodoTrieTelefonos nodo) {

        if (nodo != null) {
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    buscarTelefonos(paisArea, listaAbonados, nodo.hijos[c]);
                }
            }
            if (nodo.esTelefono == true) {
                listaAbonados.add(nodo.nombre);

            }
        }

    }

    @Override
    public void insertar(TAbonado unAbonado) {
        String telefono = unAbonado.getTelefono(); // Obtengo telefono
        TNodoTrieTelefonos nodo = this;
        char[] caracteresTelefonicos = telefono.toCharArray();
        // 059894984982
        for (int c = 0; c < caracteresTelefonicos.length; c++) {
            int indice = Character.getNumericValue(caracteresTelefonicos[c]);
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esTelefono = true;
        nodo.nombre = unAbonado;
    }

}
