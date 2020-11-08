package componentes;

import Grafo.Direccion;

public class ListaDireccion {

	NodoListaDireccion inicio;

	public NodoListaDireccion getInicio() {
		return inicio;
	}

	public void setInicio(NodoListaDireccion inicio) {
		this.inicio = inicio;
	}
	
	public ListaDireccion() {
		
	}

	public String listadoDir() {
		String ret = "";
		NodoListaDireccion aux = inicio;
		while(aux != null) {
		ret += aux.dir.getCodX() + ";" + aux.dir.getCodY() + "|";
		aux = aux.getSig();
		}
		return ret;
	}
	
	public void insertar(Direccion d) {
		NodoListaDireccion aux = inicio;
		if(aux == null) {
			inicio = new NodoListaDireccion(d);
		}
		while(aux.getSig() != null) {
			if(aux.getDir().equals(d)) {
				aux.cantVeces++;
				break;
			}
			aux.getSig();
		}
		if(aux.getDir().equals(d)) {
			aux.cantVeces++;
		}
		aux.setSig(new NodoListaDireccion(d));
		ordernarListado();
	}
	
	private void ordernarListado() {
		NodoListaDireccion aux = inicio;
		
	}
	
}
