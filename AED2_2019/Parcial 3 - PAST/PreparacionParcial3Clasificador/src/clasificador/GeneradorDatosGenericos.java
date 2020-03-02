package clasificador;

import java.util.Random;

public class GeneradorDatosGenericos {
    private static int TAMANIO_MAX = 32000;

    public int[] generarDatosAleatorios() {
        Random rnd = new Random();
        int[] datosAleatorios = new int[TAMANIO_MAX];
        boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
        for (int i = 0; i < datosAleatorios.length; i++) {
            int j = rnd.nextInt(TAMANIO_MAX);
            while(datosUtilizados[j]){
                    j = (j + 1) % TAMANIO_MAX;
            }
            datosAleatorios[j] = i;
            datosUtilizados[j] = true;
        }
        return datosAleatorios;
    }

    public int[] generarDatosAleatorios(int largo) {
        Random rnd = new Random();
        int[] datosAleatorios = new int[largo];
        boolean[] datosUtilizados = new boolean[largo];
        for (int i = 0; i < datosAleatorios.length; i++) {
            int j = rnd.nextInt(largo);
            while(datosUtilizados[j]){
                    j = (j + 1) % largo;
            }
            datosAleatorios[j] = i;
            datosUtilizados[j] = true;
        }
        return datosAleatorios;
    }

    public int[] generarDatosAscendentes() {
        int [] datosAscendentes = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
                datosAscendentes[i] = i;
        }
        return datosAscendentes;
    }
    
    public int[] generarDatosAscendentes(int largo) {
        int [] datosAscendentes = new int[largo];
        for (int i = 0; i < largo; i++) {
                datosAscendentes[i] = i;
        }
        return datosAscendentes;
    }

    public int[] generarDatosDescendentes() {
        int [] datosDescendentes = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
                datosDescendentes[i] = TAMANIO_MAX - i;
        }
        return datosDescendentes;
    }
    
    public int[] generarDatosDescendentes(int largo) {
        int [] datosDescendentes = new int[largo];
        for (int i = 0; i < largo; i++) {
                datosDescendentes[i] = largo - i;
        }
        return datosDescendentes;
    }
    
    public String ordenadoAscendente(int[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i] > datos[i+1]){
                return  "NO. Conjunto desordenado entre los valores "+datos[i] +" y "+ datos[i+1];
            }
        }
        return "SI. Conjunto ordenado ascendentemente";
    }
    
    public boolean ordenadoAscendente2(int[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i] > datos[i+1]){
                return  false;
            }
        }
        return true;
    }
    
    public String ordenadoDescendente(int[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i] < datos[i+1]){
                return  "NO. Conjunto desordenado entre los valores "+datos[i] +" y "+ datos[i+1];
            }
        }
        return "SI. Conjunto ordenado descendentemente";
    }
    
    public boolean ordenadoDescendente2(int[] datos){
        for(int i = 0; i< datos.length - 1 ; i++){
            if(datos[i] < datos[i+1]){
                return  false;
            }
        }
        return true;
    }
}
