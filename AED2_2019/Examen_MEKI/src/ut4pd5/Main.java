package ut4pd5;


import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/UT4PD5/aeropuertos_1.txt","src/UT4PD5/conexiones_1.txt",
                false, TGrafoDirigido.class);

        System.out.println("gd tiene ciclo? :"+gd.tieneCiclo());
        System.out.println("gd es conexo? :"+gd.esConexo());
       
        

       System.out.println("****************************CALCULOS ORDEN TOPOLOGICO****************************");
        System.out.println("");
        
                TGrafoDirigido gdInvertido = (TGrafoDirigido) UtilGrafos.cargarGrafoInvertido(
                "./src/UT4PD5/asignaturas.txt", 
                "./src/UT4PD5/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        TGrafoDirigido gdasignatura = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/UT4PD5/asignaturas.txt", 
                "./src/UT4PD5/previaturas.txt",
                false, 
                TGrafoDirigido.class);
        
        System.out.println("ORDEN TOPOLOGICO");
        
        System.out.println("Asignaturas");
        gdasignatura.imprimirTopologico(gdasignatura.ordenTopologico());
        System.out.println("Grafo invertido");
        gdInvertido.imprimirTopologico(gdInvertido.ordenTopologico());
        System.out.println(" ");


       
    }
}
