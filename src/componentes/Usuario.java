package componentes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario implements Comparable<Usuario>{
	
	

	//Atributos del Usuario
	private String email;
	private String nombre;
	private String password;
	private ListaDireccion direcciones;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ListaDireccion getListaDireccion() {
		return direcciones;
	}
	
	public Usuario(String email) {
		this.email = email;
	}
	public Usuario(String nombre,String email,String password) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.direcciones = new ListaDireccion();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Usuario u) {
		return this.email.compareTo(u.email);
	}
	
	
	@Override
	public String toString() {
		return email + ";" + nombre;
	}
	
	
	public String listadoDir() {
		return direcciones.listadoDir();
	}
	
	
	
	//Para poder validar el mail utilizando expresiones regulares
	private static String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	private static Pattern patron = Pattern.compile(regex);
	public static boolean validarMail(String email) {
		Matcher matcher = patron.matcher(email);
		return matcher.matches();
	}
	
	
	
}
