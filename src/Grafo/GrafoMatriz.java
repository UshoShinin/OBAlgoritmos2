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
	
	public int costoCaminoMinimo(double coordXi, double coordYi, double coordXf, double coordYf) {
		int origen = buscarDireccion(coordXi,coordYi);
		int destino = buscarDireccion(coordXf,coordYf);
		System.out.println("O:"+origen+" D:"+destino);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[]costos = new int[cantDir];
		boolean[]visitados = new boolean[cantDir];
		visitados[origen] = true;
		for(int i = 0; i<cantDir;i++) {
			if(MatrizCostos[origen][i].existe) {
				costos[i]=MatrizCostos[origen][i].metros;
			}else {
				costos[i]=Integer.MAX_VALUE;
			}
		}
		System.out.println("---");
		for(int i = 0 ; i<costos.length;i++) {
			System.out.println(costos[i]);
		}
		System.out.println("---");
		
		while(direccionesSinVisitar(visitados)) {
			int w = direccionMasBarataSinVisitar(visitados,costos);
			if(w==-1)return -1;
			visitados[w]=true;
			for(int i = 0; i<cantDir;i++) {
				if(MatrizCostos[w][i].existe&&!visitados[i]) {
					costos[i]=Math.min(costos[i], costos[w]+MatrizCostos[w][i].metros);
				}
			}
		}
		return costos[destino];
	}
	
	public boolean direccionesSinVisitar(boolean[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			if(!visitados[i]) {
				return false;
			}
		}
		return true;
	}
	
	public int direccionMasBarataSinVisitar(boolean[] visitados, int[]costos) {
		int costoMinimo = Integer.MAX_VALUE;
		int posMasBarata = -1;
		for (int i = 0; i < visitados.length; i++) {
			if(!visitados[i] && costos[i] <= costoMinimo) {
				costoMinimo = costos[i];
				posMasBarata = i;
			}
		}
		return posMasBarata;
	}
	/*
	//devuelve la posicion en el array de direcciones de la direccion con un movil mas cercana a la direccion de inicio
	public int costoCaminoMinimo(double codXi, double codYi, double codXf, double codYf) {
		int[] metros = new int[cantDir];
		//seguramente a este array de direcciones le tengo que ir agregando tambien los que fui pasando cosa de saber cuantos fueron
		//Direccion[] anteriores = new Direccion[cantDir];
		Direccion[] visitados = new Direccion[cantDir];
		int posDireccionInicial = buscarDireccion(codXi, codYi);
		int posDireccionDestino = buscarDireccion(codXf, codYf);
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
			visitados[w] = Nodos[w];
			//aca hay que ver de si al visitar W tengo que agregar el que estaba antes al array de anteriores para saber a cuantos fui
			for (int i = 0; i < cantDir; i++) {
				if(MatrizCostos[w][i].existe && visitados[i] == null) {
					metros[i] = Math.min(metros[i], metros[w] + MatrizCostos[w][i].metros);
				}
			}
		}
		//visite todas las direcciones
		return metros[posDireccionDestino];
	}
	*/
	
	
	/*
	public boolean direccionesSinVisitar(Direccion[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			if(visitados[i] == null) {
				return false;
			}
		}
		return true;
	}
	
	
	public static int direccionMasBarataSinVisitar(Direccion[] visitados, int[]  costos) {
		int costoMinimo = Integer.MAX_VALUE;
		int posMasBarata = -1;
		for (int i = 0; i < visitados.length; i++) {
			if(visitados[i] == null && costos[i] <= costoMinimo) {
				posMasBarata = i;
			}
		}
		return posMasBarata;
	}
	*/
}

