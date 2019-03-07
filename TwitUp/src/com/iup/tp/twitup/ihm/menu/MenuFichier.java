package com.iup.tp.twitup.ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.menuFichier.IObservableMenuFichier;
import com.iup.tp.twitup.datamodel.menuFichier.IObserverMenuFichier;

public class MenuFichier extends JMenu implements IObservableMenuFichier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFileChooser fileChooser;
	
	private ResourceBundle fileLanguage;

	private IObserverMenuFichier observer;
	
	public MenuFichier(JFrame fenetre, IObserverMenuFichier observer) {
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.observer = observer;
		this.setText(this.fileLanguage.getObject(Constants.MENU_FICHIER).toString());
	    this.setItemToFichierMenu(fenetre);
	}
	
	
	
	/**
	 * 
	 */
	 private void setFileChooser(){
	        this.fileChooser = new JFileChooser();
	        this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        this.fileChooser.setDialogTitle(Constants.CLE_DOSSIER_ECHANGE);
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
                        JOptionPane.showMessageDialog(fenetre, Constants.CLE_ERREUR_DOSSIER_ECHANGE,
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
	public void addObserver(IObserverMenuFichier o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyChargeFichier() {
		this.observer.chargeFichier();
	}
}
