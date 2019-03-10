package com.iup.tp.twitup.ihm.twit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.datamodel.Twit;

public class TwitupTwit extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Dimension screenSize;
	
	JTextArea textTwit;
	JLabel userTwiter;
	
	public TwitupTwit(Twit monTwit) {
		this.initComponent();
		this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
		Border compound = null;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setNewTwit(monTwit));
	}

	private void initComponent(){
		this.screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		this.textTwit = new JTextArea();
		this.userTwiter = new JLabel();
	}

	private JPanel setNewTwit(Twit monTwit) {
		JPanel panelCreateTwit = new JPanel();
		panelCreateTwit.setLayout(new BorderLayout());
		this.textTwit.disable();
		this.textTwit.setLineWrap(true);
		this.textTwit.setBorder(new LineBorder(Color.black,2));
		this.textTwit.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/8));
		this.textTwit.setText(monTwit.getText());
		panelCreateTwit.add(textTwit, BorderLayout.CENTER);
		Date d = new Date(monTwit.getEmissionDate());
		this.userTwiter.setText("Twiter :" + monTwit.getUserTag() + " Date : "+d);
		panelCreateTwit.add(this.userTwiter, BorderLayout.SOUTH);
		return panelCreateTwit;
	}

}
