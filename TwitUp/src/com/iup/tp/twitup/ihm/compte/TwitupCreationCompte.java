package com.iup.tp.twitup.ihm.compte;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.iup.tp.twitup.datamodel.accountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.datamodel.accountCreation.IObserverAccountCreation;

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


	
	public TwitupCreationCompte(IObserverAccountCreation observer){
		
		JPanel create = new JPanel();
		
		create.setLayout(new GridBagLayout());
		setLayout(new GridBagLayout());
		
		this.initUserPage(create);
		this.setActionAccountCreation();

		this.observer = observer;
		
		create.setOpaque(true);
		add(create, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		Dimension componentDimension = new Dimension(screenSize.width/5, screenSize.height/22);
		this.nom.setPreferredSize(componentDimension);
		this.pseudo.setPreferredSize(componentDimension);
		this.password.setPreferredSize(componentDimension);
		this.confirmPassword.setPreferredSize(componentDimension);
		
	}

	private void initUserPage(JPanel create) {
		
		JPanel nomLabel = initJPanelComponent(this.nomLabel);
		JPanel nom = initJPanelComponent(this.nom);
		JPanel pseudoLabel = initJPanelComponent(this.pseudoLabel);
		JPanel pseudo = initJPanelComponent(this.pseudo);
		JPanel passwordLabel = initJPanelComponent(this.passwordLabel);
		JPanel password = initJPanelComponent(this.password);
		JPanel confirmPasswordLabel = initJPanelComponent(this.confirmPasswordLabel);
		JPanel confirmPassword = initJPanelComponent(this.confirmPassword);
		
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
		
	private JPanel initJPanelComponent(JComponent component) {
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