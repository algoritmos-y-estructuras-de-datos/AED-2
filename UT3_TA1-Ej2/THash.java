import java.lang.Thread.UncaughtExceptionHandler;

public class THash {
    public String[] miLista;

    public THash(Integer tam) {
        miLista = new String[tam];
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
        // Lo encontro en la primer posición
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

    public int insertarLineal(String unaClave) {
        int indiceEsperado = funcionHash(unaClave);
        int intentos = 1;
        // int posiblesIndices = miLista.length - indiceEsperado;
        
        if(miLista[indiceEsperado] == null){
            miLista[indiceEsperado] = unaClave;
            return intentos;
        } 
        else {
            for(int i = 1; i < miLista.length; i++){
                int indiceCalculado = indiceEsperado + i;
                if(miLista[indiceCalculado] == null && indiceCalculado < miLista.length-1){
                    miLista[indiceCalculado] = unaClave;
                }else{
                    if(indiceCalculado > miLista.length){
                        if(miLista[indiceCalculado - miLista.length] == null){
                        miLista[indiceCalculado] = unaClave;
                        }
                    }
                }
            }
            return intentos;
        }
    }

    public int insertarLineal2(String unaClave) {
        int indiceEsperado = funcionHash(unaClave);
        int indiceAux = indiceEsperado;
        int intentos = 1;
        
        if(miLista[indiceEsperado] == null){
            miLista[indiceEsperado] = unaClave;
            return intentos;
        } 
        else {
            for(int i = indiceEsperado; i < miLista.length; i++){
                if(miLista[indiceEsperado] == null){
                    miLista[indiceEsperado] = unaClave;
                    break;
                }
                indiceEsperado++;
                if(i == miLista.length-1){
                    for(int j = 0; j <indiceAux; j++){
                        if(miLista[j] == null){
                            miLista[j] = unaClave;
                            break;
                        }
                    }
                }
            }
            return intentos;
        }
    }
}