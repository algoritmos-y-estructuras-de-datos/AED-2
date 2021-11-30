package uy.edu.ucu.aed2;

import java.util.LinkedList;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // LEER CUIDADOSAMENTE LA CONSIGNA DE ESTE TRABAJO, PUBLICADA EN LA TAREA
        // PARCIAL2_PARTE3
        // LOS COMENTARIOS DEL PRESENTE ARCHIVO NO SUSTITUYEN LO INDICADO EN LA LETRA DE
        // LA TAREA

        TGrafoRedDatos redDatos = (TGrafoRedDatos) UtilGrafos.cargarGrafo(
                "./src/main/java/uy/edu/ucu/aed2/servidores.txt",
                "./src/main/java/uy/edu/ucu/aed2/enlaces.txt",
                false, TGrafoRedDatos.class);

        // cargar grafo con SERVIDORES y ENLACES
        // redDatos = (TGrafoRedDatos)UtilGrafos.cargarGrafo... DONE

        // EJECUTAR PARA servidor1 = BUF y servidor2 = DFW
        String servidor1 = "BUF";
        String servidor2 = "DFW"; // BUF BWI PIT DFW
        LinkedList<TVertice> ruta = redDatos.rutaMenosSaltos(servidor1, servidor2);
        //ESCRIBIR RUTA EN rutas.txt SEGUIDO DE 2 LINEAS EN BLANCO - DONE
        String[] lineas= new String[2];
        String linea = "";
        int i=0;
        for (TVertice v : ruta) {
            linea += v.getEtiqueta().toString() + " ";
        }
        lineas[0] = linea;
        lineas[1] = "\n";
        ManejadorArchivosGenerico.escribirArchivo("./src/main/java/uy/edu/ucu/aed2/rutas.txt", lineas);
     
        // EJECUTAR PARA servidor1 = BUF y servidor2 = LAS
        servidor2 = "LAS";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2);
        //ESCRIBIR RUTA EN rutas.txt SEGUIDO DE 2 LINEAS EN BLANCO
        String[] lineas2= new String[2];
        String linea2 = "";
        for (TVertice v : ruta) {
            linea2 += v.getEtiqueta().toString() + " ";
        }
        lineas2[0] = linea2;
        lineas2[1] = "\n";
        ManejadorArchivosGenerico.escribirArchivo("./src/main/java/uy/edu/ucu/aed2/rutas.txt", lineas2);
        
        //EJECUTAR PARA servidor1 = BUF y servidor2 = MIA
        servidor2 = "MIA";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2);
        // ESCRIBIR RUTA EN rutas.txt SEGUIDO DE 2 LINEAS EN BLANCO
        String[] lineas3= new String[2];
        String linea3 = "";
        for (TVertice v : ruta) {
            linea3 += v.getEtiqueta().toString();
        }
        lineas3[0] = linea3;
        lineas3[1] = "\n";
        ManejadorArchivosGenerico.escribirArchivo("./src/main/java/uy/edu/ucu/aed2/rutas.txt", lineas3);
        

    }
}
