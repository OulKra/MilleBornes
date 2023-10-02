package testsFonctionnels;

import java.util.Iterator;

import Jeu.Sabot;
import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Probleme.Type;

public class Tests {

	public static void main(String[] args) {
		Carte accident = new Attaque(3, Type.ACCIDENT);
		Carte reparation = new Parade(3, Type.ACCIDENT);
		Carte asDuVolant = new Botte(1, Type.ACCIDENT);

		Sabot sabot = new Sabot(10);
		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);

		System.out.println("[TEST AVEC PIOCHER]");

		while (Boolean.FALSE.equals(sabot.estVide())) {
			Carte top = sabot.piocher();

			System.out.println("Je pioche " + top.toString());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("[TEST AVEC ITERATOR]");

		sabot = new Sabot(7);
		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);

		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			System.out.println("Je pioche " + iterator.next().toString());
			iterator.remove();
		}

		System.out.println("");
		System.out.println("");
		System.out.println("[TEST AVEC PIOCHER + AJOUT]");

		sabot = new Sabot(7);
		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);

		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			System.out.println("Je pioche " + carte.toString());
			iterator.remove();

//			sabot.ajouterFamilleCarte(asDuVolant);
//			sabot.piocher();
		}
	}
}
