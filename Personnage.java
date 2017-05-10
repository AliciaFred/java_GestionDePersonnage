package gestionDesPersonnages;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Personnage {
	private int id = 0;
	private String nom_spe;
	private TreeMap<String, Propriete> caracteristique;
	
	public Personnage(String nom) {
		Propriete initial = new Propriete("Nom");
		initial.ajouter(nom);
		this.nom_spe = nom;
		caracteristique = new TreeMap<String, Propriete>();
		caracteristique.put(initial.getCle(), initial);
		this.id++;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void mettreC(String cle, Propriete valeur) {
		caracteristique.put(cle, valeur);
	}
	
	public void supprimerC(String cle) {
		caracteristique.remove(cle);
	}
	
	public void presenter() {
		System.out.println(id);
			
		for (Propriete prop: caracteristique.values()) {
			prop.presenter();
			System.out.println("---------- ----------");
		}
		
		System.out.println("**********  ********** **********");
	}
	
	public void sauvegarder(String fichier) {
		PrintWriter f =null;
		try {
			f = new PrintWriter(new FileWriter("./common/" + fichier));
		} catch (IOException e) {
			System.err.println("erreur en ouverture du fichier" + e.getMessage());
			System.exit(1);
		}
		System.out.println(this.id);
		f.println(this.id + ";" + nom_spe);
		for (Propriete prop: caracteristique.values()) {
			System.out.println("---------- ----------");
			f.println("---------- ----------");
			System.out.println(prop.getCle());
			f.println(prop.getCle());
			Object valeur = null;
			for (Object integ: prop.getValeurs()) {
				valeur = integ;
				System.out.println(valeur);
				f.println(valeur);
			}
		}
		System.out.println("**********  ********** **********");
		f.println("**********  ********** **********");
		f.close();
	}
	
	public String getNomSpecial() {
		return this.nom_spe;
	}
}
