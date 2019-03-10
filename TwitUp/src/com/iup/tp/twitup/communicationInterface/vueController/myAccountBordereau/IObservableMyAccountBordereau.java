package com.iup.tp.twitup.communicationInterface.vueController.myAccountBordereau;

public interface IObservableMyAccountBordereau {

    void addObserver(IObserverMyAccountBordereau o);

    void deleteObserver();

    void notifyUpdateAccount();

}
