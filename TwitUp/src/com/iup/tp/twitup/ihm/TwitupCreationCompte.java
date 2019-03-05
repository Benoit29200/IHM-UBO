package com.iup.tp.twitup.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TwitupCreationCompte extends JPanel{
	
	TwitupCreationCompte() {
		
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		JPanel creation = createJPanel(screenSize);
		
	    add(creation);
	    add(new JButton("Créer mon compte"));
	}

	private JPanel createJPanel(Dimension screenSize) {
		JPanel creation = new JPanel();
		JLabel nom = new JLabel("Votre nom");
		nom.setVisible(true);
		JTextField nomText = new JTextField("");
		nomText.setPreferredSize(new Dimension(screenSize.width/22, screenSize.height/22));
		creation.add(nom);
		creation.add(nomText);
		return creation;
	}

}
