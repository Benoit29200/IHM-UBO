package com.iup.tp.twitup.communicationInterface.vueController;

import com.iup.tp.twitup.datamodel.Twit;

public interface IObserverNotifyFollower {

    void receiveNewTwit(Twit twit);
}
