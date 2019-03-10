package com.iup.tp.twitup.ihm.fond;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.bordereau.IObservableBordereau;
import com.iup.tp.twitup.datamodel.bordereau.IObserverBordereau;

public class TwitupBordereau extends JPanel implements IObservableBordereau {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IObserverBordereau observer;

	JLabel connexion;
	protected User userConnected;
	
	public TwitupBordereau(IObserverBordereau observer, User userConnected) {
		this.userConnected = userConnected;
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.addObserver(observer);
		
		this.add(this.getPanelUtilisateurEtFollowers(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
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
		panelFinal.add(panelUtilisateur, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		
		panelFollower.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		panelFinal.add(panelFollower, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		
		return panelFinal;
	}

	public void updateUser(User u){
		this.connexion.setText(u.getUserTag());
	}

	/**
	 * Permet de retourner un panel comprenant les infos de l'utilisateur
	 * @return
	 */
	private JPanel getPanelUtilisateur() {
		
		JPanel monJPanel= new JPanel();
		monJPanel.setBackground(Color.white);
		monJPanel.setLayout(new GridBagLayout());
		this.connexion = new JLabel(this.userConnected.getUserTag());
		
		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource(this.userConnected.getAvatarPath())));
		monJPanel.add(picLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		
		monJPanel.add(this.connexion, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		
		return monJPanel;
	}
	
	private JPanel getFollowerUtilisateur() {
		JPanel follow = new JPanel(new GridBagLayout());
		
//		follow.setMinimumSize(new Dimension(2000, 2000));
		follow.setBackground(new Color(240,248,255));
		
		JScrollPane scroll = new JScrollPane(follow, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		int i = 0;
		for(String follower : this.userConnected.getFollows()) {
			JLabel comp = new JLabel(follower);
			follow.add(comp, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
			i++;
		}
		follow.revalidate();
		follow.repaint();
		
		return follow;
	}

	@Override
	public void addObserver(IObserverBordereau o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
