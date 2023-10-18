package utils;

import java.util.*;

public class Utils {
	
	public static <E> E extraire(List<E> liste) {
		
		Random r = new Random();
		int index = r.nextInt(liste.size());
		
		E elem = (E) liste.get(index);
		liste.remove(index);
		return elem;		
	}

	public static <E> E extraireIterator(List<E> liste) {
		
		Iterator<?> iter = liste.iterator();
		Random r = new Random();
		int index = r.nextInt(liste.size());
		E elem = null;
		
		for (int i = 0; i < index; i++) {
			elem = (E) iter.next();
		}
		
		iter.remove();

		return elem;		
	}
	
	public static <E> List<E> melanger(List<E> liste) {
		
		List<E> newListe = liste;
		while(newListe.size() > 0) {
			extraire(newListe);
		}
		
		return newListe;
	}
	
	public static <E> boolean verifierMelange(List<E> liste1, List<E> liste2) {
		
		for (int i = 0; i < liste1.size(); i++) {
			int frequenceListe1 = Collections.frequency(liste1, liste1.get(i));
			int frequenceListe2 = Collections.frequency(liste2, liste1.get(i));
			if(frequenceListe1 != frequenceListe2) {
				System.out.println("Les listes n'ont pas le même nombre d'occurences pour"
						+ " chaque élément");
				return false;
			}

		}
		System.out.println("Les listes ont bien le même nombre d'occurences pour"
				+ " chaque élément");
		return true;
	}
	
	public static <E> List<E> rassembler(List<E> liste) {
		
		List<E> newListe = new ArrayList<>();
		for (int i = 0; i < liste.size(); i++) {
			E elem = liste.get(i);
			newListe.add(elem);
			for (int j = i; j < liste.size(); j++) {
				if(liste.get(j).equals(elem) && j != i) {
					newListe.add(liste.get(j));
				}
			}
		}
		
		return newListe;
	}
	
	public static <E> boolean verifierRassemblement(List<E> liste) {

        ListIterator<E> iterator1 = liste.listIterator();
        ListIterator<E> iterator2 = liste.listIterator(liste.size());
        
        E dernierElemIdentique = null; 

        while (iterator1.hasNext()) {
            E elem1 = iterator1.next();

            if (dernierElemIdentique == null) {
                dernierElemIdentique = elem1;
            } else if (!elem1.equals(dernierElemIdentique)) {
                while (iterator2.hasPrevious()) {
                    E elem2 = iterator2.previous();
                    if (elem2.equals(dernierElemIdentique)) {
                        dernierElemIdentique = elem2;
                        break;
                    } else {
                        return false; 
                    }
                }
            }
        }
        
        return true;
    }
	
	
}
