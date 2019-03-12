package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.bordereau.IObserverBordereau;
import com.iup.tp.twitup.communicationInterface.betweenController.myAccountBordereau.IObserverMyAccountBordereau;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereau;

public class BordereauController implements IObserverBordereau, IObserverMyAccountBordereau {

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
}
