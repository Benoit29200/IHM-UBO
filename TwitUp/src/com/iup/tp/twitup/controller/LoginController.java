package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.login.IObservableLogin;
import com.iup.tp.twitup.datamodel.login.IObserverLogin;
import com.iup.tp.twitup.common.LOGER;

public class LoginController implements IObserverLogin {

    @Override
    public void eventCancel(IObservableLogin o, Object arg) {
        //TODO
        LOGER.debug("J'ai reçu l'évènement Cancel");
    }

    @Override
    public void eventLogin(IObservableLogin o, String login, String mdp) {
        //TODO
        LOGER.debug("J'ai reçu l'évènement login avec pseudo: "+login + " et mdp: "+mdp);
    }
}
