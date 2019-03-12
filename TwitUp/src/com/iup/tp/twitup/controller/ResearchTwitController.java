package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.researchViewTwit.IObservableResearchViewTwit;
import com.iup.tp.twitup.communicationInterface.betweenController.researchViewTwit.IObserverResearchViewTwit;
import com.iup.tp.twitup.communicationInterface.vueController.researchTwit.IObserverTwitupResearch;
import com.iup.tp.twitup.ihm.twit.ResearchTwit;

public class ResearchTwitController implements IObserverTwitupResearch, IObservableResearchViewTwit {

    private CreateViewTwitController parent;
    private ResearchTwit vue;
    private IObserverResearchViewTwit observer;

    public ResearchTwitController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setObserver(IObserverResearchViewTwit observer) {
        this.observer = observer;
    }

    public void setVue(ResearchTwit vue) {
        this.vue = vue;
    }

    @Override
    public void notifyResearch(String research) {
        if(research.length() < 2){
            observer.majTwits();
        }

        else if(research.startsWith("@")){
            observer.searchTwitByUser(research.substring(1));
        }

        else if(research.startsWith("#")){
            observer.searchByTag(research.substring(1));
        }
        else {
            observer.searchByTagAndUser(research);
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

}
