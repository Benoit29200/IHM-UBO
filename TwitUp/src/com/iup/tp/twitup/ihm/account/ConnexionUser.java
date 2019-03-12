package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.login.IObservableLogin;
import com.iup.tp.twitup.communicationInterface.vueController.login.IObserverLogin;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Mise en place du component gérant la connexion d'un utilisateur
 * @author gaetan
 *
 */
public class ConnexionUser extends Account implements IObservableLogin {

	private JButton creationcompteJButton;
	private JButton connexionUser;

	private Dimension screenOfTheSize;

	private JLabel loginLabel;
	private JTextField login;

	private JLabel passwordLabel;
	private JTextField password;

	private JLabel errorMessage;

	protected IObserverLogin observer;

	public ConnexionUser(IObserverLogin observer){

		super();
		this.initComponent();
		this.addObserver(observer);
		
		JPanel connexionUserPanel = new JPanel();

		connexionUserPanel.setLayout(new GridBagLayout());
		connexionUserPanel.setBorder(new LineBorder(Color.CYAN, 4, true));
		connexionUserPanel.setOpaque(true);

		this.setLayout(new GridBagLayout());
		this.addInto(this,connexionUserPanel,0,0,2,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.initConnexionUserContent(connexionUserPanel);
		this.setAction();
	}

	/**
	 * Initialisation des composants avec le label associé à la langue
	 */
	private void initComponent(){
		this.creationcompteJButton = new JButton(this.fileLanguage.getObject(Constants.VIEW_CREATION_COMPTE).toString());
		this.connexionUser = new JButton(this.fileLanguage.getObject(Constants.VIEW_CONNEXION_COMPTE).toString());

		this.screenOfTheSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		this.loginLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
		this.login = new JTextField();

		this.passwordLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_MDP).toString());
		this.password = new JPasswordField();

		this.errorMessage = new JLabel("");
	}

	/**
	 * Ajout d'un action sur le bouton de connexion et sur le bouton de création de account
	 */
	private void setAction(){
		this.connexionUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyEventLogin(login.getText(), password.getText());
			}
		});

		this.creationcompteJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyEventAccountManager();
			}
		});
	}

	/**
	 * Permet de créer le JPanel correspondant au component de la création d'un account
	 * @param connexionUserPanel
	 */
	private void initConnexionUserContent(JPanel connexionUserPanel) {

		this.setSizeComponent();
		
		JPanel labelEtBoutonConnexion = initJLabelsEtConnexion(new JPanel(new GridBagLayout()));
		JPanel textFieldEtBoutonCreation = initJTextFieldEtCreation(new JPanel(new GridBagLayout()));

		/**
		 * Mise en place des composants du panel connexion
		 */
		this.addInto(connexionUserPanel,labelEtBoutonConnexion,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,5,5,0,0);
		this.addInto(connexionUserPanel,textFieldEtBoutonCreation, 1,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE, 5,5,5,5,0,0);
		this.addInto(connexionUserPanel,errorMessage, 0,2,2,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
	}

	/**
	 * Permet de gérer la configuration de la taille des components et de la couleur du message
	 */
	private void setSizeComponent() {
		this.login.setPreferredSize(new Dimension(screenOfTheSize.width/5, screenOfTheSize.height/22));
		this.password.setPreferredSize(new Dimension(screenOfTheSize.width/5, screenOfTheSize.height/22));
		this.loginLabel.setPreferredSize(new Dimension(screenOfTheSize.width/5, screenOfTheSize.height/22));
		this.passwordLabel.setPreferredSize(new Dimension(screenOfTheSize.width/5, screenOfTheSize.height/22));
		this.errorMessage.setForeground(Color.RED);
	}

	/**
	 * Permet de gérer la mise dans un Panel des JTextField et du bouton Création
	 * @param textFieldEtBoutonCreation
	 */
	private JPanel initJTextFieldEtCreation(JPanel textFieldEtBoutonCreation) {

		this.addInto(textFieldEtBoutonCreation, this.login, 0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,5,5,0,0);
		this.addInto(textFieldEtBoutonCreation,this.password,0,1,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,5,5,0,0);
		this.addInto(textFieldEtBoutonCreation, this.creationcompteJButton, 0,2,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,5,5,0,0);

		return textFieldEtBoutonCreation;
	}

	/**
	 * Permet de gérer la mise en place dans un Panel des  JLabels et du bouton Connexion
	 * @param labelEtBoutonConnexion
	 * @return
	 */
	private JPanel initJLabelsEtConnexion(JPanel labelEtBoutonConnexion) {

		this.addInto(labelEtBoutonConnexion, this.loginLabel, 0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5, 5, 5, 5, 0,0);
		this.addInto(labelEtBoutonConnexion, this.passwordLabel, 0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,5,5,0,0);
		this.addInto(labelEtBoutonConnexion, this.connexionUser, 0,2,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,5,5,0,0);

		return labelEtBoutonConnexion;
	}

	@Override
	public void addObserver(IObserverLogin o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyEventCancel() {
		this.observer.eventCancel(this,null);
	}

	@Override
	public void notifyEventLogin(String login, String mdp) {
		if(StringUtils.isNotBlank(login) && StringUtils.isNotBlank(mdp))
			this.observer.eventLogin(this,login,mdp);
		else
			this.setErrorMessage(this.fileLanguage.getObject(Constants.VIEW_ERREUR_CONNEXION).toString());
	}

	@Override
	public void notifyEventAccountManager() {
		this.observer.chargeAccountManager();
	}

	@Override
	public void setErrorMessage(String error) {
		this.errorMessage.setText(error);
	}
}
