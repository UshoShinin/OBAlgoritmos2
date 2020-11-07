package uy.edu.ort.obli;

import uy.edu.ort.obli.Retorno.Resultado;
import componentes.*;
import Grafo.*;
public class Sistema implements ISistema {
	
	private static Sistema sistema;
	private ABBUsuario Usuarios;
	public GrafoMatriz Grafo;
	
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
		Grafo = new GrafoMatriz(maxPuntos);
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
		return Usuarios.buscarUsuario(email);
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
		return Grafo.altaEsquina(coordX, coordY);
	}

	@Override
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros,int tiempo) {
		return Grafo.altaTramo(coordXi, coordYi, coordXf, coordYf, metros, tiempo);
	}

	@Override
	public Retorno registrarDelivery(String cedula, double coordX, double coordY) {
		return Grafo.altaDelivery(coordX, coordY,cedula);
	}

	@Override
	public Retorno registrarMovil(String matricula, double coordX, double coordY) {
		return Grafo.altaMovil(coordX, coordY,matricula);
	}

	@Override
	public Retorno movilMasCercano(double coordXi, double coordYi) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno deliveryMasCercano(double coordXi, double coordYi) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoMinimoMovil(double coordXi, double coordYi, double coordXf, double coordYf) {
		//esto simplemente es para probar, asi que veamos que pasa. Obviamente vamos a cambiarlo con ivan el ssabado
		System.out.println(Grafo.costoCaminoMinimoMovil(coordXi, coordYi, coordXf, coordYf)); 
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoMinimoDelivery(double coordXi, double coordYi, double coordXf, double coordYf) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

}
