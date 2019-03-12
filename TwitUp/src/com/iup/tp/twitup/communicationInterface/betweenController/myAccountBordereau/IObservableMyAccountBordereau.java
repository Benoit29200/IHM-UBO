package com.iup.tp.twitup.communicationInterface.betweenController.myAccountBordereau;

public interface IObservableMyAccountBordereau {

    void addObserver(IObserverMyAccountBordereau o);

    void deleteObserver();

    void notifyUpdateAccount();

}
