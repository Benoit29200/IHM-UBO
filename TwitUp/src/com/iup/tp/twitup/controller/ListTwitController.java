package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.createTwitViewTwit.IObserverCreateTwitViewTwit;
import com.iup.tp.twitup.communicationInterface.betweenController.researchViewTwit.IObserverResearchViewTwit;
import com.iup.tp.twitup.communicationInterface.vueController.listTwit.IObserverTwitupFilTwit;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.twit.ListTwit;

import java.util.List;

public class ListTwitController implements IObserverTwitupFilTwit, IObserverCreateTwitViewTwit, IObserverResearchViewTwit {

    private CreateViewTwitController parent;
    private ListTwit vue;

    public ListTwitController(CreateViewTwitController parent) {
        this.parent = parent;
    }


    public void setVue(ListTwit vue) {
        this.vue = vue;
    }

    @Override
    public List<Twit> getTwit(){
        return this.parent.getDatabase().getTwits();
    }

    @Override
    public void majTwits() {
        this.vue.viewTwitSearch(this.getTwit());
    }

    @Override
    public void searchTwitByUser(String user) {
        List<Twit> twitsUser = this.parent.getDatabase().getTwitsByUser(user);
        this.vue.viewTwitSearch(twitsUser);
    }

    @Override
    public void searchByTag(String tag) {
        List<Twit> twitsWithTag = this.parent.getDatabase().getTwitsWithTag(tag);
        this.vue.viewTwitSearch(twitsWithTag);
    }

    @Override
    public void searchByTagAndUser(String chaine) {
        List<Twit> twits = this.parent.getDatabase().getTwitsByTagOrUserTag(chaine);
        this.vue.viewTwitSearch(twits);
    }
}
