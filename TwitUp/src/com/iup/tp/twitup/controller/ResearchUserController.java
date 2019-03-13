package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser.IObservableResearchViewUser;
import com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser.IObserverResearchViewUser;
import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObserverResearchUser;

public class ResearchUserController implements IObserverResearchUser, IObservableResearchViewUser {

    private IObserverResearchViewUser observer;


    @Override
    public void searchUserContains(String pattern) {
        this.notifySearchUserContains(pattern);
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
    public void notifySearchUserContains(String pattern) {
        this.observer.searchUserContains(pattern);
    }

    @Override
    public void searchUser(String userName) {
        this.notifySearchUser(userName);
    }

    @Override
    public void notifySearchUser(String userName) {
        this.observer.searchUser(userName);
    }
}
