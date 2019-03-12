package com.iup.tp.twitup.ihm.twit;

import com.iup.tp.twitup.communicationInterface.vueController.listTwit.IObservableTwitupFilTwit;
import com.iup.tp.twitup.communicationInterface.vueController.listTwit.IObserverTwitupFilTwit;
import com.iup.tp.twitup.datamodel.Twit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTwit extends TwitMother implements IObservableTwitupFilTwit {

	private IObserverTwitupFilTwit observer;
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
		this.addInto(this,scroll,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH,5,5,0,5,0,0);
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
			this.addInto(this.scrollTwit,displayTwit,0,iterator,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE,5,5,0,5,0,0);
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
