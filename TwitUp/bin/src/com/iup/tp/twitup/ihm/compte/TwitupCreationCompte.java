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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.accountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.communicationInterface.vueController.accountCreation.IObserverAccountCreation;

public class TwitupCreationCompte extends JPanel implements IObservableAccountCreation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;

	private JButton creationcompteJButton;
	
	private Dimension screenSize;

	private IObserverAccountCreation observer;

	private JLabel errorMessage;
	private JLabel nomLabel;
	private JLabel pseudoLabel;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;

	private JTextField nom;
	private JTextField pseudo;
	private JPasswordField password;
	private JPasswordField confirmPassword;


	public TwitupCreationCompte(IObserverAccountCreation observer){
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.addObserver(observer);
		this.initComponent();

		JPanel panelCreation = new JPanel(new GridBagLayout());
		panelCreation.setLayout(new GridBagLayout());
		panelCreation.setOpaque(true);
		panelCreation.setBorder(new LineBorder(Color.CYAN, 4, true));
		
		this.initAccountManager(panelCreation);
		this.setActionAccountCreation();


		this.setLayout(new GridBagLayout());
		this.setOpaque(true);
		
		this.add(panelCreation, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		this.dimensionComponent();
		
	}

	private void initComponent(){
		this.creationcompteJButton = new JButton(this.fileLanguage.getObject(Constants.VIEW_CREATION_COMPTE).toString());
		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.errorMessage = new JLabel("");
		this.nomLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_NOM).toString());
		this.pseudoLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
		this.passwordLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_MDP).toString());
		this.confirmPasswordLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_CMDP).toString());

		this.errorMessage = new JLabel("");
		this.errorMessage.setForeground(Color.RED);

		this.nom = new JTextField();
		this.pseudo = new JTextField();
		this.password = new JPasswordField();
		this.confirmPassword = new JPasswordField();
	}

	public void setErrorMessage(String error) {
		this.errorMessage.setText(error);
	}

	private void dimensionComponent() {
		Dimension componentDimension = new Dimension(screenSize.width/5, screenSize.height/22);
		this.errorMessage.setPreferredSize(componentDimension);
		this.nomLabel.setPreferredSize(componentDimension);
		this.pseudoLabel.setPreferredSize(componentDimension);
		this.passwordLabel.setPreferredSize(componentDimension);
		this.confirmPasswordLabel.setPreferredSize(componentDimension);
		this.nom.setPreferredSize(componentDimension);
		this.pseudo.setPreferredSize(componentDimension);
		this.password.setPreferredSize(componentDimension);
		this.confirmPassword.setPreferredSize(componentDimension);
	}

	/**
	 * Permet de créer le JPanel principal
	 * @param create
	 */
	private void initAccountManager(JPanel create) {
		
		JPanel panelJLabels = this.initJComponentDansJPanelComponent(this.nomLabel,this.pseudoLabel,this.passwordLabel,this.confirmPasswordLabel);
		JPanel panelJTextField = this.initJComponentDansJPanelComponent(this.nom,this.pseudo,this.password,this.confirmPassword);
		
		create.add(panelJLabels, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(panelJTextField, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(this.errorMessage, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE, new Insets(5, 5, 6, 5), 0, 0));
		create.add(this.creationcompteJButton, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

	}

	/**
	 * Permet de construire un JPanel qui prend les 4 components afin de les aligner correctement
	 * @param component1
	 * @param component2
	 * @param component3
	 * @param component4
	 * @return
	 */
	private JPanel initJComponentDansJPanelComponent(JComponent component1, JComponent component2, JComponent component3,JComponent component4
			) {
		JPanel panelConstruit = new JPanel(new GridBagLayout());
		
		panelConstruit.add(component1, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelConstruit.add(component2, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelConstruit.add(component3, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelConstruit.add(component4, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		
		return panelConstruit;
	}

	/**
	 * Ajoute une action lors de l'appui sur le bouton de création du compte
	 */
	private void setActionAccountCreation(){
		this.creationcompteJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyEventAccountCreation(nom.getText(),pseudo.getText(),password.getText(), confirmPassword.getText());
			}
		});
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
	public void notifyEventAccountCreation(String nom, String login, String mdp, String confirm) {
		this.observer.eventEventAccountCreation(this, nom, login, mdp, confirm);
	}
}