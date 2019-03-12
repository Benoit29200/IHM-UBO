package com.iup.tp.twitup.communicationInterface.vueController.background;

public interface IObservableFond {

    void addObserver(IObserverFond o);

    void deleteObserver();

    void notifyEventApp(String nom, String login, String mdp);

}
