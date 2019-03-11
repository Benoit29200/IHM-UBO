package com.iup.tp.twitup.ihm.menu;

import javax.swing.*;

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
	

	public void addMenuConnexion(MenuConnexionCreation menuConnexionCreation){
		this.add(menuConnexionCreation);
		this.refresh();
	}

	public void addMenuFichier(MenuFichier menuFichier){
		this.add(menuFichier);
		this.refresh();
	}

	public void addMenuInformation(MenuInformation menuInformation){
		this.add(menuInformation);
		this.refresh();
	}

	public void addMenuDeconnexion(MenuDeconnexion menuDeconnexion){
		this.add(menuDeconnexion);
		this.refresh();
	}

	private void refresh(){
		this.revalidate();
		this.repaint();
	}
}