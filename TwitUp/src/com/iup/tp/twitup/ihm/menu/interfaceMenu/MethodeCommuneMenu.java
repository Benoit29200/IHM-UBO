package com.iup.tp.twitup.ihm.menu.interfaceMenu;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.commons.lang3.StringUtils;

public interface MethodeCommuneMenu {
	/**
	  * 
	  * @param name
	  * @param filenameIcon
	  * @param action
	  */
	 void addItemToMenu(String name, JMenu menu, String filenameIcon, ActionListener action);

}
