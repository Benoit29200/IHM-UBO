package com.iup.tp.twitup.ihm.compte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TwitupCreationCompte extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton creationcompteJButton = new JButton("Créer mon compte");
	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	public TwitupCreationCompte(){
		
		JPanel create = new JPanel();
		
		create.setLayout(new GridBagLayout());
		
		createUserPage(create);
		
		create.setBorder(new LineBorder(Color.CYAN, 4, true));
		create.setPreferredSize(new Dimension((int) (screenSize.width/2.5), screenSize.height/2));
		create.setOpaque(true);
//		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/images/logoTwitterDummy.jpg")));
//		add(picLabel);
		add(create);
		
	}

	private void createUserPage(JPanel create) {
		JPanel creationLabel = createJPanelLabel("Votre nom :");
		create.setBorder(new LineBorder(Color.RED, 4, true));
		JPanel creationText = createJPanelTextField(screenSize,false);
		create.setBorder(new LineBorder(Color.RED, 4, true));
		JPanel creationLabel1 = createJPanelLabel("Votre pseudo :");
		create.setBorder(new LineBorder(Color.RED, 4, true));
		JPanel creationText1 = createJPanelTextField(screenSize,false);
		create.setBorder(new LineBorder(Color.RED, 4, true));
		JPanel creationLabel2 = createJPanelLabel("Votre mot de passe :");
		create.setBorder(new LineBorder(Color.RED, 4, true));
		JPanel creationText2 = createJPanelTextField(screenSize,true);
		create.setBorder(new LineBorder(Color.RED, 4, true));
		JPanel creationLabel3 = createJPanelLabel("Confirmation mot de passe :");
		create.setBorder(new LineBorder(Color.RED, 4, true));
		JPanel creationText3 = createJPanelTextField(screenSize,true);
		create.setBorder(new LineBorder(Color.RED, 4, true));
		
		create.add(creationLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(creationText, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(creationLabel1, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(creationText1, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(creationLabel2, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(creationText2, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(creationLabel3, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(creationText3, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(this.creationcompteJButton, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
	}
		
	private JPanel createJPanelLabel(String titreLabel) {
		JPanel creation = new JPanel();
		JLabel nom = new JLabel(titreLabel);
		creation.add(nom);
		return creation;
	}

    private JPanel createJPanelTextField(Dimension screenSize,Boolean pwd) {
        JPanel creation = new JPanel();
        Dimension dimension =new Dimension(screenSize.width/5, screenSize.height/22);
        if(pwd) {
            JPasswordField password = new JPasswordField();
            password.setPreferredSize(dimension);
            creation.add(password);
        }
        else {
            JTextField champ = new JTextField("");
            champ.setPreferredSize(dimension);
            creation.add(champ);
        }
        return creation;
    }

}
