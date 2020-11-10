package uy.edu.ort.obli;

import uy.edu.ort.obli.Retorno.Resultado;
import componentes.*;

import java.awt.Desktop;
import java.net.URL;

import Grafo.*;
public class Sistema implements ISistema {
	
	private ABBUsuario Usuarios;
	public GrafoMatriz Grafo;
	
	//esto hay que ver si puede ir o no
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
		Usuarios = null;
		Grafo = null;
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarUsuario(String email, String nombre, String password) {
		return Usuarios.insertar(new Usuario(nombre,email,password));
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
		return Usuarios.direccionesDeUsuario(email);
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
		return Grafo.movilMasCercano(coordXi, coordYi);
	}

	@Override
	public Retorno deliveryMasCercano(double coordXi, double coordYi) {
		return Grafo.deliveryMasCercano(coordXi, coordYi);
	}

	@Override
	public Retorno caminoMinimoMovil(double coordXi, double coordYi, double coordXf, double coordYf, String email) {
		//esto simplemente es para probar, asi que veamos que pasa. Obviamente vamos a cambiarlo con ivan el ssabado
		Usuario user = Usuarios.buscarUsuarioSimple(email);
		 
		return Grafo.costoCaminoMinimoMovil(coordXi, coordYi, coordXf, coordYf, user);
	}

	@Override
	public Retorno caminoMinimoDelivery(double coordXi, double coordYi, double coordXf, double coordYf) {
		return Grafo.caminoMinimoDelivery(coordXi,coordYi,coordXf,coordYf);
	}

	@Override
	public Retorno dibujarMapa() {
		String url = Grafo.generarStringMapa();
		try {
		  Desktop.getDesktop().browse(new URL(url).toURI());
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return new Retorno(Resultado.OK);
	}

}
