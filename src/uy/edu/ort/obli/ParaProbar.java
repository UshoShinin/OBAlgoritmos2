package uy.edu.ort.obli;



public class ParaProbar {
	
	public static void main(String[] args) {
		
		Sistema sistema = Sistema.getSistema();
		
		
		sistema.inicializarSistema(10);
		//sistema.listarUsuarios();
		
		Retorno a = sistema.registrarUsuario("a@a", "pepe", "1234");
		System.out.println(a);
	}
	
}
