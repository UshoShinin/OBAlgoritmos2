package Grafo;

public class Arco {
	boolean existe;
	int kilomentros;
	int tiempo;
	
	public Arco() {
		existe = false;
		kilomentros = 0;
		tiempo = 0;
	}

	public Arco(int kilomentros, int tiempo) {
		this.existe = true;
		this.kilomentros = kilomentros;
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "K." + kilomentros + ", T" + tiempo ;
	}
	
	
}
