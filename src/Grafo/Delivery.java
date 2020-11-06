package Grafo;

public class Delivery extends Direccion{

	String cedula;
	boolean ocupado;
	public Delivery(double X, double Y, String cedula) {
		super(X, Y);
		this.cedula = cedula;
		ocupado = false;
	}
	
	
}
