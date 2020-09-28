package ut4pd7;

import java.util.LinkedList;

public class Proyecto {

    public static void main(String[] args) {

        LinkedList<TVertice> verticesList = new LinkedList<>();
        TAristas aristasList = new TAristas();
        // cargar los archivos de tareas y precedencias
        // generar una lista con los vertices y una lista de aristas
        
        // instanciar el grafo dirigido, CON LAS ARISTAS EN EL SENTIDO APROPIADO!!!!

        
        TGrafoDirigido gd = (TGrafoDirigido)UtilGrafos.cargarGrafo("src/ut4pd7/tareas.txt","src/ut4pd7/precedencias.txt",false, TGrafoDirigido.class);

//      ejecutar el metodo para hallar el orden parcial para todo el proyecto
        
        gd.listarTareas(gd.ordenParcial());

      
        // guardar las tareas en un archivo de texto "orden.txt" (para el primer conjunto de 
      // precedencias, y "orden2.txt" para el segundo.

    }
}
