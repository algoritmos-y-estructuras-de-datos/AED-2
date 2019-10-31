package parcialCompleto;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap {

    private final HashMap<Character,TNodoTrieHashMap> hijos;
    private boolean esPalabra;
    private int posicion;

    public boolean isEsPalabra() {
        return esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public TNodoTrieHashMap() {
        hijos       = new HashMap<>();
        esPalabra   = false;
        posicion = -1;
    }

   
      public void insertar(String unaPalabra, int posicion) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character character = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(character)) {
                nodo.hijos.put(character, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(character);
        }
        nodo.setEsPalabra(true);
        nodo.setPosicion(posicion);
    }
      
    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " " + nodo.getPosicion());
            }
            
            for (Character caracter : nodo.hijos.keySet())
                if (nodo.hijos.get(caracter) != null) {
                    imprimir(s + caracter, nodo.hijos.get(caracter));
                }
            }
        }

    public void imprimir(){
        imprimir("", this);
    }

    
    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
            }
            for (Character caracter : nodo.hijos.keySet()) {
                if (nodo.hijos.get(caracter) != null) {
                    predecir(s + caracter, prefijo, palabras, nodo.hijos.get(caracter));
                }
            }
        }
    }

    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        predecir("", prefijo, palabras, nodo);
    }
    
    public void contarPalAux(TNodoTrieHashMap nodo,int[] contador){
        if(nodo != null){
            if(nodo.esPalabra){
                contador[0]++;
                
            }
            for (Character caracter : nodo.hijos.keySet()) {
                if (nodo.hijos.get(caracter) != null) {
                     contarPalAux(nodo.hijos.get(caracter),contador);
                }
            }
        } 
    }
    
    public int contarPal(){
        int[] contador = new int[1];
        for(Character caracter : hijos.keySet())
            contarPalAux(hijos.get(caracter), contador);
        return contador[0];
    }
    
    public void alturaTrieAux(TNodoTrieHashMap nodo,int contador,int mayor[]){
        if(nodo != null){
            if(nodo.esPalabra){
                if(mayor[0]<=contador){
                    if(mayor[0]<contador){
                        mayor[0] = contador;
                    }
                }
            }
            for (Character caracter : nodo.hijos.keySet()) {
                if (nodo.hijos.get(caracter) != null){
                    alturaTrieAux(nodo.hijos.get(caracter),contador+1,mayor);
                }
            }
        }   
    }
    
    public int alturaTrie(){
        int contador = 1;
        int mayor[]=new int[1];
        for(Character caracter : hijos.keySet())
           alturaTrieAux(hijos.get(caracter), contador,mayor);
        return mayor[0];
    }
    
    public void contarPrefijosAux(TNodoTrieHashMap nodo, int[] contador){
        if(nodo != null){
            if(nodo.esPalabra){
                contador[0]++;
                
                }
            }
            for (Character caracter : nodo.hijos.keySet()) {
                if (nodo.hijos.get(caracter) != null) {
                     contador[0]++;
                     contarPrefijosAux(nodo.hijos.get(caracter),contador);
                }
            }
        }
    
    public int contarPrefijos(){
        int[] contador2 = new int[1];
        for(Character caracter : hijos.keySet())
            contarPrefijosAux(hijos.get(caracter),contador2);
        
        return contador2[0];
    }
    

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            Character character = s.charAt(c);
            if (nodo.hijos.get(character) == null) {
                return null;
            }
            nodo = nodo.hijos.get(character);
        }
        return nodo;
    }
     private void ocurrenciasPosicionesPatron(String patron, ArrayList<Integer> posiciones, TNodoTrieHashMap nodo) {
        // TODO completar
        if (nodo != null) {
            if (nodo.esPalabra) {
                
                posiciones.add(0, posiciones.get(0)+1);
                posiciones.remove(1);
                posiciones.add(nodo.posicion);
            }
            for (Character caracter : nodo.hijos.keySet()){
                if (nodo.hijos.get(caracter) != null) {
                    ocurrenciasPosicionesPatron(patron, posiciones, nodo.hijos.get(caracter));
                }
            }
        }
    }

    public ArrayList<Integer> ocurrenciasPosicionesPatron(String patron) {
         //TODO completar
        ArrayList<Integer> posiciones = new ArrayList<>();
        posiciones.add(0);
        TNodoTrieHashMap nodo=this.buscarNodoTrie(patron);
        ocurrenciasPosicionesPatron(patron, posiciones,nodo);
        return posiciones;
    }
    
   
    
    /*
    public void longestSubStringAux(String patronAcumulado,TNodoTrieHashMap nodo,LinkedList<String> palabras,int mayor){
        if (nodo!=null){
        
        for(Character caracter : nodo.hijos.keySet()){
            
            predecir(patronAcumulado+caracter,palabras);
            int tamPal = palabras.size()-2;
            if(tamPal>1){
                String p=patronAcumulado+caracter;
            if(palabras.size()>0 && palabras.get(0).length()<patronAcumulado.length()+1 && (palabras.get(0).indexOf(p)>0 || palabras.get(0).indexOf(p)==-1) )
            {
                mayor=tamPal;
                palabras.clear();
                palabras.add(patronAcumulado+caracter);
            }
            else
                if(mayor<=tamPal){
                    if(mayor<tamPal){
                        palabras.clear();
                        mayor = tamPal;
                        }
                    palabras.add(patronAcumulado+caracter);
                    }
                    longestSubStringAux(patronAcumulado+caracter,nodo.hijos.get(caracter),palabras,mayor);
                }
            }
        }
    }
    
    public void longestSubString(LinkedList<String> palabras){
    //TNodoTrieHashMap nodo = buscarNodoTrie(acumulado);
        int mayor =0;
        for(Character caracter : hijos.keySet()){
            longestSubStringAux("",hijos.get(caracter),palabras,mayor);
        }
    }*/
    
    
    
    
    

   
    
    
}
