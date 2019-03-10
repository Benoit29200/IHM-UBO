package com.iup.tp.twitup.communicationInterface.vueController.twitupFilTwit;


import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

import java.util.Set;

public interface IObserverTwitupFilTwit {


    Set<Twit> getTwit();
    Set<User> getUsers();
}
