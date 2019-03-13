package com.iup.tp.twitup.ihm.background;

import com.iup.tp.twitup.communicationInterface.vueController.background.IObservableFond;
import com.iup.tp.twitup.communicationInterface.vueController.background.IObserverFond;
import com.iup.tp.twitup.ihm.account.ConsultAccount;
import com.iup.tp.twitup.ihm.account.ConsultAnUserAccount;
import com.iup.tp.twitup.ihm.account.ListTwitUser;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereau;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereauMenu;
import com.iup.tp.twitup.ihm.listUser.TwitupCreateViewUserFil;
import com.iup.tp.twitup.ihm.twit.CreateViewTwit;

import javax.swing.*;
import java.awt.*;

/**
 * Permet d'avoir une page background toujours affiché
 * @author gaetan
 *
 */
public class Background extends JPanel implements IObservableFond {
	


	private IObserverFond observer;

	public Background(IObserverFond observer) {
		this.setLayout(new GridBagLayout());
		this.addObserver(observer);
	}


	public void chargeTwitupBordereauMenu(TwitupBordereauMenu twitupBordereauMenu){
		this.add(twitupBordereauMenu,new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void chargeTwitupBordereau(TwitupBordereau twitupBordereau){
		this.add(twitupBordereau,new GridBagConstraints(2, 0, 1, 1, 0, 1, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
	}


	public void chargeTwitupCreateViewTwit(CreateViewTwit createViewTwit){
		this.add(createViewTwit,new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void chargeTwitupMyAccount(ConsultAccount ConsultAccount){
		this.add(ConsultAccount,new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void chargeListUser(TwitupCreateViewUserFil twitupCreateViewUserFil){
		this.add(twitupCreateViewUserFil,new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void chargeUserAccount(ConsultAnUserAccount consultAnUserAccount){
		this.add(consultAnUserAccount,new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void chargeListTwitUser(ListTwitUser listTwitUser){
		this.add(listTwitUser,new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
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

}
