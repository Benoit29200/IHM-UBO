package com.iup.tp.twitup.ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.commons.lang3.StringUtils;

public class MenuDeconnexion extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;
	
	public MenuDeconnexion(JFrame fenetre) {
		
		this.fileLanguage = ResourceBundle.getBundle("menu", Locale.getDefault());
		this.setText(this.fileLanguage.getObject("userAccount").toString());
        this.addItemToUserAccountMenu(fenetre); 
	}
	
	
	/**
	 * 
	 * @param fenetre
	 */
	private void addItemToUserAccountMenu(JFrame fenetre) {
		addItemToMenu(this.fileLanguage.getObject("deconnexion").toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 //fenetre.setContentPane();
				 fenetre.revalidate();
			 }
		});
		
	}

	public void addItemToMenu(String name, JMenu menu, String filenameIcon, ActionListener action) {
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
