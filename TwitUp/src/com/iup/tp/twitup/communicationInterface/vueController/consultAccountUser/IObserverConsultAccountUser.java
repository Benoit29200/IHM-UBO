package com.iup.tp.twitup.communicationInterface.vueController.consultAccountUser;


import com.iup.tp.twitup.datamodel.User;

public interface IObserverConsultAccountUser {

    void abonne(User u);
    void desabonne(User u);


}
