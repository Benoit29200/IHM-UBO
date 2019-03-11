package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser.IObservableResearchViewUser;
import com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser.IObserverResearchViewUser;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObserverResearchUser;
import com.iup.tp.twitup.ihm.listUser.TwitupResearchUser;

public class ResearchUserController implements IObserverResearchUser, IObservableResearchViewUser {

    CreateViewUserController parent;
    TwitupResearchUser vue;
    IObserverResearchViewUser observer;

    public ResearchUserController(CreateViewUserController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupResearchUser vue) {
        this.vue = vue;
    }

    @Override
    public void searchUser(String userName) {
        this.notifySearchUser(userName);
    }

    @Override
    public void addObserver(IObserverResearchViewUser o) {
        this.observer = o;
    }

    @Override
    public void deleteObserverResearch() {
        this.observer = null;
    }

    @Override
    public void notifySearchUser(String userName) {
        this.observer.searchUser(userName);
    }
}
