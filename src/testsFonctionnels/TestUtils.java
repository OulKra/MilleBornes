package testsFonctionnels;

import java.util.*;

import cartes.*;
import utils.Utils;

public class TestUtils {
	
	public static <E> int compte(E elem, List<E> list) {
		int nombre = 0;
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			E e = (E) iterator.next();
			if(e == elem) {
				nombre++;
			}
			
		}
		
		return nombre;
	}
	
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListCarte();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println("Pas m�lang�" + listeCartes);
		
		listeCartes = Utils.melanger(listeCartes);
		System.out.println("M�lang� " + listeCartes);
		System.out.println("liste m�lang�e sans erreur ? "
		+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println("Rassembl� " + listeCartes);
		for (int i = 0; i < listeCartes.size(); i++) {
			System.out.println(listeCartes.get(i));
		}
		
		System.out.println("liste rassembl�e sans erreur ? " + Utils.verifierRassemblement(listeCartes));
		
		boolean bonneFrequence = true;
		for (Iterator iterator = listeCartes.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if(! (compte(carte, listeCartes) == compte(carte, listeCarteNonMelangee))) {
				bonneFrequence = false;
			}
		}
		if(bonneFrequence) {
			System.out.println("Le nombre d'occurences de chaque carte est respect� dans le jeu melang� : " + bonneFrequence);
		}

	}
}
