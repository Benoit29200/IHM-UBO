package com.iup.tp.twitup.ihm.twit;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TwitupCreateViewTwit extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	public TwitupCreateViewTwit() {
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
//		this.setBorder(new LineBorder(Color.WHITE, 4, true));
//		this.setBackground(Color.WHITE);
		this.add(new TwitupCreateTwit(), new GridBagConstraints(0, 0, 1, 1, 0, 0.2, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.add(new TwitupFilTwit(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}
	
	

}
