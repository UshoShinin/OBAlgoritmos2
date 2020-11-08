package componentes;
import uy.edu.ort.obli.Retorno;
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
	
	public Retorno buscarUsuario(String email) {
		if(this.raiz == null) {
			return null;
		}
		//Creo un usuario auxiliar para facilitar las comparaciones
		Usuario aux = new Usuario(email);
		return buscarUsuario(aux, this.raiz,1);
	}
	
	private Retorno buscarUsuario(Usuario u, NodoUsuario nu,int pasos) {
		if(nu == null) {
			return null;
		}
		if(nu.getUsu().equals(u)) {
			return new Retorno(Retorno.Resultado.OK,pasos,nu.getUsu().toString());
		}
		if(u.compareTo(nu.getUsu()) > 0) {
			return buscarUsuario(u, nu.getDrc(),pasos+1);
		}else {
			return buscarUsuario(u, nu.getIzq(),pasos+1);
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

	public Retorno direccionesDeUsuario(String email) {
		Retorno ret = new Retorno(Retorno.Resultado.OK);
		if(!Usuario.validarMail(email)) {
			ret.resultado = Retorno.Resultado.ERROR_1;
			return ret;
		}
		Usuario u = buscarUsuarioSimple(email);
		if(u == null) {
			ret.resultado = Retorno.Resultado.ERROR_2;
			return ret;
		}
		String strRet = u.listadoDir();
		if(strRet == "") {
			strRet = "El usuario no tiene ninguna direccion guardada";
		}
		ret.valorString = strRet;
		return ret;
	}
	
	//Estos 2 metodos los cree para tener un metodo que nos devuelva un usuario y listo
	//El otro metodo que hay de buscar se usa para devolver algunas otras cosas que pide la letra
	public Usuario buscarUsuarioSimple(String email) {
		if(this.raiz == null) {
			return null;
		}
		Usuario aux = new Usuario(email);
		return buscarUsuarioSimple(aux, this.raiz);
	}
	
	private Usuario buscarUsuarioSimple(Usuario u, NodoUsuario nu) {
		if(nu == null) {
			return null;
		}
		if(nu.getUsu().equals(u)) {
			return nu.getUsu();
		}
		if(u.compareTo(nu.getUsu()) > 0) {
			return buscarUsuarioSimple(u, nu.getDrc());
		}else {
			return buscarUsuarioSimple(u, nu.getIzq());
		}
	}
	
}
