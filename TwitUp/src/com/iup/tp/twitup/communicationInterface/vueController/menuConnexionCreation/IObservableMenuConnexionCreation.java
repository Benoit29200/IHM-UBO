package com.iup.tp.twitup.communicationInterface.vueController.menuConnexionCreation;

public interface IObservableMenuConnexionCreation {

    void addObserver(IObserverMenuConnexionCreation o);

    void deleteObserver();

    void notifyChargeAccountManager();

    void notifyChargeConnexion();
}
