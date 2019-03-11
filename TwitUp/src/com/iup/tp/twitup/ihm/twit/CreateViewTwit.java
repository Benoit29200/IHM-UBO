package com.iup.tp.twitup.ihm.twit;

import com.iup.tp.twitup.communicationInterface.betweenController.createViewTwit.IObservableCreateViewTwit;
import com.iup.tp.twitup.communicationInterface.betweenController.createViewTwit.IObserverCreateViewTwit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class CreateViewTwit extends JPanel implements IObservableCreateViewTwit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverCreateViewTwit observer;
	
	protected Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
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
		this.add(createTwitForm, new GridBagConstraints(0, 0, 1, 1, 0, 0.4, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.refresh();
	}
	
	public void addTwitupResearchTwit(ResearchTwit researchTwit){
		this.add(researchTwit, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
		this.refresh();
	}

	public void addTwitupFilTwit(ListTwit listTwit){
		this.add(listTwit, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		this.refresh();
	}

	private void refresh(){
		this.revalidate();
		this.repaint();
	}
}
