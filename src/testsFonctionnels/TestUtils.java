package testsFonctionnels;

import java.util.*;

import cartes.*;
import utils.Utils;

public class TestUtils {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListCarte();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		/*listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));*/
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes);
		for (int i = 0; i < listeCartes.size(); i++) {
			System.out.println(listeCartes.get(i));
		}
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));

	}
}
