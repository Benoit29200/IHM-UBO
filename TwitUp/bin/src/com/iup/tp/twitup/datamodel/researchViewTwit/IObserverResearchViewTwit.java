package com.iup.tp.twitup.datamodel.researchViewTwit;


public interface IObserverResearchViewTwit {

    void majTwits();

    void searchTwitByUser(String user);
    void searchByTag(String tag);

}
