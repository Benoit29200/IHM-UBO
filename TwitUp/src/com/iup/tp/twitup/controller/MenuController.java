package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.menu.IObservableMenu;
import com.iup.tp.twitup.datamodel.menu.IObserverMenu;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.TwitupMenu;

public class MenuController implements IObserverMenu  {

    private TwitupMenu menuView;
    private MainViewController mainViewController;

    public MenuController( MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }

    public void setMenuView(TwitupMenu menuView) {
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
