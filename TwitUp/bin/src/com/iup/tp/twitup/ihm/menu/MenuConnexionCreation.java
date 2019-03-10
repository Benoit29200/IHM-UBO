package com.iup.tp.twitup.ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.commons.lang3.StringUtils;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuConnexionCreation.IObservableMenuConnexionCreation;
import com.iup.tp.twitup.communicationInterface.vueController.menuConnexionCreation.IObserverMenuConnexionCreation;

public class MenuConnexionCreation extends JMenu implements IObservableMenuConnexionCreation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;
	protected IObserverMenuConnexionCreation observer;
	
	public MenuConnexionCreation(IObserverMenuConnexionCreation observer) {
		
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.setText(this.fileLanguage.getObject(Constants.MENU_USER_ACCOUNT).toString());
        this.setItemToUserAccountMenu();
        this.addObserver(observer);
	}

	/**
	 *
	 */
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

	public void setItemToMenu(String name, JMenu menu, String filenameIcon, ActionListener action) {
		JMenuItem j = new JMenuItem(name);
		menu.add(j);
		if(StringUtils.isNotBlank(filenameIcon)){
			j.setIcon(new ImageIcon(menu.getClass().getResource(filenameIcon)));
		}
		if(action != null){
			j.addActionListener(action);
		}
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
