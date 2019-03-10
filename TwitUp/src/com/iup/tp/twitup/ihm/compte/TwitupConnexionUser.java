package com.iup.tp.twitup.ihm.compte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.apache.commons.lang3.StringUtils;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.login.IObservableLogin;
import com.iup.tp.twitup.datamodel.login.IObserverLogin;

/**
 * Mise en place du component gérant la connexion d'un utilisateur
 * @author gaetan
 *
 */
public class TwitupConnexionUser extends JPanel implements IObservableLogin {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;

	private JButton creationcompteJButton;
	private JButton connexionUser;

	private Dimension screenSize;

	private JLabel loginLabel;
	private JTextField login;

	private JLabel passwordLabel;
	private JTextField password;

	private JLabel errorMessage;

	protected IObserverLogin observer;

	public TwitupConnexionUser(IObserverLogin observer){

		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.initComponent();
		this.addObserver(observer);
		
		JPanel connexionUserPanel = new JPanel();

		connexionUserPanel.setLayout(new GridBagLayout());
		connexionUserPanel.setBorder(new LineBorder(Color.CYAN, 4, true));
		connexionUserPanel.setOpaque(true);

		this.setLayout(new GridBagLayout());
		this.add(connexionUserPanel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		this.initConnexionUserContent(connexionUserPanel);
		this.setAction();
	}

	/**
	 * Initialisation des composants avec le label associé à la langue
	 */
	private void initComponent(){
		this.creationcompteJButton = new JButton(this.fileLanguage.getObject(Constants.VIEW_CREATION_COMPTE).toString());
		this.connexionUser = new JButton(this.fileLanguage.getObject(Constants.VIEW_CONNEXION_COMPTE).toString());

		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		this.loginLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
		this.login = new JTextField();

		this.passwordLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_MDP).toString());
		this.password = new JPasswordField();

		this.errorMessage = new JLabel("");
	}

	/**
	 * Ajout d'un action sur le bouton de connexion et sur le bouton de création de compte
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
	 * Permet de créer le JPanel correspondant au component de la création d'un compte
	 * @param connexionUserPanel
	 */
	private void initConnexionUserContent(JPanel connexionUserPanel) {

		setSizeComponent();
		
		JPanel labelEtBoutonConnexion = new JPanel(new GridBagLayout());
		JPanel textFieldEtBoutonCreation = new JPanel(new GridBagLayout());

		/**
		 * Mise en place des composants du panel connexion
		 */
		labelEtBoutonConnexion = initJLabelsEtConnexion(labelEtBoutonConnexion);
		
		textFieldEtBoutonCreation = initJTextFieldEtCreation(textFieldEtBoutonCreation);

		connexionUserPanel.add(labelEtBoutonConnexion, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		connexionUserPanel.add(textFieldEtBoutonCreation, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		connexionUserPanel.add(errorMessage, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
	}

	/**
	 * Permet de gérer la configuration de la taille des components et de la couleur du message
	 */
	private void setSizeComponent() {
		this.login.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		this.password.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		this.loginLabel.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		this.passwordLabel.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		this.errorMessage.setForeground(Color.RED);
	}

	/**
	 * Permet de gérer la mise dans un Panel des JTextField et du bouton Création
	 * @param textFieldEtBoutonCreation
	 */
	private JPanel initJTextFieldEtCreation(JPanel textFieldEtBoutonCreation) {
		textFieldEtBoutonCreation.add(this.login, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		textFieldEtBoutonCreation.add(this.password, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		textFieldEtBoutonCreation.add(this.creationcompteJButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		return textFieldEtBoutonCreation;
	}

	/**
	 * Permet de gérer la mise en place dans un Panel des  JLabels et du bouton Connexion
	 * @param labelEtBoutonConnexion
	 * @return
	 */
	private JPanel initJLabelsEtConnexion(JPanel labelEtBoutonConnexion) {
		
		labelEtBoutonConnexion.add(this.loginLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		labelEtBoutonConnexion.add(this.passwordLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		labelEtBoutonConnexion.add(this.connexionUser, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
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
