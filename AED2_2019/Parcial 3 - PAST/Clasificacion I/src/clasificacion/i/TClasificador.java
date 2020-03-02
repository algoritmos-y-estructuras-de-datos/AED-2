package clasificacion.i;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
        public static final int METODO_CLASIFICACION_QUICK = 4;
        public static final int METODO_CLASIFICACION_HEAP = 5;
        public static final int METODO_CLASIFICACION_SELECCIONDIRECTA = 6;
        public static final int METODO_BINSORT = 7;
        public static final int METODO_RADIX = 8;
        
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
                case METODO_CLASIFICACION_QUICK:
			return ordenarPorQuickSort(datosParaClasificar);
                case METODO_CLASIFICACION_HEAP:
                        return ordenarPorHeapSort(datosParaClasificar);
                case METODO_CLASIFICACION_SELECCIONDIRECTA:
                        return ordenarPorSeleccionDirecta(datosParaClasificar);
                case METODO_BINSORT:
                        return binsort(datosParaClasificar,100);
                case METODO_RADIX:
                        return ordenarPorRadix(datosParaClasificar);
		default:
			System.err.println("Este codigo no deberia haberse ejecutado");
			break;
		}
		return datosParaClasificar;
	}
        
        public String metodo(int metodoClasificacion) {
		switch (metodoClasificacion) {
		case METODO_CLASIFICACION_INSERCION:
			return "Inserción Directa";
		case METODO_CLASIFICACION_SHELL:
			return "ShellSort";
		case METODO_CLASIFICACION_BURBUJA:
			return "Burbuja";
                case METODO_CLASIFICACION_QUICK:
			return "QuickSort";
                case METODO_CLASIFICACION_HEAP:
                        return "HeapSort";
                case METODO_CLASIFICACION_SELECCIONDIRECTA:
                        return "Selección Directa";
                case METODO_BINSORT:
                        return "Selección Biinsort";
                case METODO_RADIX:
                        return "Selección Radix";
		default:
			System.err.println("Este codigo no deberia haberse ejecutado");
			break;
		}
		return "";
	}
        
	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}

	protected int[] ordenarPorShell(int[] datosParaClasificar) {
		int j;
		int[] incrementos = new int[] { 7805,1805,7705,9505,1505,9305,3205,1205,1105,9005,3005,9994,3994,7894,3794,9694,7694,7594,1594,3494,7394,3394,1394,9194,9094,3094,9884,7784,1784,1684,1384,7184,3184,1084,9974,3974,9874,7874,3874,9574,1574,3374,9274,3274,1274,3074,1964,9764,3764,3664,7564,1564,9464,3464,9364,7364,1264,3064,7954,1954,3854,7654,1654,9454,7454,3254,9154,7154,3154,7054,3944,3844,1844,3644,7544,1544,7444,1444,3244,1244,9044,7934,1934,3734,3634,7534,9434,9334,7334,7234,7924,9824,3824,3724,1724,1624,9524,3524,3424,1424,1324,9224,9124,7124,1124,1024,7714,9514,7514,3514,9314,3314,9214,7214,1114,9904,3904,1904,9704,3704,7504,1504,9404,7204,1204,9104,3104,7004,3004,1004,9893,7693,7493,3493,1393,9293,3293,9193,7193,1193,7093,9883,1883,7783,3683,3583,1583,7483,3383,3283,1283,3083,7973,3973,9773,9673,7673,1673,9373,3373,7273,9173,9073,1073,7963,1963,7763,3763,1763,9563,3463,7363,1363,3263,7163,3163,7063,3953,3853,1853,1753,9553,7553,7453,1453,9353,3353,9253,7253,7153,1153,9943,1943,9643,7643,3643,1643,7543,9443,3343,3143,7043,1933,9833,3733,1733,1633,9533,7433,3433,1333,9233,3233,9133,3133,7033,1033,9923,1723,9523,7523,3523,1523,9223,1223,7123,9023,3023,1913,7813,1813,9613,7613,3613,7313,1213,9113,9013,9803,3803,9703,7603,1603,9403,1403,7303,3203,9103,1103,1003,9992,1792,9692,3692,7592,3592,9392,7292,7192,9092,3092,7982,7882,9782,1682,7582,1582,3482,7382,3382,9182,3082,1082,7972,1972,9872,7772,7672,3572,9472,1472,1372,9272,9172,3172,1172,7072,9962,3962,9862,7862,3862,7762,1762,3662,9562,7562,7462,3362,1262,7162,9062,3952,1952,9752,7552,1552,9452,3452,9352,1352,1252,3052,7742,3742,7642,9542,7442,1442,7342,3242,7142,1142,9932,3932,9832,3832,1832,7732,1732,7532,1532,7432,1432,9332,3332,1132,9032,7922,3922,7822,1822,3722,9622,7622,1522,3422,9322,7322,1222,3122,7022,3022,9712,1612,3512,3412,1412,7312,1312,9212,3112,1112,9902,9802,7802,3802,1802,9602,3602,3502,9302,9202,7202,7102,1102,3002,9991,7991,3991,7891,9791,3791,1591,9491,3391,1391,3191,7091,1091,9881,9781,7781,3781,1781,7681,1681,7481,1381,3281,1181,1081,9871,7871,3871,7771,9571,3571,7471,1471,3371,3271,1271,9071,9961,7961,3961,9661,7661,3661,7561,7361,7261,1261,9161,3161,9061,7061,1061,7951,3851,9751,1751,7651,9551,3551,9451,3451,1351,3251,1151,9941,3941,9841,7841,3841,1841,1741,9541,3541,1541,7441,9341,3341,9241,7241,3241,9041,9931,1831,3731,7631,1631,7231,1231,9131,7031,3031,1031,7921,1921,9821,3821,9721,7721,9521,9421,7321,1321,9221,3221,7121,3121,1021,3911,7811,1811,1711,3611,3511,1511,9211,3211,7111,9011,3011,7901,3901,1901,7801,9601,3601,1601,1501,9401,9301,3301,1301,1201,9101,3101,9001,799,199,389,779,179,769,359,749,149,739,929,919,119,709,788,388,188,778,368,958,758,358,938,928,728,328,128,118,908,797,787,377,967,167,757,157,347,937,337,727,917,907,107,196,386,776,376,166,956,356,746,346,146,136,916,716,316,706,106,995,395,785,775,175,965,365,755,745,145,325,125,905,305,994,194,784,974,764,364,164,754,944,344,934,334,134,124,914,904,104,793,983,383,973,373,763,953,353,943,743,733,133,713,313,113,703,392,382,182,772,172,962,362,752,152,142,932,332,922,722,322,112,991,791,391,191,181,971,371,761,361,751,151,941,931,731,131,721,311,901,701,301,101,79,98,38,97,37,17,76,16,95,35,74,34,14,73,13,92,32,91,71,31,11,7,5,3,2,1 };

		for (int inc : incrementos) {
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i++) {
                                        int aux = datosParaClasificar[i];
					j = i;
					while (j >= inc && aux < datosParaClasificar[j - inc]) {
                                            //intercambiar(datosParaClasificar, j, j + inc);
                                            datosParaClasificar[j] = datosParaClasificar[j - inc];
                                            j -= inc;
					}
                                    datosParaClasificar[j] = aux;
				}
			}
		}
		return datosParaClasificar;
	}
        
    private static int DMS(int x, int m) {
        if (x == 0) {
            return 0;
        }
        x = Math.abs(x) / m;
        return (int) Math.floor(x / Math.pow(10, Math.floor(Math.log10(x))));
    }

    protected int[] binsort(int[] entrada, int m) {
        List<Integer>[] urnas = new List[m];
        for (int i = 0; i < urnas.length; i++) {
            urnas[i] = new ArrayList<>();

        }
        for (int i = 0; i < entrada.length; i++) {
            urnas[DMS(entrada[i], m)].add(entrada[i]);
        }

        for (int i = 0; i < m; i++) {

            Integer[] a = urnas[i].toArray(new Integer[urnas[i].size()]);
            int[] b = new int[a.length];
            for (int x = 0; x < a.length; x++) {
                b[x] = a[x];
            }
            b = ordenarPorInsercion(b);

            urnas[i].clear();
            for (int x = 0; x < b.length; x++) {
                urnas[i].add(b[x]);
            }
        }
        int contSalida = 0;
        for (int i = 0; i < m; i++) {
            for (Integer num : urnas[i]) {
                entrada[contSalida] = num;
                contSalida++;
            }
        }
        return entrada;
    }

    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
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

    protected int[] ordenarPorBurbuja(int[] datosParaClasificar) {

        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorSeleccionDirecta(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length; i++) {
            int indiceDelMenor = i;
            int claveMenor = datosParaClasificar[i];
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] < claveMenor) {
                    indiceDelMenor = j;
                    claveMenor = datosParaClasificar[j];
                }
            }
            intercambiar(datosParaClasificar, i, indiceDelMenor);
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
            int[] cont = new int[1];
                cont[0]=0;
		quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1,cont);
                System.out.println("Cantidad de llamadas recursivas: " + cont[0]);
		return datosParaClasificar;
	}
	
        protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
		for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
			armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
		}
		for (int i = datosParaClasificar.length - 1; i > 0; i--) {
			intercambiar(datosParaClasificar,0,i);
			armaHeap(datosParaClasificar, 0, i-1);
		}
		return datosParaClasificar;
	}

	private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
                if (primero < ultimo) {
                        int r = primero;
			while(r <= ultimo / 2){
				if (ultimo == 2*r){ //r tiene un hijo solo
						if (datosParaClasificar[r] < datosParaClasificar[r*2]){
							intercambiar(datosParaClasificar, r, 2 * r);
                                                }
                                                r = ultimo;
				} else { //r tiene 2 hijos
					int posicionIntercambio = 0;
					if (datosParaClasificar[2*r] < datosParaClasificar[2*r + 1]){
						posicionIntercambio = 2 * r +1;
					} else {
						posicionIntercambio = 2 * r;
					}
					if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]){
						intercambiar(datosParaClasificar,r,posicionIntercambio);
						r = posicionIntercambio;
					} else {
						r = ultimo;
					}
				}
			}			
                }
	}
        
        public int[] ordenarPorRadix(int datosParaClasificar[]){
            int largoVector = datosParaClasificar.length;
            int valorMenosSignificativo = datosParaClasificar[0];
            int exp = 1;
            
            
            int[] urnaResultado = new int[datosParaClasificar.length];

            for (int i = 1; i < largoVector; i++)
                if (datosParaClasificar[i] > valorMenosSignificativo)
                    valorMenosSignificativo = datosParaClasificar[i];
            
            while (valorMenosSignificativo / exp > 0){              
                
                int[] urna = new int[10];

                for (int i = 0; i < largoVector; i++){
                    urna[(datosParaClasificar[i] / exp) % 10]++;
                }
                for (int i = 1; i < 10; i++){
                    urna[i] += urna[i - 1];
                }
                for (int i = largoVector - 1; i >= 0; i--){
                    urnaResultado[--urna[(datosParaClasificar[i] / exp) % 10]] = datosParaClasificar[i];
                }
                for (int i =0; i< largoVector; i++){
                    datosParaClasificar[i] = urnaResultado[i];  
                }
                exp *= 10;        
            }
            return datosParaClasificar;
        }
        
        protected int encuentraPivote(int izquierda, int derecha, int[] entrada)
        {
            return entrada[(izquierda+derecha)/2];
        }
        
        protected int encuentraPivote1(int izquierda, int derecha, int[] entrada)
        {
            int medio = entrada[(izquierda+derecha) / 2];
            return entrada[(entrada[izquierda]+entrada[derecha]+medio)/3];
        }
        
	private void quicksort(int[] entrada, int i, int j, int[] cont) {
		cont[0]++;
                int izquierda = i;
		int derecha = j;

		int posicionPivote = encuentraPivote1(i,j,entrada);
                
		if (posicionPivote >= 0){
			int pivote = posicionPivote;  
			while (izquierda <= derecha) {
				while ((entrada[izquierda] < pivote) && (izquierda < j)) {
					 izquierda++; 
				}

				while ((pivote < entrada[derecha]) && (derecha > i)) {
					derecha--; 
				}

				if (izquierda <= derecha) {
					intercambiar(entrada, izquierda, derecha); 
					izquierda++;
					derecha--;
				}
			}

			if (i < derecha)
				quicksort(entrada, i, derecha,cont); 
			if (izquierda < j)
				quicksort(entrada, izquierda, j,cont); 
		}
        }
        
         protected int[] ordenarPorCuentasPorDistribucion(int[] datosParaClasificar){
                    int[] salida = null;
        if (datosParaClasificar != null) {
            //obtener maximo y minimo
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i : datosParaClasificar) {
                if (i > max) {
                    max = i;
                }
                if (i < min) {
                    min = i;
                }
            }

            int[] cuenta = new int[max - min + 1];
            for (int i : datosParaClasificar) {
                cuenta[i - min]++;
            }
            for (int i = 1; i < cuenta.length; i++) {
                cuenta[i] += cuenta[i - 1];
            }
            salida = new int[datosParaClasificar.length];
            for (int i = datosParaClasificar.length - 1; i >= 0; i--) {
                cuenta[datosParaClasificar[i] - min]--;
                salida[cuenta[datosParaClasificar[i] - min]] = datosParaClasificar[i];
            }
        }
        return salida;
    
    }
        
        private static void testearAlgos(int[] vector, int metodoClasif){
            TClasificador clasif = new TClasificador();
            System.out.println("Método:"+ clasif.metodo(metodoClasif));
            int[] resAleatorio = clasif.clasificar(vector,metodoClasif);
            
            for (int i = 0; i < resAleatorio.length; i++) {
                    System.out.print(resAleatorio[i] + " ");
            }
            System.out.println("");
            	
        }
        
        private static void tiempoAproximado (int[] vec, int metodo){
            System.out.println("Cantidad de elementos: "+vec.length);
            TClasificador clasif = new TClasificador();
            long t1 = System.nanoTime();
                double total = 0.0;
                int cantLlamadas = 0;
                
                while (total < 1000000000.0) {
                    cantLlamadas++;
                    int[] copia = vec.clone();
                    
                    copia = clasif.clasificar(copia, metodo);
                    long t2 = System.nanoTime();
                    total = t2 - t1;
                }
                
                double medioBase = total/cantLlamadas;
                
                t1 = System.nanoTime();
                total = 0.0;
                cantLlamadas = 0;
                
                while (total < 1000000000.0) {
                    cantLlamadas++;
                    int [] copia = new int[0];
                    
                    copia = clasif.clasificar(copia, metodo);
                    long t2 = System.nanoTime();
                    total = t2 - t1;
                }
                
                double medioCascara = total/cantLlamadas;
                
                System.out.println("Base: " + (long)medioBase+ " ns");
                System.out.println("Cascara: " + (long)medioCascara+ " ns");
                System.out.println("Tiempo medio de ejecucion: " + (long)(medioBase - medioCascara) + " ns");
        }
        
        protected static boolean ordenado(int[] vec)
        {
            for(int i=0; i < vec.length-1;i++)
            {if (vec[i]>vec[i+1]){
                return false;
                }
            }
            return true;
        }

	public static void main(String args[]) {
		
		GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
		int[] vectorAleatorio = gdg.generarDatosAleatorios(100);
                int[] vectorAleatorio1 = gdg.generarDatosAleatorios(3000);
                int[] vectorAleatorio2 = gdg.generarDatosAleatorios(30000);
		int[] vectorAscendente = gdg.generarDatosAscendentes(300);
                int[] vectorAscendente1 = gdg.generarDatosAscendentes(3000);
                int[] vectorAscendente2 = gdg.generarDatosAscendentes(30000);
		int[] vectorDescendente = gdg.generarDatosDescendentes(300);
                int[] vectorDescendente1 = gdg.generarDatosDescendentes(3000);
                int[] vectorDescendente2= gdg.generarDatosDescendentes(30000);
                
                int[] v1 = vectorAleatorio.clone();
                int[] v2 = vectorAleatorio.clone();
                int[] v3 = vectorAleatorio.clone();
                int[] v4 = vectorAleatorio.clone();
                int[] v5 = vectorAleatorio.clone(); 
                int[] v6 = vectorAleatorio.clone();
                int[] v7 = vectorAleatorio.clone();
                int[] v8 = gdg.generarDatosAleatorios(10000);
                testearAlgos(v1,1);
                testearAlgos(v2,2);
                testearAlgos(v3,3);
                testearAlgos(v4,4);
                testearAlgos(v5,5);
                testearAlgos(v6,6);
                testearAlgos(v7,7);
                testearAlgos(v8,8);
                System.out.println("Ordenados?");
                System.out.println(ordenado(v1));
                System.out.println(ordenado(v2));
                System.out.println(ordenado(v3));
                System.out.println(ordenado(v4));
                System.out.println(ordenado(v5));
                System.out.println(ordenado(v6));
                System.out.println(ordenado(v7));
                System.out.println(ordenado(v8));
                /*
                System.out.println("========ALEATORIO BURBUJA======");
                tiempoAproximado(vectorAleatorio.clone(), METODO_CLASIFICACION_BURBUJA);
                tiempoAproximado(vectorAleatorio1.clone(), METODO_CLASIFICACION_BURBUJA);
                tiempoAproximado(vectorAleatorio2.clone(), METODO_CLASIFICACION_BURBUJA);
                
                System.out.println("========ASCENDENTE BURBUJA======");        
                tiempoAproximado(vectorAscendente.clone(), METODO_CLASIFICACION_BURBUJA);
                tiempoAproximado(vectorAscendente1.clone(), METODO_CLASIFICACION_BURBUJA);
                tiempoAproximado(vectorAscendente2.clone(), METODO_CLASIFICACION_BURBUJA);

                System.out.println("========DESCENDIENTE BURBUJA======");
                tiempoAproximado(vectorDescendente.clone(), METODO_CLASIFICACION_BURBUJA);
                tiempoAproximado(vectorDescendente1.clone(), METODO_CLASIFICACION_BURBUJA);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_BURBUJA);
                /*
                System.out.println("");
                
                System.out.println("========ALEATORIO QUICK======");
                tiempoAproximado(vectorAleatorio.clone(), METODO_CLASIFICACION_QUICK);
                tiempoAproximado(vectorAleatorio1.clone(), METODO_CLASIFICACION_QUICK);
                tiempoAproximado(vectorAleatorio2.clone(), METODO_CLASIFICACION_QUICK);
                
                System.out.println("========ASCENDENTE QUICK======");        
                tiempoAproximado(vectorAscendente.clone(), METODO_CLASIFICACION_QUICK);
                tiempoAproximado(vectorAscendente1.clone(), METODO_CLASIFICACION_QUICK);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_QUICK);

                System.out.println("========DESCENDIENTE QUICK======");
                tiempoAproximado(vectorDescendente.clone(), METODO_CLASIFICACION_QUICK);
                tiempoAproximado(vectorDescendente1.clone(), METODO_CLASIFICACION_QUICK);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_QUICK);
                
                System.out.println("");
                
                System.out.println("========ALEATORIO SELECCION======");
                tiempoAproximado(vectorAleatorio.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                tiempoAproximado(vectorAleatorio1.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                tiempoAproximado(vectorAleatorio2.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                
                System.out.println("========ASCENDENTE SELECCION======");        
                tiempoAproximado(vectorAscendente.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                tiempoAproximado(vectorAscendente1.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);

                System.out.println("========DESCENDIENTE SELECCION======");
                tiempoAproximado(vectorDescendente.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                tiempoAproximado(vectorDescendente1.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_SELECCIONDIRECTA);
                
                System.out.println("");
                
                System.out.println("========ALEATORIO HEAP======");
                tiempoAproximado(vectorAleatorio.clone(), METODO_CLASIFICACION_HEAP);
                tiempoAproximado(vectorAleatorio1.clone(), METODO_CLASIFICACION_HEAP);
                tiempoAproximado(vectorAleatorio2.clone(), METODO_CLASIFICACION_HEAP);
                
                System.out.println("========ASCENDENTE HEAP======");        
                tiempoAproximado(vectorAscendente.clone(), METODO_CLASIFICACION_HEAP);
                tiempoAproximado(vectorAscendente1.clone(), METODO_CLASIFICACION_HEAP);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_HEAP);

                System.out.println("========DESCENDIENTE HEAP======");
                tiempoAproximado(vectorDescendente.clone(), METODO_CLASIFICACION_HEAP);
                tiempoAproximado(vectorDescendente1.clone(), METODO_CLASIFICACION_HEAP);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_HEAP);
                
                System.out.println("");
                
                System.out.println("========ALEATORIO SHELL======");
                tiempoAproximado(vectorAleatorio.clone(), METODO_CLASIFICACION_SHELL);
                tiempoAproximado(vectorAleatorio1.clone(), METODO_CLASIFICACION_SHELL);
                tiempoAproximado(vectorAleatorio2.clone(), METODO_CLASIFICACION_SHELL);
                
                System.out.println("========ASCENDENTE SHELL======");        
                tiempoAproximado(vectorAscendente.clone(), METODO_CLASIFICACION_SHELL);
                tiempoAproximado(vectorAscendente1.clone(), METODO_CLASIFICACION_SHELL);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_SHELL);

                System.out.println("========DESCENDIENTE SHELL======");
                tiempoAproximado(vectorDescendente.clone(), METODO_CLASIFICACION_SHELL);
                tiempoAproximado(vectorDescendente1.clone(), METODO_CLASIFICACION_SHELL);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_SHELL);
                
                System.out.println("");
                
                System.out.println("========ALEATORIO INSERCION======");
                tiempoAproximado(vectorAleatorio.clone(), METODO_CLASIFICACION_INSERCION);
                tiempoAproximado(vectorAleatorio1.clone(), METODO_CLASIFICACION_INSERCION);
                tiempoAproximado(vectorAleatorio2.clone(), METODO_CLASIFICACION_INSERCION);
                
                System.out.println("========ASCENDENTE INSERCION======");        
                tiempoAproximado(vectorAscendente.clone(), METODO_CLASIFICACION_INSERCION);
                tiempoAproximado(vectorAscendente1.clone(), METODO_CLASIFICACION_INSERCION);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_INSERCION);

                System.out.println("========DESCENDIENTE INSERCION======");
                tiempoAproximado(vectorDescendente.clone(), METODO_CLASIFICACION_INSERCION);
                tiempoAproximado(vectorDescendente1.clone(), METODO_CLASIFICACION_INSERCION);
                tiempoAproximado(vectorDescendente2.clone(), METODO_CLASIFICACION_INSERCION);
                */
                /*System.out.println("========ALEATORIO======");
                testearAlgos(vectorAleatorio.clone(), METODO_CLASIFICACION_BURBUJA);
                testearAlgos(vectorAleatorio.clone(), METODO_CLASIFICACION_INSERCION);
                testearAlgos(vectorAleatorio.clone(), METODO_CLASIFICACION_SHELL);
                System.out.println("========ASCENDENTE======");        
                testearAlgos(vectorAscendente.clone(), METODO_CLASIFICACION_BURBUJA);
                testearAlgos(vectorAscendente.clone(), METODO_CLASIFICACION_INSERCION);
                testearAlgos(vectorAscendente.clone(), METODO_CLASIFICACION_SHELL);
                System.out.println("========DESCENDIENTE======");
                testearAlgos(vectorDescendente.clone(), METODO_CLASIFICACION_BURBUJA);
                testearAlgos(vectorDescendente.clone(), METODO_CLASIFICACION_INSERCION);
                testearAlgos(vectorDescendente.clone(), METODO_CLASIFICACION_SHELL);
                int[] prueba = gdg.generarDatosAleatorios(300);
                System.out.println("========QUICK ALEATORIO======");
                testearAlgos(prueba.clone(),METODO_CLASIFICACION_QUICK);
                /*System.out.println("==========INSERCION ALEATORIO==========");
                System.out.println("300 elementos: ");
                tiempoAproximado(vectorAleatorio, 1);
                System.out.println("10000 elementos: ");
                tiempoAproximado(vectorAleatorio1, 1);
                System.out.println("30000 elementos: ");
                tiempoAproximado(vectorAleatorio2, 1);
                System.out.println("==========BURBUJA ALEATORIO==========");
                System.out.println("300 elementos: ");
                tiempoAproximado(vectorAleatorio, 3);
                System.out.println("10000 elementos: ");
                tiempoAproximado(vectorAleatorio1, 3);
                System.out.println("30000 elementos: ");
                tiempoAproximado(vectorAleatorio2, 3);
                System.out.println("==========INSERCION AS==========");
                System.out.println("300 elementos: ");
                tiempoAproximado(vectorAscendente, 1);
                System.out.println("10000 elementos: ");
                tiempoAproximado(vectorAscendente1, 1);
                System.out.println("30000 elementos: ");
                tiempoAproximado(vectorAscendente2, 1);
                System.out.println("==========BURBUJA DES==========");
                System.out.println("300 elementos: ");
                tiempoAproximado(vectorDescendente, 3);
                System.out.println("10000 elementos: ");
                tiempoAproximado(vectorDescendente1, 3);
                System.out.println("30000 elementos: ");
                tiempoAproximado(vectorDescendente2, 3);
                System.out.println("==========BURBUJA AS==========");
                System.out.println("300 elementos: ");
                tiempoAproximado(vectorAscendente, 3);
                System.out.println("10000 elementos: ");
                tiempoAproximado(vectorAscendente1, 3);
                System.out.println("30000 elementos: ");
                tiempoAproximado(vectorAscendente2, 3);
                System.out.println("==========INSERCION DES==========");
                System.out.println("300 elementos: ");
                tiempoAproximado(vectorDescendente, 1);
                System.out.println("10000 elementos: ");
                tiempoAproximado(vectorDescendente1, 1);
                System.out.println("30000 elementos: ");
                tiempoAproximado(vectorDescendente2, 1);
                */
	}
}
