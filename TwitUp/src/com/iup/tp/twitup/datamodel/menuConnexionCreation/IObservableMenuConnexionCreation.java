package com.iup.tp.twitup.datamodel.menuConnexionCreation;

public interface IObservableMenuConnexionCreation {

    void addObserver(IObserverMenuConnexionCreation o);

    void deleteObserver();

    void notifyChargeAccountManager();

    void notifyChargeConnexion();
}
