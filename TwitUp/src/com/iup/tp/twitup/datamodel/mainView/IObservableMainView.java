package com.iup.tp.twitup.datamodel.mainView;

public interface IObservableMainView {

    void addObserver(IObserverMainView o);

    void deleteObserver();

    void notifyController();
}
