package com.iup.tp.twitup.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMenu extends JMenuBar {
	
    private JFileChooser fileChooser;
	
	public TwitupMenu(JFrame fenetre) {
		JMenu fichier = new JMenu("Fichier");
        add(fichier);
        setFileChooser();

        addItemToMenu("Ouvrir", fichier, null, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                switch (fileChooser.showOpenDialog(fenetre))
                {
                    case JFileChooser.APPROVE_OPTION:

                        JOptionPane.showMessageDialog(fenetre, "Vous avez choisi: \""+
                                        fileChooser.getSelectedFile()+"\" comme dossier d'échange",
                                "TwitUp",
                                JOptionPane.OK_OPTION);
                        break;

                    case JFileChooser.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(fenetre, "Vous devez sélectionner un dossier d'échange avant de lancer l'application",
                                "TwitUp",
                                JOptionPane.OK_OPTION);
                        break;
                }
            }
        });

        addItemToMenu("Enregistrer sous", fichier, null, null);
        addItemToMenu("Fermer", fichier,"/resources/images/exitIcon_20.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu aide = new JMenu("?");
        add(aide);

        addItemToMenu("A propos", aide,null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"UBO M2TIIL \n Département Informatique"," A propos",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(getClass().getResource("/resources/images/logoIUP_50.jpg")));
            }
        });
	}
	
	 private void setFileChooser(){
	        this.fileChooser = new JFileChooser();
	        this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        this.fileChooser.setDialogTitle("Selection du dossier d'Ã©change");
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

    
}
