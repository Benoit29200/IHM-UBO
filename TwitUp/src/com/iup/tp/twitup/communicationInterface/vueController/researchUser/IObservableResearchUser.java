package com.iup.tp.twitup.communicationInterface.vueController.researchUser;

public interface IObservableResearchUser {

    void addObserver(IObserverResearchUser o);

    void deleteObserver();

    void notifySearchUserContains(String pattern);
    void notifySearchUser(String userName);



}
