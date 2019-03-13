package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.menuConnexionCreation.IObserverMenuConnexionCreation;

public class MenuConnexionCreationController implements IObserverMenuConnexionCreation {

    private MenuController menuController;

    public MenuConnexionCreationController(MenuController mainViewController) {
        this.menuController = mainViewController;
    }

    @Override
    public void chargeConnexion() {
        this.menuController.getParent().chargeConnexionComponent();
    }

    @Override
    public void chargeAccountManager() {
        this.menuController.getParent().chargeAccountManager();
    }
}
