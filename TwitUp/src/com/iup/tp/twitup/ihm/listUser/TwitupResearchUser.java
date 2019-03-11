package com.iup.tp.twitup.ihm.researchUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser.IObservableResearchViewUser;
import com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser.IObserverResearchViewUser;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObservableResearchUser;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObserverResearchUser;

public class TwitupResearchUser extends JPanel implements IObservableResearchUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverResearchUser observerVue;

	private Dimension screenSize;
	
	private ResourceBundle fileLanguage;

	private JTextField researchTextField;
	private JButton researchButton;


	public TwitupResearchUser(IObserverResearchUser observerVue) {
		this.initComponent();
		this.addActionResearchTextField();
		this.addObserver(observerVue);
		Border compound = null;

		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setLayout(new GridBagLayout());
		this.addObserver(observer);
		this.setBackground(Color.WHITE);
		this.add(setNewResearchBar(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	private void initComponent(){
		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		this.setPreferredSize(new Dimension(this.screenSize.width/2,this.screenSize.height/2));

		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());

		this.researchTextField = new JTextField();
		this.researchButton = new JButton(this.fileLanguage.getObject(Constants.RESEARCH_TWIT_JBUTTON_TITLE).toString());
	}

	/**
	 * Permet de créer le JPanel de recherche de twit
	 * @return
	 */
	private JPanel setNewResearchBar() {
		JPanel panelResearchTwit = new JPanel();
		panelResearchTwit.setLayout(new GridBagLayout());
		this.researchTextField.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/15));
		panelResearchTwit.add(researchTextField, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		panelResearchTwit.add(this.researchButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		return panelResearchTwit;
	}

	private void addActionResearchTextField(){
		this.researchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						notifySearchUser(researchTextField.getText());
					}
				});
			}
		});
	}

	@Override
	public void addObserver(IObserverResearchUser o) {
		this.observerVue = o;
	}

	@Override
	public void deleteObserver() {
		this.observerVue = null;
	}

	@Override
	public void notifySearchUser(String userName) {
		this.observerVue.searchUser(userName);
	}

}
