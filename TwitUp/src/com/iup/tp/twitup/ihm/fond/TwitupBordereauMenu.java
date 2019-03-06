package com.iup.tp.twitup.ihm.fond;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TwitupBordereauMenu extends JPanel{
	
	public TwitupBordereauMenu() {
		setBackground(Color.WHITE);
//		panelCoteLeft.setBorder(new LineBorder(Color.RED, 4, true));
		setLayout(new GridBagLayout());
		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/logoTwitterDummy.png")));
		add(picLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		JButton connexion = new JButton("Connexion à mon compte");
		JButton creation = new JButton("Création de mon compte");
		add(connexion, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		add(creation, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
	}

}
