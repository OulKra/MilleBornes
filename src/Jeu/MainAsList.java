package Jeu;

import java.util.*;

import cartes.Carte;

public class MainAsList implements Main{
	
	List<Carte> listeMain = new ArrayList<>();
	
	
	@Override
	public void prendre(Carte carteAAjouter) {
		listeMain.add(carteAAjouter);
		
	}

	@Override
	public void jouer(Carte carteASupprimer) {
		assert listeMain.contains(carteASupprimer);
		
		ListIterator<Carte> iterator = listeMain.listIterator();
		Carte carte = (Carte) iterator.next();
		while(!carte.equals(carteASupprimer))
			carte = (Carte) iterator.next();
		carte = (Carte) iterator.next();
		iterator.remove();
		assert !listeMain.contains(carteASupprimer);		
	}

}
