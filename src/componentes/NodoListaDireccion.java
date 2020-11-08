package componentes;

import Grafo.Direccion;

public class NodoListaDireccion {

	Direccion dir;
	int cantVeces;
	NodoListaDireccion sig;
	
	public Direccion getDir() {
		return dir;
	}
	public void setDir(Direccion dir) {
		this.dir = dir;
	}
	public int getCantVeces() {
		return cantVeces;
	}
	public void setCantVeces(int cantVeces) {
		this.cantVeces = cantVeces;
	}
	public NodoListaDireccion getSig() {
		return sig;
	}
	public void setSig(NodoListaDireccion sig) {
		this.sig = sig;
	}
	
	public NodoListaDireccion(Direccion d) {
		this.dir = d;
		this.cantVeces = 1;
	}
}
