package testsFonctionnels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestAfficherJeu {

	public static void main(String[] args) {
		JeuDeCartes jeuDeCarte = new JeuDeCartes();
		
		ArrayList<Carte> JeuDeCarte = jeuDeCarte.getListCarte();
		Carte[] typesDeCartes = jeuDeCarte.getTypesDeCartes();
		
		for (int i = 0; i < JeuDeCarte.size(); i++) {
			System.out.println("Carte " + (i+1) + " : " + JeuDeCarte.get(i).toString());
		}
		
		System.out.println(" ");
		System.out.println(" ");

		boolean bonneFrequence = true;
		int i = 0;
		while(bonneFrequence  && i < typesDeCartes.length) {
			int frequenceReel = Collections.frequency(JeuDeCarte, typesDeCartes[i]);
			int frequenceSouhaite = typesDeCartes[i].getNombre();
			
			/*System.out.println("Carte " + (i+1) + " Frequence reel : " + frequenceReel
					+ " Frequence souhaité : " + frequenceSouhaite);*/
			
			if(frequenceReel != frequenceSouhaite) {
				bonneFrequence = false;
			}
			
			i++;
		}
		if(bonneFrequence) {
			System.out.println("La fréquence est bonne pour toutes les cartes");
		}
		else {
			System.out.println("La fréquence n'est pas bonne pour toutes les cartes");

		}

	}
}
