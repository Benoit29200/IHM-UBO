package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu.IObserverBordereauMenu;
import com.iup.tp.twitup.ihm.fond.TwitupBordereauMenu;

public class BordereauMenuController implements IObserverBordereauMenu {

    private TwitupBordereauMenu vue;
    private FondController parent;

    public BordereauMenuController(FondController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupBordereauMenu vue) {
        this.vue = vue;
    }


    @Override
    public void eventChargeTwitView() {
        this.parent.getParent().chargeFond();
    }

    @Override
    public void eventChargeMyAccount() {
        this.parent.getParent().chargeFondWithMyAccount();
    }
}
