package com.iup.tp.twitup.ihm.fond;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.iup.tp.twitup.ihm.twit.TwitupCreateTwit;
import com.iup.tp.twitup.ihm.twit.TwitupCreateViewTwit;

/**
 * Permet d'avoir une page fond toujours affiché
 * @author gaetan
 *
 */
public class TwitupFond extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2724237454765496211L;
	
	protected Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

	public TwitupFond() {
		this.setLayout(new GridBagLayout());
		
		/**
		 * Pour les tests
		 */
		this.add(new TwitupBordereauMenu(), new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
		
		this.add(new TwitupBordereau(), new GridBagConstraints(2, 0, 1, 1, 0, 1, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
		
		this.add(new TwitupCreateViewTwit(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void addComponentInPage(Container monComponent) {
//		monComponent.setPreferredSize(new Dimension((int)(screenSize.width/1.7), screenSize.height/2));
		this.add(monComponent, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		this.revalidate();
	}

}
