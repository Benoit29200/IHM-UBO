package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.consultAccountUser.IObserverConsultAccountUser;
import com.iup.tp.twitup.datamodel.User;

public class ConsultAccountUserController implements IObserverConsultAccountUser {

    private BackgroundController parent;

    public ConsultAccountUserController(BackgroundController parent) {
        this.parent = parent;
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
