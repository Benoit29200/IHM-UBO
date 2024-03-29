package com.iup.tp.twitup.ihm.listUser;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.communicationInterface.vueController.listUser.IObservableListUser;
import com.iup.tp.twitup.communicationInterface.vueController.listUser.IObserverListUser;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class TwitupFilUser extends ListUser implements IObservableListUser {
	

	private IObserverListUser observer;
	private JPanel scrollUser;

	public TwitupFilUser(IObserverListUser observer) {
		super();
		this.setLayout(new GridBagLayout());
		this.observer = observer;
		this.setBackground(Color.WHITE);
		this.scrollUser = new JPanel(new GridBagLayout());
		scrollUser.setMinimumSize(new Dimension(1000, 1000));
		scrollUser.setBackground(new Color(240,248,255));
		
		JScrollPane scroll = new JScrollPane(scrollUser, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.viewUsers(this.observer.getUsers());

		this.addInto(this,scroll,0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.BOTH, 5,5,0,5,0,0);
	}

	public void viewUsers(List<User> users){
		this.scrollUser.removeAll();
		int iterator = 0;
		for(User user: users) {
			this.addInto(this.scrollUser,createNewPanelUser(user),0,iterator,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,5,5,0,5,0,0);
			iterator++;
		}
		this.scrollUser.revalidate();
		this.scrollUser.repaint();
	}

	private JPanel createNewPanelUser(User user) {
		JPanel infoUser = new JPanel(new GridBagLayout());


		ImagePanel avatar = null;

		try{
			avatar = new ImagePanel(new File(getClass().getResource(user.getAvatarPath()).toURI()), new Dimension(80,80));
		} catch(Exception e){
			LOGER.err("Erreur récupération image utilisateur");
		}

		JLabel userTag = new JLabel(user.getUserTag()+ " ( "+user.getName()+" )");
		JButton profilUser = new JButton(this.fileLanguage.getObject(Constants.USER_SEE_OTHER_USER).toString());
		profilUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyChargeViewProfilUser(user);
			}
		});

		this.addInto(infoUser,avatar,0,0,1,1,1,1,GridBagConstraints.WEST,GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(infoUser,userTag,1,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
		this.addInto(infoUser,profilUser,2,0,1,1,1,1,GridBagConstraints.EAST, GridBagConstraints.NONE,5,5,0,5,0,0);

		return infoUser;
	}



	@Override
	public void addObserver(IObserverListUser o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyChargeViewProfilUser(User user) {
		this.observer.chargeProfilUser(user);
	}
}
