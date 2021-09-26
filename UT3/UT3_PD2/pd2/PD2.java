/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3.pd2;

import java.util.ArrayList;
import java.util.List;
import ut3.ta1.THash;

/**
 *
 * @author Lucas Lois <lucas.lois@correo.ucu.edu.uy>
 */
public class PD2 {
    public static void main(String[] args) {
        ArrayList<String> lineas = new ArrayList();
        lineas.add("factor;comp ins;comp busc;no exito");
        for (double i = 0.70; i <= .90; i+= 0.05) {
            probarFactorCarga(i, lineas);
        }
        for (double i = 0.91; i <= .99; i+= 0.01) {
            probarFactorCarga(i, lineas);
        }
        ManejadorArchivosGenerico.escribirArchivo("./src/ut3/pd2/salida.csv", lineas.toArray(new String[] {}));
    }
    
    public static void probarFactorCarga(double factorCarga, List<String> out) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/ut3/pd2/claves_insertar.txt");
        THash hash = new THash((int) Math.ceil((lineas.length) / factorCarga));

        float compProm = 0;
        int noInsertadas = 0;
        for (String l : lineas) {
            int clave = Integer.parseInt(l);
            int c = hash.insertar(clave);
            if (c >= 0) {
                compProm += ((float) c) / lineas.length;
                //System.out.printf("Se insertó %d en %d comparaciones\n", clave, c);
            } else {
                noInsertadas += 1;
            }
        }
        //System.out.printf("Comparaciones (insercion) total promedio %.1f\n", compProm);
        //System.out.printf("Cantidad de claves no insertadas: %d\n", noInsertadas);
        
        
        String[] lBuscar = ManejadorArchivosGenerico.leerArchivo("./src/ut3/pd2/claves_buscar.txt");
        int comparacionesBuscar = 0;
        int busquedasExitosas = 0;
        float noExitoProm = 0;
        for (String lb : lBuscar) {
            final int clave = Integer.parseInt(lb);
            int c = hash.buscar(clave);
            if (c >= 0) {
                busquedasExitosas += 1;
                comparacionesBuscar += c;
                // System.out.printf("Se encontró %d en %d comparaciones\n", clave, c);
            } else {
                noExitoProm += ((float) -c) / lineas.length;
            }
        }
        double buscProm = ((double)comparacionesBuscar) / busquedasExitosas;
        //System.out.printf("Comparaciones (busqueda) con exito promedio %.1f\n", buscProm);
        //System.out.printf("Comparaciones (busqueda) sin exito promedio %.1f\n", buscProm);
        
        out.add(String.format("%.2f;%.1f;%.1f;%.1f", factorCarga, compProm, buscProm, noExitoProm));
        
        System.out.printf("%.2f\t%.1f\t%.1f\t%.1f\n", factorCarga, compProm, buscProm, noExitoProm);
        //System.out.printf("Cantidad de claves no encontradas: %d\n", noInsertadas);
    }
    
}
