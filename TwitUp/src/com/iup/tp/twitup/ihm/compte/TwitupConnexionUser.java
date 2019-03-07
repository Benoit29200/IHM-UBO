package com.iup.tp.twitup.ihm.compte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

	private JButton creationcompteJButton = new JButton("Créer mon compte");
	private JButton connexionUser = new JButton("Connexion");

	private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	private JLabel loginLabel = new JLabel("Votre pseudo :");
	private JTextField login = new JTextField();

	private JLabel passwordLabel = new JLabel("Votre mot de passe :");
	private JTextField password = new JPasswordField();

	private JLabel errorMessage = new JLabel("");

	protected IObserverLogin observer;
	
	public TwitupConnexionUser(IObserverLogin observer){

		JPanel create = new JPanel();

		create.setLayout(new GridBagLayout());
//		create.setBorder(new LineBorder(Color.CYAN, 4, true));
		create.setOpaque(true);

		setLayout(new GridBagLayout());
		add(create, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		this.observer = observer;
		this.initUserPage(create);
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
	 * @param create
	 */
	private void initUserPage(JPanel create) {

		this.login.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		this.password.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/22));
		this.errorMessage.setForeground(Color.RED);

		create.add(loginLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		create.add(login, new GridBagConstraints(1, 0, 5, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		create.add(passwordLabel, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		create.add(password, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		create.add(errorMessage, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		create.add(this.creationcompteJButton, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		create.add(this.connexionUser, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
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
			this.setErrorMessage("Vous devez remplir les champs pseudo et mot de passe.");
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
