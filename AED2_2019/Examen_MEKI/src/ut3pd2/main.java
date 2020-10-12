/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd2;
import java.text.DecimalFormat;

/**
 *
 * @author Meki
 */
public class main {
    public static void main(String[] args){
        main main = new main();
        String[] aInsertar = ManejadorArchivosGenerico.leerArchivo("src/ut3pd2/claves_insertar.txt");
        String[] aBuscar = ManejadorArchivosGenerico.leerArchivo("src/ut3pd2/claves_buscar.txt");
        int contadorCantidadBusquedasExito = 0 ;
        int contadorCantidadBusquedasSinExito = 0;
        int elementosInsertados = 0;
        
        THash tabla1 = new THash(new Double(aInsertar.length/0.70).intValue());
        THash tabla2 = new THash(new Double(aInsertar.length/0.75).intValue());
        THash tabla3 = new THash(new Double(aInsertar.length/0.80).intValue());
        THash tabla4 = new THash(new Double(aInsertar.length/0.85).intValue());
        THash tabla5 = new THash(new Double(aInsertar.length/0.90).intValue());
        THash tabla6 = new THash(new Double(aInsertar.length/0.91).intValue());
        THash tabla7 = new THash(new Double(aInsertar.length/0.92).intValue());
        THash tabla8 = new THash(new Double(aInsertar.length/0.93).intValue());
        THash tabla9 = new THash(new Double(aInsertar.length/0.94).intValue());
        THash tabla10 = new THash(new Double(aInsertar.length/0.95).intValue());
        THash tabla11 = new THash(new Double(aInsertar.length/0.96).intValue());
        THash tabla12 = new THash(new Double(aInsertar.length/0.97).intValue());
        THash tabla13 = new THash(new Double(aInsertar.length/0.98).intValue());
        THash tabla14 = new THash(new Double(aInsertar.length/0.99).intValue());
        THash[] tablas = {tabla1,tabla2,tabla3,tabla4,tabla5,tabla6,tabla7,tabla8,tabla9,
                                tabla10,tabla11,tabla12,tabla13,tabla14};
        
        String[] archivo = new String[14];
        int contador = 0;
            for(THash tabla : tablas){
                elementosInsertados = 0;
                contadorCantidadBusquedasSinExito = 0;
                contadorCantidadBusquedasExito = 0;
                for(String clave: aInsertar){
                    if(tabla.insertarAux(Integer.valueOf(clave))){
                        elementosInsertados++;
                    }
                }
                for(String claveAbuscar : aBuscar){
                    if(tabla.buscarAux(Integer.valueOf(claveAbuscar))){
                        contadorCantidadBusquedasExito++;
                    }
                    else{
                        contadorCantidadBusquedasSinExito++;
                    }
                } 
                DecimalFormat decimal = new DecimalFormat("0.00");
                Double factorCarga = new Double(aInsertar.length) / new Double((tabla.getTamanio()));
                String Fcarga = decimal.format(factorCarga);
                main.imprimirBusquedas(archivo,contador,contadorCantidadBusquedasExito,contadorCantidadBusquedasSinExito,Fcarga,tabla);
                main.imprimirInserciones(archivo,contador,elementosInsertados,tabla);
                contador++;
            }  
            ManejadorArchivosGenerico.escribirArchivo("src/ut3pd2/comparaciones.csv", archivo);
        
       
        
        
    }
    
     public void imprimirBusquedas(String[] archivo,int contador,int cantidadBusquedasExito,int cantidadBusquedasSinExito,String factorCarga,THash tabla){
        String fCarga = "Factor carga: " + factorCarga;
        String cantidadComparacionesExitoBusqueda = "Cantidad comparaciones promedio busquedas con exito: " + 
                                        tabla.cantidadPromedioBusquedaExito[0]/cantidadBusquedasExito;
        String cantidadComparacionesSinExitoBusqueda = "Cantidad comparaciones promedio busquedas sin exito: " + 
                                        tabla.cantidadPromedioBusquedaSinExito[0]/cantidadBusquedasSinExito;
        System.out.println(fCarga);
        System.out.println(cantidadComparacionesExitoBusqueda);
        System.out.println(cantidadComparacionesSinExitoBusqueda);
        archivo[contador] = factorCarga + ";"+ tabla.cantidadPromedioBusquedaExito[0]/cantidadBusquedasExito
                + ";" + tabla.cantidadPromedioBusquedaSinExito[0]/cantidadBusquedasSinExito;
    }
    public void imprimirInserciones(String[] archivo,int contador,int cantidadInsercionesExitosas,THash tabla){
        String cantidadComparacionesInserciones = "Cantidad comparaciones promedio en inserciones realizadas: "  + tabla.cantidadPromedioInserccionesExito[0]/cantidadInsercionesExitosas;
        archivo[contador] += ";" + tabla.cantidadPromedioInserccionesExito[0]/cantidadInsercionesExitosas;
        System.out.println(cantidadComparacionesInserciones);
    }
    
    
}
