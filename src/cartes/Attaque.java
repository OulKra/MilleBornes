package cartes;

public class Attaque extends Bataille {

	public Attaque(int n, Type t) {
		super(n, t);
	}

	@Override
	public String toString() {
		switch (super.getType()) {
		case FEU:
			return "Feu rouge";
		case ESSENCE:
			return "Panne d'essence";
		case ACCIDENT:
			return "Accident";
		case CREVAISON:
			return "Crevaison";
		default:
			break;

		}

		return null;

	}

	public boolean equals(Object obj) {
		if (obj instanceof Attaque attaque) {
			return attaque.getType() == this.getType();
		}

		return false;
	}

}
