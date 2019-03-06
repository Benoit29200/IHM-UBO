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
	  * @param parent
	  * @param filenameIcon
	  * @param action
	  */
	static void addItemToMenu(String name, JMenu menu, String filenameIcon, ActionListener action){

      JMenuItem j = new JMenuItem(name);
      menu.add(j);
      if(StringUtils.isNotBlank(filenameIcon)){
          j.setIcon(new ImageIcon(menu.getClass().getResource(filenameIcon)));
      }
      if(action != null){
          j.addActionListener(action);
      }
  }
}
