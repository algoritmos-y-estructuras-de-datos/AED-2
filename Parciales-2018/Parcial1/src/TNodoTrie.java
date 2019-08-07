
import java.util.HashMap;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class TNodoTrie implements INodoTrie {
    
    private HashMap<Comparable,TNodoTrie> hijos;
    private boolean esNumero;
    private TDispositivo abonado;

    public TNodoTrie() {
        hijos = new HashMap();
    }
 
    
    public void buscarDispositivos(String primerosDigitos, LinkedList<TDispositivo> dispositivos) {
        TNodoTrie aux = this.buscarNodoTrie(primerosDigitos);
        if (aux!=null){obtenerNumeros(aux,dispositivos);}
    }

    @Override
    public void insertar(TDispositivo dispositivo) {
        TNodoTrie nodo = this;
        String[] l = dispositivo.getDirIP().split(".");
        for (String trio : dispositivo.getDirIP().replaceAll(".",",").split(",")) {
            if (!nodo.hijos.containsKey(Integer.parseInt(trio))) {
                nodo.hijos.put(Integer.parseInt(trio), new TNodoTrie());
            }
            nodo = nodo.hijos.get(Integer.parseInt(trio));
        }
        nodo.esNumero = true;
    }
    
    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (String trio : s.split(".")) {
            if (!nodo.hijos.containsKey(Integer.parseInt(trio))) {
                return null;
            }
            nodo = nodo.hijos.get(Integer.parseInt(trio));
        }
        return nodo;
    }

    public void obtenerNumeros(TNodoTrie nodo, LinkedList<TDispositivo> palabras) {
        if (nodo != null) {
            if (nodo.esNumero) {
                palabras.add(nodo.abonado);
            }
            for (Integer c = 0; c < 1000; c++) {
                if (nodo.hijos.containsKey(c)) {
                    obtenerNumeros(nodo.hijos.get(c), palabras);
                }
            }
        }
    }
    
    
}
