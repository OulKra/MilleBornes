package testsFonctionnels;

import java.util.Iterator;

import Jeu.Sabot;
import cartes.*;
import cartes.Probleme.Type;

public class Tests {
	
	
	public static void main(String[] args) {
		Carte accident = new Attaque(3, Type.ACCIDENT);
		Carte reparation = new Parade(3, Type.ACCIDENT);
		Carte asDuVolant = new Botte(1, Type.ACCIDENT);

		Sabot sabot = new Sabot(7);
		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);
		
		
		
		System.out.println("[TEST AVEC PIOCHER]");
		
		for(Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();)
		{
			Carte top = sabot.piocher();
			
			System.out.println("Je pioche " + top.toString());		
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("[TEST AVEC ITERATOR]");

		sabot = new Sabot(7);
		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);
				
		for(Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();)
		{
			System.out.println("Je pioche " + iterator.next().toString());
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("[TEST AVEC PIOCHER + AJOUT]");

		sabot = new Sabot(7);
		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);
		
		
		for(Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext(); iterator.next())
		{
			Carte top = sabot.piocher();
			System.out.println("Je pioche " + top.toString());
			sabot.ajouterFamilleCarte(reparation);
		}
	}

}
