package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.menuDeconnexion.IObserverMenuDeconnexion;
import com.iup.tp.twitup.ihm.menu.MenuDeconnexion;

public class MenuDeconnexionController implements IObserverMenuDeconnexion {

    private MenuController parent;
    private MenuDeconnexion vue;

    public MenuDeconnexionController(MenuController parent) {
        this.parent = parent;
    }

    public void setVue(MenuDeconnexion vue) {
        this.vue = vue;
    }

    public void chargeConnexionComponent(){
        this.parent.getParent().reset();
    }
}
