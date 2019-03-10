package com.iup.tp.twitup.communicationInterface.vueController.accountCreation;

public interface IObservableAccountCreation {

    void addObserver(IObserverAccountCreation o);

    void deleteObserver();

    void notifyEventCancel();

    void notifyEventAccountCreation(String nom, String login, String mdp, String confirm);
}
