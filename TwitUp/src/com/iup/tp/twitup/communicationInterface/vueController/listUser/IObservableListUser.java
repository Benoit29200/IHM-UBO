package com.iup.tp.twitup.communicationInterface.vueController.listUser;

import com.iup.tp.twitup.datamodel.User;

public interface IObservableListUser {

    void addObserver(IObserverListUser o);

    void deleteObserver();

    void notifyChargeViewProfilUser(User u);



}
