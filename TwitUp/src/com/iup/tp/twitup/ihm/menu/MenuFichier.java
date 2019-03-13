package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuFichier.IObservableMenuFichier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFichier extends Menu implements IObservableMenuFichier {




	
	public MenuFichier() {
		super();
		this.setText(this.fileLanguage.getObject(Constants.MENU_FICHIER).toString());
	    this.setItemToFichierMenu();
	}

	private void setItemToFichierMenu() {
        setItemToMenu(this.fileLanguage.getObject(Constants.MENU_FERMER).toString(),this,"/resources/images/exitIcon_20.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}


}
