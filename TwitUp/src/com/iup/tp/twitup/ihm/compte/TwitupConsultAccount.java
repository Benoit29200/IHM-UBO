package com.iup.tp.twitup.ihm.compte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.myAccount.IObservableMyAccount;
import com.iup.tp.twitup.datamodel.myAccount.IObserverMyAccount;

public class TwitupConsultAccount extends JPanel implements IObservableMyAccount {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	Dimension tailleComponent = new Dimension(screenSize.width/3, screenSize.height/15);
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());

	private JLabel nomLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_NOM).toString());
	private JLabel pseudoLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_PSEUDO).toString());
	private JLabel avatarPathLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_AVATAR).toString());
	private JLabel changePwdLabel = new JLabel(this.fileLanguage.getObject(Constants.VIEW_CHANGE_PWD).toString());

	private JTextField nom = new JTextField();
	private JTextField pseudo = new JTextField();
	private JTextField avatarPath = new JTextField();
	private JPasswordField changePwd = new JPasswordField();

	private IObserverMyAccount observer;
	
	JButton updatemyaccount = new JButton(this.fileLanguage.getObject(Constants.RESEARCH_TWIT_JBUTTON_TITLE).toString());
	
	public TwitupConsultAccount(IObserverMyAccount observer) {
		Border compound = null;
		this.observer = observer;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setPanelAccount());
		User userConnected = this.observer.getUserConnected();
		this.nom.setText(userConnected.getName());
		this.pseudo.setText(userConnected.getUserTag());
		this.avatarPath.setText(userConnected.getAvatarPath());
	}

	/**
	 * Permet de créer le JPanel de gestion du compte
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
		
		panelLabelUserAccount.add(nomLabel,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelLabelUserAccount.add(pseudoLabel,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelLabelUserAccount.add(avatarPathLabel,new GridBagConstraints(0,2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelLabelUserAccount.add(changePwdLabel,new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
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
		
		panelTextFieldUserAccount.add(nom,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelTextFieldUserAccount.add(pseudo,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelTextFieldUserAccount.add(avatarPath,new GridBagConstraints(0,2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelTextFieldUserAccount.add(changePwd,new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelTextFieldUserAccount.add(updatemyaccount,new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		
		return panelTextFieldUserAccount;
	}

	@Override
	public void addObserver(IObserverMyAccount o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
