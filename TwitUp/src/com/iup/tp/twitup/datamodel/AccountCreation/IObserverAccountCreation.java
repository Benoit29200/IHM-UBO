package com.iup.tp.twitup.datamodel.AccountCreation;


public interface IObserverAccountCreation {

    void eventCancel(IObservableAccountCreation o, Object arg);
    void eventEventAccountCreation(IObservableAccountCreation o, String nom, String login, String mdp);
}
