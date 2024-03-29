package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.communicationInterface.vueController.accountCreation.IObservableAccountCreation;
import com.iup.tp.twitup.communicationInterface.vueController.accountCreation.IObserverAccountCreation;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.CreationCompte;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.UUID;

public class AccountCreationController implements IObserverAccountCreation {

    private MainViewController parent;
    private CreationCompte vue;


    public AccountCreationController(MainViewController parent) {
        this.parent = parent;
    }

    public void setVue(CreationCompte vue) {
        this.vue = vue;
    }

    @Override
    public void eventCancel(IObservableAccountCreation o, Object arg) {
        LOGER.debug("J'ai reçu le signal cancel sur la page de création de account");
    }

    @Override
    public void eventEventAccountCreation(IObservableAccountCreation o, String nom, String login, String mdp, String confirm, String avatarPath) {
        if(StringUtils.isBlank(nom) || StringUtils.isBlank(login) || StringUtils.isBlank(mdp) || StringUtils.isBlank(confirm) || StringUtils.isBlank(avatarPath)){
            this.vue.setErrorMessage("Tous les champs sont obligatoires");
        }else if(!mdp.equals(confirm)) {
            this.vue.setErrorMessage("Les mots de passe ne correspondent pas");
        }else if(parent.getDatabase().findTagUser(login)){
            this.vue.setErrorMessage("Le login est déja utilisé");
        }else{
            User u = new User(UUID.randomUUID(), login, mdp,nom ,new HashSet<String>(),avatarPath);
            parent.getDatabase().addUser(u);
            parent.getEntityManager().sendUser(u);
            parent.getDatabase().setUserConnected(u);
            parent.chargeFond();
        }


    }
}
