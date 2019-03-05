package com.iup.tp.twitup.ihm;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame {
    
    /**
	 * Base de donénes de l'application.
	 */
	protected IDatabase mDatabase;

	/**
	 * Gestionnaire de bdd et de fichier.
	 */
	protected EntityManager mEntityManager;
	
	protected JTextArea grandeZone = new JTextArea(4, 10);

	private static final long serialVersionUID = 1L;

	public TwitupMainView(IDatabase database, EntityManager entityManager) {
		super("twiItUp");
		this.mDatabase = database;
		this.mEntityManager = entityManager;
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
//        try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * Initialisation de l'IHM
	 */
	protected void initGUI() {
		setJMenuBar(new TwitupMenu(this));
		add(grandeZone);
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
				setVisible(true);
			}
		});
	}
    
}
