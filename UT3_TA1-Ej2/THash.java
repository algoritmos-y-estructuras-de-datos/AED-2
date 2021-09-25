import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.lang.model.util.ElementScanner6;

public class THash {
    public String[] miLista;
    public LinkedList<String>[] miListaSeparada;
    public String[] miListaCuadrada;

    public THash(int tam) {
        miLista = new String[(int) Math.round(tam + (tam * 0.1))];
        miListaSeparada = new LinkedList[tam];
        miListaCuadrada = new String[GFG.closetPrime(tam)];
    }

    public int funcionHash(String unaClave) {
        int sumaAux = 0;
        String[] cadenaSeparada = unaClave.split("");
        for (String linea : cadenaSeparada) {
            sumaAux += Integer.parseInt(linea);
        }
        return sumaAux;
    }

    public int buscar(String unaClave) {
        int indiceEsperado = funcionHash(unaClave);
        int intento = 1;
        if (miLista[indiceEsperado] == unaClave) {
            return intento;
        } else {
            for (int i = (indiceEsperado + 1); i < miLista.length; i++) {
                if (miLista[i] == unaClave) {
                    intento++;
                    return intento;
                }
            }
        }
        return -1;
    }

    public ArrayList<String> buscarCuadratico(String unaClave){
        int indiceEsperado = funcionHash(unaClave);
        ArrayList<String> devolucion = new ArrayList<>();
        String[] miListaCuadradaAux = miListaCuadrada;

        if(miListaCuadradaAux[indiceEsperado] != null) {
            if(miListaCuadradaAux[indiceEsperado].equals(unaClave)){
                devolucion.add(unaClave);
                miListaCuadradaAux[indiceEsperado] = null;
            }
            for(int i = 1; i < miListaCuadradaAux.length; i++){
                int indiceAux = indiceEsperado + (int) Math.round(Math.pow(i, 2));
                if(indiceAux < miListaCuadradaAux.length - 1){
                    if(miListaCuadradaAux[indiceAux] != null && miListaCuadradaAux[indiceAux].equals(unaClave)){
                        devolucion.add(unaClave);
                        miListaCuadradaAux[indiceAux] = null;
                    }
                }else{
                    indiceAux = (indiceEsperado + (int) Math.round(Math.pow(i, 2))) % miListaCuadrada.length;
                    if(miListaCuadradaAux[indiceAux] != null && miListaCuadradaAux[indiceAux].equals(unaClave)){
                        devolucion.add(unaClave);
                        miListaCuadradaAux[indiceAux] = null;
                    }
                }
            }
        }
        return devolucion;

    }


    public LinkedList<String> buscarSeparado(String unaClave){
        int indiceEsperado =  funcionHash(unaClave);
        LinkedList<String> listaAux = new LinkedList<>();

        if(miListaCuadrada[indiceEsperado] != null){
            for(String elemento : miListaSeparada[indiceEsperado]){
                if(elemento.equals(unaClave)){
                    listaAux.add(elemento);
                }
            }
        }
        return listaAux;
    }

    public int insertarLineal(String unaClave) {
        int indiceEsperado = funcionHash(unaClave);
        int indiceAux = indiceEsperado;
        int intentos = 1;

        if (miLista[indiceEsperado] == null) {
            miLista[indiceEsperado] = unaClave;
            return intentos;
        } else {
            for (int i = indiceEsperado; i < miLista.length; i++) {
                if (miLista[indiceEsperado] == null) {
                    miLista[indiceEsperado] = unaClave;
                    break;
                }
                indiceEsperado++;
                if (i == miLista.length - 1) {
                    for (int j = 0; j < indiceAux; j++) {
                        if (miLista[j] == null) {
                            miLista[j] = unaClave;
                            break;
                        }
                    }
                }
            }
            return intentos;
        }
    }

    public void insertarSeparado(String unaClave) {
        int indiceEsperado = funcionHash(unaClave);
        if (miListaSeparada[indiceEsperado] == null) {
            miListaSeparada[indiceEsperado] = new LinkedList<>();
            miListaSeparada[indiceEsperado].add(unaClave);
        } else {
            miListaSeparada[indiceEsperado].add(unaClave);
        }

    }

    public void insertarCuadratico(String unaClave) {
        int indiceEsperado = funcionHash(unaClave);
        int indiceAux = indiceEsperado;

        if (miListaCuadrada[indiceEsperado] == null) {
            miListaCuadrada[indiceEsperado] = unaClave;
        } else {
            for (int i = 1; i < miListaCuadrada.length; i++) {
                int indiceSec = indiceAux + (int) Math.round(Math.pow(i, 2));
                if (indiceSec < miListaCuadrada.length - 1) {
                    if (miListaCuadrada[indiceSec] == null) {
                        miListaCuadrada[indiceSec] = unaClave;
                        break;
                    }
                } else {
                    indiceSec = (indiceAux + (int) Math.round(Math.pow(i, 2))) % miListaCuadrada.length;
                    if (miListaCuadrada[indiceSec] == null) {
                        miListaCuadrada[indiceSec] = unaClave;
                        break;
                    }
                }
            }
        }
    }

    // i1 = 1^2 = 1
    // i2 = 2^2 = 4
    // i3 = 3^2 = 9
    // i4 = 4^2 = 16
    // i5 = 5^2 = 25
    // i6 = 6^2 = 36
    // i7 = 7^2 = 49
    // i8 = 8^2 = 64
    // i9 = 9^2

    public void insertarCuadratico2(String unaClave) {
        int indiceEsperado = funcionHash(unaClave);
        int indiceAux = indiceEsperado;
        if (miLista[indiceEsperado] == null) {
            miLista[indiceEsperado] = unaClave;
        
        } else {
            for (int i = indiceEsperado; i < miLista.length; i++) {
                if (miLista[indiceEsperado] == null) {
                    miLista[indiceEsperado] = unaClave;
                    break;
                } else {
                    int nuevoIndice = (int) Math.pow(indiceEsperado, 2);
                    if (miLista[nuevoIndice] == null) {
                    miLista[nuevoIndice] = unaClave;
                    break;
                }
                indiceEsperado++;
                if (i == miLista.length - 1) {
                    for (int j = 0; j < indiceAux; j++) {
                        if (miLista[j] == null) {
                            miLista[j] = unaClave;
                            break;
                        } else {
                    int nuevoIndice2 = (int) Math.pow(j, 2);
                    if (miLista[nuevoIndice2] == null) {
                    miLista[nuevoIndice2] = unaClave;
                    break;
                }
                    }
                }
            }

            }
    }
}
}
}

