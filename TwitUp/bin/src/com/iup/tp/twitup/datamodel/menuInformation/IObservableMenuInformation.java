package com.iup.tp.twitup.datamodel.menuInformation;

public interface IObservableMenuInformation {

    void addObserver(IObserverMenuInformation o);

    void deleteObserver();

    void notifyChargeInformation();

}
