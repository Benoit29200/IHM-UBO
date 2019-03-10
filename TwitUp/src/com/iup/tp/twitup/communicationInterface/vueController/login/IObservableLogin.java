package com.iup.tp.twitup.communicationInterface.vueController.login;

public interface IObservableLogin {

    void addObserver(IObserverLogin o);

    void deleteObserver();

    void notifyEventCancel();

    void notifyEventLogin(String login, String mdp);

    void notifyEventAccountManager();

    void setErrorMessage(String error);
}
