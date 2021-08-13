/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bruno Cattáneo <c@ttaneo.uy>
 */
public class IndizarLibro {
    
    public static String filtrarPalabra(String unaPalabra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unaPalabra.length(); i++) {
                char caracter = unaPalabra.charAt(i);
                if ((caracter >= 'A' && caracter <= 'Z') ||
                                (caracter >= 'a' && caracter <= 'z'))
                        sb.append(caracter);
        }
        return sb.toString().toLowerCase();
    }
    
}
