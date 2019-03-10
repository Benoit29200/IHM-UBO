package com.iup.tp.twitup.ihm.researchUser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.communicationInterface.vueController.twitupFilTwit.IObservableTwitupFilTwit;
import com.iup.tp.twitup.communicationInterface.vueController.twitupFilTwit.IObserverTwitupFilTwit;

public class TwitupFilUser extends JPanel implements IObservableTwitupFilTwit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverTwitupFilTwit observer;
	JPanel scrollUser;
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());


	public TwitupFilUser(IObserverTwitupFilTwit observer) {
		this.setLayout(new GridBagLayout());
		this.observer = observer;
		this.scrollUser = new JPanel(new GridBagLayout());
		scrollUser.setMinimumSize(new Dimension(1000, 1000));
		scrollUser.setBackground(new Color(240,248,255));
		
		JScrollPane scroll = new JScrollPane(scrollUser, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.viewUsers();
		
		this.add(scroll, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
	}

	public void viewUsers(){
		this.scrollUser.removeAll();
		int iterator = 0;
		for(User user: this.observer.getUsers()) {
			this.scrollUser.add(createNewPanelUser(user), new GridBagConstraints(0, iterator, 1, 1, 1, 1, GridBagConstraints.NORTH,
					GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
			iterator++;
		}
		this.scrollUser.revalidate();
		this.scrollUser.repaint();
	}

	private JPanel createNewPanelUser(User user) {
		JPanel infoUser = new JPanel(new GridBagLayout());
		JLabel avatar = new JLabel(new ImageIcon(getClass().getResource(user.getAvatarPath())));
		JLabel userTag = new JLabel(Constants.USER_TAG_FIL + user.getUserTag());
		JButton profilUser = new JButton(this.fileLanguage.getObject(Constants.USER_SEE_OTHER_USER).toString());
		infoUser.add(avatar);
		infoUser.add(userTag);
		infoUser.add(profilUser);
		return infoUser;
	}

	@Override
	public void addObserver(IObserverTwitupFilTwit o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}
}
