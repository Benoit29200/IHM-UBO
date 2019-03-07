package com.iup.tp.twitup.ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.iup.tp.twitup.ihm.menu.interfaceMenu.MethodeCommuneMenu;

public class MenuInformation extends JMenu implements MethodeCommuneMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage;
	
	public MenuInformation(JFrame fenetre) {
		this.fileLanguage = ResourceBundle.getBundle("menu", Locale.getDefault());
		this.setText("?");
        addItemToTheProposMenu();
	}
	
	/**
	 * Méthode privée permettant de mettre en place la fenêtre de dialogue pour le "à propos"
	 */
	private void addItemToTheProposMenu() {
		addItemToMenu(this.fileLanguage.getObject("a_propos").toString(),this,null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"UBO M2TIIL \n Département Informatique"," A propos",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(getClass().getResource("/resources/images/logoIUP_50.jpg")));
            }
        });
	}

	@Override
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
