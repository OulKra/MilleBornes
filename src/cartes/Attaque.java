package cartes;

public class Attaque extends Bataille {

	public Attaque(int n, Type t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		switch(super.getType()){
		case FEU:
			System.out.println("Carte Feu rouge");
			break;
		case ESSENCE:
			System.out.println("Carte Panne d'essence");
			break;
		case ACCIDENT:
			System.out.println("Carte Accident");
			break;
		case CREVAISON:
			System.out.println("Carte Crevaison");
			break;
		default:
			break;
		
		}
		
		return super.toString();
			
	}
	
}
