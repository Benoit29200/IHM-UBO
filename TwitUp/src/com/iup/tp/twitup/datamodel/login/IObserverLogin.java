package com.iup.tp.twitup.datamodel.login;



public interface IObserverLogin {

    void eventCancel(IObservableLogin o, Object arg);
    void eventLogin(IObservableLogin o, String login, String mdp);
}
