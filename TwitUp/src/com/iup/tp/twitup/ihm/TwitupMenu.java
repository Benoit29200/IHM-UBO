package com.iup.tp.twitup.ihm;

import javax.swing.*;

import com.iup.tp.twitup.ihm.menu.MenuConnexionCreation;
import com.iup.tp.twitup.ihm.menu.MenuFichier;
import com.iup.tp.twitup.ihm.menu.MenuInformation;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMenu extends JMenuBar {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected JFrame mainFenetre;
	
    /**
     * Constructeur de la classe
     * @param fenetre
     */
	public TwitupMenu(JFrame fenetre) {

        this.mainFenetre = fenetre;
        
        this.add(new MenuFichier(fenetre));

        //this.add(new MenuConnexionCreation(fenetre));

	    this.add(new MenuInformation(fenetre));

	}

	public void addComponent(JComponent component){
		this.add(component);
		this.revalidate();
	}
}