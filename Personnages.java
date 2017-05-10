package gestionDesPersonnages;

import java.io.File;
import java.util.ArrayList;

public class Personnages {
	private ArrayList<Personnage> personnages;
	
	public Personnages() {
		personnages = new ArrayList<Personnage>();
	}
	
	public void ajouter(Personnage personnage) {
		personnages.add(personnage);
	}
	
	public void supprimer(Personnage personnage) {
		personnages.remove(personnage);
	}
	
	public void presenter() {
		Personnage personnage = null;
		for (Personnage i: this.personnages) {
			personnage = i;
			personnage.presenter();
		}
	}
	
	public void sauvegarder() {
		Personnage personnage = null;
		for (Personnage i: this.personnages) {
			personnage = i;
			personnage.sauvegarder("" + personnage.getID());
		}
	}
	
	public void tester() {
		Personnage personnage = null;
		for (Personnage i: this.personnages) {
			personnage = i;
			System.out.print(personnage);
		}
	}
	
	public String[] lire() {
		File file = null;
		String[] paths=null;
		
		try {
			file = new File("./common");
			paths = file.list();
			return paths;
		} catch (Exception e) {
			e.printStackTrace();
			return paths;
		} 
	}
	
	public ArrayList<String> getListNoms() {
		ArrayList<String> str = new ArrayList<String>();
		Personnage personnage = null;
		for (Personnage i: this.personnages) {
			personnage = i;
			str.add(personnage.getNomSpecial());
		}
		return str;
	}
}
