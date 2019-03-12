package com.iup.tp.twitup.ihm.background.bordereaux;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu.IObservableBordereauMenu;
import com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu.IObserverBordereauMenu;
import com.iup.tp.twitup.ihm.background.BackgroundMother;

public class TwitupBordereauMenu extends BackgroundMother implements IObservableBordereauMenu {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	JButton home;
	JButton myAccount;
	JButton listeusers;

	private IObserverBordereauMenu observer;

	public TwitupBordereauMenu(IObserverBordereauMenu observer) {
		super();
		this.addObserver(observer);
		this.initComponent();
		this.addAction();

		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);

		this.addInto(this,this.getPanelMenu(),0,0,2,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH,5,5,0,5,0,0);
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

		this.addInto(panelMenu,picLabel,0,0,1,1,0,0,GridBagConstraints.NORTH, GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelMenu,getButtonsCreationConnexion(),0,1,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.NONE, 5,5,0,5,0,0);

		return panelMenu;
	}

	private JPanel getButtonsCreationConnexion() {

		JPanel monJPanel= new JPanel();

		monJPanel.setLayout(new GridBagLayout());
		monJPanel.setBackground(Color.white);

		this.addInto(monJPanel,this.home,0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH,5,5,0,5,0,0);
		this.addInto(monJPanel,this.myAccount,0,1,1,1,1,1,GridBagConstraints.NORTH, GridBagConstraints.BOTH, 5, 5, 0, 5,0,0);
		this.addInto(monJPanel,listeusers, 0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 5, 5, 0, 5, 0,0);

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
				notifyChargeListUser();
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