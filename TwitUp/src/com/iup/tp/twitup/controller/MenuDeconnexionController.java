package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.menuDeconnexion.IObserverMenuDeconnexion;

public class MenuDeconnexionController implements IObserverMenuDeconnexion {

    private MenuController parent;
    public MenuDeconnexionController(MenuController parent) {
        this.parent = parent;
    }

    public void chargeConnexionComponent(){
        this.parent.getParent().reset();
    }
}
