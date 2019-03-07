package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.menuConnexionCreation.IObserverMenuConnexionCreation;
import com.iup.tp.twitup.ihm.menu.MenuConnexionCreation;

public class MenuConnexionCreationController implements IObserverMenuConnexionCreation {

    private MenuConnexionCreation menuView;
    private MainViewController mainViewController;

    public MenuConnexionCreationController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }

    public void setMenuView(MenuConnexionCreation menuView) {
        this.menuView = menuView;
    }

    @Override
    public void chargeConnexion() {
        this.mainViewController.chargeConnexionComponent();
    }

    @Override
    public void chargeAccountManager() {
        this.mainViewController.chargeAccountManager();
    }
}
