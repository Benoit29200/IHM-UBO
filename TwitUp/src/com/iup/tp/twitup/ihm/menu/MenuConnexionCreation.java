package com.iup.tp.twitup.ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.commons.lang3.StringUtils;

import com.iup.tp.twitup.datamodel.menuConnexionCreation.IObservableMenuConnexionCreation;
import com.iup.tp.twitup.datamodel.menuConnexionCreation.IObserverMenuConnexionCreation;

public class MenuConnexionCreation extends JMenu implements IObservableMenuConnexionCreation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;
	protected IObserverMenuConnexionCreation observer;
	
	public MenuConnexionCreation(IObserverMenuConnexionCreation observer) {
		
		this.fileLanguage = ResourceBundle.getBundle("menu", Locale.getDefault());
		this.setText(this.fileLanguage.getObject("userAccount").toString());
        this.setItemToUserAccountMenu();
        this.observer = observer;
	}

	/**
	 *
	 */
	private void setItemToUserAccountMenu() {
		setItemToMenu(this.fileLanguage.getObject("creation").toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 notifyChargeAccountManager();
			 }
		});
		
		setItemToMenu(this.fileLanguage.getObject("connexion").toString(),this, null, new ActionListener() {
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
