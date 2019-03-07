package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.menuConnexionCreation.IObserverMenuConnexionCreation;
import com.iup.tp.twitup.ihm.menu.MenuConnexionCreation;

public class MenuConnexionCreationController implements IObserverMenuConnexionCreation {

    private MenuConnexionCreation menuView;
    private MenuController menuController;

    public MenuConnexionCreationController(MenuController mainViewController) {
        this.menuController = mainViewController;
    }

    public void setMenuView(MenuConnexionCreation menuView) {
        this.menuView = menuView;
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
