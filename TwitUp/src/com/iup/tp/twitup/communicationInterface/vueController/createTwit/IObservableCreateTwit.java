package com.iup.tp.twitup.communicationInterface.vueController.createTwit;

public interface IObservableCreateTwit {

    void addObserver(IObserverCreateTwit o);

    void deleteObserver();

    void notifyAddTwit(String twitTexte);


}
