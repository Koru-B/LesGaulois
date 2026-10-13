package village_gaulois;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private int capaciteMax;
	private Gaulois[] villageois;
	
	public Village(String nom, Gaulois chef, final int NB_VILLAGEOIS_MAX) {
		super();
		this.nom = nom;
		this.chef = chef;
		this.capaciteMax = NB_VILLAGEOIS_MAX;
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		
		chef.setVillage(this);
	}

	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < capaciteMax) {
			villageois[nbVillageois] = gaulois;
			nbVillageois ++;
			gaulois.setVillage(this);
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois > nbVillageois || numVillageois < 1) {
			System.out.println("In n'y a pas autant d'habitants dans notre village !");
			return null;
		} else {
			Gaulois personne = villageois[numVillageois - 1];
			return personne;
		}
	}
	
	public int afficherVillage() {
		return nbVillageois;
	}
	
	private void afficherVillageois() {
		System.out.println("Dans le village \"" + nom + "\" du chef " + 
				chef + " vivent des légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(" - " + trouverVillageois(i + 1));
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		
		village.trouverVillageois(30);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}
