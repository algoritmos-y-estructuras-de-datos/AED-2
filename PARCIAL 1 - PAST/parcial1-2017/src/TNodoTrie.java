

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    public TAbonado dato;
    
    
    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        dato=null;
    }
   
    public TNodoTrie[] getHijos() {
        return hijos;
    }

    public void setHijos(TNodoTrie[] hijos) {
        this.hijos = hijos;
    }

    public boolean getEsPalabra() {
        return esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }
  
    public TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

     public void predecir(String x, String primerosDigitos, Map<String,TAbonado> abonados, TNodoTrie nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                abonados.put(dato.getNombre(), dato);   
                System.out.println(dato.getNombre());
            }   
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(x +(char)(c + 'a'), primerosDigitos, abonados, nodo.hijos[c]);
                }
            }
        }
    }
    
    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado>  abonados) {
        Map<String,TAbonado> dicc = new HashMap<String,TAbonado>();
        TNodoTrie nodo = buscarNodoTrie(primerosDigitos);
        System.out.println(nodo);
        predecir("", primerosDigitos, dicc, nodo);
        System.out.println("bbbbb"+dicc.size());
        Map<String,TAbonado> order = new TreeMap<>(dicc);
        
        abonados=new LinkedList<TAbonado>(order.values());
        
    }

    @Override
    public void insertar(TAbonado unAbonado) {       
        TNodoTrie nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            int indice = unAbonado.getTelefono().trim().charAt(c) - '0'; //No esta convertiiendo bien
            //System.out.println(unAbonado.getTelefono().trim().charAt(c) - '0');
            
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.dato=unAbonado;
    }


}
