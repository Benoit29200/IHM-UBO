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
import com.iup.tp.twitup.ihm.fond.TwitupBordereau;
import com.iup.tp.twitup.ihm.fond.TwitupBordereauMenu;
import com.iup.tp.twitup.ihm.fond.TwitupFond;
import com.iup.tp.twitup.ihm.menu.MenuConnexionCreation;
import com.iup.tp.twitup.ihm.menu.MenuFichier;
import com.iup.tp.twitup.ihm.menu.MenuInformation;
import com.iup.tp.twitup.ihm.twit.TwitupCreateTwit;
import com.iup.tp.twitup.ihm.twit.TwitupCreateViewTwit;
import com.iup.tp.twitup.ihm.twit.TwitupFilTwit;

import java.awt.*;


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
        TwitupMenu twitupMenu = new TwitupMenu();
        menuController.setVue(twitupMenu);
        this.vue.setJMenuBar(twitupMenu);
        this.chargeMenuFichier(menuController,twitupMenu);
        this.chargeMenuConnexionCreation(menuController,twitupMenu);
        this.chargeMenuInformation(menuController,twitupMenu);
    }

    private void chargeMenuConnexionCreation(MenuController parent, TwitupMenu vueParent){
        MenuConnexionCreationController menuConnexionCreationController = new MenuConnexionCreationController(parent);
        MenuConnexionCreation menuConnexionCreation = new MenuConnexionCreation(menuConnexionCreationController);
        menuConnexionCreationController.setMenuView(menuConnexionCreation);
        vueParent.addMenuConnexion(menuConnexionCreation);
    }

    private void chargeMenuFichier(MenuController parent, TwitupMenu vueParent){
        MenuFichierController menuFichierController = new MenuFichierController(parent);
        MenuFichier menuFichier = new MenuFichier(this.vue, menuFichierController);
        menuFichierController.setVue(menuFichier);
        vueParent.addMenuFichier(menuFichier);
    }

    private void chargeMenuInformation(MenuController parent, TwitupMenu vueParent){
        MenuInformationController menuInformationController = new MenuInformationController(parent);
        MenuInformation menuInformation = new MenuInformation(menuInformationController);
        menuInformationController.setVue(menuInformation);
        vueParent.addMenuInformation(menuInformation);
    }

    public void chargeConnexionComponent(){
        LoginController loginController = new LoginController(this);
        TwitupConnexionUser connexion = new TwitupConnexionUser(loginController);
        loginController.setVue(connexion);
        this.vue.addTwitupConnexionUser(connexion);
    }

    public void chargeAccountManager(){
        AccountCreationController accountCreationController = new AccountCreationController(this);
        TwitupCreationCompte creationCompte = new TwitupCreationCompte(accountCreationController);
        accountCreationController.setVue(creationCompte);
        this.vue.chargeAccountManager(creationCompte);
    }

    public void chargeFond(){
        FondController fondController = new FondController(this);
        TwitupFond twitupFond = new TwitupFond(fondController);
        fondController.setVue(twitupFond);
        this.vue.chargeFond(twitupFond);
        this.chargeBordereauMenu(fondController,twitupFond);
        this.chargeBordereau(fondController,twitupFond);
        this.chargeCreateViewTwit(fondController,twitupFond);
    }

    private void chargeBordereauMenu(FondController parent, TwitupFond vueParent){
        BordereauMenuController bordereauMenuController = new BordereauMenuController(parent);
        TwitupBordereauMenu twitupBordereauMenu = new TwitupBordereauMenu(bordereauMenuController);
        bordereauMenuController.setVue(twitupBordereauMenu);
        
        vueParent.chargeComponent(twitupBordereauMenu, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.WEST,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
    }

    private void chargeBordereau(FondController parent, TwitupFond vueParent){
        BordereauController bordereauController = new BordereauController(parent);
        TwitupBordereau twitupBordereau = new TwitupBordereau(bordereauController, this.database.getUserConnected());
 
        bordereauController.setVue(twitupBordereau);
        
        vueParent.chargeComponent(twitupBordereau,new GridBagConstraints(2, 0, 1, 1, 0, 1, GridBagConstraints.EAST,
                GridBagConstraints.VERTICAL, new Insets(5, 5, 0, 5), 0, 0));
    }

    private void chargeCreateViewTwit(FondController parent, TwitupFond vueParent){
        CreateViewTwitController createViewTwitController = new CreateViewTwitController(parent);
        TwitupCreateViewTwit twitupCreateViewTwit = new TwitupCreateViewTwit(createViewTwitController);
        createViewTwitController.setVue(twitupCreateViewTwit);
        vueParent.chargeComponent(twitupCreateViewTwit,new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
        this.chargeCreateTWit(createViewTwitController,twitupCreateViewTwit);
        this.chargeFilTwit(createViewTwitController,twitupCreateViewTwit);
    }

    private void chargeCreateTWit(CreateViewTwitController parent, TwitupCreateViewTwit vueParent){
        CreateTwitController createTwitController = new CreateTwitController(parent);
        TwitupCreateTwit twitupCreateTwit = new TwitupCreateTwit(createTwitController);
        createTwitController.setVue(twitupCreateTwit);
        vueParent.addTwitupCreateTwit(twitupCreateTwit);
    }

    private void chargeFilTwit(CreateViewTwitController parent, TwitupCreateViewTwit vueParent){
        TwitupFilTwitController twitupFilTwitController = new TwitupFilTwitController(parent);
        TwitupFilTwit twitupFilTwit = new TwitupFilTwit(twitupFilTwitController);
        twitupFilTwitController.setVue(twitupFilTwit);
        vueParent.addTwitupFilTwit(twitupFilTwit);
    }
}
