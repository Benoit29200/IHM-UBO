package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu.IObserverBordereauMenu;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereauMenu;

public class BordereauMenuController implements IObserverBordereauMenu {

    private TwitupBordereauMenu vue;
    private BackgroundController parent;

    public BordereauMenuController(BackgroundController parent) {
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

    @Override
    public void eventChargeListUser() {
        this.parent.getParent().chargeFondWithListUser();
    }
}
