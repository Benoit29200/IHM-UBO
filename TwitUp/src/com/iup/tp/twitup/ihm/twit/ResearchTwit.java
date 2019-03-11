package com.iup.tp.twitup.ihm.twit;

import com.iup.tp.twitup.communicationInterface.vueController.twitupResearch.IObservableTwitupResearch;
import com.iup.tp.twitup.communicationInterface.vueController.twitupResearch.IObserverTwitupResearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import com.iup.tp.twitup.common.Constants;
public class ResearchTwit extends JPanel implements IObservableTwitupResearch {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverTwitupResearch observer;

	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());

	JTextField researchTextField = new JTextField();
	JButton researchButton = new JButton(this.fileLanguage.getObject(Constants.RESEARCH_TWIT_JBUTTON_TITLE).toString());

	public ResearchTwit(IObserverTwitupResearch observer) {
		this.addActionResearchTextField();
		this.observer = observer;
		Border compound = null;

		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setNewResearchBar());
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
		this.researchButton.setEnabled(false);

		return panelResearchTwit;
	}

	private void addActionResearchTextField(){
		this.researchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						observer.notifyResearch(researchTextField.getText());
					}
				});
			}
		});

	}


	@Override
	public void addObserver(IObserverTwitupResearch o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
