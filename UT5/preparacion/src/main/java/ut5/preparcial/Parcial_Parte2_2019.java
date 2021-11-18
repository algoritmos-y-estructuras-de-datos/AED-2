package ut5.preparcial;

public class Parcial_Parte2_2019 {
    public static void main(String[] args) {
        TGrafoNoDirigido planoCasas = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("UT5/preparacion/src/main/java/ut5/preparcial/aeropuertosParcial2019.txt", "UT5/preparacion/src/main/java/ut5/preparcial/conexionesParcial2019.txt",
                false, TGrafoNoDirigido.class);


        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(planoCasas.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, planoCasas.getVertices(), " Costos Casas ");
        /*
        EJERCICIO 1:
        Una empresa constructora se encuentra desarrollando un barrio suburbano residencial, en el que las casas
        se encuentran dispersas en forma no estructurada sobre un área relativamente extensa. El subcontratista
        eléctrico ha presentado un plano de conexión eléctrica de las residencias con un costo que ha sido juzgado
        demasiado alto, ya que, a juicio del CEO de la empresa constructora, no optimiza la cantidad de cable
        necesaria.  

        Respuesta: Para optimizar el cableado decidimos obtener el plano mejor optimizado utilizando el algoritmo 
        de prim que nos brinda el AAM. Una vez teniendo esto, sumamos el costo de todas las conexiones (aristas)
        para obtener finalmente el costo total del cableado minimo.
        */

        System.out.println(planoCasas.centroDelGrafo());
        TGrafoNoDirigido planoOptimizado = planoCasas.Prim();
        
        Double[][] matrizPrim = UtilGrafos.obtenerMatrizCostos(planoOptimizado.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizPrim, planoOptimizado.getVertices(), " Costos Optimizados ");

        double costoTotal = 0;
        for(TArista airstaAux : planoOptimizado.getLasAristas()){
            costoTotal += airstaAux.getCosto();
        }

        System.out.println("Costo total del cableado : " + costoTotal);

    }
}
