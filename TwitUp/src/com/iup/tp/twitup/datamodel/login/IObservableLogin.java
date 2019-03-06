package com.iup.tp.twitup.datamodel.login;

public interface IObservableLogin {

    void addObserver(IObserverLogin o);

    void deleteObserver();

    void notifyEventCancel();

    void notifyEventLogin(String login, String mdp);
}
