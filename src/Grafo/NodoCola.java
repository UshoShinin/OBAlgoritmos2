package Grafo;

public class NodoCola {
	public int peso;
	public int indice;
	public NodoCola sig;
	
	public NodoCola(int indice,int peso) {
		this.peso = peso;
		this.indice = indice;
		this.sig= null;
	}

}
