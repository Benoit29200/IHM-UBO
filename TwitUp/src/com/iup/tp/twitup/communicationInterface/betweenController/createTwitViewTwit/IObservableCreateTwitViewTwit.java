package com.iup.tp.twitup.communicationInterface.betweenController.createTwitViewTwit;

public interface IObservableCreateTwitViewTwit {

    void addObserver(IObserverCreateTwitViewTwit o);

    void deleteObserver();

    void notifyAddTwit();


}
