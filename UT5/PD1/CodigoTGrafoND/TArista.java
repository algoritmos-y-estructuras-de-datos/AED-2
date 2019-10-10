public class TArista  {
	Comparable etOrigen;
	Comparable etDestino;
	int costo;

	public TArista(Comparable etOrigen, Comparable etDestino, int costo) {
		
		this.etOrigen = etOrigen;
		this.etDestino = etDestino;
	}

	protected Comparable etDestino;
	protected Comparable costo;

	public Comparable getEtDestino() {
		return etDestino;
	}

	public void setEtDestino(Comparable etDestino) {
		this.etDestino = etDestino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

}
