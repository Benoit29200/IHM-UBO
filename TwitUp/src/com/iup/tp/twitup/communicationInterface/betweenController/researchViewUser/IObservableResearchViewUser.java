package com.iup.tp.twitup.communicationInterface.betweenController.researchViewUser;

public interface IObservableResearchViewUser {

    void addObserver(IObserverResearchViewUser o);

    void deleteObserverResearch();

    void notifySearchUserContains(String pattern);

    void notifySearchUser(String userName);

}
