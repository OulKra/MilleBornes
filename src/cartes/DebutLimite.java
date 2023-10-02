package cartes;

public class DebutLimite extends Limite {

	int lim;

	public DebutLimite(int n) {
		super(n);
		lim = n;
		// TODO Auto-generated constructor stub
	}

	public String toString() {

		return "Début limite : " + lim + "km/h";

	}

	public boolean equals(Object obj) {
		return obj instanceof DebutLimite;
	}
}
