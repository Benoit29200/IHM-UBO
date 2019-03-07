package com.iup.tp.twitup.ihm.fond;

import java.awt.*;

import javax.swing.*;

import com.iup.tp.twitup.datamodel.fond.IObservableFond;
import com.iup.tp.twitup.datamodel.fond.IObserverFond;
import com.iup.tp.twitup.ihm.twit.TwitupCreateTwit;
import com.iup.tp.twitup.ihm.twit.TwitupCreateViewTwit;

/**
 * Permet d'avoir une page fond toujours affiché
 * @author gaetan
 *
 */
public class TwitupFond extends JPanel implements IObservableFond {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2724237454765496211L;

	private IObserverFond observer;

	public TwitupFond(IObserverFond observer) {
		this.setLayout(new GridBagLayout());
		this.observer = observer;
	}

	@Override
	public void chargeComponent(JComponent component, GridBagConstraints constraints) {
		this.add(component,constraints);
		this.revalidate();
		this.repaint();
	}

	@Override
	public void addObserver(IObserverFond o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyEventApp(String nom, String login, String mdp) {

	}
}
