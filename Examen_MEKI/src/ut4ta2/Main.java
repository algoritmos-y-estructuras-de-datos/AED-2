package ut4ta2;


import ut4pd5.*;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/ut4ta2/actividades.txt","src/ut4ta2/dependencias_actividades.txt",
                false, TGrafoDirigido.class);

      Comparable origen = "Inicio";
        Comparable destino = "Fin";
        gd.caminoCritico(origen, destino);


       
    }
}
