package uy.edu.ort.obli;


public class ParaProbar {
	
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		sistema.inicializarSistema(10);
		
		System.out.println(sistema.registrarUsuario("pepe@gmail.com","Pepe","PepeCapo1"));
		
		
		sistema.registrarMovil("1", 1.0, 1.0);
		sistema.registrarDelivery("4", 4.0, 4.0);
		sistema.registrarMovil("7", 7.0, 7.0);
		sistema.registrarDelivery("10", 11.0, 11.0);
		sistema.registrarMovil("11", 11.0, 11.0);
		sistema.registrarEsquina(2.0, 2.0);
		sistema.registrarEsquina(3.0, 3.0);
		sistema.registrarEsquina(5.0, 5.0);
		sistema.registrarEsquina(6.0, 6.0);
		sistema.registrarEsquina(8.0, 8.0);
		sistema.registrarEsquina(9.0, 9.0);

		sistema.registrarTramo(1.0, 1.0, 2.0, 2.0, 5, 9999);
		sistema.registrarTramo(1.0, 1.0, 4.0, 4.0, 3, 9999);
		sistema.registrarTramo(2.0, 2.0, 3.0, 3.0, 1, 9999);
		sistema.registrarTramo(2.0, 2.0, 5.0, 5.0, 11, 9999);
		sistema.registrarTramo(3.0, 3.0, 6.0, 6.0, 2, 9999);
		sistema.registrarTramo(3.0, 3.0, 11.0, 11.0, 19, 9999);
		sistema.registrarTramo(4.0, 4.0, 5.0, 5.0, 14, 9999);
		sistema.registrarTramo(5.0, 5.0, 6.0, 6.0, 6, 9999);
		sistema.registrarTramo(5.0, 5.0, 8.0, 8.0, 1, 9999);
		sistema.registrarTramo(6.0, 6.0, 9.0, 9.0, 3, 9999);
		sistema.registrarTramo(7.0, 7.0, 8.0, 8.0, 8, 9999);
		sistema.registrarTramo(8.0, 8.0, 7.0, 7.0, 8, 9999); //doble
		sistema.registrarTramo(8.0, 8.0, 9.0, 9.0, 5, 9999); 
		sistema.registrarTramo(9.0, 9.0, 8.0, 8.0, 5, 9999); //doble
		sistema.registrarTramo(9.0, 9.0, 10.0, 10.0, 4, 9999);
		
		System.out.println("-----------");
		
		
		
		System.out.println(sistema.caminoMinimoMovil(1.0, 1.0, 7.0, 7.0,"pepe@gmail.com"));
		

		
		//System.out.println(sistema.direccionesDeUsuario("pepe@gmail.com"));
				
	}
	
}
