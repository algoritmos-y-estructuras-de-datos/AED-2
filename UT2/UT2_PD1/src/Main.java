
public class Main {
    public static void main(String[] args) {
        ArbolGenerico arbol = new ArbolGenerico();
        
        arbol.insertar("RECTORIA", "");
        arbol.insertar("VICERRECTORIA ADMINISTRATIVA", "RECTORIA");
        arbol.insertar("VICERRECTORIA ACADEMICA", "RECTORIA");
        arbol.insertar("VICERRECTORIA DEL MEDIO UNIVERSITARIO", "RECTORIA");
        arbol.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE INGENIERIA Y TECNOLOGIAS", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORIA ACADEMICA");
        arbol.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORIA ACADEMICA");
        arbol.insertar("DEPARTAMENTO DE MATEMTICAS","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        arbol.insertar("DEPARTAMENTO DE INFORMATICA Y CIENCIAS DE LA COMPUTACIÓN","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        arbol.insertar("NUEVA RECTORIA","");
        System.out.println(arbol.insertar("NUEVA RECTORIA3","pepe"));
        arbol.listarIndentado();
    }
    
}
