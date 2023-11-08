package cartes;

import java.util.*;
import cartes.Probleme.Type;
import utils.Utils;

public class JeuDeCartes {

	Carte[] typesDeCartes = { new Botte(1, Type.ACCIDENT), new Botte(1, Type.ESSENCE), new Botte(1, Type.FEU),
			new Botte(1, Type.CREVAISON), new Attaque(5, Type.FEU), new DebutLimite(4), new Attaque(3, Type.ACCIDENT),
			new Attaque(3, Type.CREVAISON), new Attaque(3, Type.ESSENCE), new Parade(14, Type.FEU), new FinLimite(6),
			new Parade(6, Type.ACCIDENT), new Parade(6, Type.CREVAISON), new Parade(6, Type.ESSENCE), new Borne(10, 25),
			new Borne(10, 50), new Borne(10, 75), new Borne(12, 100), new Borne(4, 200) };

	ArrayList<Carte> listCarte = new ArrayList<>();

	public ArrayList<Carte> getListCarte(){
		return listCarte;
	}
	
	public Carte[] getTypesDeCartes(){
		return typesDeCartes;
	}
	
	public int compteNbrCarte(Carte carte) {
		return carte.getNombre();
	}
	
	public JeuDeCartes() {

		for(Carte carte : typesDeCartes) {
			if(carte instanceof Attaque a) {
				for (int i = 0; i < compteNbrCarte(a); i++) {
					listCarte.add(a);
				}
			}
			
			if(carte instanceof Parade p) {
				for (int i = 0; i < compteNbrCarte(p); i++) {
					listCarte.add(p);
				}
			}
			
			if(carte instanceof Botte b) {
				for (int i = 0; i < compteNbrCarte(b); i++) {
					listCarte.add(b);
				}
			}
			
			if(carte instanceof DebutLimite dl) {
				for (int i = 0; i < compteNbrCarte(dl); i++) {
					listCarte.add(dl);
				}
			}
			
			if(carte instanceof FinLimite fl) {
				for (int i = 0; i < compteNbrCarte(fl); i++) {
					listCarte.add(fl);
				}
			}
			
			if(carte instanceof Borne b) {
				for (int i = 0; i < compteNbrCarte(b); i++) {
					listCarte.add(b);
				}
			}
		}
		
		Utils.melanger(listCarte);
	}
}
