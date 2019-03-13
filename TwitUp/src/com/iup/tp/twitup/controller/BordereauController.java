package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.myAccountBordereau.IObserverMyAccountBordereau;
import com.iup.tp.twitup.communicationInterface.vueController.IObserverNotifyFollower;
import com.iup.tp.twitup.communicationInterface.vueController.bordereau.IObserverBordereau;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereau;

public class BordereauController implements IObserverBordereau, IObserverMyAccountBordereau, IObserverNotifyFollower {

    private TwitupBordereau vue;
    private BackgroundController parent;

    public BordereauController(BackgroundController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupBordereau vue) {
        this.vue = vue;
    }


    @Override
    public void updateAccount() {
        this.vue.updateUser(this.parent.getParent().database.getUserConnected());
    }

    @Override
    public void consultListTwitUser(String userTag) {
        this.parent.getParent().chargeFondWithListTwitUser(userTag);
    }

    @Override
    public void receiveNewTwit(Twit twit) {
        this.vue.notification(twit.getTwiter().getUserTag());
    }
}
