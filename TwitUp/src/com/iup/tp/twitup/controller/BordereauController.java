package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.bordereau.IObserverBordereau;
import com.iup.tp.twitup.datamodel.myAccountBordereau.IObserverMyAccountBordereau;
import com.iup.tp.twitup.ihm.fond.TwitupBordereau;

public class BordereauController implements IObserverBordereau, IObserverMyAccountBordereau {

    private TwitupBordereau vue;
    private FondController parent;

    public BordereauController(FondController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupBordereau vue) {
        this.vue = vue;
    }


    @Override
    public void updateAccount() {
        //TODO mettre à jour la vue
        this.vue.updateUser(this.parent.getParent().database.getUserConnected());
    }
}
