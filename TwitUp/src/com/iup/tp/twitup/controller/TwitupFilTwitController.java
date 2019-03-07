package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.twitupFilTwit.IObserverTwitupFilTwit;
import com.iup.tp.twitup.ihm.twit.TwitupFilTwit;

public class TwitupFilTwitController implements IObserverTwitupFilTwit {

    private CreateViewTwitController parent;
    private TwitupFilTwit vue;

    public TwitupFilTwitController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupFilTwit vue) {
        this.vue = vue;
    }
}
