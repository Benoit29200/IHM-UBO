package com.iup.tp.twitup.ihm.account;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.consultAccountUser.IObservableConsultAccountUser;
import com.iup.tp.twitup.communicationInterface.vueController.consultAccountUser.IObserverConsultAccountUser;
import com.iup.tp.twitup.datamodel.User;

public class ConsultAnUserAccount extends Account implements IObservableConsultAccountUser {


	Dimension tailleComponent;


	private JLabel nomLabel;
	private JLabel nom;

	private JLabel pseudoLabel;
	private JLabel pseudo;

	private JLabel avatar;
	
	private User user;

	private IObserverConsultAccountUser observer;

	JButton connectToThisAccount;
	
	public ConsultAnUserAccount(User theUser, User userConnected, IObserverConsultAccountUser observer) {
		super();
		this.addObserver(observer);
		this.user = theUser;
		this.initComponent();
		this.setLayout(new GridBagLayout());

		this.abonnement(theUser,userConnected);
		this.user = theUser;
		this.avatar = new JLabel(new ImageIcon(getClass().getResource(theUser.getAvatarPath())));
		this.setBackground(new Color(135,206,250));
		this.addInto(this,setPanelAccount(),0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);

	}

	public void abonnement(User theUser, User userConnected){
		if(userConnected.getFollows().contains(theUser.getUserTag())) {
			connectToThisAccount = new JButton(this.fileLanguage.getObject(Constants.DECONNECTION_TO_ACCOUNT).toString());
			connectToThisAccount.setBackground(Color.red);
			connectToThisAccount.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					notifyDesabonne(theUser);
				}
			});
		}
		else {
			connectToThisAccount = new JButton(this.fileLanguage.getObject(Constants.CONNECTION_TO_ACCOUNT).toString());
			connectToThisAccount.setBackground(Color.green);
			connectToThisAccount.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					notifyAbonne(theUser);
				}
			});
		}
		this.revalidate();
		this.repaint();
	}

	private void initComponent(){
		this.tailleComponent = new Dimension(screenSize.width/6, screenSize.height/15);

		this.nomLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_NOM).toString());
		this.nom = new JLabel(this.user.getName());

		this.pseudoLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
		this.pseudo = new JLabel(this.user.getUserTag());

		this.nomLabel.setPreferredSize(tailleComponent);
		this.nom.setPreferredSize(tailleComponent);

		this.pseudoLabel.setPreferredSize(tailleComponent);
		this.pseudo.setPreferredSize(tailleComponent);

	}

	/**
	 * Permet de créer le JPanel de gestion du account
	 * @return
	 */
	private JPanel setPanelAccount() {
		JPanel panelResearchTwit = new JPanel( new GridBagLayout());

		this.addInto(panelResearchTwit,avatar,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(panelResearchTwit,this.setLabelPanel(), 0,1,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(panelResearchTwit,this.setTextFieldPanel(),0,2,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(panelResearchTwit, connectToThisAccount, 0,3,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);

		return panelResearchTwit;
	}
	
	/**
	 * Création du panel contenant les JLabels
	 * @return
	 */
	private JPanel setLabelPanel() {
		JPanel panelLabelUserAccount = new JPanel(new GridBagLayout());

		this.addInto(panelLabelUserAccount, nomLabel,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(panelLabelUserAccount, nom, 1,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);

		return panelLabelUserAccount;
	}
	
	/**
	 * Création du panel contenant les textField et le bouton
	 * @return
	 */
	private JPanel setTextFieldPanel() {
		JPanel panelTextFieldUserAccount = new JPanel(new GridBagLayout());

		this.addInto(panelTextFieldUserAccount, pseudoLabel,0,0,1,1,1,1,GridBagConstraints.EAST,GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(panelTextFieldUserAccount, pseudo, 1,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);

		return panelTextFieldUserAccount;
	}

	@Override
	public void addObserver(IObserverConsultAccountUser o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyAbonne(User u) {
		this.observer.abonne(u);
	}

	@Override
	public void notifyDesabonne(User u) {
		this.observer.desabonne(u);
	}
}
