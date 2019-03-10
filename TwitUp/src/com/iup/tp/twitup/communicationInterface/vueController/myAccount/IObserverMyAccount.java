package com.iup.tp.twitup.communicationInterface.vueController.myAccount;


import com.iup.tp.twitup.datamodel.User;

import java.util.UUID;

public interface IObserverMyAccount {


        User getUserConnected();

        void chargeViewTwit();
        void chargeMyAccount();
        void updateMyAccount(UUID id, String name, String pseudo, String avatarPath, String password);
}
