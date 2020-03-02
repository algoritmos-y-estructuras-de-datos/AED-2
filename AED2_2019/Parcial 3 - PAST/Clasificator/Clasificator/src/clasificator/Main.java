package clasificator;

import static clasificator.TClasificador.METODO_CLASIFICACION_BURBUJA;
import static clasificator.TClasificador.METODO_CLASIFICACION_INSERCION;
import static clasificator.TClasificador.METODO_CLASIFICACION_SHELL;
import static clasificator.TClasificador.METODO_CLASIFICACION_QUICKSORT;
import static clasificator.TClasificador.METODO_CLASIFICACION_SELECCION;
import static clasificator.TClasificador.METODO_CLASIFICACION_HEAP;

public class Main {
    public static void main(String[] args) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();

        //Creo los vectores de datos
        int[] vectorAscendente300 = gdg.generarDatosAscendentes(300);
        int[] vectorDescendente300 = gdg.generarDatosDescendentes(300);
        int[] vectorAleatorio300 = gdg.generarDatosAleatorios(300);
        int[] vectorAscendente10000 = gdg.generarDatosAscendentes(10000);
        int[] vectorDescendente10000 = gdg.generarDatosDescendentes(10000);
        int[] vectorAleatorio10000 = gdg.generarDatosAleatorios(10000);
        int[] vectorAscendente30000 = gdg.generarDatosAscendentes(30000);
        int[] vectorDescendente30000 = gdg.generarDatosDescendentes(30000);
        int[] vectorAleatorio30000 = gdg.generarDatosAleatorios(30000);
        
        int[] miVector = {99,4,12,65,2,53,25,6,1,671,4161, 171};
        // SI ESTÁ COMENTADO ES PORQUE FUNCIONA!!
        
        // HAY UN ATRIBUTO BOOLEANO AL FINAL DEL CLASIFICADOR, DICHO VALOR BOOLEANO ES EL
        // PRIMERO EN SER VERIFICADO, SI ES TRUE, EL CLASIFICADOR LLAMA AL MÉTODO DESCENDENTE EN LUGAR
        // DE LLAMAR AL ASCENDENTE.
        
        
        //clasif.clasificar(miVector, METODO_CLASIFICACION_QUICKSORT,false,true);
        //clasif.clasificar(miVector, METODO_CLASIFICACION_BURBUJA,false,true);
        //clasif.clasificar(miVector, METODO_CLASIFICACION_SELECCION,false,true);
        //clasif.clasificar(miVector, METODO_CLASIFICACION_SHELL,false,true);
        //clasif.clasificar(miVector, METODO_CLASIFICACION_HEAP,false,true);
        //clasif.clasificar(miVector, METODO_CLASIFICACION_INSERCION,false,true);
        
        
        for (int i: miVector){
            System.out.println(i);
        }
        System.out.println(gdg.ordenadoDescendente(miVector));
    }
    
}
