package com.iup.tp.twitup.ihm.background.bordereaux;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.common.LOGER;

import com.iup.tp.twitup.communicationInterface.vueController.bordereau.IObservableBordereau;
import com.iup.tp.twitup.communicationInterface.vueController.bordereau.IObserverBordereau;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ImagePanel;
import com.iup.tp.twitup.ihm.background.BackgroundMother;

public class TwitupBordereau extends BackgroundMother implements IObservableBordereau {


	private IObserverBordereau observer;

	private JLabel connexion;
	private User userConnected;
	private ImagePanel avatar;
	private ArrayList<JButton> buttonFollower;
	
	public TwitupBordereau(IObserverBordereau observer, User userConnected) {
		super();
		this.buttonFollower = new ArrayList<>();
		this.userConnected = userConnected;
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.addObserver(observer);
		this.addInto(this,this.getPanelUtilisateurEtFollowers(),0,0,1,1,1,1,GridBagConstraints.NORTH, GridBagConstraints.BOTH, 5,5,0,5,0,0);

	}
	
	/**
	 * Permet de contruire le Panel qui sera affiché comprenant le panel utilisateur et le panel follower
	 * @return un JPanel
	 */
	private JPanel getPanelUtilisateurEtFollowers() {
		JPanel panelFinal = new JPanel();
		panelFinal.setBackground(Color.WHITE);
		panelFinal.setLayout(new GridBagLayout());
		
		JPanel panelUtilisateur = getPanelUtilisateur();
		JPanel panelFollower = this.getFollowerUtilisateur();
		
		panelUtilisateur.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

		this.addInto(panelFinal, panelUtilisateur,0,0,1,1,1,1,GridBagConstraints.NORTH, GridBagConstraints.NONE, 5,5,0,5,0,0);

		panelFollower.setBorder(BorderFactory.createLineBorder(Color.GREEN));

		this.addInto(panelFinal,panelFollower,0,1,1,1,1,1,GridBagConstraints.NORTH, GridBagConstraints.BOTH, 5, 5, 0, 5,0,0);
		
		return panelFinal;
	}

	public void updateUser(User u){
		this.connexion.setText(u.getUserTag());
		this.avatar = new ImagePanel(new File(this.userConnected.getAvatarPath()), new Dimension(80,80));

		revalidate();
		repaint();
	}

	/**
	 * Permet de retourner un panel comprenant les infos de l'utilisateur
	 * @return
	 */
	private JPanel getPanelUtilisateur() {
		
		JPanel panelUtilisateur= new JPanel();
		panelUtilisateur.setBackground(Color.white);
		panelUtilisateur.setLayout(new GridBagLayout());

		this.connexion = new JLabel(this.userConnected.getUserTag());
		panelUtilisateur.setMinimumSize(new Dimension(92,100));

		String path =getClass().getResource(this.userConnected.getAvatarPath()).toString();
		try{
			this.avatar = new ImagePanel(new File(getClass().getResource(this.userConnected.getAvatarPath()).toURI()), new Dimension(80,80));
		} catch(Exception e){
			LOGER.err("Erreur récupération image utilisateur connecté");
		}

		this.addInto(panelUtilisateur,this.avatar,0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.NONE,5,5,0,5,0,0);
		this.addInto(panelUtilisateur,this.connexion,0,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,5,5,0,5,0,0);

		return panelUtilisateur;
	}
	
	private JPanel getFollowerUtilisateur() {
		JPanel follow = new JPanel(new GridBagLayout());

		follow.setBackground(new Color(240,248,255));
		int i = 0;
		for(String follower : this.userConnected.getFollows()) {
			JButton comp = new JButton(follower);
			this.buttonFollower.add(comp);
			comp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					notifyConsultListTwitUser(follower);
				}
			});

			this.addInto(follow,comp,0,i,1,1,1,1,GridBagConstraints.NORTH, GridBagConstraints.NONE, 5,5,0,5,0,0);
			i++;
		}
		follow.revalidate();
		follow.repaint();
		
		return follow;
	}

	public void notification(String userTag){
		for(JButton bouton: this.buttonFollower){
			if(bouton.getText().equals(userTag)){
				bouton.setForeground(Color.BLUE);
				this.revalidate();
				this.repaint();
			}
		}
	}

	@Override
	public void addObserver(IObserverBordereau o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyConsultListTwitUser(String userTag) {
		this.observer.consultListTwitUser(userTag);
	}
}
