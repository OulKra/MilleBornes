package Jeu;

import java.util.*;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	
	Carte[] cartes;
	int nombre_carte;
	int indiceIterateur = 0;
	boolean nextEffectue = false;
	
	public Sabot(int capacite) {
		nombre_carte = 0;
		cartes = new Carte[capacite];
	}
	
	public Boolean estVide()
	{
		return this.nombre_carte == 0;
	}
	
	private void ajouterCarte(Carte c) throws ArrayIndexOutOfBoundsException{
		try {
			cartes[nombre_carte] = c;
			nombre_carte++;
		}catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("[ajouterCarte] Capacité du tableau dépassé");
		}
	}
	
	public void ajouterFamilleCarte(Carte c) throws ArrayIndexOutOfBoundsException{
		try {
			for (int i = 0; i < c.getNombre(); i++) {
				ajouterCarte(c);
			}
			
		}catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("[ajouterFamilleCarte(Carte c)] Capacité du tableau dépassé");
		}
	}
	
	public void ajouterFamilleCarte(Carte... c) throws ArrayIndexOutOfBoundsException{
		try {
			for (Carte carte : c) {
				ajouterFamilleCarte(carte);				
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("[ajouterFamilleCarte(Carte... c)] Capacité du tableau dépassé");
		}
	}
	
	public Carte piocher() {
		
		Iterator<Carte> iterator = iterator();
		Carte carte = iterator.next();
		
		iterator.remove();
		
		return carte;
	}
	
	@Override
    public Iterator<Carte> iterator() {
        return new SabotIterator();
    }
	
	private class SabotIterator implements Iterator<Carte> {
        
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
}
