import java.util.Collection;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;
  
    public TNodoTrie buscarNodoTrie(String unaPalabra){
        if(raiz == null){
            return null;
        }
        return raiz.buscarNodoTrie(unaPalabra);
    }

    @Override
    public Collection<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> abonados = new LinkedList();
        if(raiz == null){
            return abonados;
        }
        raiz.buscarTelefonos(pais, abonados);
        System.out.println("aaa"+abonados.isEmpty());
        return abonados;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(unAbonado);
    }
    
}
