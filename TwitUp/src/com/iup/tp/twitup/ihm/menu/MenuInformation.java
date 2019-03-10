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

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.menuInformation.IObservableMenuInformation;
import com.iup.tp.twitup.datamodel.menuInformation.IObserverMenuInformation;
import org.apache.commons.lang3.StringUtils;

public class MenuInformation extends JMenu implements IObservableMenuInformation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverMenuInformation observer;
	
	private ResourceBundle fileLanguage;
	
	public MenuInformation(IObserverMenuInformation observer) {
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.observer = observer;
		this.setText("?");
        setItemToTheProposMenu();
	}
	
	/**
	 * Méthode privée permettant de mettre en place la fenêtre de dialogue pour le "à propos"
	 */
	private void setItemToTheProposMenu() {
		setItemToMenu(this.fileLanguage.getObject(Constants.MENU_A_PROPOS).toString(),this,null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,Constants.UBO_MESSAGE, fileLanguage.getObject(Constants.MENU_A_PROPOS).toString(),JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(getClass().getResource("/resources/images/logoIUP_50.jpg")));
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
	public void addObserver(IObserverMenuInformation o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

}
