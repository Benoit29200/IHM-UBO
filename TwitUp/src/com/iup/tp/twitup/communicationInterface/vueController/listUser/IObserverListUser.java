package com.iup.tp.twitup.communicationInterface.vueController.listUser;


import com.iup.tp.twitup.datamodel.User;

import java.util.List;

public interface IObserverListUser {

    List<User> getUsers();
    void chargeProfilUser(User u);

}
