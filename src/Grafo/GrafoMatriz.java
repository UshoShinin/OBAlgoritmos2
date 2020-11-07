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
					System.out.println(MatrizCostos[i][j]); 
				}
			}
		}
	}
	
	
	
	//devuelve la posicion en el array de direcciones de la direccion con un movil mas cercana a la direccion de inicio
	public int costoCaminoMinimoMovil(double codXi, double codYi, double codXf, double codYf) {
		int[] metros = new int[cantDir];
		Direccion[] visitados = new Direccion[cantDir];
		int posDireccionInicial = buscarDireccion(codXi, codYi);
		int posDireccionDestino = buscarDireccion(codXf, codYf);
		int anterior = posDireccionInicial;
		int[] anteriores = new int[cantDir];
		//Arranque
		visitados[posDireccionInicial] = Nodos[posDireccionInicial];
		for (int i = 0; i < cantDir; i++) {
			if(MatrizCostos[posDireccionInicial][i].existe) {
				metros[i] = MatrizCostos[posDireccionInicial][i].metros;
			}else {
				metros[i] = Integer.MAX_VALUE;
			}
		}
		//Visitamos todos
		while(direccionesSinVisitar(visitados)) {
			int w = direccionMasBarataSinVisitar(visitados, metros);
			if(w == -1) {
				return -1;
			}
			anteriores[w] = anterior;
			visitados[w] = Nodos[w];
			//aca hay que ver de si al visitar W tengo que agregar el que estaba antes al array de anteriores para saber a cuantos fui
			for (int i = 0; i < cantDir; i++) {
				if(MatrizCostos[w][i].existe && visitados[i] == null) {
					System.out.println(w + "/" + i + "/" + metros[w] + MatrizCostos[w][i].metros);
					metros[i] = Math.min(metros[i], metros[w] + MatrizCostos[w][i].metros);
				}
			}
			anterior = w;
		}
		//visite todas las direcciones
		return metros[posDireccionDestino];
	}
	
	
	
	
	public boolean direccionesSinVisitar(Direccion[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			if(visitados[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	
	public static int direccionMasBarataSinVisitar(Direccion[] visitados, int[]  costos) {
		int costoMinimo = Integer.MAX_VALUE;
		int posMasBarata = -1;
		for (int i = 0; i < visitados.length; i++) {
			if(visitados[i] == null && costos[i] <= costoMinimo) {
				posMasBarata = i;
				costoMinimo = costos[i];
			}
		}
		return posMasBarata;
	}
	
}

