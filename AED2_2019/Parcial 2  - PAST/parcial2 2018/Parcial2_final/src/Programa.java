


import java.util.Collection;
import java.util.LinkedList;

public class Programa {

    /**
     * @param args argumentos de linea de comando
     */
    public static void main(String[] args) {
        /**
         * NOTA: Se dejan los métodos que cumplen la interfaz de grafo y vertice
         * que no fueron utilizados SIN IMPLEMENTAR, con permiso de la cátedra.
         * e.g. Prim, todosLosCaminos, etc.
         */

        LinkedList<TVertice> losActores = new LinkedList<>();
        TAristas lasPeliculas = new TAristas();
        
        String[] lineasV = ManejadorArchivosGenerico.leerArchivo("./src/actores.txt", false);
        for (String linea : lineasV) {
            String verticeEtiqueta = linea.trim();
            losActores.add(new TVertice(verticeEtiqueta));
        }

        String[] lineasA = ManejadorArchivosGenerico.leerArchivo("./src/en_pelicula.txt", false);
        for (String linea : lineasA) {
            String[] datos = linea.split(",");
            if (datos.length != 3) {
                System.out.printf("ERROR al leer arista: '%s'\n", linea);
                continue;
            }
            String etiquetaOrigen = datos[0];
            String etiquetaDestino = datos[1];
            
            // El costo de la arista para este problema no tiene significado
            lasPeliculas.add(new TArista(etiquetaOrigen, etiquetaDestino, 1));
        }
        
        TGrafoNoDirigido gkb = new TGrafoNoDirigido(losActores, lasPeliculas);
        
        
        final String nomArchivoSalida = "./src/salida.txt";
        
        String actorZZ1 = "Kevin_Bacon"; // se indicará en el pizarrón
        Collection<TVertice> contactos1 = gkb.listarContactos(actorZZ1, 1);
        // escribir los resultados al archivo "salida.txt"
        escribirContactos(contactos1, nomArchivoSalida);
        
        ManejadorArchivosGenerico.escribirArchivo(nomArchivoSalida, new String[] {""});

        String actorZZ2 = "David_Cross"; // se indicará en el pizarrón
        Collection<TVertice> contactos2 = gkb.listarContactos(actorZZ2, 5);
        // escribir los resultados al archivo "salida.txt"
        escribirContactos(contactos2, nomArchivoSalida);
    }

    private static void escribirContactos(Collection<TVertice> contactos, String nomArchivo) {
        String[] lineas = new String[contactos.size()];
       
        int i = 0;
        for (TVertice contacto : contactos) {
            lineas[i] = String.format("%s --- %d", contacto.getEtiqueta().toString(), contacto.getNumBacon());
            i += 1;
        }
        ManejadorArchivosGenerico.escribirArchivo(nomArchivo, lineas);
        
    }
}
