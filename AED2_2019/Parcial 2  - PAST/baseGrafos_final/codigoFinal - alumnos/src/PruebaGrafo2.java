
import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class PruebaGrafo2 {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt", "./src/conexiones_1.txt",
                false, TGrafoDirigido.class);
        
        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        if(recorrido_Asuncion != null){
            for(TVertice v: recorrido_Asuncion){
               System.out.println(v.getEtiqueta());
            }
        }else{
            System.out.println("Esta vacio el recorrido");
        }
        
        System.out.println("\n\nCaminos de Santos a Curitibia:");
        
        TCaminos caminos = gd.todosLosCaminos("Santos", "Curitiba");
        caminos.imprimirCaminosConsola();
        System.out.println(gd.centroDelGrafo());
        
        
        
        for(LinkedList<TVertice> lista:gd.componentesFuertes()){
            System.out.print("(");
            for(TVertice vert : lista){
                System.out.print(vert.getEtiqueta()+",");
            }
            System.out.print(")"+"\n");
        }
        gd.imprimirTopologico(gd.ordenTopologico());
    }
}
