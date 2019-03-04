package com.iup.tp.twitup.ihm;

import com.sun.deploy.util.StringUtils;

import javax.swing.*;
import java.awt.event.*;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame {

    private JFileChooser fileChooser;

    public TwitupMainView(){
        super("TwitUp");


        this.menu();

        setSize(1920,1080);
        setVisible(true);
    }

    private JMenuItem addItemToMenu(String name, JMenu parent, String filenameIcon){

        JMenuItem j = new JMenuItem(name);
        parent.add(j);
        if(filenameIcon != null){
            j.setIcon(new ImageIcon(filenameIcon));
        }
        return j;
    }

    private void menu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fichier = new JMenu("Fichier");

        JMenuItem ouvrir = addItemToMenu("Ouvrir", fichier, null);
        addFileChooser(ouvrir);

        JMenuItem enregistrer_sous = new JMenuItem("Enregistrer sous");
        fichier.add(enregistrer_sous);

        JMenuItem fermer = new JMenuItem("Fermer");
        fermer.setIcon(new ImageIcon("src/resources/images/exitIcon_20.png"));
        fermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
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

    private void addFileChooser(JMenuItem parent){
        // sélection de répertoire uniquement
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.fileChooser.setDialogTitle("Selection du dossier d'échange");


        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                switch (fileChooser.showOpenDialog(TwitupMainView.this))
                {
                    case JFileChooser.APPROVE_OPTION:
                        JOptionPane.showMessageDialog(TwitupMainView.this, "Vous avez choisi: \""+
                                        fileChooser.getSelectedFile()+"\" comme dossier d'échange",
                                "TwitUp",
                                JOptionPane.OK_OPTION);
                        break;

                    case JFileChooser.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(TwitupMainView.this, "Vous devez sélectionner un dossier d'échange avant de lancer l'application",
                                "TwitUp",
                                JOptionPane.OK_OPTION);
                        break;

                    case JFileChooser.ERROR_OPTION:
                        JOptionPane.showMessageDialog(TwitupMainView.this, "Une erreur est apparu lors de la sélection du fichier",
                                "TwitUp",
                                JOptionPane.OK_OPTION);
                }
            }
        };
        parent.addActionListener(actionListener);
    }
}
