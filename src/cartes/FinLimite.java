package cartes;

public class FinLimite extends Limite {

	int lim;

	public FinLimite(int n) {
		super(n);
		lim = n;
		// TODO Auto-generated constructor stub
	}

	public String toString() {

		return "Fin limite : " + lim + "km/h";

	}

	public boolean equals(Object obj) {
		return obj instanceof FinLimite;
	}
}
