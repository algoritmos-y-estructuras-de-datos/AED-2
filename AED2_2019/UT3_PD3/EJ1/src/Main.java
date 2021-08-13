
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map< String, Object> mapa = new HashMap<>();
        // Inserto las claves
        mapa.put("a", null);
        mapa.put("b", null);
        mapa.put("c", null);
        mapa.put("d", null);
        mapa.put("e", null);
        // Imprimo tamaño antes de eliminar
        System.out.println(mapa.size());
        // Elimino todas las claves
        for (Iterator<String> iterator = mapa.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            if (!key.equals("f")) {
                iterator.remove();
            }
        }
        // Imprimo tamaño luego de eliminar
        System.out.println(mapa.size());

    }

}
