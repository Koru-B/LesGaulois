package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	
	public Druide(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion, Chaudron chaudron) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une "
				+ "force de " + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois, Chaudron chaudron) {
		boolean contientPotion = chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();
		if (contientPotion) {
			if (nomGaulois == "Obélix") {
				parler("Non, " + nomGaulois + " Non !... Et tu le sais très bien !");
			} else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + nomGaulois + " un peu de potion magique.");
			}
		} else {
			parler("Désolé " + nomGaulois + " il n'y a plus de potion magique.");
		}
	}

	public String getNom() {
		return nom;
	}
}
