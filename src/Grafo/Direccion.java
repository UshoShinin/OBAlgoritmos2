package Grafo;

public abstract class Direccion {
	double codX;
	double codY;
	
	public Direccion(double X, double Y) {
		codX=X;
		codY=Y;
	}

	
	public boolean soy(double codX, double codY) {
		return this.codX==codX&&this.codY==codY;
	}
	
	
	
}
