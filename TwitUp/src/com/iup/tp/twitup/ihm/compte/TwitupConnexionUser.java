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
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle("menu", Locale.getDefault());

	private JButton creationcompteJButton = new JButton(this.fileLanguage.getObject("creation").toString());
	private JButton connexionUser = new JButton(this.fileLanguage.getObject("connexion").toString());

	private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	private JLabel loginLabel = new JLabel(this.fileLanguage.getObject("pseudo").toString());
	private JTextField login = new JTextField();

	private JLabel passwordLabel = new JLabel(this.fileLanguage.getObject("mdp").toString());
	private JTextField password = new JPasswordField();

	private JLabel errorMessage = new JLabel("");

	protected IObserverLogin observer;

	public TwitupConnexionUser(IObserverLogin observer){
		
		JPanel panelCreate = new JPanel();

		panelCreate.setLayout(new GridBagLayout());
		panelCreate.setBorder(new LineBorder(Color.CYAN, 4, true));
		panelCreate.setOpaque(true);

		this.setLayout(new GridBagLayout());
		this.add(panelCreate, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		this.observer = observer;
		this.initUserPage(panelCreate);
		this.setAction();

	}

	/**
	 * Ajout d'un action sur le bouton de connexion
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
	 * @param panelCreate
	 */
	private void initUserPage(JPanel panelCreate) {

		configurationComponentPanel();
		
		JPanel labelEtBoutonConnexion = new JPanel(new GridBagLayout());
		JPanel textFieldEtBoutonCreation = new JPanel(new GridBagLayout());

		/**
		 * Mise en place 
		 */
		labelEtBoutonConnexion = initJLabelsEtConnexion(labelEtBoutonConnexion);
		
		textFieldEtBoutonCreation = initJTextFieldEtCreation(textFieldEtBoutonCreation);

		panelCreate.add(labelEtBoutonConnexion, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		panelCreate.add(textFieldEtBoutonCreation, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		panelCreate.add(errorMessage, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

	}

	/**
	 * Permet de gérer la configuration de la taille des components et de la couleur du message
	 */
	private void configurationComponentPanel() {
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
			this.setErrorMessage(this.fileLanguage.getObject("erreurconnexion").toString());
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
