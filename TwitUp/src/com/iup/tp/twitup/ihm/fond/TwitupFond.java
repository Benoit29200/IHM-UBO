package com.iup.tp.twitup.ihm.fond;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Permet d'avoir une page fond toujours affiché
 * @author gaetan
 *
 */
public class TwitupFond extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2724237454765496211L;

	public TwitupFond() {
		this.setLayout(new GridBagLayout());
		this.add(this.addMenuLeft(), new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void addComponentInPage(Container monComponent) {
		this.add(monComponent, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		this.revalidate();
	}
	
	private JPanel addMenuLeft() {
		JPanel panelCoteLeft = new JPanel();
		panelCoteLeft.setBackground(Color.WHITE);
		panelCoteLeft.setBorder(new LineBorder(Color.RED, 4, true));
		panelCoteLeft.setLayout(new GridBagLayout());
		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/logoTwitterDummy.png")));
		panelCoteLeft.add(picLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		JButton connexion = new JButton("Connexion à mon compte");
		JButton creation = new JButton("Création de mon compte");
		panelCoteLeft.add(connexion, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelCoteLeft.add(creation, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		return panelCoteLeft;
	}

}
