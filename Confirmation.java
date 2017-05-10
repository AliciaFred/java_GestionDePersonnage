package gestionDesPersonnages;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Confirmation extends JDialog implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton oui, non;	
	
	public Confirmation(JFrame fenetre)	
	{	
	 	super(fenetre, "Confirmation", true);	
	 	this.setVisible(false);	
	 	this.setSize(300, 100);	
	 	this.setLocation(250, 250);	
	 	this.setLayout(new FlowLayout()); 	 		
	 	oui = new JButton("Oui");	
	 	oui.addActionListener(this);	
	 	oui.setActionCommand("OUI");	
	 	this.add(oui); 	 		
	 	non = new JButton("Non");	
	 	non.addActionListener(this);	
	 	non.setActionCommand("NON");	
	 	this.add(non);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String evenement = e.getActionCommand();	
	 		
 	 	switch(evenement)	
 	 	{	
 	 	case "OUI":	
 	 	{	
 	 	 	System. exit(0);	
 	 	 	break;	
 	 	}	
 	 	case "NON":	
 	 	{ 	 	 		
 	 	 	this.setVisible(false);	
 	 	 	break;	
 	 	}	
 	 	default:	
 	 	{	
 	 	 	System. err.println("cas non prévu");	
 	 	}	
 	 	}			
	}
}