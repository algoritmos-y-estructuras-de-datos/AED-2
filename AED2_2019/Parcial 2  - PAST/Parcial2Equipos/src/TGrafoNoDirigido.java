
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {
protected TAristas lasAristas = new TAristas() ;
       /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
       super(vertices, aristas);     
      lasAristas.insertarAmbosSentidos(aristas);
       
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> listarContactos(String nombreActor, int maxSaltos) {
        TVertice origen = this.getVertices().get(nombreActor);
        Collection<TVertice> visitados = new ArrayList<>();
        if (origen != null)
        {
            origen.listarContactos(visitados, maxSaltos);
        }
        return visitados;
    }
    
    public Collection<TVertice>  listarContactos(String nombreActor, int maxSaltos, int minSaltos) {
        TVertice origen = this.getVertices().get(nombreActor);
        Collection<TVertice> visitados = new ArrayList<>();
        if (origen != null)
        {
            origen.listarContactos(visitados, maxSaltos, minSaltos);
        }
        return visitados;
    }
    
    
    public boolean conectados(Comparable et1,Comparable et2){
        TVertice v1 = getVertices().get(et1);
        TVertice v2 = getVertices().get(et2);
        if(v1 != null && v2 != null)
        {
            return v1.conectadoCon(et2);
        }
        return false;
    }
   public int numerozz(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice actor = getVertices().get(etiquetaOrigen);
        actor.setNumBacon(0);
        int zz = actor.numerozz(etiquetaDestino);
        for (TVertice v:getVertices().values()){
            v.setVisitado(false);
        }
        return zz;
    }

    
    
    
  


}
