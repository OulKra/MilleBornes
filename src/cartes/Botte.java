package cartes;

public class Botte extends Probleme {

	public Botte(int n, Type t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		switch(super.getType()){
		case FEU:
			System.out.println("Carte Vehicule prio");
			break;
		case ESSENCE:
			System.out.println("Carte Citerne d'essence");
			break;
		case ACCIDENT:
			System.out.println("Carte As du volant");
			break;
		case CREVAISON:
			System.out.println("Carte Increvable");
			break;
		default:
			break;
		
		}
		
		return super.toString();
			
	}

}
