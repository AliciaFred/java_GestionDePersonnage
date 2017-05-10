package gestionDesPersonnages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gestion {
	
	private Personnages personnages;

	public Gestion() {
		
		
		
		Personnages donnePersonnel = new Personnages();
		String[] paths = donnePersonnel.lire();
		Personnage personnage = null;
		
		BufferedReader f=null;
		String ligne = null;
		
		Propriete propriete=null;
		
		String nom;
		
		for (String fichier: paths) {
			try {
				f = new BufferedReader(new FileReader("./common/" + fichier));
				ligne = f.readLine();
				
				nom = ligne.split(";")[1];
				personnage = new Personnage(nom);
				while ((ligne = f.readLine()) != null) {
					if (ligne.compareTo("---------- ----------") == 0) {
						ligne = f.readLine();
						propriete = new Propriete(ligne);
					} else if (ligne.compareTo("**********  ********** **********") == 0) {
						break;
					} else {
					propriete.ajouter(ligne);
					}
				}
				
				personnage.mettreC(propriete.getCle(), propriete);
				
			} catch (IOException e) {
				e.getMessage();
			} 
			
			donnePersonnel.ajouter(personnage);
		}

		this.personnages = donnePersonnel;
	}
	
	public Personnages getPersonnages() {
		return this.personnages;
	}

}
