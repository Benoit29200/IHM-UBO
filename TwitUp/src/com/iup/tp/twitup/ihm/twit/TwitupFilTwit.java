package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.UUID;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class TwitupFilTwit extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	public TwitupFilTwit() {
		this.setLayout(new GridBagLayout());
		this.setBorder(new LineBorder(Color.RED, 2, true));
		
		JPanel testScroll = new JPanel(new GridBagLayout());
		testScroll.setMinimumSize(new Dimension(1000, 1000));
		//testScroll.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
		
		JScrollPane scroll = new JScrollPane(testScroll, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		Twit twit = new Twit(new User(new UUID(0011, 002),"Test","Test","Test",null,""),"Je suis un twit");
		
		for(int i = 0; i<5 ; i++) {
			TwitupTwit twitPanel = new TwitupTwit(twit);
			//twitPanel.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
			testScroll.add(twitPanel, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		}
		testScroll.revalidate();
		testScroll.repaint();
		
		this.add(scroll, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

}
