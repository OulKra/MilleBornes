package Jeu;

import java.util.*;

import cartes.Borne;
import cartes.Carte;

public class Joueur <E extends Carte> {
	
	List<E> pileLimiteFin = new ArrayList<>();
	List<E> pileBataille = new ArrayList<>();
	List<E> pileBorne = new ArrayList<>();
	List<E> pileBotte = new ArrayList<>();

	String nom;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur j) {
			return j.getNom() == this.getNom();
		}
		return false;
	}
}
