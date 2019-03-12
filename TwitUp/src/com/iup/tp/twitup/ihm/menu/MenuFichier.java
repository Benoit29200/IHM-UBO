package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.menuFichier.IObservableMenuFichier;
import com.iup.tp.twitup.communicationInterface.vueController.menuFichier.IObserverMenuFichier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFichier extends Menu implements IObservableMenuFichier {


	
	private JFileChooser fileChooser;

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
		
		setFileChooser();
		
		setItemToMenu(this.fileLanguage.getObject(Constants.MENU_OUVRIR).toString(),this, null, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                switch (fileChooser.showOpenDialog(fenetre))
                {
                    case JFileChooser.APPROVE_OPTION:

                        JOptionPane.showMessageDialog(fenetre, "Vous avez choisi: \""+
                                        fileChooser.getSelectedFile()+"\" comme dossier d'échange",
                                "TwitUp",
                                JOptionPane.OK_OPTION);
                        break;

                    case JFileChooser.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(fenetre, fileLanguage.getObject(Constants.CLE_ERREUR_DOSSIER_ECHANGE).toString(),
                                "TwitUp",
                                JOptionPane.OK_OPTION);
                        break;
                }
            }
        });

        setItemToMenu(this.fileLanguage.getObject(Constants.MENU_ENREGISTRER_SOUS).toString(),this, null, null);
        setItemToMenu(this.fileLanguage.getObject(Constants.MENU_FERMER).toString(),this,"/resources/images/exitIcon_20.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}

	/**
	 *
	 */
	private void setFileChooser(){
		this.fileChooser = new JFileChooser();
		this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.fileChooser.setDialogTitle(this.fileLanguage.getObject(Constants.CLE_DOSSIER_ECHANGE).toString());
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
