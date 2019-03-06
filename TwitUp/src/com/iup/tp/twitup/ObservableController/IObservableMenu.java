package com.iup.tp.twitup.ObservableController;

public interface IObservableMenu {

    void addObserver(IObserverMenu o);

    void deleteObserver();

    void notifyEventCancel();

    void notifyEventLogin(String login, String mdp);
}
