package ut4.pd7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Proyecto {

  public static void main(String[] args) {

    LinkedList<TVertice> verticesList = new LinkedList<>();
    TAristas aristasList = new TAristas();
    // cargar los archivos de tareas y precedencias
    // generar una lista con los vertices y una lista de aristas

    // instanciar el grafo dirigido, CON LAS ARISTAS EN EL SENTIDO APROPIADO!!!!

    // TGrafoDirigido proyecto = new TGrafoDirigido....

    TGrafoDirigido proyecto = (TGrafoDirigido) UtilGrafos.cargarGrafo(
        "UT4/ordenparcialpd7/src/main/java/ut4/pd7/tareas.txt",
        "UT4/ordenparcialpd7/src/main/java/ut4/pd7/precedencias.txt",
        false, TGrafoDirigido.class);

    // ejecutar el metodo para hallar el orden parcial para todo el proyecto

    // LinkedList<Tarea> op = proyecto.ordenParcial();
    // proyecto.listarTareas(op);

    // guardar las tareas en un archivo de texto "orden.txt" (para el primer
    // conjunto de
    // precedencias, y "orden2.txt" para el segundo.

  }
}
