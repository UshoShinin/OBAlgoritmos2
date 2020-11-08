package Grafo;

public abstract class Direccion {
	double codX;
	double codY;
	
	public double getCodX() {
		return codX;
	}

	public double getCodY() {
		return codY;
	}
	
	public Direccion(double X, double Y) {
		codX=X;
		codY=Y;
	}

	
	public boolean soy(double codX, double codY) {
		return this.codX==codX&&this.codY==codY;
	}


	@Override
	/*public String toString() {
		public String toString() {
		return "Yo soy la direccion: " + codX + " " + codY;
	}return "Yo soy la direccion: " + codX + " " + codY;
	}
	*/
	public String toString() {
		return "X:" + codX + " Y:" + codY;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		if (Double.doubleToLongBits(codX) != Double.doubleToLongBits(other.codX))
			return false;
		if (Double.doubleToLongBits(codY) != Double.doubleToLongBits(other.codY))
			return false;
		return true;
	}
	
}
