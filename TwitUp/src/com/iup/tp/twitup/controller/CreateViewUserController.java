package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.createViewUser.IObserverCreateViewUser;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.listUser.TwitupCreateViewUserFil;

import java.util.List;

public class CreateViewUserController implements IObserverCreateViewUser {


    private BackgroundController parent;
    private TwitupCreateViewUserFil vue;

    public CreateViewUserController(BackgroundController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupCreateViewUserFil vue) {
        this.vue = vue;
    }

    public BackgroundController getParent() {
        return parent;
    }

    @Override
    public List<User> getUsers() {
        return this.parent.getParent().getDatabase().getUsers();
    }
}
