package com.iup.tp.twitup.ihm;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame {

    private JFileChooser fileChooser;

    public TwitupMainView(){
        super("TwitUp");
        this.menu();
        this.setFileChooser();

        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
    }

    private void addItemToMenu(String name, JMenu parent, String filenameIcon, ActionListener action){

        JMenuItem j = new JMenuItem(name);
        parent.add(j);
        if(StringUtils.isNotBlank(filenameIcon)){
            j.setIcon(new ImageIcon(getClass().getResource(filenameIcon)));
        }
        if(action != null){
            j.addActionListener(action);
        }
    }

    private void setFileChooser(){
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.fileChooser.setDialogTitle("Selection du dossier d'échange");
    }


    private void menu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fichier = new JMenu("Fichier");
        menuBar.add(fichier);

        addItemToMenu("Ouvrir", fichier, null, new ActionListener()
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
                }
            }
        });

        addItemToMenu("Enregistrer sous", fichier, null, null);
        addItemToMenu("Fermer", fichier,"/images/exitIcon_20.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu aide = new JMenu("?");
        menuBar.add(aide);

        addItemToMenu("A propos", aide,null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"UBO M2TIIL \n Département Informatique"," A propos",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(getClass().getResource("/images/logoIUP_50.jpg")));
            }
        });
    }
}
