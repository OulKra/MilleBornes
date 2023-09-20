package cartes;

public class Parade extends Bataille {

	public Parade(int n, Type t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		switch(super.getType()){
		case FEU:
			return "Feu vert";
		case ESSENCE:
			return "Essence";
		case ACCIDENT:
			return "Reparation";
		case CREVAISON:
			return "Roue de secours";
		default:
			break;
		
		}
		
		return super.toString();
			
	}
}
