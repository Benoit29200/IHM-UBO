package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.database.IDatabase;
import com.iup.tp.twitup.communicationInterface.vueController.myAccount.IObserverMyAccount;
import com.iup.tp.twitup.communicationInterface.vueController.myAccountBordereau.IObservableMyAccountBordereau;
import com.iup.tp.twitup.communicationInterface.vueController.myAccountBordereau.IObserverMyAccountBordereau;
import com.iup.tp.twitup.ihm.account.ConsultAccount;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class MyAccountController implements IObserverMyAccount, IObservableMyAccountBordereau {

    private ConsultAccount vue;
    private FondController parent;
    private IDatabase database;
    private IObserverMyAccountBordereau observer;

    public MyAccountController(FondController parent, IDatabase database) {
        this.parent = parent;
        this.database = database;
    }

    public void setVue(ConsultAccount vue) {
        this.vue = vue;
    }


    @Override
    public User getUserConnected() {
        return this.database.getUserConnected();
    }

    @Override
    public void chargeViewTwit() {
        this.parent.getParent().chargeFond();
    }

    @Override
    public void chargeMyAccount() {
        this.parent.getParent().chargeFondWithMyAccount();
    }

    @Override
    public void updateMyAccount(UUID id, String name, String pseudo, String avatarPath, String password) {
        if(StringUtils.isBlank(name) || StringUtils.isBlank(pseudo)){
            this.vue.setMessage("Le nom et le pseudo sont obligatoires");
        }else if(this.database.findTagUser(pseudo) && !pseudo.equals(this.database.getUserConnected().getUserTag())){
            this.vue.setMessage("Le pseudo est déja utilisé");
        } else{
                this.database.updateAccount(id,name,pseudo,avatarPath,password);
                this.notifyUpdateAccount();
            this.vue.setMessage("Votre profil a été mis à jour");
        }
    }

    @Override
    public void addObserver(IObserverMyAccountBordereau o) {
        this.observer = o;
    }

    @Override
    public void deleteObserver() {
        this.observer = null;
    }

    @Override
    public void notifyUpdateAccount() {
        this.observer.updateAccount();
    }
}