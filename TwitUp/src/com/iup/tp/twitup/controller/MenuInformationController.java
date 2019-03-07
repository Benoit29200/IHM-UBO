package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.menuFichier.IObserverMenuFichier;
import com.iup.tp.twitup.datamodel.menuInformation.IObserverMenuInformation;
import com.iup.tp.twitup.ihm.menu.MenuFichier;
import com.iup.tp.twitup.ihm.menu.MenuInformation;

public class MenuInformationController implements IObserverMenuInformation {


    private MenuController parent;
    private MenuInformation vue;

    public MenuInformationController(MenuController parent) {
        this.parent = parent;
    }

    public void setVue(MenuInformation vue) {
        this.vue = vue;
    }

    @Override
    public void chargeInformation() {

    }
}
