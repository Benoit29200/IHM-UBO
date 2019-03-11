package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.researchUser.IObserverResearchUser;
import com.iup.tp.twitup.ihm.researchUser.TwitupResearchUser;

public class ResearchUserController implements IObserverResearchUser {

    CreateViewUserController parent;
    TwitupResearchUser vue;

    public ResearchUserController(CreateViewUserController parent) {
        this.parent = parent;
    }

    public void setVue(TwitupResearchUser vue) {
        this.vue = vue;
    }
}
