package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.menu.IObserverMenu;

public class MenuController implements IObserverMenu {

    private MainViewController parent;

    public MenuController(MainViewController parent) {
        this.parent = parent;
    }

    public MainViewController getParent() {
        return parent;
    }
}
