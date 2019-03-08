package com.iup.tp.twitup.ihm.researchUser;

import com.iup.tp.twitup.datamodel.createViewTwit.IObservableCreateViewTwit;
import com.iup.tp.twitup.datamodel.createViewTwit.IObserverCreateViewTwit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class TwitupCreateViewUserFil extends JPanel implements IObservableCreateViewTwit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverCreateViewTwit observer;
	
	public TwitupCreateViewUserFil(IObserverCreateViewTwit observer) {
		this.observer = observer;
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(135,206,250));


	}

	@Override
	public void addObserver(IObserverCreateViewTwit o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	
	public void addTwitupResearchTwit(TwitupResearchUser twitupResearchUser){
		this.add(twitupResearchUser, new GridBagConstraints(0, 0, 1, 1,0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
		this.refresh();
	}

	public void addTwitupFilTwit(TwitupFilUser twitupFilUser){
		this.add(twitupFilUser, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.refresh();
	}

	private void refresh(){
		this.revalidate();
		this.repaint();
	}
}
