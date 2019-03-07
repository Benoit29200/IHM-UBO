package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.accountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.datamodel.accountCreation.IObserverAccountCreation;
import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.ihm.compte.TwitupCreationCompte;
import org.apache.commons.lang3.StringUtils;

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
    public void eventEventAccountCreation(IObservableAccountCreation o, String nom, String login, String mdp, String confirm) {
        if(StringUtils.isBlank(nom) || StringUtils.isBlank(login) || StringUtils.isBlank(mdp) || StringUtils.isBlank(confirm)){
            this.vue.setErrorMessage("Tous les champs sont obligatoires");
        }else if(!mdp.equals(confirm)) {
            this.vue.setErrorMessage("Les mots de passe ne correspondent pas");
        }else if(parent.getDatabase().findTagUser(login)){
            this.vue.setErrorMessage("Le login est déja utilisé");
        }else{
            LOGER.debug("J'ai reçu le signal \"Créer compte\" ");
            User u = new User(UUID.randomUUID(), login, mdp,nom ,new HashSet<String>(),"");
            parent.getDatabase().addUser(u);
            parent.getDatabase().setUserConnected(u);
            parent.chargeFond();
        }


    }
}
