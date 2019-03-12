package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuDeconnexion.IObservableMenuDeconnexion;
import com.iup.tp.twitup.communicationInterface.vueController.menuDeconnexion.IObserverMenuDeconnexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDeconnexion extends Menu implements IObservableMenuDeconnexion {

	private IObserverMenuDeconnexion observer;
	
	public MenuDeconnexion(JFrame fenetre, IObserverMenuDeconnexion observer) {
		super();
		this.addObserver(observer);
		this.setText(this.fileLanguage.getObject(Constants.MENU_USER_ACCOUNT).toString());
        this.setItemToUserAccountMenu(fenetre); 
	}
	
	
	/**
	 * 
	 * @param fenetre
	 */
	private void setItemToUserAccountMenu(JFrame fenetre) {
		setItemToMenu(this.fileLanguage.getObject(Constants.DECONNEXION).toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
			 	notifyChargeConnexionComponent();
				 fenetre.revalidate();
			 }
		});
		
	}


	@Override
	public void addObserver(IObserverMenuDeconnexion o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyChargeConnexionComponent() {
		this.observer.chargeConnexionComponent();
	}
}
