package village_gaulois;

import objets.Equipement;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee ++;
	}
	
	public String extraireInstructionsOCaml() {
	    String instructions = "let musee = [\n";

	    for (int i = 0; i < nbTrophee; i++) {
	        instructions += "\"" + trophees[i].donnerNom()
	                + "\", \"" + trophees[i].getEquipement() + "\"";

	        if (i < nbTrophee - 1) {
	            instructions += ";\n";
	        } else {
	            instructions += "\n";
	        }
	    }

	    instructions += "]";
	    return instructions;
	}
}
