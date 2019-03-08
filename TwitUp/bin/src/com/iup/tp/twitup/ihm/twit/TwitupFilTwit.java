package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Set;
import java.util.UUID;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.twitupFilTwit.IObservableTwitupFilTwit;
import com.iup.tp.twitup.datamodel.twitupFilTwit.IObserverTwitupFilTwit;

public class TwitupFilTwit extends JPanel implements IObservableTwitupFilTwit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverTwitupFilTwit observer;
	JPanel scrollTwit;


	public TwitupFilTwit(IObserverTwitupFilTwit observer) {
		this.setLayout(new GridBagLayout());
		this.observer = observer;
		this.scrollTwit = new JPanel(new GridBagLayout());
		scrollTwit.setMinimumSize(new Dimension(1000, 1000));
		scrollTwit.setBackground(new Color(240,248,255));
		
		JScrollPane scroll = new JScrollPane(scrollTwit, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
//		Twit twit = new Twit(new User(new UUID(0011, 002),"Test","Test","Test",null,""),"Je suis un twit");

		this.viewTwit();
		
		this.add(scroll, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void viewTwit(){
		this.scrollTwit.removeAll();
		int iterator = 0;
		for(Twit twit: this.observer.getTwit()) {
			TwitupTwit twitPanel = new TwitupTwit(twit);
			//twitPanel.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
			this.scrollTwit.add(twitPanel, new GridBagConstraints(0, iterator, 1, 1, 1, 1, GridBagConstraints.NORTH,
					GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
			iterator++;
		}
		this.scrollTwit.revalidate();
		this.scrollTwit.repaint();
	}

	public void viewTwitSearch(Set<Twit> twits){
		this.scrollTwit.removeAll();
		int iterator = 0;
		for(Twit myTwit: twits) {
			TwitupTwit twitupTwit = new TwitupTwit(myTwit);
			//twitPanel.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/6));
			this.scrollTwit.add(twitupTwit, new GridBagConstraints(0, iterator, 1, 1, 1, 1, GridBagConstraints.NORTH,
					GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
			iterator++;
		}
		this.scrollTwit.revalidate();
		this.scrollTwit.repaint();
	}

	@Override
	public void addObserver(IObserverTwitupFilTwit o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
