package com.iup.tp.twitup.ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.iup.tp.twitup.datamodel.menu.IObservableMenuConnexionCreation;
import com.iup.tp.twitup.datamodel.menu.IObserverMenuConnexionCreation;

import com.iup.tp.twitup.ihm.menu.interfaceMenu.MethodeCommuneMenu;

public class MenuConnexionCreation extends JMenu implements MethodeCommuneMenu, IObservableMenuConnexionCreation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;
	protected IObserverMenuConnexionCreation observer;
	
	public MenuConnexionCreation(JFrame fenetre, IObserverMenuConnexionCreation observer) {
		
		this.fileLanguage = ResourceBundle.getBundle("menu", Locale.getDefault());
		this.setText(this.fileLanguage.getObject("userAccount").toString());
        this.addItemToUserAccountMenu(fenetre);
        this.observer = observer;
	}

	/**
	 * 
	 * @param fenetre
	 */
	private void addItemToUserAccountMenu(JFrame fenetre) {
		addItemToMenu(this.fileLanguage.getObject("creation").toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 notifyChargeAccountManager();
			 }
		});
		
		addItemToMenu(this.fileLanguage.getObject("connexion").toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 notifyChargeConnexion();
			 }
		});
		
	}

	@Override
	public void addItemToMenu(String name, JMenu menu, String filenameIcon, ActionListener action) {

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
