package com.iup.tp.twitup.ihm.fond;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu.IObservableBordereauMenu;
import com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu.IObserverBordereauMenu;

public class TwitupBordereauMenu extends JPanel implements IObservableBordereauMenu {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ResourceBundle fileLanguage;

	JButton home;
	JButton myAccount;
	JButton listeusers;

	private IObserverBordereauMenu observer;

	public TwitupBordereauMenu(IObserverBordereauMenu observer) {
		this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
		this.addObserver(observer);
		this.initComponent();
		this.addAction();

		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.add(this.getPanelMenu(), new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	private void initComponent(){
		this.home = new JButton(this.fileLanguage.getObject(Constants.VIEW_ACCUEIL).toString());
		this.myAccount = new JButton(this.fileLanguage.getObject(Constants.VIEW_MON_COMPTE).toString());
		this.listeusers = new JButton(this.fileLanguage.getObject(Constants.USER_LIST_USERS).toString());
	}

	private JPanel getPanelMenu() {

		JPanel panelMenu = new JPanel();
		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource(Constants.CLE_IMAGES+"logoTwitterDummy.png")));

		panelMenu.setBackground(Color.WHITE);
		panelMenu.setLayout(new GridBagLayout());

		panelMenu.add(picLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		panelMenu.add(getButtonsCreationConnexion(), new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));

		return panelMenu;
	}

	private JPanel getButtonsCreationConnexion() {

		JPanel monJPanel= new JPanel();

		monJPanel.setLayout(new GridBagLayout());
		monJPanel.setBackground(Color.white);

		monJPanel.add(this.home, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));

		monJPanel.add(this.myAccount, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));

		monJPanel.add(listeusers, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));

		return monJPanel;
	}

	private void addAction(){
		this.home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyChargeTwitView();
			}
		});

		this.myAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyChargeMyAccount();
			}
		});

		this.listeusers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyChargeMyAccount();
			}
		});
	}

	@Override
	public void addObserver(IObserverBordereauMenu o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyChargeTwitView() {
		this.observer.eventChargeTwitView();
	}

	@Override
	public void notifyChargeMyAccount() {
		this.observer.eventChargeMyAccount();
	}

	@Override
	public void notifyChargeListUser() {
		this.observer.eventChargeListUser();
	}
}