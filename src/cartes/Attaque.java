package cartes;

public class Attaque extends Bataille {

	public Attaque(int n, Type t) {
		super(n, t);
	}

	@Override
	public String toString() {
		switch(super.getType()){
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
	
}
