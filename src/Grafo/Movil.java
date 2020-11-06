package Grafo;

public class Movil extends Direccion {

	String matricula;
	boolean ocupado;
	public Movil(double X, double Y, String m) {
		super(X, Y);
		matricula = m;
		ocupado = false;
		// TODO Auto-generated constructor stub
	}

}
