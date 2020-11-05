package uy.edu.ort.obli;



public class ParaProbar {
	
	public static void main(String[] args) {
		
		Sistema sistema = Sistema.getSistema();
		
		
		sistema.inicializarSistema(10);
		sistema.registrarUsuario("pepe@gmail.com","Pepe","PepeCapo1");
		sistema.registrarUsuario("pepa@gmail.com","Pepa","PepeCapo1");
		sistema.registrarUsuario("ana12@gmail.com","Ana","Anita");
		sistema.registrarUsuario("godOfThunder@gmail.com","Zeus","Rayito");
		System.out.println(sistema.listarUsuarios().valorString);
		
		
		Retorno a = sistema.registrarUsuario("a@a", "pepe", "1234");
		System.out.println(a);
	}
	
}
