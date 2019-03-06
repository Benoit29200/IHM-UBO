package com.iup.tp.twitup.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

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
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser;
    private ResourceBundle language;
	
    /**
     * Constructeur de la classe
     * @param fenetre
     * @param mResourceBundleLanguage
     */
	public TwitupMenu(JFrame fenetre, ResourceBundle mResourceBundleLanguage) {

	    this.language = mResourceBundleLanguage;
		JMenu fichier = new JMenu(this.language.getObject("fichier").toString());
        add(fichier);
        addItemToFichierMenu(fenetre, fichier);
        
        JMenu userAccount = new JMenu(this.language.getObject("userAccount").toString());
        

        JMenu aide = new JMenu("?");
        add(aide);

        addItemToTheProposMenu(aide);
	}

	/**
	 * Méthode privée permettant de mettre en place la fenêtre de dialogue pour le "à propos"
	 * @param aide
	 */
	private void addItemToTheProposMenu(JMenu aide) {
		addItemToMenu("A propos", aide,null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"UBO M2TIIL \n Département Informatique"," A propos",JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(getClass().getResource("/resources/images/logoIUP_50.jpg")));
            }
        });
	}

	/**
	 * 
	 * @param fenetre
	 * @param fichier
	 */
	private void addItemToFichierMenu(JFrame fenetre, JMenu fichier) {
		
		setFileChooser();
		
		addItemToMenu(this.language.getObject("ouvrir").toString(), fichier, null, new ActionListener()
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

        addItemToMenu(this.language.getObject("enregistrer_sous").toString(), fichier, null, null);
        addItemToMenu(this.language.getObject("fermer").toString(), fichier,"/resources/images/exitIcon_20.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}
	
	/**
	 * 
	 */
	 private void setFileChooser(){
	        this.fileChooser = new JFileChooser();
	        this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        this.fileChooser.setDialogTitle("Selection du dossier d'échange");
	    }
	
	 /**
	  * 
	  * @param name
	  * @param parent
	  * @param filenameIcon
	  * @param action
	  */
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
