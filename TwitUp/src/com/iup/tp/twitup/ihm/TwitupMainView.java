package com.iup.tp.twitup.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.iup.tp.twitup.datamodel.mainView.IObservableMainView;
import com.iup.tp.twitup.datamodel.mainView.IObserverMainView;
import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.database.IDatabase;
import com.iup.tp.twitup.ihm.compte.TwitupCreationCompte;
import com.iup.tp.twitup.ihm.fond.TwitupFond;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame implements IObservableMainView {
    
    /**
	 * Base de don�nes de l'application.
	 */
	protected IDatabase mDatabase;

	/**
	 * Gestionnaire de bdd et de fichier.
	 */
	protected EntityManager mEntityManager;

	/**
	 * observer
	 */
	protected IObserverMainView observer;


	private static final long serialVersionUID = 1L;

	public TwitupMainView(IDatabase database, EntityManager entityManager) {
		super("twiItUp");
		this.mDatabase = database;
		this.mEntityManager = entityManager;
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
	}
	
	/**
	 * Initialisation de l'IHM
	 */
	protected void initGUI() {
		setJMenuBar(new TwitupMenu(this));
		TwitupFond fond = new TwitupFond();
		//fond.addComponentInPage(new TwitupCreationCompte());
		setContentPane(fond);
	}

	/**
	 * Lance l'afficahge de l'IHM.
	 */
	public void showGUI() {
		// Init auto de l'IHM au cas ou ;)
		this.initGUI();
		// Affichage dans l'EDT
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Custom de l'affichage
				setIconImage(new ImageIcon("/resources/images/logoIUP_20.jpg").getImage());
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(true);
			}
		});
	}

	@Override
	public void addObserver(IObserverMainView o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyController() {
		//TODO
	}
}