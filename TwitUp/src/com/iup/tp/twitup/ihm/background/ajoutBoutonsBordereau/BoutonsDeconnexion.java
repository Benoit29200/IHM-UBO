package com.iup.tp.twitup.ihm.background.ajoutBoutonsBordereau;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.ihm.background.BackgroundMother;

import javax.swing.*;
import java.awt.*;

public class BoutonsDeconnexion extends BackgroundMother {


	public BoutonsDeconnexion() {
		this.add(getButtonDeconnexion());
		this.setBackground(Color.white);
	}
	
	private JPanel getButtonDeconnexion() {
		JPanel monJPanel= new JPanel();
		monJPanel.setLayout(new GridBagLayout());
		monJPanel.setBackground(Color.white);
		JButton connexion = new JButton(Constants.DECONNEXION);

		this.addInto(monJPanel,connexion,0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH,5,5,0,5,0,0);

		return monJPanel;
	}
}
