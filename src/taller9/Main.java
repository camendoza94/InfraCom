package taller9;

public class Main {
	public static void main(String[] args) {
		Asim�trico e = new Asim�trico();
		byte[] cifrada = e.cifrar();
		e.descifrar(cifrada);
	}
}
