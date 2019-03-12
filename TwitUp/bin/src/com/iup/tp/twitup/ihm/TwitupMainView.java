package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.communicationInterface.vueController.mainView.IObservableMainView;
import com.iup.tp.twitup.communicationInterface.vueController.mainView.IObserverMainView;
import com.iup.tp.twitup.ihm.account.ConnexionUser;
import com.iup.tp.twitup.ihm.account.CreationCompte;
import com.iup.tp.twitup.ihm.background.Background;

import javax.swing.*;

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
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
	}

	public void addTwitupConnexionUser(ConnexionUser connexionUser){
		setContentPane(connexionUser);
		this.refresh();
	}

	public void chargeAccountManager(CreationCompte creationCompte){
		setContentPane(creationCompte);
		this.refresh();
	}

	public void chargeFond(Background background){
		setContentPane(background);
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