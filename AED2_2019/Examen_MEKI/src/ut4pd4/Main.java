package ut4pd4;


import ut4pd3.*;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/UT4PD2/aeropuertos_1.txt","src/UT4PD2/conexiones_1.txt",
                false, TGrafoDirigido.class);

        System.out.println("****************************CALCULOS DE TODOS LOS CAMINOS****************************");
        System.out.println("Santos a San Pablo");
        System.out.println(" ");
        TCaminos caminos = gd.todosLosCaminos("Santos", "San_Pablo");
        caminos.imprimirCaminosConsola();
        System.out.println("------------");
        System.out.println("Montevideo a Rio de Janeiro");
        System.out.println(" ");
        caminos = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        caminos.imprimirCaminosConsola();
       
        

       
       
    }
}
