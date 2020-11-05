package uy.edu.ort.obli;

import uy.edu.ort.obli.Retorno.Resultado;
import componentes.*;
import componentes.Usuario;
public class Sistema implements ISistema {
	
	private static Sistema sistema;
	private ABBUsuario Usuarios;
	
	public static Sistema getSistema() {
		if(sistema == null) {
			sistema = new Sistema();
		}
		return sistema;
	}
	public Sistema(){
	};
	
	@Override
	public Retorno inicializarSistema(int maxPuntos) {
		Usuarios = new ABBUsuario();
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno destruirSistema() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarUsuario(String email, String nombre, String password) {
		//valido el mail 
		if(!Usuario.validarMail(email)) {
			return new Retorno(Resultado.ERROR_1);
		}
		//valido que el usuario no exista ya
		if(Usuarios.buscarUsuario(email) != null) {
			return new Retorno(Resultado.ERROR_2);
		}
		Usuarios.insertar(new Usuario(nombre,email,password));
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno buscarUsuario(String email) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno listarUsuarios() {
		//este metodo nos tendria que devolver un string que es el mensaje que tenemos que mostrar
		String ret =  Usuarios.Listar();
		return new Retorno(Resultado.OK, 0, ret);
	}

	@Override
	public Retorno direccionesDeUsuario(String email) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarEsquina(double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarDelivery(String cedula, Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarMovil(String matricula, Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno movilMasCercano(Double coordXi, Double coordYi) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno deliveryMasCercano(Double coordXi, Double coordYi) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoMinimoMovil(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoMinimoDelivery(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

}
