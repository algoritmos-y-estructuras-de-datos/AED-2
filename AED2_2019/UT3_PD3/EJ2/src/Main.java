
import java.util.HashMap;
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
        // Inicializo el mapa
        Map<String, String> mapa = new HashMap<>();
        // Cargo los valores
        mapa.put("key1", "valor1");
        mapa.put("key2", "valor2");
        mapa.put("key3", "valor3");
        mapa.put("key4", "valor4");
        // Llamo al metodo
        Map<String, String> mapaIntercambiado = Intercambio(mapa);
        // Imprimo el mapa intercambiado
        for (Map.Entry<String, String> entry : mapaIntercambiado.entrySet()) {
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }
    }

    public static Map<String, String> Intercambio(Map<String, String> mapa) {
        Map<String, String> mapaDevolver = new HashMap<>();
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            mapaDevolver.put(entry.getValue(), entry.getKey());
        }
        return mapaDevolver;
    }
}
