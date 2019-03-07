package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.createTwit.IObservableCreateTwit;
import com.iup.tp.twitup.datamodel.createTwit.IObserverCreateTwit;

public class TwitupCreateTwit extends JPanel implements IObservableCreateTwit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverCreateTwit observer;
	
	JButton creationTwit = new JButton(Constants.CREATION_TWIT);

	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	JTextField textTwit = new JTextField();
	
	public TwitupCreateTwit(IObserverCreateTwit observer) {
		this.observer = observer;
		Border compound = null;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.textTwit.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/8));
		this.add(textTwit);
		this.add(creationTwit);
	}


	@Override
	public void addObserver(IObserverCreateTwit o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
