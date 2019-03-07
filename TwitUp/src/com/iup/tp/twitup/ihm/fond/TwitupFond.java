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


	public void chargeTwitupBordereauMenu(TwitupBordereauMenu twitupBordereauMenu){
		this.add(twitupBordereauMenu,new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void chargeTwitupBordereau(TwitupBordereau twitupBordereau){
		this.add(twitupBordereau,new GridBagConstraints(2, 0, 1, 1, 0, 1, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
	}


	public void chargeTwitupCreateViewTwit(TwitupCreateViewTwit twitupCreateViewTwit){
		this.add(twitupCreateViewTwit,new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
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
