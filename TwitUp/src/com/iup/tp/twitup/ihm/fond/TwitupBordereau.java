package com.iup.tp.twitup.ihm.fond;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Set;

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
	
	protected User monUser;
	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	public TwitupBordereau(IObserverBordereau observer, User user) {
		this.monUser = user;
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
//		this.setPreferredSize(new Dimension(this.screenSize.width/5, this.screenSize.height));
		this.observer = observer;
		
		this.add(this.addMenuRight(), new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
	}
	
	/**
	 * Permet de contruire le Panel qui sera affiché comprenant 
	 * @return un JPanel
	 */
	private JPanel addMenuRight() {
		JPanel panelCoteRight = new JPanel();
		panelCoteRight.setBackground(Color.WHITE);
		panelCoteRight.setLayout(new GridBagLayout());
		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource(this.monUser.getAvatarPath())));
		panelCoteRight.add(picLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		panelCoteRight.add(getPanelUtilisateur(), new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		return panelCoteRight;
	}

	/**
	 * Permet de retourner un panel comprenant les infos de l'utilisateur
	 * @return
	 */
	private JPanel getPanelUtilisateur() {
		
		JPanel monJPanel= new JPanel();
		monJPanel.setBackground(Color.white);
		monJPanel.setLayout(new GridBagLayout());
		JLabel connexion = new JLabel(this.monUser.getUserTag());
		
		monJPanel.add(connexion, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		
		monJPanel.add(this.getFollowerUtilisateur(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		return monJPanel;
	}
	
	private JPanel getFollowerUtilisateur() {
		JPanel follow = new JPanel(new GridBagLayout());
		
		follow.setMinimumSize(new Dimension(10, 10));
		follow.setBackground(new Color(240,248,255));
		
		JScrollPane scroll = new JScrollPane(follow, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		int i = 0;
		for(String follower : this.monUser.getFollows()) {
			follow.add(new JLabel(follower), new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
			i++;
		}
		follow.revalidate();
		follow.repaint();
		
		this.add(scroll, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		
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
