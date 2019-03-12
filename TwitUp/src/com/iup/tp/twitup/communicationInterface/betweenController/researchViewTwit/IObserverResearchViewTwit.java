package com.iup.tp.twitup.communicationInterface.betweenController.researchViewTwit;


public interface IObserverResearchViewTwit {

    void majTwits();

    void searchTwitByUser(String user);
    void searchByTag(String tag);
    void searchByTagAndUser(String chaine);

}
