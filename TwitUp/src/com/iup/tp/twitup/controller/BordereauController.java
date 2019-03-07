package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.bordereau.IObserverBordereau;
import com.iup.tp.twitup.ihm.fond.TwitupBordereau;

public class BordereauController implements IObserverBordereau {

    private TwitupBordereau vue;
    private FondController parent;

    public BordereauController(FondController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupBordereau vue) {
        this.vue = vue;
    }

    @Override
    public void eventChargeBordereau() {

    }
}
