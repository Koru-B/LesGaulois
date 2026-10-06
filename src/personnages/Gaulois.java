package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoir de " 
				+ nomRomain);
		int forceCoup = (force*effetPotion)/3;
		romain.recevoirCoup(forceCoup);
		if (effetPotion > 1) {
			effetPotion--;
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
}
