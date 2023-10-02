package Jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

	Carte[] cartes;
	int nombreCarte = 0;
	int indiceIterateur = 0;
	int nombreOperations = 0;
	boolean nextEffectue = false;

	public Sabot(int capacite) {
		cartes = new Carte[capacite];
	}

	public boolean estVide() {
		return nombreCarte == 0;
	}

	private void ajouterCarte(Carte carte) throws ArrayIndexOutOfBoundsException {
		try {
			cartes[nombreCarte] = carte;
			nombreOperations++;
			nombreCarte++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("[ajouterCarte] Taille du tableau atteind");
		}
	}

	public void ajouterFamilleCarte(Carte c) throws ArrayIndexOutOfBoundsException {
		try {
			for (int i = 0; i < c.getNombre(); i++) {
				ajouterCarte(c);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("[ajouterFamilleCarte(Carte c)] Taille du tableau atteind");
		}
	}

	public void ajouterFamilleCarte(Carte... c) throws ArrayIndexOutOfBoundsException {
		try {
			for (Carte carte : c) {
				ajouterFamilleCarte(carte);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("[ajouterFamilleCarte(Carte... c)] Taille du tableau atteind");
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

		int nombreOperationsReference = nombreOperations;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nombreCarte;
		}

		@Override
		public Carte next() {
			verifierConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}

		}

		private void verifierConcurrence() {
			if (nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}

		@Override
		public void remove() {
			verifierConcurrence();
			if (nombreCarte < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}

			nombreOperations++;
			nombreOperationsReference++;

			for (int i = indiceIterateur - 1; i < nombreCarte - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nombreCarte--;
		}
	}
}
