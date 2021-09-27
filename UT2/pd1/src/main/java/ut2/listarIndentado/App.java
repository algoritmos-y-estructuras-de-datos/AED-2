package ut2.listarIndentado;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
        arbol.insertar("Nueva raiiii","");
        arbol.listarIndentado();
    }
}
