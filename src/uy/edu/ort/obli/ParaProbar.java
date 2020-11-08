package uy.edu.ort.obli;
import Grafo.*;

public class ParaProbar {
	
	public static void main(String[] args) {
		
		Sistema sistema = Sistema.getSistema();
		
		
		sistema.inicializarSistema(16);
		/*
		sistema.registrarUsuario("pepe@gmail.com","Pepe","PepeCapo1");
		sistema.registrarUsuario("pepa@gmail.com","Pepa","PepeCapo1");
		sistema.registrarUsuario("ana12@gmail.com","Ana","Anita");
		sistema.registrarUsuario("godOfThunder@gmail.com","Zeus","Rayito");
		System.out.println(sistema.listarUsuarios().valorString);
		
		
		Retorno a = sistema.registrarUsuario("a@a", "pepe", "1234");
		System.out.println(a);
		System.out.println(sistema.buscarUsuario("ana12@gmail.com"));
		System.out.println("\n");
		
		*/
		
		//Direcciones
		/*
		System.out.println(sistema.registrarEsquina(1, 1));
		System.out.println(sistema.registrarEsquina(1, 2));
		System.out.println(sistema.registrarEsquina(1, 3));
		
		System.out.println(sistema.registrarDelivery("123",2,1));
		System.out.println(sistema.registrarDelivery("234",2, 2));
		System.out.println(sistema.registrarDelivery("345",2, 3));
		
		System.out.println(sistema.registrarMovil("AB123",3, 1));
		System.out.println(sistema.registrarMovil("AB123",3, 2));
		System.out.println(sistema.registrarMovil("AB123",3, 3));
		System.out.println("-----------");
		*/
		
		
		
		/*
		System.out.println(sistema.registrarTramo(1, 1, 1, 2, 1, 1));
		System.out.println(sistema.registrarTramo(1, 1, 2, 1, 3, 1));
		System.out.println(sistema.registrarTramo(1, 2, 1, 3, 1, 1));
		System.out.println(sistema.registrarTramo(1, 2, 2, 2, 3, 1));
		System.out.println(sistema.registrarTramo(1, 3, 2, 3, 3, 1));
		System.out.println(sistema.registrarTramo(2, 1, 2, 2, 1, 1));
		System.out.println(sistema.registrarTramo(2, 1, 3, 1, 3, 1));
		System.out.println(sistema.registrarTramo(2, 2, 2, 3, 1, 1));
		System.out.println(sistema.registrarTramo(2, 3, 3, 3, 1, 1));
		System.out.println(sistema.registrarTramo(3, 1, 3, 2, 1, 1));
		System.out.println(sistema.registrarTramo(3, 2, 2, 2, 3, 1));
		System.out.println(sistema.registrarTramo(3, 2, 3, 3, 3, 1));
		
		sistema.caminoMinimoMovil(1, 1, 3, 2);
		*/
		
		sistema.registrarEsquina(1, 1);
		sistema.registrarEsquina(1, 2);
		sistema.registrarEsquina(1, 3);
		sistema.registrarEsquina(1, 4);
		
		sistema.registrarEsquina(2, 1);
		sistema.registrarEsquina(2, 2);
		sistema.registrarDelivery("123456", 2, 3);
		sistema.registrarEsquina(2, 4);
		
		sistema.registrarMovil("MTV123", 3, 1);
		sistema.registrarDelivery("234567", 3, 2);
		sistema.registrarEsquina(3, 3);
		sistema.registrarMovil("MTV456", 3, 4);
		
		sistema.registrarEsquina(4, 1);
		sistema.registrarEsquina(4, 2);
		sistema.registrarEsquina(4, 3);
		sistema.registrarEsquina(4, 4);
		
		sistema.registrarTramo(1, 1, 1, 2, 1, 1); // 0 - 1
		sistema.registrarTramo(1, 2, 1, 3, 10, 10);// 1 - 2
		sistema.registrarTramo(1, 3, 1, 4, 1, 10);// 2 - 3
		
		sistema.registrarTramo(1, 2, 2, 2, 2, 10);// 1 - 5
		sistema.registrarTramo(1, 4, 2, 4, 1, 10);// 3 - 7
		
		sistema.registrarTramo(2, 1, 2, 2, 2, 10);// 4 - 5
		sistema.registrarTramo(2, 2, 2, 3, 1, 10);// 5 - 6
		
		sistema.registrarTramo(2, 1, 3, 1, 3, 10);// 4 - 8
		sistema.registrarTramo(2, 3, 3, 3, 4, 10);// 6 - 10
		sistema.registrarTramo(2, 4, 3, 4, 1, 10);// 7 - 11
		
		sistema.registrarTramo(3, 1, 3, 2, 1, 10);// 8 - 9

		sistema.registrarTramo(3, 2, 4, 2, 60, 10);// 9 - 13
		sistema.registrarTramo(3, 3, 4, 3, 2, 10);// 10 - 14
		
		sistema.registrarTramo(4, 1, 4, 2, 2, 10);// 12 - 13
		sistema.registrarTramo(4, 2, 4, 3, 3, 10);// 13 - 14
		sistema.registrarTramo(4, 3, 4, 4, 2, 10);// 14 - 15
		
		//sistema.Grafo.mostrar2();
		
		
		//sistema.caminoMinimoMovil(4, 1, 3, 1);
		
		//System.out.println(sistema.registrarTramo(1, 1, 1, 2, 0, 10));
		
		//System.out.println(sistema.registrarTramo(1, 1, 1, 2, 10, 0));
		
		//System.out.println(sistema.registrarTramo(4, 1, 1, 2, 10, 10));
		//System.out.println(sistema.registrarTramo(1, 4, 1, 2, 10, 10));
		
		//System.out.println(sistema.registrarTramo(1, 1, 1, 2, 1, 10));
		
		System.out.println("-----------");
		sistema.registrarUsuario("pepe@gmail.com","Pepe","PepeCapo1");
		System.out.println(sistema.direccionesDeUsuario("pepe@gmail.com"));
		
	}
	
}
