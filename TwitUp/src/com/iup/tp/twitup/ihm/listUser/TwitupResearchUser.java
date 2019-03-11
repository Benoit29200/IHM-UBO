package com.iup.tp.twitup.ihm.listUser;

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
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObservableResearchUser;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObserverResearchUser;
public class TwitupResearchUser extends JPanel implements IObservableResearchUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverResearchUser observer;

	private Dimension screenSize;
	
	private ResourceBundle fileLanguage;

	private JTextField researchTextField;
	private JButton researchButton;
	
	public TwitupResearchUser(IObserverResearchUser observer) {
		this.initComponent();
		this.setLayout(new GridBagLayout());
		this.addObserver(observer);
		this.setBackground(Color.WHITE);
		
		this.researchTextField.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/15));
		this.add(researchTextField, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.add(this.researchButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
	}

	private void initComponent(){
		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());

		this.researchTextField = new JTextField();
		this.researchButton = new JButton(this.fileLanguage.getObject(Constants.RESEARCH_TWIT_JBUTTON_TITLE).toString());
	}

	@Override
	public void addObserver(IObserverResearchUser o) {
		this.observer = observer;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
