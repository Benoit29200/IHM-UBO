package com.iup.tp.twitup.ihm.twit;

import com.iup.tp.twitup.datamodel.Twit;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Date;

public class DisplayTwit extends TwitMother {


	
	JTextArea textTwit;
	JLabel userTwiter;
	
	public DisplayTwit(Twit monTwit) {
		this.initComponent();
		this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
		this.setBorder(BorderFactory.createTitledBorder(null, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.add(setNewTwit(monTwit));
	}

	private void initComponent(){
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
