
import static java.lang.System.in;
import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

    public static void main(String[] args) {
//        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt", "./src/conexiones_1.txt",
//                false, TGrafoDirigido.class);
//
//        Object[] etiquetasarray = gd.getEtiquetasOrdenado();
//
//   
//        gd.desvisitarVertices();
//   
//        if (gd.tieneCiclo()) {
//            System.out.println("tiene ciclos");
//        } else {
//            System.out.println("no tiene ciclos");
//        }
        
        
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        
        TVertice a = new TVertice("A");
        TVertice b = new TVertice("B");
        TVertice c = new TVertice("C");
        TVertice d = new TVertice("D");
        
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);

        aristas.add(new TArista("A", "B", 50));
        aristas.add(new TArista("A", "C", 200));
        aristas.add(new TArista("B", "D", 10));
        aristas.add(new TArista("C", "D", 30));
        
        TGrafoNoDirigido gd2 = new TGrafoNoDirigido(vertices, aristas);
        //gd2.insertarArista(new TArista("C", "D", 30));
        //System.out.println(gd2.getLasAristas().imprimirEtiquetas());
        TGrafoNoDirigido gd3 = gd2.Prim();
        //TGrafoNoDirigido gd3 = gd2.Kruskal();
        //System.out.println(gd2.getLasAristas().size());
        System.out.println(gd3.imprimirEtiquetas());
        /*for(TArista comp:gd2.getLasAristas()){
            System.out.println(comp.getCosto());
        }*/
        //System.out.println(campo.getCostoTotal());
    }
}
