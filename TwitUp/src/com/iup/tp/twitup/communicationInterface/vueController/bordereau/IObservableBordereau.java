package com.iup.tp.twitup.communicationInterface.vueController.bordereau;

public interface IObservableBordereau {

    void addObserver(IObserverBordereau o);

    void deleteObserver();

    void notifyConsultListTwitUser(String userTag);

}
