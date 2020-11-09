package Grafo;

public class Cola {

	public NodoCola inicio;
	public NodoCola fin;
	
	public Cola() {
		inicio = null;
		fin = null;
	}
	
	public void add(int indice,int peso) {
		NodoCola C = new NodoCola(indice, peso);
		if(isEmpty()) {
			inicio = C;
			fin = C;
		}else {
			fin.sig = C;
			fin = C;
		}
	}
	
	public NodoCola peek() {
		NodoCola C = this.inicio;
		if(inicio == fin) {
			inicio = null;
			fin = null;
		}else {
			this.inicio = this.inicio.sig;
		}
		C.sig= null;
		return C;
	}
	
	public boolean isEmpty() {
		return inicio==null;
	}
}
