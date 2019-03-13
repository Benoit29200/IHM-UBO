package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuFichier.IObservableMenuFichier;
import com.iup.tp.twitup.communicationInterface.vueController.menuFichier.IObserverMenuFichier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFichier extends Menu implements IObservableMenuFichier {




	private IObserverMenuFichier observer;
	
	public MenuFichier(JFrame fenetre, IObserverMenuFichier observer) {
		super();
		this.addObserver(observer);
		this.setText(this.fileLanguage.getObject(Constants.MENU_FICHIER).toString());
	    this.setItemToFichierMenu(fenetre);
	}

	/**
	 * 
	 * @param fenetre
	 */
	private void setItemToFichierMenu(JFrame fenetre) {
        setItemToMenu(this.fileLanguage.getObject(Constants.MENU_FERMER).toString(),this,"/resources/images/exitIcon_20.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}

	@Override
	public void addObserver(IObserverMenuFichier o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

}
