package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.createViewTwit.IObserverCreateViewTwit;
import com.iup.tp.twitup.datamodel.database.IDatabase;

public class CreateViewTwitController implements IObserverCreateViewTwit {

    private BackgroundController parent;
    private IDatabase database;

    public CreateViewTwitController(BackgroundController parent, IDatabase database) {
        this.parent = parent;
        this.database = database;
    }


    public IDatabase getDatabase() {
        return database;
    }

    public BackgroundController getParent() {
        return parent;
    }

}
