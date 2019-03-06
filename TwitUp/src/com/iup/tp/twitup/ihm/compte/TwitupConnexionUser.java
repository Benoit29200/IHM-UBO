package com.iup.tp.twitup.ihm.compte;

import com.iup.tp.twitup.ObservableController.IObservableMenu;
import com.iup.tp.twitup.ObservableController.IObserverMenu;
import com.iup.tp.twitup.controller.MenuController;
import org.apache.commons.lang3.StringUtils;

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
import javax.swing.border.LineBorder;

public class TwitupConnexionUser extends JPanel implements IObservableMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton creationcompteJButton = new JButton("Créer mon compte");
	JButton connexionUser = new JButton("Connexion");

	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	JLabel loginLabel = new JLabel("Votre pseudo :");
	JTextField login = new JTextField();

	JLabel passwordLabel = new JLabel("Votre mot de passe :");
	JTextField password = new JPasswordField();

	protected IObserverMenu observer;
	
	public TwitupConnexionUser(){

		JPanel create = new JPanel();

		create.setLayout(new GridBagLayout());
		create.setBorder(new LineBorder(Color.CYAN, 4, true));
		create.setPreferredSize(new Dimension((int) (screenSize.width/3), screenSize.height/4));
		create.setOpaque(true);

		setLayout(new GridBagLayout());
		add(create, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));


		this.createUserPage(create);
		this.addActionLogin();
		this.addObserver(new MenuController());

	}

	private void addActionLogin(){
		this.connexionUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyEventLogin(login.getText(), password.getText());
			}
		});
	}

	private void createUserPage(JPanel create) {

		
		create.add(loginLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(login, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(passwordLabel, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(password, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(this.creationcompteJButton, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(this.connexionUser, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
	}

	@Override
	public void addObserver(IObserverMenu o) {
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
	}

}
