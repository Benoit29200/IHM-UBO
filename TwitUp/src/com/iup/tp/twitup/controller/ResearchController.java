package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.datamodel.researchViewTwit.IObservableResearchViewTwit;
import com.iup.tp.twitup.datamodel.researchViewTwit.IObserverResearchViewTwit;
import com.iup.tp.twitup.datamodel.twitupResearch.IObserverTwitupResearch;
import com.iup.tp.twitup.ihm.twit.TwitupResearch;

public class ResearchController implements IObserverTwitupResearch, IObservableResearchViewTwit {

    private CreateViewTwitController parent;
    private TwitupResearch vue;
    private IObserverResearchViewTwit observer;

    public ResearchController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setObserver(IObserverResearchViewTwit observer) {
        this.observer = observer;
    }

    public void setVue(TwitupResearch vue) {
        this.vue = vue;
    }

    @Override
    public void notifyResearch(String research) {
        if(research.length() < 2){
            LOGER.debug("< 2");
            observer.majTwits();
        }

        else if(research.startsWith("@")){
            LOGER.debug("@");
            observer.searchTwitByUser(research.substring(1));
        }

        else if(research.startsWith("#")){
            LOGER.debug("#");
            observer.searchByTag(research.substring(1));
        }
        else {
            LOGER.debug(">2 sans @#");
            observer.majTwits();
        }
    }

    @Override
    public void addObserver(IObserverResearchViewTwit o) {
        this.observer = o;
    }

    @Override
    public void deleteObserver() {
        this.observer = null;
    }

    @Override
    public void notifySearchTwitByUser(String user) {

    }

    @Override
    public void notifySearchByTag(String tag) {

    }
}
