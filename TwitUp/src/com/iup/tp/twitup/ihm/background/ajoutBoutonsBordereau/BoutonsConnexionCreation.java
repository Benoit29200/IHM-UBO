package com.iup.tp.twitup.ihm.background.ajoutBoutonsBordereau;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.ihm.background.BackgroundMother;

import javax.swing.*;
import java.awt.*;

public class BoutonsConnexionCreation extends BackgroundMother {


	public BoutonsConnexionCreation() {
		super();
		this.add(getButtonsCreationConnexion());
		this.setBackground(Color.white);
	}
	
	private JPanel getButtonsCreationConnexion() {
		JPanel monJPanel= new JPanel();
		monJPanel.setLayout(new GridBagLayout());
		monJPanel.setBackground(Color.white);
		JButton connexion = new JButton(this.fileLanguage.getObject(Constants.VIEW_CONNEXION_COMPTE).toString());
		JButton creation = new JButton(this.fileLanguage.getObject(Constants.VIEW_CREATION_COMPTE).toString());
		this.addInto(monJPanel,connexion,0,0,1,1,1,1,GridBagConstraints.NORTH, GridBagConstraints.BOTH,5,5,0,5,0,0);
		this.addInto(monJPanel,creation,0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH,5,5,0,5,0,0);
		return monJPanel;
	}

}
