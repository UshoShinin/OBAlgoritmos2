package componentes;

public class ABBUsuario {

	//Atributos ABBUsuario
	private NodoUsuario raiz;

	public ABBUsuario() {
		raiz=null;
	}
	
	public NodoUsuario getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoUsuario raiz) {
		this.raiz = raiz;
	}
	
	
	//Metodos para insertar, buscar y esas cosas
	public void insertar(Usuario u) {
		if (this.raiz == null) {
			this.raiz = new NodoUsuario(u);
		}else{
			if(buscarUsuario(u.getEmail())==null) {
				insertar(u, this.raiz);
			}else {
				//REtorno d error
			}
			
		}
	}
	
	private void insertar(Usuario u, NodoUsuario nu) {
		if(u.compareTo(nu.getUsu()) > 0) {
			if(nu.getDrc() == null) {
				nu.setDrc(new NodoUsuario(u));
			}else {
				insertar(u, nu.getDrc());
			}
		} else {
			if(nu.getIzq() == null) {
				nu.setIzq(new NodoUsuario(u));
			}else {
				insertar(u, nu.getIzq());
			}
		}
	}
	
	
	public Usuario buscarUsuario(String email) {
		if(this.raiz == null) {
			return null;
		}
		//Creo un usuario auxiliar para facilitar las comparaciones
		Usuario aux = new Usuario(email);
		return buscarUsuario(aux, this.raiz);
	}
	
	private Usuario buscarUsuario(Usuario u, NodoUsuario nu) {
		if(nu == null) {
			return null;
		}
		if(nu.getUsu().equals(u)) {
			return nu.getUsu();
		}
		if(u.compareTo(nu.getUsu()) > 0) {
			return buscarUsuario(u, nu.getDrc());
		}else {
			return buscarUsuario(u, nu.getIzq());
		}
	}
	
	public String Listar() {
		return Listar(this.raiz);
	}
	
	private String Listar(NodoUsuario n) {
		String nombre = "";
		if(n!=null) {
			nombre  +=  Listar(n.getIzq()) + n.getUsu().toString()+"\n" + Listar(n.getDrc());
			
			return nombre;
		}
		return nombre;
	}
	
	
}
