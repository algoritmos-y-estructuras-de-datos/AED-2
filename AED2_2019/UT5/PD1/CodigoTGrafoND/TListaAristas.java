
public class TListaAristas extends LinkedList<TArista> {

	public TArista buscar(Comparable etOrigen, Comparable etDestino) {
		TArista tempArista;
		tempArista = (TArista) obtenerPrimero();
		while (tempArista != null) {
			if ((tempArista.getEtiqueta().compareTo(etOrigen) == 0)
					&& (tempArista.getEtDestino().compareTo(etDestino) == 0)) {
				return tempArista;
			}
			tempArista = (TArista) tempArista.getSiguiente();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public TArista buscarMin(LinkedList<Comparable> VerticesU, LinkedList<Comparable> VerticesV) {
		TArista tempArista = null;
		TArista tAMin = null;
		Integer costoMin = Integer.MAX_VALUE;
	
	
		//---------COMPLETAR ALGORITMO--------
		// para todo u en Vertices U
			// para todo v en Vertices V
				// tA =buscar (u, v)
				// si tA <> null y tA.costo < costoMin entonces
					// tAMin = tA y costoMin = tA.costo
			// fin para todo v
		// fin para todo u
		// devolver tAMin
	}

	

	}

}
