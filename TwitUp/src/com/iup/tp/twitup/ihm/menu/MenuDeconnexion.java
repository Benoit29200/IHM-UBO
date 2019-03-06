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

import com.iup.tp.twitup.ihm.menu.interfaceMenu.MethodeCommuneMenu;

public class MenuDeconnexion extends JMenu implements MethodeCommuneMenu{

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
	 * @param userAccount
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

}
