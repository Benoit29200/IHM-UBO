package com.iup.tp.twitup.datamodel.accountCreation;

public interface IObservableAccountCreation {

    void addObserver(IObserverAccountCreation o);

    void deleteObserver();

    void notifyEventCancel();

    void notifyEventAccountCreation(String nom, String login, String mdp);
}
