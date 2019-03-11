package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.consultAccountUser.IObserverConsultAccountUser;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.ConsultAnUserAccount;

public class ConsultAccountUserController implements IObserverConsultAccountUser {

    private FondController parent;
    private ConsultAnUserAccount vue;

    public ConsultAccountUserController(FondController parent) {
        this.parent = parent;
    }

    public void setVue(ConsultAnUserAccount vue) {
        this.vue = vue;
    }

    @Override
    public void abonne(User u) {
        this.parent.getParent().getDatabase().getUserConnected().addFollowing(u.getUserTag());
        this.parent.getParent().chargeFondWithProfilUser(u);
    }

    @Override
    public void desabonne(User u) {
        this.parent.getParent().getDatabase().getUserConnected().removeFollowing(u.getUserTag());
        this.parent.getParent().chargeFondWithProfilUser(u);
    }
}
