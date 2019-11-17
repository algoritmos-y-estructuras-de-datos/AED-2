package clasificador;

import static clasificador.TClasificador.METODO_CLASIFICACION_BURBUJA;
import static clasificador.TClasificador.METODO_CLASIFICACION_INSERCION;
import static clasificador.TClasificador.METODO_CLASIFICACION_SHELL;
import static clasificador.TClasificador.METODO_CLASIFICACION_QUICKSORT;
import static clasificador.TClasificador.METODO_CLASIFICACION_SELECCION;
import static clasificador.TClasificador.METODO_CLASIFICACION_HEAP;
import static clasificador.TClasificador.METODO_CLASIFICACION_DISTRIBUCION;
import static clasificador.TClasificador.METODO_CLASIFICACION_RADIX;
import static clasificador.TClasificador.METODO_CLASIFICACION_BINSORT;
import static clasificador.TClasificador.METODO_CLASIFICACION_BINSORT_REPETIDOS;

public class Clasificador {
    public static void main(String[] args) {
        TClasificador clasif = new TClasificador();
        
        //RECIBIENDO UN DATO DE NUMEROS
        String[] datosCrudos = ManejadorArchivosGenerico.leerArchivo("src/clasificador/claves.txt", false);
        int[] miVector = new int[datosCrudos.length];
        int i=0;
        for (String s : datosCrudos){
            miVector[i]= Integer.parseInt(s);
            i+=1;
        }
//        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
//        //Creo los vectores de datos
//        int[] vectorAscendente300 = gdg.generarDatosAscendentes(300);
//        int[] vectorDescendente300 = gdg.generarDatosDescendentes(300);
//        int[] vectorAleatorio300 = gdg.generarDatosAleatorios(300);
//        int[] vectorAscendente10000 = gdg.generarDatosAscendentes(10000);
//        int[] vectorDescendente10000 = gdg.generarDatosDescendentes(10000);
//        int[] vectorAleatorio10000 = gdg.generarDatosAleatorios(10000);
//        int[] vectorAscendente30000 = gdg.generarDatosAscendentes(30000);
//        int[] vectorDescendente30000 = gdg.generarDatosDescendentes(30000);
//        int[] vectorAleatorio30000 = gdg.generarDatosAleatorios(30000);
        
        //int[] miVector = {99,4,12,65,2,53,25,6,1,671,4161, 171};
        
        
        // HAY UN ATRIBUTO BOOLEANO AL FINAL DEL CLASIFICADOR, DICHO VALOR BOOLEANO ES EL
        // PRIMERO EN SER VERIFICADO, SI ES TRUE, EL CLASIFICADOR LLAMA AL MÉTODO DESCENDENTE EN LUGAR
        // DE LLAMAR AL ASCENDENTE.
        
        System.out.println("QUICKSORT");
        System.out.println("Ascendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_QUICKSORT);
        clasif.imprimirSort(miVector);
        String[] salidaAQ = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/QUICKSORT.txt", salidaAQ,false);   
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_QUICKSORT,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaDQ = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/QUICKSORT.txt", salidaDQ,true);
        System.out.println("\n");
        System.out.println("*********");
        //////////////////////////////////////////////////////////////////////////
        System.out.println("BUBBLE SORT");
        System.out.println("Ascendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_BURBUJA);
        clasif.imprimirSort(miVector);
        String[] salidaAB = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/BUBBLESORT.txt", salidaAB,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_BURBUJA,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaQB = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/BUBBLESORT.txt", salidaQB,true);
        System.out.println("\n");
        System.out.println("*********");
        /////////////////////////////////////////////////////////////////////////
        
        System.out.println("SELECTION SORT");
        System.out.println("Ascendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_SELECCION);
        clasif.imprimirSort(miVector);
        String[] salidaASE = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/SELECTIONSORT.txt", salidaASE,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_SELECCION,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaDSE = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/SELECTIONSORT.txt", salidaDSE,true);
        System.out.println("\n");
        System.out.println("*********");
        
        /////////////////////////////////////////////////////////////////////////
        
        System.out.println("SHELL SORT");
        System.out.println("Ascendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_SHELL);
        clasif.imprimirSort(miVector);
        String[] salidaASH = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/SHELLSORT.txt", salidaASH,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_SHELL,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaDSH = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/SHELLSORT.txt", salidaDSH,true);
        System.out.println("\n");
        System.out.println("*********");
        
        
/////////////////////////////////////////////////////////////////////////
        
        System.out.println("HEAP SORT");
        System.out.println("Ascendente");       
        clasif.clasificar(miVector, METODO_CLASIFICACION_HEAP);
        clasif.imprimirSort(miVector);
        String[] salidaAH = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/HEAPSORT.txt", salidaAH,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_HEAP,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaDH = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/HEAPSORT.txt", salidaDH,true);
        System.out.println("\n");
        System.out.println("*********");
        
        
        /////////////////////////////////////////////////////////////////////////
        
        System.out.println("INSERTION SORT");
        System.out.println("Ascendente"); 
        clasif.clasificar(miVector, METODO_CLASIFICACION_INSERCION);
        clasif.imprimirSort(miVector);
        String[] salidaAI = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/INSERTIONSORT.txt", salidaAI,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_INSERCION,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaDI = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/INSERTIONSORT.txt", salidaDI,true);
        System.out.println("\n");
        System.out.println("*********");
        
