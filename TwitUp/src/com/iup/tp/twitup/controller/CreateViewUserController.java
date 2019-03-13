package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObserverCreateViewUser;
import com.iup.tp.twitup.datamodel.User;

import java.util.List;

public class CreateViewUserController implements IObserverCreateViewUser {


    private BackgroundController parent;

    public CreateViewUserController(BackgroundController parent) {
        this.parent = parent;
    }

    public BackgroundController getParent() {
        return parent;
    }

    @Override
    public List<User> getUsers() {
        return this.parent.getParent().getDatabase().getUsers();
    }
}
