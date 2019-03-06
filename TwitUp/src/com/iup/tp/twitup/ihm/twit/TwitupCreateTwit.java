package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class TwitupCreateTwit extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton creationTwit = new JButton("Créer mon twit");

	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	JTextField textTwit = new JTextField();
	
	public TwitupCreateTwit() {
		this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
//		this.setBorder(new LineBorder(Color.GRAY, 2, true));
		Border compound = null;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.textTwit.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/8));
		this.add(textTwit);
		this.add(creationTwit);
	}
	
	

}
