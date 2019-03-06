package com.iup.tp.twitup.ihm;

import java.awt.Dimension;

import javax.swing.*;

import com.iup.tp.twitup.datamodel.mainView.IObservableMainView;
import com.iup.tp.twitup.datamodel.mainView.IObserverMainView;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame implements IObservableMainView {

	/**
	 * observer
	 */
	protected IObserverMainView observer;


	private static final long serialVersionUID = 1L;

	public TwitupMainView() {
		super("twiItUp");
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
	}

	/**
	 * Lance l'affichage de la page de connexion
	 */
	public void chargeComponent(JPanel connexionComponent) {
		setContentPane(connexionComponent);
		revalidate();
	}

	public void setMenu(JMenuBar menu){
		setJMenuBar(menu);
	}


	/**
	 * Lance l'afficahge de l'IHM.
	 */
	public void showGUI() {
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


}