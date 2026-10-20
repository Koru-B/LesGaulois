package objets;

public enum Equipement {
	CASQUE("un casque"), BOUCLIER("un bouclier");
	
	private String nom;

	Equipement(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