        /////////////////////////////////////////////////////////////////////////
        
        System.out.println("CUENTAS POR DISTRIBUCION");
        System.out.println("Ascendente");       
        clasif.clasificar(miVector, METODO_CLASIFICACION_DISTRIBUCION);
        clasif.imprimirSort(miVector);
        String[] salidaAD = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/CUENTASDISTRIBUCION.txt", salidaAD,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_DISTRIBUCION,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaDD = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/CUENTASDISTRIBUCION.txt", salidaDD,true);
        System.out.println("\n");
        System.out.println("*********");
        
        
        /////////////////////////////////////////////////////////////////////////
        System.out.println("RADIX SORT");
        System.out.println("Ascendente");       
        clasif.clasificar(miVector,METODO_CLASIFICACION_RADIX);
        clasif.imprimirSort(miVector);
        String[] salidaAR = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/RADIXSORT.txt", salidaAR,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_RADIX,false,true);
        clasif.imprimirSort(miVector);
        String[] salidaDR = clasif.arrayIntToString(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/RADIXSORT.txt", salidaDR,true);
        System.out.println("\n");
        System.out.println("*********");
        
        
        /////////////////////////////////////////////////////////////////////////
        System.out.println("BINSORT");
        System.out.println("Ascendente");       
        clasif.clasificar(miVector,METODO_CLASIFICACION_BINSORT);
        clasif.imprimirBinsort(miVector);
        String[] salidaABI = clasif.arrayIntToStringBinsort(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/BINSORT.txt", salidaABI,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_BINSORT,false,true);
        clasif.imprimirBinsort(miVector);
        String[] salidaDBI = clasif.arrayIntToStringBinsort(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/BINSORT.txt", salidaDBI,true);
        System.out.println("\n");
        System.out.println("*********");
        /////////////////////////////////////////////////////////////////////////
        System.out.println("BINSORT REPETIDOS");
        System.out.println("Ascendente");       
        clasif.clasificar(miVector,METODO_CLASIFICACION_BINSORT_REPETIDOS);
        clasif.imprimirBinsortRepetidos(miVector);
        String[] salidaABIR = clasif.arrayIntToStringBinsortRepetidos(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/BINSORTR.txt", salidaABIR,false);
        System.out.println("\n");
        System.out.println("Descendente");
        clasif.clasificar(miVector, METODO_CLASIFICACION_BINSORT_REPETIDOS,false,true);
        clasif.imprimirBinsortRepetidosDesc(miVector);
        String[] salidaDBIR = clasif.arrayIntToStringBinsortRepetidosDesc(miVector);
        ManejadorArchivosGenerico.escribirArchivo("src/clasificador/BINSORTR.txt", salidaDBIR,true);
        System.out.println("\n");
        System.out.println("*********");
        
        
    }
    
    
    
}
