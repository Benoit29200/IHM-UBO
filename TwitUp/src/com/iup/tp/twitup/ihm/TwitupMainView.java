package com.iup.tp.twitup.ihm;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame {

    private JMenu menu;
    private JMenuItem menuItem;

    public TwitupMainView(){
        super("TwitUp");

        this.menu();

        setSize(1920,1080);
        setVisible(true);
    }

    private void menu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fichier = new JMenu("Fichier");

        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        fichier.add(ouvrir);

        JMenuItem enregistrer_sous = new JMenuItem("Enregistrer sous");
        fichier.add(enregistrer_sous);

        JMenuItem fermer = new JMenuItem("Fermer");
        fermer.setIcon(new ImageIcon("src/resources/images/exitIcon_20.png"));
        fichier.add(fermer);

        menuBar.add(fichier);


        JMenu aide = new JMenu("?");

        JMenuItem a_propos = new JMenuItem("A propos");
        aide.add(a_propos);

        a_propos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"UBO M2TIIL \n Département Informatique"," A propos",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("src/resources/images/logoIUP_50.jpg"));
            }
        });

        menuBar.add(aide);
        setJMenuBar(menuBar);
    }

    private void setWindowListener(){
        WindowListener l = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        };

        addWindowListener(l);
    }
}
