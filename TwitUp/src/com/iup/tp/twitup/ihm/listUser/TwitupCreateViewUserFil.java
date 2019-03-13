package com.iup.tp.twitup.ihm.listUser;

import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObservableCreateViewUser;
import com.iup.tp.twitup.ihm.background.BackgroundMother;

import java.awt.*;

public class TwitupCreateViewUserFil extends BackgroundMother implements IObservableCreateViewUser  {

	
	public TwitupCreateViewUserFil() {
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(135,206,250));
	}



	
	public void addTwitupResearchUser(TwitupResearchUser twitupResearchUser){
		this.addInto(this,twitupResearchUser,0,0,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.BOTH,5,5,0,5,0,0);
		this.refresh();
	}

	public void addTwitupFilUser(TwitupFilUser twitupFilUser){
		this.addInto(this,twitupFilUser,0,1,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH,5,5,0,5,0,0);
		this.refresh();
	}

	private void refresh(){
		this.revalidate();
		this.repaint();
	}
}
