package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuInformation.IObservableMenuInformation;
import com.iup.tp.twitup.communicationInterface.vueController.menuInformation.IObserverMenuInformation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInformation extends Menu implements IObservableMenuInformation {


	private IObserverMenuInformation observer;

	
	public MenuInformation(IObserverMenuInformation observer) {
		super();
		this.addObserver(observer);
		this.setText("?");
        setItemToTheProposMenu();
	}
	
	/**
	 * Méthode privée permettant de mettre en place la fenêtre de dialogue pour le "à propos"
	 */
	private void setItemToTheProposMenu() {
		setItemToMenu(this.fileLanguage.getObject(Constants.MENU_A_PROPOS).toString(),this,null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,Constants.UBO_MESSAGE, fileLanguage.getObject(Constants.MENU_A_PROPOS).toString(),JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(getClass().getResource("/resources/images/logoIUP_50.jpg")));
            }
        });
	}

	@Override
	public void addObserver(IObserverMenuInformation o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

}
