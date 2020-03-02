
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creo String[] para agregar las lineas leidas por la entrada
        String[] linea = new String[5];
        // Leo de la entrada
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String text2 = scan.nextLine();
        String text3 = scan.nextLine();
        String text4 = scan.nextLine();
        String text5 = scan.nextLine();
        // Los agrego al array
        linea[0] = text;
        linea[1] = text2;
        linea[2] = text3;
        linea[3] = text4;
        linea[4] = text5;
        // Imprimo el array
        System.out.println("Imprimiendo array de la forma ingresada");
        for (int i = 0;i<5;i++){
            System.out.println(linea[i]);
        }
        // Ordeno e imprimo el array
        Ordenacion(linea);
    }

    public static void Ordenacion(String[] linea) {
        System.out.println("Shortest to longest: ");
        Arrays.sort(linea, (s1, s2) -> s1.length() - s2.length());
        Arrays.asList(linea).forEach(System.out::println);
    }
}
