package cartes;

public abstract class Probleme extends Carte {

	public enum Type {
		FEU, ESSENCE, CREVAISON, ACCIDENT;
	}
	
	Type type;
	
	
	public Probleme(int nombre, Type t) {
		super(nombre);
		this.type = t;
		// TODO Auto-generated constructor stub
	}


	public Type getType() {
		return type;
	}

}
