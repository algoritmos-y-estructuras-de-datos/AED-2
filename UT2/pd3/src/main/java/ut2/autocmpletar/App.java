package ut2.autocmpletar;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String[] palabras = ManejadorArchivosGenerico
                .leerArchivo("C:/Source/AED-2/UT2/pd3/src/main/java/ut2/autocmpletar/PalabrasBuscar.txt");

        TArbolTrie diccionario = new TArbolTrie();
        for (String coso : palabras) {
            diccionario.insertar(coso.trim());
        }
        String palabra = "pencil";
        System.out.println("Comparaciones para encontrar la palabra: " + palabra + " = " + diccionario.buscar(palabra));
    }
}
