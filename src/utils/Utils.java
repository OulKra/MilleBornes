package utils;

import java.util.*;

public class Utils {
	
	public static <E> E extraire(List<E> liste) {
		
		Random r = new Random();
		int index = r.nextInt(liste.size());
		
		E elem = liste.get(index);
		liste.remove(index);
		return elem;		
	}

	public static <E> E extraireIterator(List<E> liste) {
		
		Iterator<E> iter = liste.iterator();
		Random r = new Random();
		int index = r.nextInt(liste.size());
		E elem = null;
		
		for (int i = 0; i < index; i++) {
			elem = iter.next();
		}
		
		iter.remove();

		return elem;		
	}
	
	public static <E> List<E> melanger(List<E> liste) {
		
		List<E> newListe = liste;
		for (int i = 0; i < newListe.size(); i++) { 
			E carte = extraire(newListe);
			newListe.add(i, carte);			
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
		
		List<E> newListe = liste;
		for (int i = 0; i < newListe.size(); i++) {
			E elem = newListe.get(i);
			int c = 0;
			for (int j = i; j < newListe.size(); j++) {
				if(newListe.get(j).equals(elem) && j != i) {
					E carte = newListe.get(j);
					newListe.remove(j);
					newListe.add(i + c, carte);
					c++;
				}
			}
		}
		return newListe;
	}
	
	public static <E> boolean verifierRassemblement(List<E> liste) {

        ListIterator<E> iterator1 = liste.listIterator();
        //ListIterator<E> iterator2 = liste.listIterator(liste.size());
    	ListIterator<E> iterator2 = liste.listIterator();

        int index1 = 0;
        int index2 = 0;
        E dernierElemIdentique = null; 

        while (iterator1.hasNext()) {
            E elem1 = iterator1.next();
            E elem2 = iterator2.next();
            
            if (dernierElemIdentique == null) {
                dernierElemIdentique = elem1;
                index1 = iterator1.nextIndex() ;
            } else if (!elem1.equals(dernierElemIdentique)) {
                while (iterator2.hasNext() /*.hasPrevious()*/) {
                    /*E elem2 = iterator2.previous();

                    if (elem2.equals(dernierElemIdentique) && index1 != index2) {
                        return false;
                    }
                    else {
                    	break;
                    }*/
                	
                	if (elem2.equals(dernierElemIdentique)) {
                        return false;
                    }
                	 else {
                     	break;
                     }
                }
            }
        }
        
        return true;
    }
	
	
}
