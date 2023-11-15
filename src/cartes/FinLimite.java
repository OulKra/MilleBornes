package cartes;

public class FinLimite extends Limite {

	int lim;

	public FinLimite(int n) {
		super(n);
		lim = n;
		super.finLimite = true;
	}

	public String toString() {

		return "Fin limite : " + lim + "km/h";

	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FinLimite fin) {
			return fin.getfinLimite() == this.getfinLimite();
		}

		return false;
	}
}
