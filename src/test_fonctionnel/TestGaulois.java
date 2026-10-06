package test_fonctionnel;

import objets.Chaudron;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		Romain minus = new Romain("Minus", 6);
		Romain brutus = new Romain("Brutus", 14);
		Druide panoramix = new Druide("Panoramix", 2);
		Chaudron chaudron = new Chaudron(20, 1);
		
		asterix.parler("Bonjour " + obelix.getNom());
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		System.out.println("Dans la forêt, Astérix et Obélix tombent nez à nez "
				+ "sur le romain Minus.");
		for (int i = 0; i < 3; i++) {
			asterix.frapper(minus);
		}
		
		panoramix.fabriquerPotion(4, 3, chaudron);
		panoramix.booster(obelix, chaudron);
		panoramix.booster(asterix, chaudron);
		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
		}
	}
}
