package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuInformation.IObservableMenuInformation;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInformation extends Menu implements IObservableMenuInformation {



	
	public MenuInformation() {
		super();
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

}
