package Grafo;

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
}

