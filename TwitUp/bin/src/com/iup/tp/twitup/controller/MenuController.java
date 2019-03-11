package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.menu.IObserverMenu;
import com.iup.tp.twitup.ihm.menu.TwitupMenu;

public class MenuController implements IObserverMenu {

    private MainViewController parent;
    private TwitupMenu vue;

    public MenuController(MainViewController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupMenu vue) {
        this.vue = vue;
    }

    public MainViewController getParent() {
        return parent;
    }
}
