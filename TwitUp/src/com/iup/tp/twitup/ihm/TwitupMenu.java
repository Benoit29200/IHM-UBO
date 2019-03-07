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
	
    /**
     * Constructeur de la classe
     */
	public TwitupMenu() {


	}

	public void addComponent(JComponent component){
		this.add(component);
		this.revalidate();
	}
}