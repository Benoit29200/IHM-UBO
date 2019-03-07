package com.iup.tp.twitup.datamodel.menuFichier;

public interface IObservableMenuFichier {

    void addObserver(IObserverMenuFichier o);

    void deleteObserver();

    void notifyChargeFichier();

}
