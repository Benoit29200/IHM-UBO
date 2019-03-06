package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.database.IDatabase;
import com.iup.tp.twitup.datamodel.database.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.mainView.IObserverMainView;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.TwitupMenu;
import com.iup.tp.twitup.ihm.compte.TwitupConnexionUser;
import com.iup.tp.twitup.ihm.compte.TwitupCreationCompte;
import com.iup.tp.twitup.ihm.fond.TwitupFond;


public class MainViewController implements IObserverMainView, IDatabaseObserver {


    protected IDatabase database;
    protected TwitupMainView vue;

    public MainViewController(IDatabase database, TwitupMainView vue) {
        this.database = database;
        this.vue = vue;
        this.chargeConnexionComponent();
        this.chargeMenu();
    }

    @Override
    public void notifyTwitAdded(Twit addedTwit) {
        this.database.addTwit(addedTwit);
    }

    @Override
    public void notifyTwitDeleted(Twit deletedTwit) {
        this.database.removeTwit(deletedTwit);
    }

    @Override
    public void notifyTwitModified(Twit modifiedTwit) {
        this.database.modifiyTwit(modifiedTwit);
    }

    @Override
    public void notifyUserAdded(User addedUser) {
        this.database.addUser(addedUser);
    }

    @Override
    public void notifyUserDeleted(User deletedUser) {
        this.database.removeUser(deletedUser);
    }

    @Override
    public void notifyUserModified(User modifiedUser) {
        this.notifyUserModified(modifiedUser);
    }

    public IDatabase getDatabase() {
        return database;
    }

    private void chargeMenu(){

        MenuController menuController = new MenuController(this);
        TwitupMenu menu = new TwitupMenu(this.vue, menuController);
        menuController.setMenuView(menu);
        menu.addObserver(menuController);
        this.vue.setMenu(menu);
    }

    public void chargeConnexionComponent(){
        LoginController loginController = new LoginController(this);
        TwitupConnexionUser connexion = new TwitupConnexionUser(loginController);
        loginController.setVue(connexion);
        this.vue.chargeComponent(connexion);
    }

    public void chargeAccountManager(){
        AccountCreationController accountCreationController = new AccountCreationController(this);
        TwitupCreationCompte creationCompte = new TwitupCreationCompte(accountCreationController);
        accountCreationController.setVue(creationCompte);
        this.vue.chargeComponent(creationCompte);
    }

    public void chargeApp(){
        TwitupFond app = new TwitupFond();
        vue.chargeComponent(app);
    }


}
