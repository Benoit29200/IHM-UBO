package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.consultAccountUser.IObserverConsultAccountUser;
import com.iup.tp.twitup.ihm.compte.TwitupConsultAccount;
import com.iup.tp.twitup.ihm.compte.TwitupConsultAnUserAccount;

public class ConsultAccountUserController implements IObserverConsultAccountUser {

    private FondController parent;
    private TwitupConsultAnUserAccount vue;

    public ConsultAccountUserController(FondController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupConsultAnUserAccount vue) {
        this.vue = vue;
    }
}
