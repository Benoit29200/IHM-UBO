package com.iup.tp.twitup.ihm.twit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.common.Constants;

public class TwitupResearch extends JPanel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
	
	JTextField researchTextField = new JTextField();
	JButton researchButton = new JButton(this.fileLanguage.getObject(Constants.RESEARCH_TWIT_JBUTTON_TITLE).toString());
	
	public TwitupResearch() {
		this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
		Border compound = null;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setNewResearchBar());
	}

	private JPanel setNewResearchBar() {
		JPanel panelResearchTwit = new JPanel();
		panelResearchTwit.setLayout(new BorderLayout());
		this.researchTextField.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/15));
		panelResearchTwit.add(researchTextField, BorderLayout.CENTER);
		panelResearchTwit.add(this.researchButton, BorderLayout.EAST);
		return panelResearchTwit;
	}


}
