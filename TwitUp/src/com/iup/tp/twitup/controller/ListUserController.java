package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.listUser.IObserverListUser;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.fond.TwitupFond;
import com.iup.tp.twitup.ihm.researchUser.TwitupFilUser;

import java.util.List;

public class ListUserController implements IObserverListUser {

    private TwitupFilUser vue;
    private CreateViewUserController parent;

    public ListUserController(CreateViewUserController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupFilUser vue) {
        this.vue = vue;
    }

    @Override
    public List<User> getUsers() {
        return this.parent.getParent().getParent().getDatabase().getUsers();
    }
}
