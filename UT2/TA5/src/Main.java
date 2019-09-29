
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap; 
import static javafx.scene.input.KeyCode.T;
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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("src/libro.txt"));
        for(String linea; (linea = br.readLine()) != null; ) {
            for (String palabra : linea.split(" ")){
                if (!palabra.trim().isEmpty()) {
                    String palabraLimpia = IndizarLibro.filtrarPalabra(palabra);
                    if(hashMap.containsKey(palabraLimpia)){
                        hashMap.put(palabraLimpia, hashMap.get(palabraLimpia) + 1);
                    } else {
                        hashMap.put(palabraLimpia, 1);
                    }
                }
                
            }
        }
        
        //System.out.println(Collections.max(hashMap.entrySet()));
        //System.out.println(hashMap.entrySet());
    }
    
}
