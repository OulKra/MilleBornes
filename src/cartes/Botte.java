package cartes;

public class Botte extends Probleme {

	public Botte(int n, Type t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		switch(super.getType()){
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
		
		return null;
			
	}

}
