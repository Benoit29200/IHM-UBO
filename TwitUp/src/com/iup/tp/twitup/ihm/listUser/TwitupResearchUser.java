package com.iup.tp.twitup.ihm.listUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObservableResearchUser;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObserverResearchUser;

public class TwitupResearchUser extends ListUser implements IObservableResearchUser {


	private IObserverResearchUser observerVue;

	private JTextField researchTextField;
	private JButton researchButton;


	public TwitupResearchUser(IObserverResearchUser observerVue) {
		this.initComponent();
		this.addActionResearchTextField();
		this.addObserver(observerVue);

		this.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setLayout(new GridBagLayout());
		this.addObserver(observerVue);
		this.setBackground(Color.WHITE);

		this.researchTextField.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/15));

		this.addInto(this,researchTextField,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH,5,5,0,5,0,0);
		this.addInto(this,this.researchButton,0,1,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE,5,5,0,5,0,0);
	}

	private void initComponent(){
		this.setPreferredSize(new Dimension(this.screenSize.width/2,this.screenSize.height/2));

		this.researchTextField = new JTextField();
		this.researchButton = new JButton(this.fileLanguage.getObject(Constants.RESEARCH_TWIT_JBUTTON_TITLE).toString());
	}


	private void addActionResearchTextField(){
		this.researchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						notifySearchUserContains(researchTextField.getText());
					}
				});
			}
		});

		this.researchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifySearchUser(researchTextField.getText());
            }
        });
	}

	@Override
	public void addObserver(IObserverResearchUser o) {
		this.observerVue = o;
	}

	@Override
	public void deleteObserver() {
		this.observerVue = null;
	}

	@Override
	public void notifySearchUserContains(String pattern) {
		this.observerVue.searchUserContains(pattern);
	}

    @Override
    public void notifySearchUser(String userName) {
        this.observerVue.searchUser(userName);
    }
}
