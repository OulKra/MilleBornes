package cartes;

public class Attaque extends Bataille {

	public Attaque(int n, Type t) {
		super(n, t);
	}

	public String toString() {
		switch(super.getType()){
		case FEU:
			return "Carte Feu rouge";
		case ESSENCE:
			return "Carte Panne d'essence";
		case ACCIDENT:
			return "Carte Accident";
		case CREVAISON:
			return "Carte Crevaison";
		default:
			break;
		
		}
		
		return super.toString();
			
	}
	
}
