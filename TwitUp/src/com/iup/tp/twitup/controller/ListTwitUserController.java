package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.listTwitUser.IObserverListTwitUser;
import com.iup.tp.twitup.ihm.account.ListTwitUser;

public class ListTwitUserController implements IObserverListTwitUser {

    private BackgroundController parent;
    private ListTwitUser vue;

    public ListTwitUserController(BackgroundController parent) {
        this.parent = parent;
    }

    public void setVue(ListTwitUser vue) {
        this.vue = vue;
    }
}
