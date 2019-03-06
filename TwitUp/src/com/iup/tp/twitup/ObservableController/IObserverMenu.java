package com.iup.tp.twitup.ObservableController;



public interface IObserverMenu {

    void eventCancel(IObservableMenu o, Object arg);
    void eventLogin(IObservableMenu o, String login, String mdp);
}
