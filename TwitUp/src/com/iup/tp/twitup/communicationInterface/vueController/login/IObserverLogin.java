package com.iup.tp.twitup.communicationInterface.vueController.login;



public interface IObserverLogin {

    void eventCancel(IObservableLogin o, Object arg);
    void eventLogin(IObservableLogin o, String login, String mdp);
    void chargeAccountManager();
}
