package ut3ta3;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante.fit
 */
public class MedicionPredecirLinkedList extends Medible{

    private LinkedListPredict linkedList;

    public MedicionPredecirLinkedList(LinkedListPredict linkedList) {
        this.linkedList = linkedList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                linkedList.predecir(palabra);
            }
        }
    }   

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }
    
}
