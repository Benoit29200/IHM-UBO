package com.iup.tp.twitup.datamodel.bordereauMenu;

public interface IObservableBordereauMenu {

    void addObserver(IObserverBordereauMenu o);

    void deleteObserver();

    void notifyChargeTwitView();
    void notifyChargeMyAccount();
}
