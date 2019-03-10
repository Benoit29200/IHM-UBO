package com.iup.tp.twitup.communicationInterface.vueController.menuDeconnexion;

public interface IObservableMenuDeconnexion {

    void addObserver(IObserverMenuDeconnexion o);

    void deleteObserver();

    void notifyChargeConnexionComponent();

}
