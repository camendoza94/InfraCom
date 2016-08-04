public class Hilo extends Thread {
	private static int[][] M; // La matriz que se desea sumar
	private static int total = 0; // El total de la suma

	private int id;
	private int suma;
	public boolean termin�;
	
	public Hilo(int fila){
		this.id = fila;
		suma = 0;
		termin� = false;
	}

	private static void crearMatriz(int n) {
		M = new int[n][n];
		int m = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				M[i][j] = m;
				m++;
			}
		}
	}
	
	public void run(){
		int nElementos = M[id].length;
		for (int j = 0; j < nElementos; j++){
			suma+=M[id][j];
		}
		total += suma;
		termin� = true;
		//System.out.println(termin�);
	}

//	public static void main(String[] args) {
//		int nThreads = 10; // N�mero de threads; un valor cualquiera.
//		Hilo[] t = new Hilo[10]; // Vector para los threads
//		crearMatriz(nThreads); // Inicializar la matriz		
//		// A continuaci�n, escribir c�digo para crear los threads
//		for (int i = 0; i < nThreads; i++){
//			Hilo h = new Hilo(i);
//			t[i]= h;
//			h.start();
//		}
//		// A continuaci�n, escribir c�digo para esperar que los threads terminen
//		boolean termin�Todos = false;
//		while(!termin�Todos){
//			termin�Todos= true;
//			for (Hilo hilo : t) {
//				if(!hilo.termin�){
//					termin�Todos = false;
//				}
//			}
//		}
//		// y recoger los resultados parciales
//		for (Hilo hilo : t) {
//			Hilo.total+=hilo.suma;
//		}
//		System.out.println(total);
//	}

	public static void main(String[] args) {
		int nThreads = 10; // N�mero de threads; un valor cualquiera.
		Hilo[] t = new Hilo[10]; // Vector para los threads
		crearMatriz(nThreads); // Inicializar la matriz		
		// A continuaci�n, escribir c�digo para crear los threads
		for (int i = 0; i < nThreads; i++){
			Hilo h = new Hilo(i);
			t[i]= h;
			h.start();
		}
		// A continuaci�n, escribir c�digo para esperar que los threads terminen
		boolean termin�Todos = false;
		while(!termin�Todos){
			termin�Todos= true;
			for (Hilo hilo : t) {
				if(!hilo.termin�){
					termin�Todos = false;
				}
			}
		}
		System.out.println(total);
	}
}
