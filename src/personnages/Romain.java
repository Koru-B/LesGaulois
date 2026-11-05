package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	public String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 1;
//		int force_debut = force;
//		force -= forceCoup;
//		if (force <= 0) {
//			force = 0;
//			parler("J'abandonne !");
//		} else {
//			parler("Aïe.");
//		}
//		assert force < force_debut;
//		assert isInvariantVerified();
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force <= 0) {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		} else {
			parler("Aïe");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 6;
				} else {
					resistanceEquipement += 3;
				}
			}
			texte += resistanceEquipement + "!";
		}
		
		if (resistanceEquipement >= forceCoup) {
			texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup
					+ "\nMais heureusement, grâce à mon équipement sa force a été complètement absorbée.";
		}
		
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup <= 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public int getForce() {
		return force;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec " + equipement + " !");
			break;

		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà " + equipement + " !");
			} else {
				equipements[nbEquipement] = equipement;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'équipe avec " + equipement + " !");
			}
			break;

		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);

		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
