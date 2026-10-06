package personnages;

public class Druide {
	private String nom;
	private int force;
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	private void fabriquerPotion(int quantite, int forcePotion) {
		// TODO Auto-generated method stub
	}
	
	private void booster(Gaulois gaulois) {
		// TODO Auto-generated method stub
	}

	public String getNom() {
		return nom;
	}
}
