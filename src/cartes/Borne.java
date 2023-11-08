package cartes;

public class Borne extends Carte {

	private int km;

	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}

	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		return km + " bornes";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne borne) {
			return borne.getKm() == this.getKm();
		}

		return false;
	}

}
