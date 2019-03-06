package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.ObservableController.IObservableMenu;
import com.iup.tp.twitup.ObservableController.IObserverMenu;
import com.iup.tp.twitup.common.LOGER;

import java.util.Observable;

public class MenuController implements IObserverMenu {

    @Override
    public void eventCancel(IObservableMenu o, Object arg) {
        //TODO
        LOGER.info("J'ai reçu l'évènement Cancel");
    }

    @Override
    public void eventLogin(IObservableMenu o, String login, String mdp) {
        //TODO
        LOGER.info("J'ai reçu l'évènement login avec pseudo: "+login + " et mdp: "+mdp);
    }
}
