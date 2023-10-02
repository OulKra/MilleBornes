package cartes;

public class Botte extends Probleme {

	public Botte(int n, Type type) {
		super(n, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		switch (super.getType()) {
		case FEU:
			return "Vehicule prio";
		case ESSENCE:
			return "Citerne d'essence";
		case ACCIDENT:
			return "As du volant";
		case CREVAISON:
			return "Increvable";
		default:
			break;

		}

		return "";

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Botte botte) {
			return botte.getType() == this.getType();
		}

		return false;
	}

}
