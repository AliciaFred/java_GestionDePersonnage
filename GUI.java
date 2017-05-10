package gestionDesPersonnages;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Confirmation confirmation;
	private AjouteBox ajoutebox;
	private Gestion gestion;
	private JTextField saisieNom;
	private int id;
	
	public static void main(String[] args) {
		GUI gui = new GUI();
	}

	public GUI() {
		super("Gestion de Personnages");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		confirmation = new Confirmation(this);
		
		init();
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	public void init() {
		JButton ajouter = new JButton("Ajouter un personnage");
		ajouter.addActionListener(this);
		ajouter.setActionCommand("AJOUTERP");
		ajoutebox = new AjouteBox(this);
		
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(this);
		enregistrer.setActionCommand("ENREGISTRER");
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(this);
		supprimer.setActionCommand("SUPPRIMER");
		
		JPanel j4 = new JPanel();
		
		gestion = new Gestion();
		ArrayList<String> str = gestion.getPersonnages().getListNoms();
		id = str.size();
		String[] string = new String[id];
		for (int i=0; i<str.size();i++) {
			string[i] = str.get(i);
		}
			
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox j5 = new JComboBox(string);
		
		saisieNom = new JTextField();
		
		JButton search = new JButton("Recherche");
		search.addActionListener(this);
		search.setActionCommand("RECHERCHE");
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList j8 = new JList(string);
		JTextArea j9 = new JTextArea();
		j9.setBackground(Color.PINK);
		
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		JMenuItem fin = new JMenuItem("Quitter");
		fin.addActionListener(this);
		fin.setActionCommand("FIN");
		
		JMenu menu = new JMenu("Fichier");
		menu.add(fin);
		
		JMenuItem ajouterMenu = new JMenuItem("Ajouter un personnage");
		ajouterMenu.addActionListener(this);
		ajouterMenu.setActionCommand("AJOUTERP");
		menu.add(ajouterMenu);

		JMenuItem enregistrerMenu = new JMenuItem("Enregistrer les données");
		enregistrerMenu.addActionListener(this);
		enregistrerMenu.setActionCommand("ENREGISTRER");
		menu.add(enregistrerMenu);
		
		JMenuItem supprimerMenu = new JMenuItem("Supprimer un personnage");
		supprimerMenu.addActionListener(this);
		supprimerMenu.setActionCommand("SUPPRIMER");
		menu.add(supprimerMenu);
		
		JMenuItem viderMenu = new JMenuItem("Vider les données");
		viderMenu.addActionListener(this);
		viderMenu.setActionCommand("VIDER");
		menu.add(viderMenu);
		
		JMenuBar barre = new JMenuBar();
		barre.add(menu);		
		this.setJMenuBar(barre);
		
		this.add(ajouter);
		this.add(enregistrer);
		this.add(supprimer);
		this.add(j4);
		this.add(j5);
		this.add(saisieNom);
		this.add(search);
		this.add(j8);
		this.add(j9);
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(ajouter, s);
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(enregistrer, s);
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(supprimer, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j4, s);
		s.gridwidth = 2;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(j5, s);
		s.gridwidth = 4;
		s.weightx = 1;
		s.weighty = 0;
		layout.setConstraints(saisieNom, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(search, s);
		s.gridwidth = 2;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(j8, s);
		s.gridwidth = 5;
		s.weightx = 0;
		s.weighty = 1;
		layout.setConstraints(j9, s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.compareTo("FIN") == 0) {
			confirmation.setVisible(true);
		}
		
		switch (action) {
		case "RECHERCHE": {
			String nomRechercher = saisieNom.getText();
			break;
		}
		case "AJOUTERP": {
			ajoutebox.setVisible(true);
			break;
		}
		case "SUPPRIMER": {
			break;
		}
		}
		
	}
	
}
	