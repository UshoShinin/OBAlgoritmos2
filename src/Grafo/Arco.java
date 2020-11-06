package Grafo;

public class Arco {
	boolean existe;
	int metros;
	int tiempo;
	
	public Arco() {
		existe = false;
		metros = 0;
		tiempo = 0;
	}

	public Arco(int metros, int tiempo) {
		this.existe = true;
		this.metros = metros;
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "K." + metros + ", T" + tiempo ;
	}
	
	//Con este metodo actualizo el tramo para que exista y tenga sus metros y minutos
	public void existir(int metros, int minutos) {
		this.existe = true;
		this.metros = metros;
		this.tiempo = minutos;
	}
	
}
