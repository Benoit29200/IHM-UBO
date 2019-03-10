package com.iup.tp.twitup.communicationInterface.vueController.myAccount;

import java.util.UUID;

public interface IObservableMyAccount {

    void addObserver(IObserverMyAccount o);

    void deleteObserver();

    void notifyUpdateMyAccount(UUID id, String name, String pseudo, String avatarPath, String password);

}
