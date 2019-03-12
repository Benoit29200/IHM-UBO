package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.communicationInterface.vueController.createTwit.IObserverCreateTwit;
import com.iup.tp.twitup.communicationInterface.betweenController.createTwitViewTwit.IObservableCreateTwitViewTwit;
import com.iup.tp.twitup.communicationInterface.betweenController.createTwitViewTwit.IObserverCreateTwitViewTwit;
import com.iup.tp.twitup.ihm.twit.CreateTwitForm;
import org.apache.commons.lang3.StringUtils;

public class CreateTwitFormController implements IObserverCreateTwit, IObservableCreateTwitViewTwit {

    private CreateViewTwitController parent;
    private CreateTwitForm vue;
    private IObserverCreateTwitViewTwit viewTwit;

    public CreateTwitFormController(CreateViewTwitController parent) {
        this.parent = parent;
    }

    public void setViewTwit(IObserverCreateTwitViewTwit viewTwit) {
        this.viewTwit = viewTwit;
    }

    public void setVue(CreateTwitForm vue) {
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

    @Override
    public void addTwit(String twitText){
            if(StringUtils.isNotBlank(twitText)){
                User userConnected = this.parent.getDatabase().getUserConnected();
                Twit twit = new Twit(userConnected,twitText);
                this.parent.getDatabase().addTwit(twit);
                this.notifyAddTwit();
            }
    }
}
