package testsFonctionnels;

import java.util.Iterator;

import Jeu.Joueur;
import cartes.*;
import cartes.Probleme.Type;

public class TestJoueur {
	public static void main(String[] args) {
		Borne borne1 = new Borne(1, 50);
		Borne borne2 = new Borne(1, 50);
		Borne borne3 = new Borne(1, 25);
		
		Joueur joueur = new Joueur("Moi");
		joueur.donner(borne1);
		joueur.donner(borne2);
		joueur.donner(borne3);
		
		//TEST BORNE
		
		int bornes = joueur.getKM();
		if(bornes == (borne1.getKm() + borne2.getKm() + borne3.getKm()))
			System.out.println("true : La quantité de borne parcourue est correcte");
		else 
			System.out.println("false : La quantité de borne parcourue n'est pas correcte");
		
		//TEST LIMITE
		
		DebutLimite debutLimite = new DebutLimite(1);
		FinLimite finLimite = new FinLimite(1);
		
		if(joueur.getLimite() == 200)
			System.out.println("true : La limite est correcte quand le joueur n'est pas limité");
		else
			System.out.println("false : Quand le joueur n'a pas de limite, il est quand même limité");
	
		joueur.donner(debutLimite);
		if(joueur.getLimite() == 50)
			System.out.println("true : La limite est correcte quand le joueur est limité");
		else
			System.out.println("false : Quand le joueur a une limite, il n'est quand même pas limité");
	
		joueur.donner(finLimite);
		if(joueur.getLimite() == 200)
			System.out.println("true : La limite est correcte quand le joueur n'est pas limité");
		else
			System.out.println("false : Quand le joueur n'a pas de limite, il est quand même limité");
		
		joueur.donner(debutLimite);
		Botte prio = new Botte(1, Type.FEU);
		joueur.donner(prio);
		if(joueur.getLimite() == 200)
			System.out.println("true : La limite est correcte quand le joueur est prio");
		else
			System.out.println("false : Le joueur est limité alors qu'il est prio");
	
	}
}
