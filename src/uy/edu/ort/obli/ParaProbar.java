package uy.edu.ort.obli;


public class ParaProbar {
	
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		sistema.inicializarSistema(16);
		
		System.out.println(sistema.registrarUsuario("pepe@gmail.com","Pepe","PepeCapo1"));
		/*
		sistema.registrarMovil("1", 1.0, 1.0);
		sistema.registrarDelivery("4", 4.0, 4.0);
		sistema.registrarMovil("7", 7.0, 7.0);
		sistema.registrarDelivery("10", 10.0, 10.0);
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
		
		System.out.println(sistema.deliveryMasCercano(4, 1));
		System.out.println(sistema.deliveryMasCercano(4, 1));
		System.out.println(sistema.deliveryMasCercano(4, 1));
		

		
		//System.out.println(sistema.direccionesDeUsuario("pepe@gmail.com"));
				
	}
	
}
