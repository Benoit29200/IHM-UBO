package com.iup.tp.twitup.communicationInterface.vueController.bordereauMenu;

public interface IObservableBordereauMenu {

    void addObserver(IObserverBordereauMenu o);

    void deleteObserver();

    void notifyChargeTwitView();
    void notifyChargeMyAccount();
    void notifyChargeListUser();
}
