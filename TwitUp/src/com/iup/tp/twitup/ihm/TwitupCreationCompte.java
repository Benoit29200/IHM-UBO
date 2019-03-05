package com.iup.tp.twitup.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TwitupCreationCompte extends JPanel{
	
	JButton creationcompteJButton = new JButton("Créer mon compte");
	
	TwitupCreationCompte() {
		
		setLayout(new BorderLayout());
		
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		JPanel userCreation = setCreationPanel(screenSize);
		
		userCreation.setBorder(BorderFactory.createTitledBorder("Vive le roi Benoît"));
		
	    add(userCreation,BorderLayout.CENTER);
	}

	private JPanel setCreationPanel(Dimension screenSize) {
		JPanel userCreation = new JPanel();
		userCreation.setLayout(new GridLayout(5,1));
		JPanel creation = createJPanel(screenSize,"Votre nom :");
		userCreation.add(creation);
		creation = createJPanel(screenSize,"Votre pseudo:");
		userCreation.add(creation);
		creation = createJPanel(screenSize,"Votre mot de passe :");
		userCreation.add(creation);
		creation = createJPanel(screenSize,"Confirmation mot de passe :");
		userCreation.add(creation);
	    creation = new JPanel();
	    creation.add(creationcompteJButton);
	    userCreation.add(creation);
		return userCreation;
	}

	private JPanel createJPanel(Dimension screenSize, String titreLabel) {
		JPanel creation = new JPanel();
		JLabel nom = new JLabel(titreLabel);
		JTextField nomText = new JTextField("");
		nomText.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		creation.add(nom);
		creation.add(nomText);
		return creation;
	}

}
