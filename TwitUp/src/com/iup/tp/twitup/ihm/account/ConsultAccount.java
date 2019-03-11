package com.iup.tp.twitup.ihm.account;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.communicationInterface.vueController.myAccount.IObservableMyAccount;
import com.iup.tp.twitup.communicationInterface.vueController.myAccount.IObserverMyAccount;

public class ConsultAccount extends Account implements IObservableMyAccount {


	private Dimension screenSize;
	private Dimension tailleComponent;


	private JLabel nomLabel;
	private JTextField nom;

	private JLabel pseudoLabel;
	private JTextField pseudo;

	private JLabel avatarPathLabel;
	private JTextField avatarPath;

	private JLabel changePwdLabel;
	private JPasswordField changePwd;

	private IObserverMyAccount observer;

	private User userConnected;

	private JButton updateMyAccount;

	private JLabel error;


	public ConsultAccount(IObserverMyAccount observer) {
		super();
		this.addObserver(observer);
		this.initComponent();
		this.addAction();
		this.setBorder(BorderFactory.createTitledBorder(null, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setPanelAccount());
	}

	private void initComponent(){
		this.userConnected = this.observer.getUserConnected();
		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.tailleComponent = new Dimension(screenSize.width/3, screenSize.height/20);
		this.nomLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_NOM).toString());
		this.nom = new JTextField(this.userConnected.getName());
		this.pseudoLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
		this.pseudo = new JTextField(this.userConnected.getUserTag());
		this.avatarPathLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_AVATAR).toString());
		this.avatarPath = new JTextField(this.userConnected.getAvatarPath());
		this.changePwdLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_CHANGE_PWD).toString());
		this.changePwd = new JPasswordField();
		this.updateMyAccount = new JButton(this.fileLanguage.getObject(Constants.USER_MODIFICATION).toString());
		this.error = new JLabel("");
		this.error.setForeground(Color.RED);
	}

	public void setMessage(String err){
		this.error.setText(err);
	}

	/**
	 * Permet de créer le JPanel de gestion du account
	 * @return
	 */
	private JPanel setPanelAccount() {
		JPanel panelResearchTwit = new JPanel( new GridBagLayout());
		panelResearchTwit.add(this.setLabelPanel(),new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelResearchTwit.add(this.setTextFieldPanel(),new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		return panelResearchTwit;
	}

	/**
	 * Création du panel contenant les JLabels
	 * @return
	 */
	private JPanel setLabelPanel() {
		JPanel panelLabelUserAccount = new JPanel(new GridBagLayout());
		this.nomLabel.setPreferredSize(tailleComponent);
		this.pseudoLabel.setPreferredSize(tailleComponent);
		this.avatarPathLabel.setPreferredSize(tailleComponent);
		this.changePwdLabel.setPreferredSize(tailleComponent);

		this.addInto(panelLabelUserAccount,nomLabel,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelLabelUserAccount,pseudoLabel,0,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelLabelUserAccount,avatarPathLabel,0,2,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelLabelUserAccount,changePwdLabel,0,3,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelLabelUserAccount,error,0,4,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);

		return panelLabelUserAccount;
	}

	/**
	 * Création du panel contenant les textField et le bouton
	 * @return
	 */
	private JPanel setTextFieldPanel() {
		JPanel panelTextFieldUserAccount = new JPanel(new GridBagLayout());
		this.nom.setPreferredSize(tailleComponent);
		this.pseudo.setPreferredSize(tailleComponent);
		this.avatarPath.setPreferredSize(tailleComponent);
		this.changePwd.setPreferredSize(tailleComponent);

		this.addInto(panelTextFieldUserAccount,nom,0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelTextFieldUserAccount,pseudo,0,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelTextFieldUserAccount,avatarPath,0,2,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelTextFieldUserAccount,changePwd,0,3,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(panelTextFieldUserAccount,updateMyAccount,0,4,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,3,0,0);

		return panelTextFieldUserAccount;
	}

	private void addAction(){
		this.updateMyAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyUpdateMyAccount(userConnected.getUuid(),nom.getText(),pseudo.getText(),avatarPath.getText(),changePwd.getText());
			}
		});
	}

	@Override
	public void addObserver(IObserverMyAccount o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyUpdateMyAccount(UUID id, String name, String pseudo, String avatarPath, String password) {
		this.observer.updateMyAccount(id,name,pseudo,avatarPath,password);

	}
}