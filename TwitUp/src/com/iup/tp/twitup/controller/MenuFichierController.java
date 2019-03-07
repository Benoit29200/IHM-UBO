package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.menuFichier.IObserverMenuFichier;
import com.iup.tp.twitup.ihm.menu.MenuFichier;

public class MenuFichierController implements IObserverMenuFichier {


    private MenuController parent;
    private MenuFichier vue;

    public MenuFichierController(MenuController parent) {
        this.parent = parent;
    }

    public void setVue(MenuFichier vue) {
        this.vue = vue;
    }

    @Override
    public void chargeFichier() {

    }
}
