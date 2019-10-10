
public class TGrafoNoDirigido extends TGrafoDirigido {
	private TListaAristas Aristas;

	public TGrafoNoDirigido() {
		super();
		Aristas = new TListaAristas();

		// TODO Auto-generated constructor stub
	}

	public void cargarArista(Comparable etiquetaOrigen,
			Comparable etiquetaDestino, Comparable costo) {
		Aristas.add(new TArista(etiquetaOrigen, etiquetaDestino,
				costo));
		
		insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo);
	}


	// este procedimiento de PRIM usa la lista de aristas explícita para
	// resolver. Por claridad y seguridad, se arman listas de vértices para
	// trabajar,
	// "VerticesU" y "VerticesV", de forma de hacerlo lo más parecido posible al
	// seudocódigo abstracto.
	// al final devuelve un nuevo grafo no dirigido que es el árbol abarcador de
	// costo mínimo obtenido.

	public TGrafoNoDirigido Prim() {
		// devuelve un nuevo grafo, que es el Arbol Abarcador de Costo Mínimo
		int costoPrim = 0;
		LinkedList<Comparable> VerticesU = new LinkedList<>();
		LinkedList<Comparable> VerticesV = new LinkedList<>();
		TListaAristas AristasAAM = new TListaAristas();
		TArista tempArista;
		
		if (vertices.esVacia())
			return null;

		
		// armar la lista VerticesV de trabajo - vertices.keySet???
		while (!(tempV == null)) {
			VerticesV.....//---------COMPLETAR ALGORITMO--------
		}
		// pasar el primero de V a U
		// sacar de VerticesV y agregarlo a VerticesU
		
		
		//boolean vaciaV = VerticesV.esVacia();
		while (!vaciaV) {
			// elegir una arista de costo minimo que vaya de U a V, agregarla a
			// la lista de aristas del AAM, quitar el vértice v de V y agregarlo
			// a U
			//---------COMPLETAR ALGORITMO--------
			// invocando al método correspondiente de TListaAristas Aristas
		}
		
		System.out.println("costo AAM: " + costoPrim);


		//A partir de los vertices del grafo (Vertices.Values????)  las aristas en AristasAAM armar el grafo nuevoGrafo y retornarlo
		//---------COMPLETAR ALGORITMO--------
		// crear nuevoGrafo 
		return nuevoGrafo;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean insertarAdyacencia(Comparable etiquetaOrigen,
			Comparable etiquetaDestino, Comparable costo) {
		return (super
				.insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo) && super
				.insertarAdyacencia(etiquetaDestino, etiquetaOrigen, costo));
	}

}