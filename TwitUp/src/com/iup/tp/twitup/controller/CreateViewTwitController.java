package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.createViewTwit.IObserverCreateViewTwit;
import com.iup.tp.twitup.ihm.twit.TwitupCreateViewTwit;

public class CreateViewTwitController implements IObserverCreateViewTwit {

    private TwitupCreateViewTwit vue;
    private FondController parent;

    public CreateViewTwitController(FondController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupCreateViewTwit vue) {
        this.vue = vue;
    }

    @Override
    public void eventChargeCreateViewTwit() {

    }
}
