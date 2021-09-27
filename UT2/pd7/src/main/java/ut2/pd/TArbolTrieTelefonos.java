package ut2.pd;
import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> listaAux = new LinkedList<>();
        raiz.buscarTelefonos((pais + area), listaAux);
        return listaAux;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if(raiz == null){
            raiz = new TNodoTrieTelefonos();
        }
        raiz.insertar(unAbonado);
    }

 
    
}
