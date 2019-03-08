package com.iup.tp.twitup.datamodel.myAccount;


import com.iup.tp.twitup.datamodel.User;

public interface IObserverMyAccount {


        User getUserConnected();

        void chargeViewTwit();
        void chargeMyAccount();
}
