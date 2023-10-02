package cartes;

import java.util.List;

import cartes.Probleme.Type;

public class JeuDeCartes {

	Carte[] typesDeCartes = { new Botte(1, Type.ACCIDENT), new Botte(1, Type.ESSENCE), new Botte(1, Type.ACCIDENT),
			new Botte(1, Type.CREVAISON), new Attaque(5, Type.FEU), new DebutLimite(4), new Attaque(3, Type.ACCIDENT),
			new Attaque(3, Type.CREVAISON), new Attaque(3, Type.ESSENCE), new Parade(14, Type.FEU), new FinLimite(6),
			new Parade(6, Type.ACCIDENT), new Parade(6, Type.CREVAISON), new Parade(6, Type.ESSENCE), new Borne(10, 25),
			new Borne(10, 50), new Borne(10, 75), new Borne(12, 100), new Borne(4, 200) };

	List<Carte> listCarte = List<>();

	public JeuDeCartes() {

	}
}
