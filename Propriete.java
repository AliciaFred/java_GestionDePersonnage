package gestionDesPersonnages;

import java.util.ArrayList;

public class Propriete {
	private String cle;
	private ArrayList<Object> valeurs;
	
	public Propriete(String cle) {
		this.cle = cle;
		valeurs = new ArrayList<Object>();
	}
	
	public void ajouter(Object valeur) {
		valeurs.add(valeur);
	}
	
	public void supprimer(int indexValeur) {
		valeurs.remove(indexValeur);
	}
	
	public void vider() {
		valeurs.clear();
	}
	
	public String getCle() {
		return this.cle;
	}
	
	public ArrayList<Object> getValeurs() {
		return this.valeurs;
	}
	
	public void presenter() {
		System.out.println(cle);
		Object valeur = null;
		for (Object integ: this.valeurs) {
			valeur = integ;
			System.out.println(valeur);
		}
	}

}
