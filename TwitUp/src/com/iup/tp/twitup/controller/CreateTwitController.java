package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.createTwit.IObserverCreateTwit;
import com.iup.tp.twitup.ihm.twit.TwitupCreateTwit;

public class CreateTwitController implements IObserverCreateTwit {

    private CreateViewTwitController parent;
    private TwitupCreateTwit vue;

    public CreateTwitController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupCreateTwit vue) {
        this.vue = vue;
    }
}
