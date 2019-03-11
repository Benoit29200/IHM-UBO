package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.communicationInterface.vueController.twitupFilTwit.IObservableTwitupFilTwit;
import com.iup.tp.twitup.communicationInterface.vueController.twitupFilTwit.IObserverTwitupFilTwit;

public class ListTwit extends JPanel implements IObservableTwitupFilTwit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverTwitupFilTwit observer;
	protected Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	JPanel scrollTwit;


	public ListTwit(IObserverTwitupFilTwit observer) {
		this.setLayout(new GridBagLayout());
		this.observer = observer;
		this.scrollTwit = new JPanel(new GridBagLayout());
		this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/7));
		scrollTwit.setMinimumSize(new Dimension(1000, 1000));
		scrollTwit.setBackground(new Color(240,248,255));
		
		JScrollPane scroll = new JScrollPane(scrollTwit, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.viewTwitSearch(this.observer.getTwit());
		
		this.add(scroll, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}


	public void viewTwitSearch(List<Twit> twits){


		List<Twit> twitList = new ArrayList<>();
		for(Twit twit: twits){
			twitList.add(twit);
		}
		Collections.reverse(twitList);

		this.scrollTwit.removeAll();
		int iterator = 0;
		for(Twit myTwit: twitList) {
			DisplayTwit displayTwit = new DisplayTwit(myTwit);
			this.scrollTwit.add(displayTwit, new GridBagConstraints(0, iterator, 1, 1, 1, 1, GridBagConstraints.NORTH,
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
