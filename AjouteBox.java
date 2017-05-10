package gestionDesPersonnages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AjouteBox extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton finir;
	private JTextField NOM, saisieNom;
	private GridBagLayout layout;
	private Propriete prop;
	private GridBagConstraints s;
	private Personnage personnage;
	
	public AjouteBox(JFrame fenetre) {
		super(fenetre, "Ajouter un personnage", true);
	 	this.setVisible(false);	
	 	this.setSize(500, 300);	
	 	this.setLocation(250, 250);	
	 	layout = new GridBagLayout();
	 	this.setLayout(layout); 
	 	NOM = new JTextField("NOM",15);
	 	this.add(NOM);
	 	saisieNom = new JTextField(15);
	 	this.add(saisieNom);
	 	finir = new JButton("Finir");	
	 	finir.addActionListener(this);	
	 	finir.setActionCommand("FINIR");
	 	this.add(finir);
	 	s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(NOM, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(saisieNom, s);	
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(finir, s);
	}
	
	public Propriete getProp() {
		return this.prop;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch (action) {
		case "FINIR": {
			String cle = NOM.getText();
			personnage = new Personnage(cle);
			String val = saisieNom.getText();
			prop = new Propriete(cle);
			prop.ajouter(val);
			personnage.mettreC(prop.getCle(), prop);
			this.setVisible(false);
			break;
		}
		}
		
	}

}
