package com.iup.tp.twitup.ihm.fond.ajoutBoutonsBordereau;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.iup.tp.twitup.common.Constants;

public class BoutonsConnexionCreation extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;

	public BoutonsConnexionCreation() {
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.add(getButtonsCreationConnexion());
		this.setBackground(Color.white);
	}
	
	private JPanel getButtonsCreationConnexion() {
		JPanel monJPanel= new JPanel();
		monJPanel.setLayout(new GridBagLayout());
		monJPanel.setBackground(Color.white);
		JButton connexion = new JButton(this.fileLanguage.getObject(Constants.VIEW_CONNEXION_COMPTE).toString());
		JButton creation = new JButton(this.fileLanguage.getObject(Constants.VIEW_CREATION_COMPTE).toString());
		monJPanel.add(connexion, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		monJPanel.add(creation, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		return monJPanel;
	}

}
