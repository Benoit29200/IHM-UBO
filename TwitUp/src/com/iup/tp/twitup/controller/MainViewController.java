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
import com.iup.tp.twitup.ihm.twit.TwitupResearch;


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

    private void chargeMenuConnexionCreation(MenuController menuController, TwitupMenu twitupMenu){
        MenuConnexionCreationController menuConnexionCreationController = new MenuConnexionCreationController(menuController);
        MenuConnexionCreation menuConnexionCreation = new MenuConnexionCreation(menuConnexionCreationController);
        menuConnexionCreationController.setMenuView(menuConnexionCreation);
        twitupMenu.addMenuConnexion(menuConnexionCreation);
    }

    private void chargeMenuFichier(MenuController menuController, TwitupMenu twitupMenu){
        MenuFichierController menuFichierController = new MenuFichierController(menuController);
        MenuFichier menuFichier = new MenuFichier(this.vue, menuFichierController);
        menuFichierController.setVue(menuFichier);
        twitupMenu.addMenuFichier(menuFichier);
    }

    private void chargeMenuInformation(MenuController menuController, TwitupMenu twitupMenu){
        MenuInformationController menuInformationController = new MenuInformationController(menuController);
        MenuInformation menuInformation = new MenuInformation(menuInformationController);
        menuInformationController.setVue(menuInformation);
        twitupMenu.addMenuInformation(menuInformation);
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

    private void chargeBordereauMenu(FondController fondController, TwitupFond twitupFond){
        BordereauMenuController bordereauMenuController = new BordereauMenuController(fondController);
        TwitupBordereauMenu twitupBordereauMenu = new TwitupBordereauMenu(bordereauMenuController);
        bordereauMenuController.setVue(twitupBordereauMenu);
        twitupFond.chargeTwitupBordereauMenu(twitupBordereauMenu);
    }

    private void chargeBordereau(FondController fondController, TwitupFond twitupFond){
        BordereauController bordereauController = new BordereauController(fondController);
        TwitupBordereau twitupBordereau = new TwitupBordereau(bordereauController, this.database.getUserConnected());
        bordereauController.setVue(twitupBordereau);
        twitupFond.chargeTwitupBordereau(twitupBordereau);
    }

    private void chargeCreateViewTwit(FondController fondController, TwitupFond twitupFond){
        CreateViewTwitController createViewTwitController = new CreateViewTwitController(fondController, this.database);
        TwitupCreateViewTwit twitupCreateViewTwit = new TwitupCreateViewTwit(createViewTwitController);
        createViewTwitController.setVue(twitupCreateViewTwit);
        twitupFond.chargeTwitupCreateViewTwit(twitupCreateViewTwit);

        CreateTwitController createTwitController = this.chargeCreateTWit(createViewTwitController,twitupCreateViewTwit);
        ResearchController  researchController= this.chargeResearch(createViewTwitController,twitupCreateViewTwit);
        TwitupFilTwitController twitupFilTwitController = this.chargeFilTwit(createViewTwitController,twitupCreateViewTwit);
        researchController.setObserver(twitupFilTwitController);
        createTwitController.setViewTwit(twitupFilTwitController);

    }

    private ResearchController chargeResearch(CreateViewTwitController createViewTwitController, TwitupCreateViewTwit twitupCreateViewTwit){
        ResearchController researchController = new ResearchController(createViewTwitController);
        TwitupResearch twitupResearch = new TwitupResearch(researchController);
        researchController.setVue(twitupResearch);
        twitupCreateViewTwit.addTwitupResearchTwit(twitupResearch);
        return researchController;
    }

    private CreateTwitController chargeCreateTWit(CreateViewTwitController createViewTwitController, TwitupCreateViewTwit twitupCreateViewTwit){
        CreateTwitController createTwitController = new CreateTwitController(createViewTwitController);
        TwitupCreateTwit twitupCreateTwit = new TwitupCreateTwit(createTwitController);
        createTwitController.setVue(twitupCreateTwit);
        twitupCreateViewTwit.addTwitupCreateTwit(twitupCreateTwit);
        return createTwitController;
    }

    private TwitupFilTwitController chargeFilTwit(CreateViewTwitController createViewTwitController, TwitupCreateViewTwit twitupCreateViewTwit){
        TwitupFilTwitController twitupFilTwitController = new TwitupFilTwitController(createViewTwitController);
        TwitupFilTwit twitupFilTwit = new TwitupFilTwit(twitupFilTwitController);
        twitupFilTwitController.setVue(twitupFilTwit);
        twitupCreateViewTwit.addTwitupFilTwit(twitupFilTwit);
        return twitupFilTwitController;
    }
}
