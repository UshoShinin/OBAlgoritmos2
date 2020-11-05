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
	
	public void mostrar() {
		for(int i = 0 ; i<cantDir;i++) {
			for(int j= 0 ; j<cantDir;j++) {
				if(MatrizCostos[i][j].existe) {
					System.out.println(MatrizCostos[i][j]); 
				}
			}
		}
	}
	
}

