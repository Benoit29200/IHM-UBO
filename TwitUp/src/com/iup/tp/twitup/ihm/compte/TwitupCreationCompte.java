package com.iup.tp.twitup.ihm.compte;

import com.iup.tp.twitup.datamodel.AccountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.datamodel.AccountCreation.IObserverAccountCreation;
import com.iup.tp.twitup.controller.AccountCreationController;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TwitupCreationCompte extends JPanel implements IObservableAccountCreation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton creationcompteJButton = new JButton("Créer mon compte");
	
	private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	private IObserverAccountCreation observer;

	private JLabel nomLabel = new JLabel("Votre nom");
	private JLabel pseudoLabel = new JLabel("Votre pseudo");
	private JLabel passwordLabel = new JLabel("Votre mot de passe");
	private JLabel confirmPasswordLabel = new JLabel("Confirmation mot de passe");

	private JTextField nom = new JTextField();
	private JTextField pseudo = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JPasswordField confirmPassword = new JPasswordField();


	
	public TwitupCreationCompte(){
		
		JPanel create = new JPanel();
		
		create.setLayout(new GridBagLayout());
		setLayout(new GridBagLayout());
		
		this.createUserPage(create);
		this.setActionAccountCreation();

		this.addObserver(new AccountCreationController());
		
//		create.setBorder(new LineBorder(Color.CYAN, 4, true));
		create.setPreferredSize(new Dimension((int) (screenSize.width/2.5), screenSize.height/2));
		create.setOpaque(true);
		add(create, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		Dimension componentDimension = new Dimension(screenSize.width/5, screenSize.height/22);
		this.nom.setPreferredSize(componentDimension);
		this.pseudo.setPreferredSize(componentDimension);
		this.password.setPreferredSize(componentDimension);
		this.confirmPassword.setPreferredSize(componentDimension);
		
	}

	private void createUserPage(JPanel create) {
		JPanel nomLabel = createJPanelComponent(this.nomLabel);
		JPanel nom = createJPanelComponent(this.nom);
		JPanel pseudoLabel = createJPanelComponent(this.pseudoLabel);
		JPanel pseudo = createJPanelComponent(this.pseudo);
		JPanel passwordLabel = createJPanelComponent(this.passwordLabel);
		JPanel password = createJPanelComponent(this.password);
		JPanel confirmPasswordLabel = createJPanelComponent(this.confirmPasswordLabel);
		JPanel confirmPassword = createJPanelComponent(this.confirmPassword);
		
		create.add(nomLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(nom, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(pseudoLabel, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(pseudo, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(passwordLabel, new GridBagConstraints(0, 2, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(password, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(confirmPasswordLabel, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(confirmPassword, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(this.creationcompteJButton, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
	}

	private void setActionAccountCreation(){
		this.creationcompteJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyEventAccountCreation(nom.getText(),pseudo.getText(),password.getText());
			}
		});
	}
		
	private JPanel createJPanelComponent(JComponent component) {
		JPanel creation = new JPanel();
		creation.add(component);
		return creation;
	}

	@Override
	public void addObserver(IObserverAccountCreation o) {
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
	public void notifyEventAccountCreation(String nom, String login, String mdp) {
		this.observer.eventEventAccountCreation(this, nom, login, mdp);
	}
}