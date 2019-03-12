package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuConnexionCreation.IObservableMenuConnexionCreation;
import com.iup.tp.twitup.communicationInterface.vueController.menuConnexionCreation.IObserverMenuConnexionCreation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConnexionCreation extends Menu implements IObservableMenuConnexionCreation {


	protected IObserverMenuConnexionCreation observer;
	
	public MenuConnexionCreation(IObserverMenuConnexionCreation observer) {
		
		super();
		this.addObserver(observer);
		this.setText(this.fileLanguage.getObject(Constants.MENU_USER_ACCOUNT).toString());
        this.setItemToUserAccountMenu();
	}


	private void setItemToUserAccountMenu() {
		setItemToMenu(this.fileLanguage.getObject(Constants.VIEW_CREATION_COMPTE).toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 notifyChargeAccountManager();
			 }
		});
		
		setItemToMenu(this.fileLanguage.getObject(Constants.VIEW_CONNEXION_COMPTE).toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 notifyChargeConnexion();
			 }
		});
		
	}

	@Override
	public void addObserver(IObserverMenuConnexionCreation o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyChargeAccountManager() {
		this.observer.chargeAccountManager();
	}

	@Override
	public void notifyChargeConnexion() {
		this.observer.chargeConnexion();
	}
}
