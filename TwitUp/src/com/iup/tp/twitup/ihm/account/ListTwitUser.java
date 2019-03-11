package com.iup.tp.twitup.ihm.account;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.iup.tp.twitup.communicationInterface.vueController.twitupFilTwit.IObservableTwitupFilTwit;
import com.iup.tp.twitup.communicationInterface.vueController.twitupFilTwit.IObserverTwitupFilTwit;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.twit.DisplayTwit;

public class ListTwitUser extends Account implements IObservableTwitupFilTwit {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private IObserverTwitupFilTwit observer;

    JPanel scrollTwit;
    User theUser;


    public ListTwitUser(IObserverTwitupFilTwit observer, User user) {
        super();
        this.theUser = user;
        this.setLayout(new GridBagLayout());
        this.observer = observer;
        this.scrollTwit = new JPanel(new GridBagLayout());
        this.setPreferredSize(new Dimension(this.screenSize.width / 2, this.screenSize.height / 7));
        scrollTwit.setMinimumSize(new Dimension(1000, 1000));
        scrollTwit.setBackground(new Color(240, 248, 255));

        JScrollPane scroll = new JScrollPane(scrollTwit, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.viewTwitSearch(this.observer.getTwit());
        this.addInto(this,scroll,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);

    }


    public void viewTwitSearch(List<Twit> twits) {


        List<Twit> twitList = new ArrayList<>();
        for (Twit twit : twits) {
            twitList.add(twit);
        }
        Collections.reverse(twitList);

        this.scrollTwit.removeAll();
        int iterator = 0;
        for (Twit myTwit : twitList) {
            DisplayTwit displayTwit = new DisplayTwit(myTwit);
            this.addInto(this.scrollTwit,displayTwit,0,iterator,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
            iterator++;
        }
        this.scrollTwit.revalidate();
        this.scrollTwit.repaint();
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
