package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.createViewTwit.IObserverCreateViewTwit;
import com.iup.tp.twitup.datamodel.database.IDatabase;
import com.iup.tp.twitup.ihm.twit.CreateViewTwit;

public class CreateViewTwitController implements IObserverCreateViewTwit {

    private CreateViewTwit vue;
    private FondController parent;
    private IDatabase database;

    public CreateViewTwitController(FondController parent, IDatabase database) {
        this.parent = parent;
        this.database = database;
    }

    public void setVue(CreateViewTwit vue) {
        this.vue = vue;
    }

    public IDatabase getDatabase() {
        return database;
    }

    @Override
    public void eventChargeCreateViewTwit() {

    }
}
