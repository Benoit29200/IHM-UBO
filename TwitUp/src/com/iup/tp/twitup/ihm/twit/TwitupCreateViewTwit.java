package com.iup.tp.twitup.ihm.twit;

import com.iup.tp.twitup.datamodel.createViewTwit.IObservableCreateViewTwit;
import com.iup.tp.twitup.datamodel.createViewTwit.IObserverCreateViewTwit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class TwitupCreateViewTwit extends JPanel implements IObservableCreateViewTwit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverCreateViewTwit observer;

	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	public TwitupCreateViewTwit(IObserverCreateViewTwit observer) {
		this.observer = observer;
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
		this.setBackground(new Color(135,206,250));
//		this.setBorder(new LineBorder(Color.WHITE, 4, true));
//		this.setBackground(Color.WHITE);
		this.add(new TwitupCreateTwit(), new GridBagConstraints(0, 0, 1, 1, 0, 0.2, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.add(new TwitupFilTwit(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	@Override
	public void addObserver(IObserverCreateViewTwit o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
