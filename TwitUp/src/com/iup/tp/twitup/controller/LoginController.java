package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.communicationInterface.vueController.login.IObservableLogin;
import com.iup.tp.twitup.communicationInterface.vueController.login.IObserverLogin;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.ConnexionUser;

public class LoginController implements IObserverLogin {

    private ConnexionUser vue;
    private MainViewController parent;

    public LoginController(MainViewController parent) {
        this.parent = parent;
    }

    public void setVue(ConnexionUser vue) {
        this.vue = vue;
    }

    @Override
    public void eventCancel(IObservableLogin o, Object arg) {
        LOGER.debug("J'ai reçu l'évènement Cancel");
    }

    @Override
    public void eventLogin(IObservableLogin o, String login, String mdp) {

        User u = parent.getDatabase().findUser(login,mdp);

        if( u != null){
            parent.getDatabase().setUserConnected(u);
            parent.chargeFond();
        }else{
            vue.setErrorMessage("Le couple pseudo / mot de passe n'existe pas");
        }
    }

    @Override
    public void chargeAccountManager() {
        this.parent.chargeAccountManager();
    }
}
