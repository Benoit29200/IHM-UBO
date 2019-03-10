package com.iup.tp.twitup.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import com.iup.tp.twitup.datamodel.mainView.IObservableMainView;
import com.iup.tp.twitup.datamodel.mainView.IObserverMainView;
import com.iup.tp.twitup.ihm.compte.TwitupConnexionUser;
import com.iup.tp.twitup.ihm.compte.TwitupCreationCompte;
import com.iup.tp.twitup.ihm.fond.TwitupFond;

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

	public void addTwitupConnexionUser(TwitupConnexionUser twitupConnexionUser){
		setContentPane(twitupConnexionUser);
		this.refresh();
	}

	public void chargeAccountManager(TwitupCreationCompte twitupCreationCompte){
		setContentPane(twitupCreationCompte);
		this.refresh();
	}

	public void chargeFond(TwitupFond twitupFond){
		setContentPane(twitupFond);
		this.refresh();
	}


	public void refresh(){
		this.revalidate();
		this.repaint();
	}

	public void setMenu(JMenuBar menu){
		setJMenuBar(menu);
	}


	/**
	 * Lance l'afficahge de l'IHM.
	 */
	public void showGUI() {
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