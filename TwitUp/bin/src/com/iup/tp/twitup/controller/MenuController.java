package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.menu.IObserverMenu;
import com.iup.tp.twitup.ihm.TwitupMenu;

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
