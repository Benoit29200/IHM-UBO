package com.iup.tp.twitup.datamodel.menu;

public interface IObservableMenu {

    void addObserver(IObserverMenu o);

    void deleteObserver();

    void notifyChargeAccountManager();

    void notifyChargeConnexion();
}
