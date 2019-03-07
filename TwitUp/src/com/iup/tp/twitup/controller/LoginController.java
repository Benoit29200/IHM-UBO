package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.login.IObservableLogin;
import com.iup.tp.twitup.datamodel.login.IObserverLogin;
import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.ihm.compte.TwitupConnexionUser;
import com.iup.tp.twitup.ihm.fond.TwitupBordereau;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LoginController implements IObserverLogin {

    private TwitupConnexionUser vue;
    private MainViewController parent;

    public LoginController(MainViewController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupConnexionUser vue) {
        this.vue = vue;
    }

    @Override
    public void eventCancel(IObservableLogin o, Object arg) {
        //TODO
        LOGER.debug("J'ai reçu l'évènement Cancel");
    }

    @Override
    public void eventLogin(IObservableLogin o, String login, String mdp) {
    	Set<String> test = new HashSet<String>();
        test.add("AdrienLeBoLol");
        test.add("LeMaxime");
        test.add("BenoitThePope");
        
        User u = new User(UUID.randomUUID(), login, mdp,"benoit" ,test,"/images/logoIUP_50.jpg");

        if(parent.getDatabase().findUser(u) != null){
            LOGER.success("L'utilisateur existe ! Allélujah");
            parent.getDatabase().setUserConnected(u);
            parent.chargeFond();
        }else{
            LOGER.err("L'utilisateur n'existe pas");
            vue.setErrorMessage("Le couple pseudo / mot de passe n'existe pas");
        }
    }

    @Override
    public void chargeAccountManager() {
        this.parent.chargeAccountManager();
    }
}
