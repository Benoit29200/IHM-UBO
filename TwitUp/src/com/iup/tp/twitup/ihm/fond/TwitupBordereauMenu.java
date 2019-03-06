package com.iup.tp.twitup.ihm.fond;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.ihm.fond.ajoutBoutonsBordereau.BoutonsConnexionCreation;

public class TwitupBordereauMenu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TwitupBordereauMenu() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		
		this.add(this.addMenuRight(), new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
	}
	
	private JPanel addMenuRight() {
		
		JPanel panelCoteLeft = new JPanel();
		panelCoteLeft.setBackground(Color.WHITE);
		panelCoteLeft.setLayout(new GridBagLayout());
		
		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/logoTwitterDummy.png")));
		panelCoteLeft.add(picLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		
		panelCoteLeft.add(new BoutonsConnexionCreation(), new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		
		return panelCoteLeft;
	}

}
