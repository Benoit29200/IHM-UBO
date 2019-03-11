package com.iup.tp.twitup.ihm.menu;

import com.iup.tp.twitup.common.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class Menu extends JMenu {

    protected ResourceBundle fileLanguage;

    public Menu() {
        this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
    }

    protected void setItemToMenu(String name, JMenu menu, String filenameIcon, ActionListener action) {
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
