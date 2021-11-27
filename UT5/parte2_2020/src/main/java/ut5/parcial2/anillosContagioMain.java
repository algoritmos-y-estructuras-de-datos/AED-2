package ut5.parcial2;

import java.util.Collection;

public class anillosContagioMain {
    public static void main(String[] args) {
        TGrafoNoDirigido grafitoNoDirigidito = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("UT5/parte2_2021/src/main/java/ut4/parcial/personas.txt", "UT5/parte2_2021/src/main/java/ut4/parcial/amistades.txt",
                false, TGrafoNoDirigido.class);

        
        //Indicar todos los contactos alcanzables con no más de una cantidad determinada de enlaces (por 
        //ejemplo, no más de 6 enlaces, o sea, no más de 5 intermediarios).
        Collection<TVertice> conexiones = grafitoNoDirigidito.listarContactos("Fabian", 1);

        for(TVertice c : conexiones){
            System.out.println(c.getEtiqueta());
        }

    }

   
    
}
