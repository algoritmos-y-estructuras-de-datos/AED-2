package parcialCompleto;


import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TTrieSufijosHashMap trie = new TTrieSufijosHashMap();


        //String eltexto = "bananasenlasmananascuandolasranasnocomenlasanaspanamalozanas";
        String texto1 = "bananapana";
        String texto = "abaaba";
        
       // TODO: insertar todos los sufijos en el trie, "anotando" la posición del texto (base 0) en que comienza cada sufijo
        
        for(int i=(texto1.length()-1);i>-1;i--){
            String sufijo = texto1.substring(i, texto1.length());
            trie.insertar(sufijo, i);
        }
        
        //ArrayList<Integer> l = trie.ocurrenciasPosicionesPatron("aba");
        //System.out.println(l);
        
       /* LinkedList<String> a = new LinkedList<>();
        a = trie.predecir("ana");
        System.out.println(a);*/
        
        
        /*
        for(int i = 0; i<texto.length();i++){
            String sufijo = texto.substring(i,texto.length());
            trie.insertar(sufijo, i);
        }*/
        
        //trie.imprimir();
        /*ArrayList<Integer> pos = new ArrayList<>();
        trie.ocurrenciasPosicionesPatron("ana", pos);
        System.out.println(pos);*/
        //int pal = trie.alturaTrie();
        //System.out.println(pal);
                
        
        
        //LinkedList<String> palabras = new LinkedList<>();
        //trie.longestSubString(palabras);
        //System.out.println(palabras);
        
        //System.out.println(trie.contarPal());
        //System.out.println(trie.alturaTrie());
        //System.out.println(trie.contarPal());
        //System.out.println(trie.contarPrefijos());
        
        //System.out.println(trie.predecir("ana"));
        //System.out.println(trie.predecir("na"));
        
        //TODO: hallar las posiciones del texto en que comienza cada ocurrencia del patrón "ana" 
        //algun arrayList = trie.posicionesPatron("ana");
        /*String patron="ana";
        ArrayList<Integer> posiciones=new ArrayList<>();
        trie.ocurrenciasPosicionesPatron(patron, posiciones);
        
        // TODO: IMPRIMIR EN CONSOLA LAS POSICIONES DEL TEXTO EN QUE SE ENCUENTRA EL PATRÓN "ana"
        System.out.println("Patrón ("+patron+")");
        System.out.println("Ocurrencias: "+posiciones.get(0));
        System.out.println("En posiciones: ");
        for(int i=1;i<posiciones.size();i++){
            System.out.println(posiciones.get(i));
        }*/
        
        
        
    }
    
}
