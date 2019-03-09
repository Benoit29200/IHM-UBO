package com.iup.tp.twitup.datamodel.myAccountBordereau;

import com.iup.tp.twitup.datamodel.User;

import java.util.UUID;

public interface IObservableMyAccountBordereau {

    void addObserver(IObserverMyAccountBordereau o);

    void deleteObserver();

    void notifyUpdateAccount();

}
