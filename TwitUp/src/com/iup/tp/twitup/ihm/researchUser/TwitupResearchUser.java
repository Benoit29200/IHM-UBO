package com.iup.tp.twitup.ihm.researchUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObservableResearchUser;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObserverResearchUser;
import com.iup.tp.twitup.communicationInterface.vueController.twitupResearch.IObservableTwitupResearch;
import com.iup.tp.twitup.communicationInterface.vueController.twitupResearch.IObserverTwitupResearch;
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
		this.addActionResearchTextField();
		this.addObserver(observer);
		Border compound = null;

		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setNewResearchBar());
	}

	private void initComponent(){
		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

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
		panelResearchTwit.setLayout(new BorderLayout());
		this.researchTextField.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/15));
		panelResearchTwit.add(researchTextField, BorderLayout.CENTER);
		panelResearchTwit.add(this.researchButton, BorderLayout.SOUTH);
		return panelResearchTwit;
	}

	private void addActionResearchTextField(){

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
