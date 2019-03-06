package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TwitupCreateTwit extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton creationTwit = new JButton("Créer mon twit");

	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	JTextField textTwit = new JTextField();
	
	public TwitupCreateTwit() {
		this.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/6));
		this.setBorder(new LineBorder(Color.GRAY, 4, true));
		this.setBackground(Color.LIGHT_GRAY);
		this.textTwit.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/8));

		this.add(textTwit);
		
		this.add(creationTwit);
	}

}
