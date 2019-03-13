package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.background.IObserverFond;

public class BackgroundController implements IObserverFond {

    private MainViewController parent;

    public BackgroundController(MainViewController parent) {
        this.parent = parent;
    }

    public MainViewController getParent() {
        return parent;
    }
}
