package uy.edu.ort.obli;



public class ParaProbar {
	
	public static void main(String[] args) {
		
		Sistema sistema = Sistema.getSistema();
		
		
		sistema.inicializarSistema(9);
		sistema.registrarUsuario("pepe@gmail.com","Pepe","PepeCapo1");
		sistema.registrarUsuario("pepa@gmail.com","Pepa","PepeCapo1");
		sistema.registrarUsuario("ana12@gmail.com","Ana","Anita");
		sistema.registrarUsuario("godOfThunder@gmail.com","Zeus","Rayito");
		System.out.println(sistema.listarUsuarios().valorString);
		
		
		Retorno a = sistema.registrarUsuario("a@a", "pepe", "1234");
		System.out.println(a);
		System.out.println(sistema.buscarUsuario("ana12@gmail.com"));
		System.out.println("\n");
		System.out.println(sistema.registrarEsquina(1, 1));
		System.out.println(sistema.registrarEsquina(1, 2));
		System.out.println(sistema.registrarEsquina(1, 3));
		
		System.out.println(sistema.registrarDelivery("123",2,1));
		System.out.println(sistema.registrarDelivery("234",2, 2));
		System.out.println(sistema.registrarDelivery("345",2, 3));
		
		System.out.println(sistema.registrarMovil("AB123",3, 1));
		System.out.println(sistema.registrarMovil("AB123",3, 2));
		System.out.println(sistema.registrarMovil("AB123",3, 3));
		
		System.out.println(sistema.registrarEsquina(1, 4));
		System.out.println(sistema.registrarEsquina(1, 3));
		
		
		System.out.println("-----------");
		
		System.out.println(sistema.registrarTramo(1, 1, 1, 2, 1, 10));
		System.out.println(sistema.registrarTramo(1, 1, 2, 2, 10, 10));
		
		System.out.println(sistema.registrarTramo(1, 1, 1, 2, 0, 10));
		
		System.out.println(sistema.registrarTramo(1, 1, 1, 2, 10, 0));
		
		System.out.println(sistema.registrarTramo(4, 1, 1, 2, 10, 10));
		System.out.println(sistema.registrarTramo(1, 4, 1, 2, 10, 10));
		
		System.out.println(sistema.registrarTramo(1, 1, 1, 2, 1, 10));
	}
	
}
