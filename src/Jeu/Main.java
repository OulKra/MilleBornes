package Jeu;

import cartes.Carte;

import java.util.*;

public interface Main {
	
	public Iterator<Carte> iterator = null;

	void prendre(Carte c);
	
	void jouer(Carte c);
}
