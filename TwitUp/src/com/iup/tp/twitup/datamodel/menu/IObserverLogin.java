package com.iup.tp.twitup.datamodel.menu;


public interface IObserverLogin {

    void eventCancel(IObservableLogin o, Object arg);
    void eventLogin(IObservableLogin o, String login, String mdp);
}
