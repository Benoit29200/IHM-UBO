package com.iup.tp.twitup.ihm.listUser;

import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObservableCreateViewUser;
import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObserverCreateViewUser;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObservableCreateViewUser;
import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObserverCreateViewUser;
import com.iup.tp.twitup.ihm.background.Background;

public class TwitupCreateViewUserFil extends Background implements IObservableCreateViewUser  {

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
		this.addInto(this,twitupResearchUser,0,0,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.BOTH,5,5,0,5,0,0);
		this.refresh();
	}

	public void addTwitupFilUser(TwitupFilUser twitupFilUser){
		this.addInto(this,twitupFilUser,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH,5,5,0,5,0,0,0);
		this.refresh();
	}

	private void refresh(){
		this.revalidate();
		this.repaint();
	}
}
