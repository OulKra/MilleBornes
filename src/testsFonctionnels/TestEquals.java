package testsFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Probleme.Type;

public class TestEquals {

	public static void main(String[] args) {
		Carte accident = new Attaque(3, Type.ACCIDENT);
		Carte accident2 = new Attaque(3, Type.ACCIDENT);
		Carte asDuVolant = new Botte(1, Type.ACCIDENT);

		if (accident.equals(accident2)) {
			System.out.println("[Test validé] Equals -> true entre accident et accident2");
		} else {
			System.out.println("[Test pas validé] Equals -> false entre accident et accident2");
		}

		if (!accident.equals(asDuVolant)) {
			System.out.println("[Test validé] Equals -> false entre accident et asDuVolant");
		} else {
			System.out.println("[Test pas validé] Equals -> true entre accident et asDuVolant");
		}

	}

}
