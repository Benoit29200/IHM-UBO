package com.iup.tp.twitup.ihm.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.iup.tp.twitup.datamodel.menuFichier.IObservableMenuFichier;
import com.iup.tp.twitup.datamodel.menuFichier.IObserverMenuFichier;
import org.apache.commons.lang3.StringUtils;

public class MenuFichier extends JMenu implements IObservableMenuFichier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFileChooser fileChooser;
	
	private ResourceBundle fileLanguage;

	private IObserverMenuFichier observer;
	
	public MenuFichier(JFrame fenetre, IObserverMenuFichier observer) {
		this.fileLanguage = ResourceBundle.getBundle("menu", Locale.getDefault());
		this.observer = observer;
		this.setText(this.fileLanguage.getObject("fichier").toString());
	    this.addItemToFichierMenu(fenetre);
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
	 * @param fenetre
	 */
	private void addItemToFichierMenu(JFrame fenetre) {
		
		setFileChooser();
		
		addItemToMenu(this.fileLanguage.getObject("ouvrir").toString(),this, null, new ActionListener()
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

        addItemToMenu(this.fileLanguage.getObject("enregistrer_sous").toString(),this, null, null);
        addItemToMenu(this.fileLanguage.getObject("fermer").toString(),this,"/resources/images/exitIcon_20.png", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}

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

	@Override
	public void addObserver(IObserverMenuFichier o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyChargeFichier() {
		this.observer.chargeFichier();
	}
}
