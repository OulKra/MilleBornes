package cartes;

public class DebutLimite extends Limite {

	int lim;
	
	public DebutLimite(int n) {
		super(n);
		lim = n;
		super.finLimite = false;
		// TODO Auto-generated constructor stub
	}

	public String toString() {

		return "Début limite : " + lim + "km/h";

	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FinLimite fin) {
			return fin.getfinLimite() == this.getfinLimite();
		}

		return false;
	}
}
