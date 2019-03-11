package com.iup.tp.twitup.ihm.listUser;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObservableCreateViewUser;
import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObserverCreateViewUser;

public class TwitupCreateViewUserFil extends JPanel implements IObservableCreateViewUser  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverCreateViewUser observer;
	
	public TwitupCreateViewUserFil(IObserverCreateViewUser observer) {
		this.observer = observer;
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(135,206,250));
	}

	@Override
	public void addObserver(IObserverCreateViewUser o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	
	public void addTwitupResearchUser(TwitupResearchUser twitupResearchUser){
		this.add(twitupResearchUser, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.refresh();
	}

	public void addTwitupFilUser(TwitupFilUser twitupFilUser){
		this.add(twitupFilUser, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.refresh();
	}

	private void refresh(){
		this.revalidate();
		this.repaint();
	}
}
