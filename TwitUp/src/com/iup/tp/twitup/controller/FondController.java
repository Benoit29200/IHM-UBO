package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.fond.IObservableFond;
import com.iup.tp.twitup.communicationInterface.vueController.fond.IObserverFond;
import com.iup.tp.twitup.ihm.fond.TwitupFond;

public class FondController implements IObserverFond {

    private MainViewController parent;
    private TwitupFond vue;

    public FondController(MainViewController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupFond vue) {
        this.vue = vue;
    }

    @Override
    public void chargeApp(IObservableFond o, String nom, String login, String mdp) {

    }

    public MainViewController getParent() {
        return parent;
    }
}
