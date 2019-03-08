package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.createTwitViewTwit.IObserverCreateTwitViewTwit;
import com.iup.tp.twitup.datamodel.researchViewTwit.IObserverResearchViewTwit;
import com.iup.tp.twitup.datamodel.twitupFilTwit.IObserverTwitupFilTwit;
import com.iup.tp.twitup.ihm.twit.TwitupFilTwit;

import java.util.Set;

public class TwitupFilTwitController implements IObserverTwitupFilTwit, IObserverCreateTwitViewTwit, IObserverResearchViewTwit {

    private CreateViewTwitController parent;
    private TwitupFilTwit vue;

    public TwitupFilTwitController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupFilTwit vue) {
        this.vue = vue;
    }

    public Set<Twit> getTwit(){
        return this.parent.getDatabase().getTwits();
    }

    @Override
    public void majTwits() {
        this.vue.viewTwit();
    }

    @Override
    public void searchTwitByUser(String user) {

    }

    @Override
    public void searchByTag(String tag) {

    }
}
