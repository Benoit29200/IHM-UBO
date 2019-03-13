package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu.IObserverBordereauMenu;

public class BordereauMenuController implements IObserverBordereauMenu {

    private BackgroundController parent;

    public BordereauMenuController(BackgroundController parent) {
        this.parent = parent;
    }


    @Override
    public void eventChargeTwitView() {
        this.parent.getParent().chargeFond();
    }

    @Override
    public void eventChargeMyAccount() {
        this.parent.getParent().chargeFondWithMyAccount();
    }

    @Override
    public void eventChargeListUser() {
        this.parent.getParent().chargeFondWithListUser();
    }
}
