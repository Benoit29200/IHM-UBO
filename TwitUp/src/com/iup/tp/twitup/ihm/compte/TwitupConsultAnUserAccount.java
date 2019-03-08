package com.iup.tp.twitup.ihm.compte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.User;

public class TwitupConsultAnUserAccount extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	Dimension tailleComponent = new Dimension(screenSize.width/3, screenSize.height/15);
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());

	private JLabel nomLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_NOM).toString());
	private JLabel pseudoLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
	private JLabel avatar;
	
	private User user;

	private JLabel nom;
	private JLabel pseudo;
	
	JButton connectToThisAccount;
	
	public TwitupConsultAnUserAccount(User theUser, User myUser) {
		if(myUser.getFollows().contains(theUser.getUserTag())) {
			connectToThisAccount = new JButton(this.fileLanguage.getObject(Constants.DECONNECTION_TO_ACCOUNT).toString());
			connectToThisAccount.setBackground(Color.red);
		}
		else {
			connectToThisAccount = new JButton(this.fileLanguage.getObject(Constants.CONNECTION_TO_ACCOUNT).toString());
			connectToThisAccount.setBackground(Color.green);
		}
		this.user = theUser;
		Border compound = null;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setPanelAccount());
		this.avatar = new JLabel(new ImageIcon(getClass().getResource(theUser.getAvatarPath())));
	}

	/**
	 * Permet de créer le JPanel de gestion du compte
	 * @return
	 */
	private JPanel setPanelAccount() {
		JPanel panelResearchTwit = new JPanel( new GridBagLayout());
		panelResearchTwit.add(avatar,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelResearchTwit.add(this.setLabelPanel(),new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelResearchTwit.add(this.setTextFieldPanel(),new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		return panelResearchTwit;
	}
	
	/**
	 * Création du panel contenant les JLabels
	 * @return
	 */
	private JPanel setLabelPanel() {
		JPanel panelLabelUserAccount = new JPanel(new GridBagLayout());
		this.nomLabel.setPreferredSize(tailleComponent);
		this.pseudoLabel.setPreferredSize(tailleComponent);
		

		panelLabelUserAccount.add(nomLabel,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelLabelUserAccount.add(pseudoLabel,new GridBagConstraints(0,2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		return panelLabelUserAccount;
	}
	
	/**
	 * Création du panel contenant les textField et le bouton
	 * @return
	 */
	private JPanel setTextFieldPanel() {
		JPanel panelTextFieldUserAccount = new JPanel(new GridBagLayout());
		this.nom.setPreferredSize(tailleComponent);
		this.nom = new JLabel(this.user.getName());
		this.pseudo.setPreferredSize(tailleComponent);
		this.pseudo = new JLabel(this.user.getUserTag());
		
		panelTextFieldUserAccount.add(nom,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelTextFieldUserAccount.add(pseudo,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelTextFieldUserAccount.add(connectToThisAccount,new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		
		return panelTextFieldUserAccount;
	}

}
