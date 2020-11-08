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
		return listadoDir(inicio);
	}
	
	private String listadoDir(NodoListaDireccion nd) {
		String ret = "";
		if(nd == null) {
			return ret;
		}
		System.out.println(ret);
		ret += listadoDir(nd.getSig());
		return nd.dir.getCodX() + ";" + nd.dir.getCodY() + "|";
	}
	
	private void insertarPrincipio(Direccion d) {
		NodoListaDireccion aux = new NodoListaDireccion(d);
		aux.setSig(inicio);
		inicio = aux;
	}
	
	public void insertar(Direccion d) {
		NodoListaDireccion aux = inicio;
		if(aux == null) {
			inicio = new NodoListaDireccion(d);
		}else {
			while(aux.getSig() != null) {
				if(aux.getDir().equals(d)) {
					aux.cantVeces++;
					ordernar(aux);
					break;
				}
				aux.getSig();
			}
			if(aux.getDir().equals(d)) {
				aux.cantVeces++;
				ordernar(aux);
			}else {
				insertarPrincipio(d);
			}
		}
	}
	
	private void ordernar(NodoListaDireccion nd) {
		NodoListaDireccion yo = nd;
		NodoListaDireccion aux = nd;
		while(aux.getSig() != null && aux.cantVeces > aux.getSig().cantVeces) {
			aux = aux.getSig();
		}
		yo.setSig(aux.getSig());
		aux.setSig(yo);
	}
	
}
