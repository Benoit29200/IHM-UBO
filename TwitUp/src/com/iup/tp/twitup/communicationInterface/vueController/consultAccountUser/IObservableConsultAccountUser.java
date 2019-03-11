package com.iup.tp.twitup.communicationInterface.vueController.consultAccountUser;

import com.iup.tp.twitup.datamodel.User;

public interface IObservableConsultAccountUser {

    void addObserver(IObserverConsultAccountUser o);

    void deleteObserver();

    void notifyAbonne(User u);
    void notifyDesabonne(User u);
}
