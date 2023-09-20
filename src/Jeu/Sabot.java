package Jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterator<Carte>{
	
	Carte[] cartes;
	int nombre_carte;
	int indiceIterateur = 0;
	boolean nextEffectue = false;
	public Sabot(int capacite) {
		this.nombre_carte = capacite;
		cartes = new Carte[capacite];
	}
	
	public Boolean estVide()
	{
		return cartes.length == 0;
	}
	
	private void ajouterCarte(Carte c) throws ArrayIndexOutOfBoundsException{
		try {
			cartes[nombre_carte] = c;
			nombre_carte++;
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Capacité du tableau dépassée");
		}
	}
	
	public void ajouterFamilleCarte(Carte c) throws ArrayIndexOutOfBoundsException{
		try {
			for (int i = 0; i < c.getNombre(); i++) {
				ajouterCarte(c);
			}
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Capacité du tableau dépassée");
		}
	}
	
	public void ajouterFamilleCarte(Carte... c) throws ArrayIndexOutOfBoundsException{
		try {
			for (Carte carte : c) {
				for (int i = 0; i < carte.getNombre(); i++) {
					ajouterCarte(carte);
				}
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Capacité du tableau dépassée");
		}
	}

	@Override
	public boolean hasNext() {
		return indiceIterateur < nombre_carte;
	}

	@Override
	public Carte next() {
		if(hasNext()) {
			Carte carte = cartes[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			return carte;
		} else {
			throw new NoSuchElementException();
		}
		
	}

	@Override
	public void remove() {
		if(nombre_carte < 1 || !nextEffectue) {
			throw new IllegalStateException();
		}
		
		for (int i = indiceIterateur -1; i < nombre_carte-1; i++) {
			cartes[i] = cartes[i+1];
		}
		nextEffectue = false;
		indiceIterateur--;
		nombre_carte--;
	}

}
