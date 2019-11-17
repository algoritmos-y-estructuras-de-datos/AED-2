package clasificador;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBinSort {
    
    public static int[] crearDatosAleatorios(){
        //int aleatorio = (int) (Math.random()*20)+1;
        int[] vectorPrueba = new int[20];
        for (int i=0; i<vectorPrueba.length; i++)
            vectorPrueba[i] = (int)(Math.random()*20)+1;
        return vectorPrueba;
    }
    
    @Test
    public void testOrdenarPorBinSortBasico() {
        System.out.println("ordenarPorBinSortBasico");
       // int[] entrada = crearDatosAleatorios();
        int[] entrada = {10,7,1,5,3,2,0,8};
        TClasificador instance = new TClasificador();
        String expResult = "SI. Conjunto ordenado ascendentemente";
        int [] vectorRes=instance.ordenarPorBinsort(entrada);
        String result = instance.ordenadoAscendenteBinSort(vectorRes);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBinSortNulo() {
        System.out.println("ordenarPorBinSortNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorBinsort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBinSortRepetidos() {
        System.out.println("ordenarPorBinSortRepetidos");
        int[] entrada = {1,0,1,0,1,0,1,0,1,0,1};
        TClasificador instance = new TClasificador();
        boolean expResult = true;
        int[] vectorResultado = instance.ordenarPorBinsort(entrada);
        boolean result=instance.ordenadoAscendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBinSortDescBasico() {
        System.out.println("ordenarPorBinSortDescBasico");
        int[] entrada = crearDatosAleatorios();
        TClasificador instance = new TClasificador();
        String expResult = "SI. Conjunto ordenado descendentemente.";
        int[] vectorResultado = instance.ordenarPorBinsortDesc(entrada);
        String result=instance.ordenadoDescendenteBinSort(vectorResultado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrdenarPorBinSortDescNulo() {
        System.out.println("ordenarPorBinSortDescNulo");
        int[] entrada = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        int[] vectorResultado = instance.ordenarPorBinsortDesc(entrada);
        boolean result=instance.ordenadoDescendenteBoolean(vectorResultado);
        assertEquals(expResult, result);
    }
}
