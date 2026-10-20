package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 1;
		int force_debut = force;
		force -= forceCoup;
		if (force <= 0) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe.");
		}
		assert force < force_debut;
		assert isInvariantVerified();
	}

	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 0 :
			equipements[nbEquipement] = equipement;
			nbEquipement ++;
			System.out.println("Le soldat " + nom + " s'équipe avec "
					+ equipement + " !");
			break;
			
		case 1 :
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà "
					+ equipement + " !");
			} else {
				equipements[nbEquipement] = equipement;
				nbEquipement ++;
				System.out.println("Le soldat " + nom + " s'équipe avec "
					+ equipement + " !");
			}
			break;
		
			default :
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

