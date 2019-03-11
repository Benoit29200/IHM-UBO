package com.iup.tp.twitup.ihm.background.ajoutBoutonsBordereau;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.iup.tp.twitup.common.Constants;

public class BoutonsDeconnexion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoutonsDeconnexion() {
		this.add(getButtonDeconnexion());
		this.setBackground(Color.white);
	}
	
	private JPanel getButtonDeconnexion() {
		JPanel monJPanel= new JPanel();
		monJPanel.setLayout(new GridBagLayout());
		monJPanel.setBackground(Color.white);
		JButton connexion = new JButton(Constants.DECONNEXION);
		monJPanel.add(connexion, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		return monJPanel;
	}
}
