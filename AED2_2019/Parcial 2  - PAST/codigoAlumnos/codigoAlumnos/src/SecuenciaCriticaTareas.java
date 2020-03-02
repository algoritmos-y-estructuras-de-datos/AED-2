
import java.util.Collection;

public class SecuenciaCriticaTareas {

    public static void main(String[] args) {
        TProceso proceso  = (TProceso) UtilGrafos.cargarGrafo(
                "tasks.txt",
                "temp/links.txt",
                false, TProceso.class);

        
        
        proceso.obtenerSecuenciaCritica();
        
        

    }
}
