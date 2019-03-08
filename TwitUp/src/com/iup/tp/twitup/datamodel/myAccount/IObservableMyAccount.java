package com.iup.tp.twitup.datamodel.myAccount;

public interface IObservableMyAccount {

    void addObserver(IObserverMyAccount o);

    void deleteObserver();

}
