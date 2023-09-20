package Jeu;

import cartes.Carte;

public class Sabot implements Iterable<T>{
	
	Carte[] cartes;
	int nombre_carte;
	public Sabot(int capacite) {
		this.cartes = new Carte[capacite];
		this.nombre_carte = 0;
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
	
	private void ajouterFamilleCarte(Carte c) throws ArrayIndexOutOfBoundsException{
		try {
			for (int i = 0; i < c.getNombre(); i++) {
				cartes[nombre_carte] = c;
				nombre_carte++;
			}
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Capacité du tableau dépassée");
		}
	}
	
	private void ajouterFamilleCarte(Carte[] c) throws ArrayIndexOutOfBoundsException{
		try {
			for (Carte carte : c) {
				for (int i = 0; i < carte.getNombre(); i++) {
					cartes[nombre_carte] = carte;
					nombre_carte++;
				}
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Capacité du tableau dépassée");
		}
	}

}
