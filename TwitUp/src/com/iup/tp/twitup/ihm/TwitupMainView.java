package com.iup.tp.twitup.ihm;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame {


    public TwitupMainView(){
        super("TwitUp");
        setJMenuBar(new TwitupMenu(this));
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
    }
}
