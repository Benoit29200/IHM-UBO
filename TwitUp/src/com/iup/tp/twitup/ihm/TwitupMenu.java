package com.iup.tp.twitup.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.iup.tp.twitup.datamodel.login.IObservableLogin;
import com.iup.tp.twitup.datamodel.login.IObserverLogin;
import com.iup.tp.twitup.datamodel.menu.IObservableMenu;
import com.iup.tp.twitup.datamodel.menu.IObserverMenu;
import org.apache.commons.lang3.StringUtils;

import com.iup.tp.twitup.ihm.compte.TwitupConnexionUser;
import com.iup.tp.twitup.ihm.compte.TwitupCreationCompte;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMenu extends JMenuBar implements IObservableMenu {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFileChooser fileChooser;
    private ResourceBundle fileLanguage;
    protected TwitupMainView mainView;

    protected IObserverMenu observer;
	
    /**
     * Constructeur de la classe
     * @param fenetre
     */
	public TwitupMenu(TwitupMainView fenetre, IObserverMenu observer) {

        this.mainView = fenetre;
        this.fileLanguage = ResourceBundle.getBundle("menu", Locale.getDefault());
        this.observer = observer;

		JMenu fichier = new JMenu(this.fileLanguage.getObject("fichier").toString());
        add(fichier);
        addItemToFichierMenu(fenetre, fichier);
        
        JMenu userAccount = new JMenu(this.fileLanguage.getObject("userAccount").toString());
        add(userAccount);
        addItemToUserAccountMenu(fenetre,userAccount);        

        JMenu aide = new JMenu("?");
        add(aide);
        addItemToTheProposMenu(aide);
	}

	/**
	 * 
	 * @param fenetre
	 * @param userAccount
	 */
	private void addItemToUserAccountMenu(JFrame fenetre, JMenu userAccount) {
		addItemToMenu(this.fileLanguage.getObject("creation").toString(), userAccount, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 notifyChargeAccountManager();
			 }
		});
		
		addItemToMenu(this.fileLanguage.getObject("connexion").toString(), userAccount, null, new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				notifyChargeConnexion();
			 }
		});
		
	}

	/**
	 * Méthode privée permettant de mettre en place la fenêtre de dialogue pour le "à propos"
	 * @param aide
	 */
	private void addItemToTheProposMenu(JMenu aide) {
		addItemToMenu(this.fileLanguage.getObject("a_propos").toString(), aide,null, new ActionListener() {
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
		
		addItemToMenu(this.fileLanguage.getObject("ouvrir").toString(), fichier, null, new ActionListener()
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

        addItemToMenu(this.fileLanguage.getObject("enregistrer_sous").toString(), fichier, null, null);
        addItemToMenu(this.fileLanguage.getObject("fermer").toString(), fichier,"/resources/images/exitIcon_20.png", new ActionListener() {
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


	@Override
	public void addObserver(IObserverMenu o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyChargeAccountManager() {
		this.observer.chargeAccountManager();
	}

	@Override
	public void notifyChargeConnexion() {
		this.observer.chargeConnexion();
	}
}