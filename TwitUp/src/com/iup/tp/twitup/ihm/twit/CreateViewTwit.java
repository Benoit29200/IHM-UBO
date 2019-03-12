package com.iup.tp.twitup.ihm.twit;

import com.iup.tp.twitup.communicationInterface.betweenController.createViewTwit.IObservableCreateViewTwit;
import com.iup.tp.twitup.communicationInterface.betweenController.createViewTwit.IObserverCreateViewTwit;

import java.awt.*;

public class CreateViewTwit extends TwitMother implements IObservableCreateViewTwit {


	private IObserverCreateViewTwit observer;

	public CreateViewTwit(IObserverCreateViewTwit observer) {
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

	public void addTwitupCreateTwit(CreateTwitForm createTwitForm){
		this.addInto(this,createTwitForm,0,0,1,1,0,0.4,GridBagConstraints.CENTER, GridBagConstraints.BOTH,5,5,0,5,0,0);
		this.refresh();
	}
	
	public void addTwitupResearchTwit(ResearchTwit researchTwit){
		this.addInto(this,researchTwit,0,1,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,5,5,0,5,0,0);
		this.refresh();
	}

	public void addTwitupFilTwit(ListTwit listTwit){
		this.addInto(this,listTwit,0,2,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 5, 5, 0, 5, 0, 0);
		this.refresh();
	}

	private void refresh(){
		this.revalidate();
		this.repaint();
	}
}
