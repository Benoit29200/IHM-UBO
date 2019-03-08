package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.database.IDatabase;
import com.iup.tp.twitup.datamodel.myAccount.IObserverMyAccount;
import com.iup.tp.twitup.ihm.compte.TwitupConsultAccount;

public class MyAccountController implements IObserverMyAccount {

    private TwitupConsultAccount vue;
    private FondController parent;
    private IDatabase database;

    public MyAccountController(FondController parent, IDatabase database) {
        this.parent = parent;
        this.database = database;
    }

    public void setVue(TwitupConsultAccount vue) {
        this.vue = vue;
    }


    @Override
    public User getUserConnected() {
        return this.database.getUserConnected();
    }

    @Override
    public void chargeViewTwit() {
        this.parent.getParent().chargeFond();
    }

    @Override
    public void chargeMyAccount() {
        this.parent.getParent().chargeFondWithMyAccount();
    }
}