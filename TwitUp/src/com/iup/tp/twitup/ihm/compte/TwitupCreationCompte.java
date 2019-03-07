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
import com.iup.tp.twitup.datamodel.accountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.datamodel.accountCreation.IObserverAccountCreation;

public class TwitupCreationCompte extends JPanel implements IObservableAccountCreation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());

	private JButton creationcompteJButton = new JButton(this.fileLanguage.getObject(Constants.VIEW_CREATION_COMPTE).toString());
	
	private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	private IObserverAccountCreation observer;

	private JLabel nomLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_NOM).toString());
	private JLabel pseudoLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
	private JLabel passwordLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_MDP).toString());
	private JLabel confirmPasswordLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_CMDP).toString());

	private JTextField nom = new JTextField();
	private JTextField pseudo = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JPasswordField confirmPassword = new JPasswordField();


	
	public TwitupCreationCompte(IObserverAccountCreation observer){
		
		JPanel panelCreation = new JPanel(new GridBagLayout());
		panelCreation.setLayout(new GridBagLayout());
		panelCreation.setOpaque(true);
		
		this.initUserPage(panelCreation);
		this.setActionAccountCreation();
		this.observer = observer;
		
		this.setBorder(new LineBorder(Color.CYAN, 4, true));
		this.setOpaque(true);
		
		this.add(panelCreation, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		this.dimensionComponent();
		
	}

	private void dimensionComponent() {
		Dimension componentDimension = new Dimension(screenSize.width/5, screenSize.height/22);
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
	private void initUserPage(JPanel create) {
		
		JPanel panelJLabels = this.initJComponentDansJPanelComponent(this.nomLabel,this.pseudoLabel,this.passwordLabel,this.confirmPasswordLabel);
		JPanel panelJTextField = this.initJComponentDansJPanelComponent(this.nom,this.pseudo,this.password,this.confirmPassword);
		
		create.add(panelJLabels, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		create.add(panelJTextField, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		create.add(this.creationcompteJButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.SOUTH,
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
				notifyEventAccountCreation(nom.getText(),pseudo.getText(),password.getText());
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
	public void notifyEventAccountCreation(String nom, String login, String mdp) {
		this.observer.eventEventAccountCreation(this, nom, login, mdp);
	}
}