package com.iup.tp.twitup.communicationInterface.vueController.accountCreation;


public interface IObserverAccountCreation {

    void eventCancel(IObservableAccountCreation o, Object arg);
    void eventEventAccountCreation(IObservableAccountCreation o, String nom, String login, String mdp, String confirm, String avatarPath);
}
