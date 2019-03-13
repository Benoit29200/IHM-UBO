package com.iup.tp.twitup.communicationInterface;

import com.iup.tp.twitup.communicationInterface.vueController.IObserverNotifyFollower;
import com.iup.tp.twitup.datamodel.Twit;

public interface IObservableNotifyFollower {

    void addObserverFollower(IObserverNotifyFollower observer);
    void deleteObserverFollower();
    void notifyFollower(Twit twit);
}
