package Jeu;

import java.util.*;

import cartes.*;
import cartes.Probleme.Type;
import Jeu.Main;
public class Joueur {
	
	List<Limite> pileLimite = new ArrayList<>();
	List<Bataille> pileBataille = new ArrayList<>();
	List<Borne> pileBorne = new ArrayList<>();
	Set<Botte> pileBotte = new HashSet<>();

	String nom;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	MainAsList main = new MainAsList();
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur j) {
			return j.getNom() == this.getNom();
		}
		return false;
	}
	
	public boolean estBloque() {
		
		boolean cas1 = pileBataille.isEmpty() && estPrio();
		
		Parade parade = new Parade(1, Type.FEU);
		
		boolean cas2 = false;
		if(pileBataille.get(pileBataille.size()-1) instanceof Parade p) {
			cas2 = p.getType() == Type.FEU;
		}
		
		boolean cas3 = estPrio() && pileBataille.get(pileBataille.size()-1) instanceof Parade;

		boolean cas4 = false;
		if(pileBataille.get(pileBataille.size()-1) instanceof Attaque p) {
			cas4 = p.getType() == Type.FEU;
		}
		cas4 = cas4 && estPrio() ;

	
		Type sommet = pileBataille.get(pileBataille.size()-1).getType();
		
		boolean cas5 = false;
		
		for (Botte botte :pileBotte) {  
	          if(botte.getType() == sommet)
	        	  cas5 = true;
	        } 
		
		cas5 = estPrio();
		
		return cas1 || cas2 || cas3 || cas4 || cas5;
	}
	
	boolean estPrio() {
		Botte bottePrio = new Botte(1, Type.FEU);
		for (Botte botte :pileBotte) {  
	          if(botte.equals(bottePrio))
	        	  return true;
	        } 
		return false;
	}
	
	public int getLimite() {
		
		if(pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1).getfinLimite() || estPrio()) {
			return 200;
		}
		return 50;
	}
	
	public int getKM() {
		int borne = 0;
		for (Iterator iterator = pileBorne.iterator(); iterator.hasNext();) {
			Borne carte = (Borne) iterator.next();
			borne += carte.getKm();
		}
		return borne;
	}
	
	Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty())
			return null;
		Carte carte = sabot.get(0);
		sabot.remove(0);
		donner(carte);
		return carte;
	}
	
	public void donner(Carte carteADonner) {
		if(carteADonner instanceof Borne b) {
			pileBorne.add(b);
		} else if(carteADonner instanceof Bataille b) {
			pileBataille.add(b);
		} else if(carteADonner instanceof Limite b) {
			pileLimite.add(b);
		} else if(carteADonner instanceof Botte b) {
			pileBotte.add(b);
		}
		main.prendre(carteADonner);
		assert main.listeMain.contains(carteADonner);
	}
	
	public MainAsList getMain(){
		return this.main;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public List<Limite> getPileLimiteFin() {
		return pileLimite;
	}

	public List<Bataille> getPileBataille() {
		return pileBataille;
	}

	public List<Borne> getPileBorne() {
		return pileBorne;
	}

	public Set<Botte> getPileBotte() {
		return pileBotte;
	}
	
	public String toString() {
		return "Joueur " + nom;
	}

}
