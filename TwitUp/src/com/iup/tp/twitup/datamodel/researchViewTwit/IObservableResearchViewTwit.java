package com.iup.tp.twitup.datamodel.researchViewTwit;

public interface IObservableResearchViewTwit {

    void addObserver(IObserverResearchViewTwit o);

    void deleteObserver();

    void notifySearchTwitByUser(String user);
    void notifySearchByTag(String tag);


}
