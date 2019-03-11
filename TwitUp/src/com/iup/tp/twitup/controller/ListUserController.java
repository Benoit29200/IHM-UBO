package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser.IObserverResearchViewUser;
import com.iup.tp.twitup.communicationInterface.vueController.listUser.IObserverListUser;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.listUser.TwitupFilUser;

import java.util.List;

public class ListUserController implements IObserverListUser, IObserverResearchViewUser {

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

    @Override
    public void searchUser(String user) {
        List<User> users = this.parent.getParent().getParent().getDatabase().getUsersByContainsName(user);
        this.vue.viewUsers(users);

    }
}
