package cartes;

public class Parade extends Bataille {

	public Parade(int n, Type t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		switch(super.getType()){
		case FEU:
			System.out.println("Carte Feu vert");
			break;
		case ESSENCE:
			System.out.println("Carte Essence");
			break;
		case ACCIDENT:
			System.out.println("Carte Reparation");
			break;
		case CREVAISON:
			System.out.println("Carte Roue de secours");
			break;
		default:
			break;
		
		}
		
		return super.toString();
			
	}
}
