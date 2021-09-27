package ut1.waringProblem;

import java.util.LinkedList;
import java.util.ArrayList;

// import 
/**
 * Ejercicio #2 – “War Story : “Mystery of the Pyramids”
En la sección 2.8 del libro “Algorithm Design Manual” de Steven Skiena se encuentra una 
interesante historia sobre el desarrollo de un algoritmo numérico eficiente. 
Se sugiere: 
a) Lee cuidadosamente la historia
b) Remarca todos los conceptos e ideas que te parezcan interesantes
c) Haz intervenciones en el foro de la UT1 con estas consultas / comentarios
d) ¿Puedes programar la solución propuesta en esta historia y probarla para una cantidad 
apreciable de elementos?
 *
 */
public class WaringProblem 
{

    public static int calculoDeWaringo(int m){
        int formulaAux = Math.round((((int) Math.pow(m, 3)) - m) / 6);
        return formulaAux;
    }

    public static ArrayList<Integer> devuelveListaPiramidales(int entrada){
        ArrayList<Integer> numerosPiramidales = new ArrayList<>();
        
        for(int i = 2; calculoDeWaringo(i) <= entrada; i++){
            numerosPiramidales.add(calculoDeWaringo(i));
        }

        return numerosPiramidales;
    }

    public static ArrayList<Integer> calculoIntentos(int numeroEntrada, ArrayList<Integer> numeros){
        ArrayList<Integer> numerosPiramidales = devuelveListaPiramidales(numeroEntrada);
        if(numeroEntrada == 0){
            return numeros;
        }else{
            int numeroMayor = numerosPiramidales.get(numerosPiramidales.size()-1);
            int nuevoCalculo = numeroEntrada - numeroMayor;
            numeros.add(numeroMayor);
            calculoIntentos(nuevoCalculo, numeros);
        }
        return numeros;
    }


    public static void main( String[] args )
    {
        ArrayList<Integer> test = new ArrayList<>();
        System.out.println(WaringProblem.calculoIntentos(250000, test).toString());

    }
}
