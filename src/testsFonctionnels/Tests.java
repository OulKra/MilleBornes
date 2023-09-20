package testsFonctionnels;

import cartes.Attaque;
import Jeu.Sabot;
import cartes.*;
import cartes.Probleme.Type;

public class Tests {

	public static void main(String[] args) {
		Carte accident = new Attaque(3, Type.ACCIDENT);
		Carte reparation = new Parade(6, Type.ACCIDENT);
		Carte asDuVolant = new Botte(1, Type.ACCIDENT);

		Sabot sabot = new Sabot(10);
		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);
		
		while(sabot.hasNext())
		{
			System.out.println("Je pioche " + sabot.next().toString());
		}
		
	}

}
