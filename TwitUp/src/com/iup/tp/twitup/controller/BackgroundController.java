package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.background.IObservableFond;
import com.iup.tp.twitup.communicationInterface.vueController.background.IObserverFond;
import com.iup.tp.twitup.ihm.background.Background;

public class BackgroundController implements IObserverFond {

    private MainViewController parent;
    private Background vue;

    public BackgroundController(MainViewController parent) {
        this.parent = parent;
    }

    public void setVue(Background vue) {
        this.vue = vue;
    }

    @Override
    public void chargeApp(IObservableFond o, String nom, String login, String mdp) {

    }

    public MainViewController getParent() {
        return parent;
    }
}
