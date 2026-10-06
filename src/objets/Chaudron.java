package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public Chaudron(int quantitePotion, int forcePotion) {
		super();
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion() {
		return quantitePotion != 0;
	}
	
	public int prendreLouche() {
		return forcePotion;
	}
}
