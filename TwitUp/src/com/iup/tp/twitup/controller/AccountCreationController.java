package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.accountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.datamodel.accountCreation.IObserverAccountCreation;
import com.iup.tp.twitup.common.LOGER;

public class AccountCreationController implements IObserverAccountCreation {
    @Override
    public void eventCancel(IObservableAccountCreation o, Object arg) {
        LOGER.debug("J'ai reçu le signal cancel sur la page de création de compte");
    }

    @Override
    public void eventEventAccountCreation(IObservableAccountCreation o, String nom, String login, String mdp) {
        LOGER.debug("J'ai reçu le signal \"Créer compte\" ");
    }
}
