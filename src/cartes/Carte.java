package cartes;

public abstract class Carte {

	private int nombre;	
	
	public Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}
	
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
}
