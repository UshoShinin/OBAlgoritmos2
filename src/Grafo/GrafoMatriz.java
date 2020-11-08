package Grafo;
import uy.edu.ort.obli.Retorno;

public class GrafoMatriz {

	int size;
	int cantDir;
	Arco[][] MatrizCostos;
	Direccion [] Nodos;
	
	
	public GrafoMatriz(int cantDir) {
		this.size=0;
		this.cantDir=cantDir;
		this.MatrizCostos = new Arco[cantDir][cantDir];
		for(int i=0;i<cantDir;i++) {
			for(int j=0;j<cantDir;j++) {
				this.MatrizCostos[i][j]=new Arco();
			}
		}
		this.Nodos=new Direccion[cantDir];
	}
	
	public int buscarDireccion(double codX, double codY) {
		for(int i = 0; i<Nodos.length;i++) {
			if(Nodos[i]!=null&&Nodos[i].soy(codX, codY)) {
				return i;
			} 
		}
		return -1;
	}
	
	public Retorno altaEsquina(double codX, double codY){
		Retorno ret = new Retorno(Retorno.Resultado.OK);
		if(size<cantDir) {
			if(buscarDireccion(codX,codY)==-1) {
				Nodos[size]=new Esquina(codX,codY);
				size++;
			}else {
				ret.resultado = Retorno.Resultado.ERROR_2;
			}
			
		}else {
			ret.resultado = Retorno.Resultado.ERROR_1;
		}
		return ret;
	}
	
	public Retorno altaDelivery(double codX, double codY,String cedula) {
		Retorno ret = new Retorno(Retorno.Resultado.OK);
		if(size<cantDir) {
			if(buscarDireccion(codX,codY)==-1) {
				Nodos[size]=new Delivery(codX,codY,cedula);
				size++;
			}else {
				ret.resultado = Retorno.Resultado.ERROR_2;
			}
			
		}else {
			ret.resultado = Retorno.Resultado.ERROR_1;
		}
		return ret;
	}
	
	public Retorno altaMovil(double codX, double codY,String matricula) {
		Retorno ret = new Retorno(Retorno.Resultado.OK);
		if(size<cantDir) {
			if(buscarDireccion(codX,codY)==-1) {
				Nodos[size]=new Movil(codX,codY,matricula);
				size++;
			}else {
				ret.resultado = Retorno.Resultado.ERROR_2;
			}
			
		}else {
			ret.resultado = Retorno.Resultado.ERROR_1;
		}
		return ret;
	}
	
	public void agregarArista(int origen, int destino, int kilometros, int tiempo) {
		this.MatrizCostos[origen][destino] = new Arco(kilometros,tiempo);
	}
	
	public Retorno altaTramo(double codXi, double codYi, double codXf, double codYf, int metros, int minutos) {
		Retorno ret = new Retorno(Retorno.Resultado.OK);
		if(metros <= 0) {
			ret.resultado = Retorno.Resultado.ERROR_1;
			return ret;
		}
		if(minutos <= 0) {
			ret.resultado = Retorno.Resultado.ERROR_2;
			return ret;
		}
		int dirI = buscarDireccion(codXi, codYi);
		int dirF = buscarDireccion(codXf, codYf);
		if(dirI < 0 || dirF < 0) {
			ret.resultado = Retorno.Resultado.ERROR_3;
		}else if(MatrizCostos[dirI][dirF].existe) {
			ret.resultado = Retorno.Resultado.ERROR_4;
		}else {
			MatrizCostos[dirI][dirF].existir(metros, minutos);
			//ESTO ES UNA CHANCHADA HAY QUE ARREGLARLO DESPUES PARA QUE QUEDE MEJOR
			MatrizCostos[dirF][dirI].existir(metros, minutos);
		}
		return ret;	
	}
	
	public void mostrar() {
		for(int i = 0 ; i<cantDir;i++) {
			for(int j= 0 ; j<cantDir;j++) {
				if(MatrizCostos[i][j].existe) {
					System.out.print(MatrizCostos[i][j] +"-"); 
				}else {
					System.out.print("0-");
				}
				
			}
			System.out.println("-");
		}
	}
	
	public void mostrar2() {
		for(int i = 0;i<16;i++) {
			if(i%4==0) {System.out.println("");}
			System.out.print(i+":"+Nodos[i]+"  -  ");
		}
	}
	
	//devuelve la posicion en el array de direcciones de la direccion con un movil mas cercana a la direccion de inicio
	public Retorno costoCaminoMinimoMovil(double codXi, double codYi, double codXf, double codYf, String email) {
		Retorno ret = new Retorno(Retorno.Resultado.OK);
		//aca llamo al metodo de movil mas cercano para que vea si hay algun movil disponible
		int[] metros = new int[cantDir];
		boolean[] visitados = new boolean[cantDir];
		int posDireccionInicial = buscarDireccion(codXi, codYi);
		int posDireccionDestino = buscarDireccion(codXf, codYf);
		//Verifico que las direcciones existan
		if(posDireccionInicial == -1 || posDireccionDestino == -1) {
			ret.resultado = Retorno.Resultado.ERROR_1;
			return ret;
		}
		int anterior = posDireccionInicial;
		int[] anteriores = new int[cantDir];
		//Arranque
		visitados[posDireccionInicial] = true;
		for (int i = 0; i < cantDir; i++) {
			if(MatrizCostos[posDireccionInicial][i].existe) {
				metros[i] = MatrizCostos[posDireccionInicial][i].metros;
			}else {
				metros[i] = Integer.MAX_VALUE;
			}
		}
		for (int i : metros) {
            if (i == Integer.MAX_VALUE) i = -1;
        }
		int w = direccionMasBarataSinVisitar(visitados, metros);
		anteriores[w]=posDireccionInicial;
		//Visitamos todos
		while(direccionesSinVisitar(visitados)) {
			w = direccionMasBarataSinVisitar(visitados, metros);
			//if(w == -1) {
			//	return -1;
			//}
			visitados[w] = true;
			for (int i = 0; i < cantDir; i++) {
				if(MatrizCostos[w][i].existe && !visitados[i]) {
					//System.out.println(w + "voy a" + i + " costo en matriz:" + MatrizCostos[w][i].metros);
					metros[i] = Math.min(metros[i], metros[w] + MatrizCostos[w][i].metros);
					anteriores[i]=w;
				}
			}	
		}
		//visite todas las direcciones
		String Ruta="";
		int punto = posDireccionDestino;
		while(punto!=posDireccionInicial) {
			Ruta = Nodos[punto].codX + ";" + Nodos[punto].codY + "|" + Ruta;
			punto = anteriores[punto];
		}
		Ruta = Nodos[punto].codX + ";" + Nodos[punto].codY + "|" + Ruta;
		ret.valorEntero = metros[posDireccionDestino];
		ret.valorString = Ruta;
		//guardo la direccion para el usuario
		return ret;
	}
	
	
	
	
	public boolean direccionesSinVisitar(boolean[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			if(!visitados[i]) {
				return true;
			}
		}
		return false;
	}
	
	
	public static int direccionMasBarataSinVisitar(boolean[] visitados, int[]  costos) {
		int costoMinimo = Integer.MAX_VALUE;
		int posMasBarata = -1;
		for (int i = 0; i < visitados.length; i++) {
			if(!visitados[i] && costos[i] <= costoMinimo) {
				posMasBarata = i;
				costoMinimo = costos[i];
			}
		}
		return posMasBarata;
	}
	
}

