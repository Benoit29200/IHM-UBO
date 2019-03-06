package com.iup.tp.twitup.datamodel.AccountCreation;

public interface IObservableAccountCreation {

    void addObserver(IObserverAccountCreation o);

    void deleteObserver();

    void notifyEventCancel();

    void notifyEventAccountCreation(String nom, String login, String mdp);
}
