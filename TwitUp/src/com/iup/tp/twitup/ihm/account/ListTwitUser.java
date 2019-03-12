package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.communicationInterface.vueController.listTwit.IObservableTwitupFilTwit;
import com.iup.tp.twitup.communicationInterface.vueController.listTwit.IObserverTwitupFilTwit;
import com.iup.tp.twitup.communicationInterface.vueController.listTwitUser.IObservableListTwitUser;
import com.iup.tp.twitup.communicationInterface.vueController.listTwitUser.IObserverListTwitUser;
import com.iup.tp.twitup.communicationInterface.vueController.listUser.IObserverListUser;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.twit.DisplayTwit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTwitUser extends Account implements IObservableListTwitUser {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel scrollTwit;

    private IObserverListTwitUser observer;


    public ListTwitUser(IObserverListTwitUser observer, List<Twit> twits) {
        super();
        this.setLayout(new GridBagLayout());
        this.addObserver(observer);
        this.scrollTwit = new JPanel(new GridBagLayout());
        this.setPreferredSize(new Dimension(this.screenSize.width / 2, this.screenSize.height / 7));
        scrollTwit.setMinimumSize(new Dimension(1000, 1000));
        scrollTwit.setBackground(new Color(240, 248, 255));

        JScrollPane scroll = new JScrollPane(scrollTwit, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.addInto(this,scroll,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE, 5,5,0,5,0,0);
        this.viewTwitSearch(twits);
    }


    private void viewTwitSearch(List<Twit> twits) {


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
    public void deleteObserver() {
        this.observer = null;
    }

    @Override
    public void addObserver(IObserverListTwitUser o) {
        this.observer = o;
    }
}
