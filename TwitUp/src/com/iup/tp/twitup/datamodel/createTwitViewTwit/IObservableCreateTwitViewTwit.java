package com.iup.tp.twitup.datamodel.createTwitViewTwit;

public interface IObservableCreateTwitViewTwit {

    void addObserver(IObserverCreateTwitViewTwit o);

    void deleteObserver();

    void notifyAddTwit();


}
