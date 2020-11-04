package componentes;

public class NodoUsuario {

	//Atributos del NodoUsuario
	private Usuario usu;
	private NodoUsuario izq;
	private NodoUsuario drc;
	
	
	public Usuario getUsu() {
		return usu;
	}
	public void setUsu(Usuario usu) {
		this.usu = usu;
	}
	public NodoUsuario getIzq() {
		return izq;
	}
	public void setIzq(NodoUsuario izq) {
		this.izq = izq;
	}
	public NodoUsuario getDrc() {
		return drc;
	}
	public void setDrc(NodoUsuario drc) {
		this.drc = drc;
	}
	
	public NodoUsuario(Usuario u) {
		this.usu = u;
	}
	
}
