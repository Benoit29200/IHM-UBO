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

import com.iup.tp.twitup.common.Constants;

public class MenuDeconnexion extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;
	
	public MenuDeconnexion(JFrame fenetre) {
		
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.setText(this.fileLanguage.getObject(Constants.MENU_USER_ACCOUNT).toString());
        this.setItemToUserAccountMenu(fenetre); 
	}
	
	
	/**
	 * 
	 * @param fenetre
	 */
	private void setItemToUserAccountMenu(JFrame fenetre) {
		setItemToMenu(this.fileLanguage.getObject(Constants.DECONNEXION).toString(),this, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 //fenetre.setContentPane();
				 fenetre.revalidate();
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
}
