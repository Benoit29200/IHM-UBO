package com.iup.tp.twitup.datamodel.accountCreation;


public interface IObserverAccountCreation {

    void eventCancel(IObservableAccountCreation o, Object arg);
    void eventEventAccountCreation(IObservableAccountCreation o, String nom, String login, String mdp);
}
