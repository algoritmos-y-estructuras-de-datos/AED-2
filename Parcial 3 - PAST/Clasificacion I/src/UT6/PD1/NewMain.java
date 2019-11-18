/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT6.PD1;

/**
 *
 * @author usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String a = ;
        
        a=a.replaceAll("\n",",");
        a=a.replaceAll(" ", ",");
        a=a.replaceAll(",,", ",");
        a=a.replaceAll(",,,", ",");
        a=a.replaceAll(",,", ",");
        StringBuilder builder=new StringBuilder(a);
        String sCadenaInvertida=builder.reverse().toString();
        System.out.println(sCadenaInvertida);
    }
    
}
