package com.iup.tp.twitup.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TwitupCreationCompte extends JPanel{
	
	JButton creationcompteJButton = new JButton("Créer mon compte");
	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	TwitupCreationCompte() {
		
		JPanel create = new JPanel();
		
		create.setLayout(new GridBagLayout());
		
		JPanel creationLabel = createJPanelLabel("Votre nom :");
		create.setBorder(new LineBorder(Color.RED, 4, true));
		
		JPanel creationText = createJPanelTextField(screenSize);
		create.setBorder(new LineBorder(Color.RED, 4, true));
		
		JPanel creationLabel1 = createJPanelLabel("Votre nom :");
		create.setBorder(new LineBorder(Color.RED, 4, true));
		
		JPanel creationText1 = createJPanelTextField(screenSize);
		create.setBorder(new LineBorder(Color.RED, 4, true));
		
		create.add(creationLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		create.add(creationText, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		create.add(creationLabel1, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		create.add(creationText1, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		create.setBorder(new LineBorder(Color.CYAN, 4, true));
		create.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/2));
		create.setOpaque(true);
		add(create);
		
	}
		
		/*setLayout(new BorderLayout());
		
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		JPanel userCreationLabel = setCreationPanelLabel(screenSize);
		JPanel userCreationTextField = setCreationPanelTextField(screenSize);
		
		JPanel create = new JPanel();
		create.setLayout(new GridLayout(1, 2));
		create.setBorder(BorderFactory.createTitledBorder("Vive le roi Benoît"));
		create.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/2));
		create.add(userCreationLabel);
		create.add(userCreationTextField);
		

	    JPanel creation = new JPanel();
	    creation.add(creationcompteJButton);
	    add(creation, BorderLayout.SOUTH);
		
	    add(create,BorderLayout.CENTER);
	}

	private JPanel setCreationPanelLabel(Dimension screenSize) {
		JPanel userCreation = new JPanel();
		userCreation.setPreferredSize(new Dimension(screenSize.width/4, screenSize.height/2));
		userCreation.setLayout(new GridLayout(5,1));
		JPanel creation = createJPanelLabel("Votre nom :");
		userCreation.add(creation);
		creation = createJPanelLabel("Votre pseudo:");
		userCreation.add(creation);
		creation = createJPanelLabel("Votre mot de passe :");
		userCreation.add(creation);
		creation = createJPanelLabel("Confirmation mot de passe :");
		userCreation.add(creation);
		return userCreation;
	}
	
	private JPanel setCreationPanelTextField(Dimension screenSize) {
		JPanel userCreation = new JPanel();
		userCreation.setPreferredSize(new Dimension(screenSize.width/4, screenSize.height/2));
		userCreation.setLayout(new GridLayout(5,1));
		JPanel creation = createJPanelTextField(screenSize);
		userCreation.add(creation);
		creation = createJPanelTextField(screenSize);
		userCreation.add(creation);
		creation = createJPanelTextField(screenSize);
		userCreation.add(creation);
		creation = createJPanelTextField(screenSize);
		userCreation.add(creation);
		return userCreation;
	}
*/
	private JPanel createJPanelLabel(String titreLabel) {
		JPanel creation = new JPanel();
		JLabel nom = new JLabel(titreLabel);
		creation.add(nom);
		return creation;
	}
	
	private JPanel createJPanelTextField(Dimension screenSize) {
		JPanel creation = new JPanel();
		JTextField nomText = new JTextField("");
		nomText.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		creation.add(nomText);
		return creation;
	}

}
