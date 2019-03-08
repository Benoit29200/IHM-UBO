package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.twitupResearch.IObserverTwitupResearch;
import com.iup.tp.twitup.ihm.twit.TwitupResearch;

public class ResearchController implements IObserverTwitupResearch {

    private CreateViewTwitController parent;
    private TwitupResearch vue;

    public ResearchController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupResearch vue) {
        this.vue = vue;
    }
}
