package taller3;

public class Seņalamiento extends Thread{
	private int id;
	private int suma = 100;
	private static Semaforo s;
	public Seņalamiento(int id, Semaforo s){
		this.id = id;
		Seņalamiento.s = s;
	}
	public void run() {
		if(id==0){
			ma();
		} else {
			mb();
		}
	}
	
	private void ma() {
		suma++;
		s.V();
	}
	
	private void mb(){
		s.P();
		suma--;
	}
	public static void main(String[] args) {
		Semaforo s2 = new Semaforo(0);
		for(int i = 0; i < 2; i++){
			new Seņalamiento(i, s2).start();
		}
	}
}
