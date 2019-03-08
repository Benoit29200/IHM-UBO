package com.iup.tp.twitup.ihm.fond;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.bordereauMenu.IObservableBordereauMenu;
import com.iup.tp.twitup.datamodel.bordereauMenu.IObserverBordereauMenu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TwitupBordereauMenu extends JPanel implements IObservableBordereauMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());

	private IObserverBordereauMenu observer;

	public TwitupBordereauMenu(IObserverBordereauMenu observer) {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.observer = observer;
		
		this.add(this.getPanelMenu(), new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
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
		JButton connexion = new JButton(this.fileLanguage.getObject(Constants.USER_HOME).toString());
		JButton creation = new JButton(this.fileLanguage.getObject(Constants.USER_ACCOUNT).toString());
		JButton listeusers = new JButton(this.fileLanguage.getObject(Constants.USER_LIST_USERS).toString());
		
		monJPanel.setLayout(new GridBagLayout());
		monJPanel.setBackground(Color.white);
		
		monJPanel.add(connexion, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		
		monJPanel.add(creation, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		
		monJPanel.add(listeusers, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		
		return monJPanel;
	}

	@Override
	public void addObserver(IObserverBordereauMenu o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

}
