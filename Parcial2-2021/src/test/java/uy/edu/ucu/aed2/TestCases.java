package uy.edu.ucu.aed2;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.*;

public class TestCases {

    TGrafoRedDatos redDatos;
    TGrafoRedDatos redNula;
    String servidor1;
    String servidor2;
    LinkedList<TVertice> ruta;

    @Before
    public void setUp(){
        redDatos = (TGrafoRedDatos) UtilGrafos.cargarGrafo(
        "./src/main/java/uy/edu/ucu/aed2/servidores.txt",
        "./src/main/java/uy/edu/ucu/aed2/enlaces.txt",
        false, TGrafoRedDatos.class);

        redNula = null;
    }    
    public TestCases() {}
    

    

    @Test
    public void tamanioRutaTest() {

        servidor1 = "BUF";
        servidor2 = "DFW";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2); 

        assertEquals("El tamanio de la lista obtenido no es correcto", 4, ruta.size());
    }

    @Test //Se espera una lista de servidores vacia
    public void servidor1NoExisteTest() {

        servidor1 = "FFF";
        servidor2 = "DFW";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2); 

        assertEquals("El tamanio de la lista obtenido no es correcto", 0, ruta.size());
    }

    @Test //Se espera una lista de servidores vacia
    public void servidor2NoExisteTest() {

        servidor1 = "BUF";
        servidor2 = "FFF";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2); 

        assertEquals("El tamanio de la lista obtenido no es correcto", 0, ruta.size());
    }

    @Test //Se espera una lista de servidores vacia
    public void servidor1NuloTest() {

        servidor1 = null;
        servidor2 = "FFF";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2); 

        assertEquals("El tamanio de la lista obtenido no es correcto", 0, ruta.size());
    }

    @Test (expected = NullPointerException.class) //Se espera un error de puntero nulo, ya que no se esta controlando por nulo en el servidor destino
    public void servidor2NuloTest() {

        servidor1 = "BUF";
        servidor2 = null;
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2);
    }

    @Test (expected = NullPointerException.class) //Se espera un error de puntero nulo, ya que no se esta inicializando el grafo
    public void redNulaTest() {

        servidor1 = "BUF";
        servidor2 = "DFW";
        ruta = redNula.rutaMenosSaltos(servidor1, servidor2); 
    }

    @Test //Se espera una lista de servidores vacia
    public void tamanioRutaTest2() {

        servidor1 = "BUF";
        servidor2 = "LAS";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2); 

        assertEquals("El tamanio de la lista obtenido no es correcto", 2, ruta.size());
    }
}
