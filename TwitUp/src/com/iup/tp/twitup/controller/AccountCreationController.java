package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.accountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.datamodel.accountCreation.IObserverAccountCreation;
import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.ihm.compte.TwitupCreationCompte;

import java.util.HashSet;
import java.util.UUID;

public class AccountCreationController implements IObserverAccountCreation {

    private MainViewController parent;
    private TwitupCreationCompte vue;


    public AccountCreationController(MainViewController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupCreationCompte vue) {
        this.vue = vue;
    }

    @Override
    public void eventCancel(IObservableAccountCreation o, Object arg) {
        LOGER.debug("J'ai reçu le signal cancel sur la page de création de compte");
    }

    @Override
    public void eventEventAccountCreation(IObservableAccountCreation o, String nom, String login, String mdp) {
        LOGER.debug("J'ai reçu le signal \"Créer compte\" ");
        User u = new User(UUID.randomUUID(), login, mdp,nom ,new HashSet<String>(),"");
        parent.getDatabase().addUser(u);
        System.out.println("testrt");
    }
}
