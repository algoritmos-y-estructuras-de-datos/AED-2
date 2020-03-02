
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));
        vertices.add(new TVertice("E"));
        
        
        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 1));
        aristas.add(new TArista("A", "D", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("B", "D", 1));
        aristas.add(new TArista("C", "D", 1));
        aristas.add(new TArista("D", "E", 1));
        aristas.add(new TArista("E", "B", 1));
       
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);
        String actorZZ = "A"; 
        Collection<TVertice> contactos = gnd.listarContactos(actorZZ, 1);
        System.out.println("Cant A, n=1 " + contactos.size());
// cargar grafo con actores y relaciones
        LinkedList<TVertice> losActores = new LinkedList<>();
        TAristas lasPeliculas = new TAristas();
        
        for (String a: ManejadorArchivosGenerico.leerArchivo("src/actores_1.txt", false)){
            try {
                TVertice v = new TVertice (a.trim());
                losActores.addLast(v);
            }
            catch (Exception e){}
        }
        
        for (String a: ManejadorArchivosGenerico.leerArchivo("src/en_pelicula_1.txt", false)){
            try {
                String[] s = a.split(",");
                Integer n = Integer.parseInt(s[2]);
                TArista v = new TArista (s[0],s[1],n);
                lasPeliculas.addLast(v);
            }
            catch (Exception e){}
        }
        TGrafoNoDirigido gkb = new TGrafoNoDirigido(losActores, lasPeliculas);
        
        String actorZZ1 = "Kevin_Bacon"; // se indicará en el pizarrón
        Collection<TVertice> contactos1 = gkb.listarContactos(actorZZ1, 1);
        // escribir los resultados al archivo "salida.txt"
       
        String[] aux1 = new String[contactos1.size()];
        int i = 0;
        for (TVertice a : contactos1)
        {
            aux1[i] = a.getEtiqueta() + ","+ a.getNumBacon();
            i++;
        }
        
        gkb.desvisitarVertices();
               
        String actorZZ2 = "David_Cross"; // se indicará en el pizarrón
        Collection<TVertice> contactos2 = gkb.listarContactos(actorZZ2, 5);

        // escribir los resultados al archivo "salida.txt"
        // emitir un archivo de salida, "salida.txt" con la lista de contactos obtenida
        i=0;
        String[] aux = new String[aux1.length+contactos2.size()];
        for (String s : aux1)
        {
            aux[i] = s;
            i++;
        }
        aux[i-1] = aux[i-1] + "\n" + "------------------------------------";
        i = aux1.length;
        for (TVertice a : contactos2)
        {
            aux[i] = a.getEtiqueta() + ","+ a.getNumBacon();
            i++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt",aux);
        
        gkb.desvisitarVertices();
        String actorZZ3 = "Harrison_Ford"; // se indicará en el pizarrón
        Collection<TVertice> contactos3 = gkb.listarContactos(actorZZ3,2,5);

        String[] aux2 = new String[contactos3.size()];
        i = 0;
        for (TVertice a : contactos3)
        {
            aux2[i] = a.getEtiqueta() + ","+ a.getNumBacon();
            i++;
        }
        
        gkb.desvisitarVertices();

        ManejadorArchivosGenerico.escribirArchivo("./src/salida2.txt",aux2);
        
        System.out.println("Resultado conectados : "+gkb.conectados("Uma_Thurman", "Juan_Garcia"));
        
        int zz = gkb.numerozz("David_Cross", "Harrison_Ford");
        System.out.println(zz);
    }
}
