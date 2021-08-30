
public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
	public static final int METODO_CLASIFICACION_QUICKSORT = 4;
	public static final int METODO_CLASIFICACION_CUENTA = 5;
	public static final int METODO_CLASIFICACION_BUCKET = 6;
	public static final int METODO_CLASIFICACION_RADIX = 7;
	public static final int METODO_CLASIFICACION_HEAP = 8;
	public static final int METODO_CLASIFICACION_SELECCION = 9;

	/**
	 * Punto de entrada al clasificador
	 * 
	 * @param metodoClasificacion
	 * @param orden
	 * @param tamanioVector
	 * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
	 */
	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
		switch (metodoClasificacion) {
			case METODO_CLASIFICACION_INSERCION:
				return ordenarPorInsercion(datosParaClasificar);
			case METODO_CLASIFICACION_SHELL:
				return ordenarPorShell(datosParaClasificar);
			case METODO_CLASIFICACION_BURBUJA:
				return ordenarPorBurbuja(datosParaClasificar);
			case METODO_CLASIFICACION_QUICKSORT:
				return null;
			case METODO_CLASIFICACION_SELECCION:
				return ordenarPorSeleccion(datosParaClasificar);
			case METODO_CLASIFICACION_CUENTA:
				return ordenarPorCuenta(datosParaClasificar);
			case METODO_CLASIFICACION_BUCKET:
				return ordenarPorBucket(datosParaClasificar);
			case METODO_CLASIFICACION_RADIX:
				return ordenarPorRadix(datosParaClasificar);
			case METODO_CLASIFICACION_HEAP:
				return ordenarPorHeap(datosParaClasificar);
			default:
				System.err.println("Este codigo no deberia haberse ejecutado");
				break;
		}
		return datosParaClasificar;
	}

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	private int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

		for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i++) {
					j = i - inc;
					while ((j >= 0) && (datosParaClasificar[j] > datosParaClasificar[j + inc])) {
						intercambiar(datosParaClasificar, j, j + inc);
						j = j - inc;
					}
				}
			}
		}
		return datosParaClasificar;
	}

	protected int[] ordenarPorSeleccion(int[] datosParaClasificar) {
		for (int i = 0; i < datosParaClasificar.length - 1; i++) {
			int indiceMenor = i;
			int claveMenor = datosParaClasificar[i];
			for (int j = i + 1; j < datosParaClasificar.length; j++) {
				if (datosParaClasificar[j] < claveMenor) {
					indiceMenor = j;
					claveMenor = datosParaClasificar[j];
				}
			}
			intercambiar(datosParaClasificar, i, indiceMenor);
		}
		return datosParaClasificar;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	public int[] ordenarPorBucket(int[] datosParaClasificar) {
		return null;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	public int[] ordenarPorRadix(int[] datosParaClasificar) {
		return null;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	public int[] ordenarPorHeap(int[] datosParaClasificar) {
		return null;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	public int[] ordenarPorCuenta(int[] datosParaClasificar) {
		int[] salida = new int[datosParaClasificar.length];
		int[] count = {0,0,0,0,0,0,0,0,0,0};
		for (int i = 0; i < datosParaClasificar.length; i++) {
			count[datosParaClasificar[i]]++;
		}
		for (int j = 1; j < count.length; j++) {
			count[j] += count[j - 1];
		}
		for (int p = 0; p < datosParaClasificar.length; p++) {
			salida[count[datosParaClasificar[p]] - 1] = datosParaClasificar[p];
			count[datosParaClasificar[p]]--;
		}
		for (int h = 0; h < datosParaClasificar.length; h++) {
			datosParaClasificar[h] = salida[h];
		}
		return salida;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
		if (datosParaClasificar != null) {
			for (int i = 2; i < datosParaClasificar.length; i++) {
				int j = i - 1;
				while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
					intercambiar(datosParaClasificar, j, j + 1);
					j--;
				}
			}
			return datosParaClasificar;
		}
		return null;
	}

	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		for (int i = 0; i < datosParaClasificar.length; i++) {
			for (int j = 1; j < datosParaClasificar.length; j++) {
				if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
					intercambiar(datosParaClasificar, j, j - 1);
				}
			}
		}
		return datosParaClasificar;
	}

	public boolean estaOrdenado(int[] datosParaVerificar) {
		for (int i = 0; i < datosParaVerificar.length - 1; i++) {
			if (datosParaVerificar[i] > datosParaVerificar[i + 1]) {
				System.out.println(String.format("%d (índice %d) >= %d (índice %d)", datosParaVerificar[i], i,
						datosParaVerificar[i + 1], (i + 1)));
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		TClasificador clasif = new TClasificador();
		GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
		int[] vectorAleatorio = gdg.generarDatosAleatorios(5);
		int[] vectorAscendente = gdg.generarDatosAscendentes(5);
		int[] vectorDescendente = gdg.generarDatosDescendentes(5);

		int[] resAleatorio = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resAleatorio.length; i++) {
			System.out.print(resAleatorio[i] + " ");
		}
		int[] resAscendente = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resAscendente.length; i++) {
			System.out.print(resAscendente[i] + " ");
		}
		int[] resDescendente = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resDescendente.length; i++) {
			System.out.print(resDescendente[i] + " ");
		}
	}
}
