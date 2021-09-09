package ut3_ta1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hash<T> implements IHash {

    public ArrayList<LinkedList<T>> tabla;
    
    @Override
    public int buscar(int unaClave) {
        LinkedList lista = tabla.get(funcionHashing(unaClave));
        int cont=0;
       for(int i=0;i<lista.size();i++){
            cont++;
            if (lista.get(i).equals(unaClave)){
                return cont;
            }
        }
        return 0;
    }

    @Override
    public int insertar(int unaClave) {
        int hash = funcionHashing(unaClave);
        LinkedList<Integer> nodos = listas[hash];
        int comp = 0;
        
        // Si no existe
        if (nodos == null) {
            listas[hash] = new LinkedList<>();
            listas[hash].add(unaClave);
        } else {
            Iterator<Integer> iterador = nodos.iterator();
            while (iterador.hasNext()) {
                Integer nodo = iterador.next();
                comp++;
                if (nodo.equals(unaClave)) {
                    return -1;
                }
            }
        }
        nodos.add(unaClave);
        return comp;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return 0;
    }
    
}