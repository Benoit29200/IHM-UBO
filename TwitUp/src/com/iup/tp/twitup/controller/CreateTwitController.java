package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.createTwit.IObserverCreateTwit;
import com.iup.tp.twitup.datamodel.createTwitViewTwit.IObservableCreateTwitViewTwit;
import com.iup.tp.twitup.datamodel.createTwitViewTwit.IObserverCreateTwitViewTwit;
import com.iup.tp.twitup.ihm.twit.TwitupCreateTwit;

public class CreateTwitController implements IObserverCreateTwit, IObservableCreateTwitViewTwit {

    private CreateViewTwitController parent;
    private TwitupCreateTwit vue;
    private IObserverCreateTwitViewTwit viewTwit;

    public CreateTwitController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setViewTwit(IObserverCreateTwitViewTwit viewTwit) {
        this.viewTwit = viewTwit;
    }

    public void setVue(TwitupCreateTwit vue) {
        this.vue = vue;
    }

    @Override
    public void addObserver(IObserverCreateTwitViewTwit o) {
        this.viewTwit = o;
    }

    @Override
    public void deleteObserver() {
        this.viewTwit = null;
    }

    @Override
    public void notifyAddTwit() {

        this.viewTwit.majTwits();
    }

    public void addTwit(String twitText){

        if(twitText.length()>150){
            //erreur
        }
        else{
            User userConnected = this.parent.getDatabase().getUserConnected();
            Twit twit = new Twit(userConnected,twitText);
            this.parent.getDatabase().addTwit(twit);
            this.notifyAddTwit();
        }


    }
}
