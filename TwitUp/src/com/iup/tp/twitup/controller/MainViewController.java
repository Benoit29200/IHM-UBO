package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.communicationInterface.vueController.mainView.IObserverMainView;
import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.database.IDatabase;
import com.iup.tp.twitup.datamodel.database.IDatabaseObserver;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.account.*;
import com.iup.tp.twitup.ihm.background.Background;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereau;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereauMenu;
import com.iup.tp.twitup.ihm.listUser.TwitupCreateViewUserFil;
import com.iup.tp.twitup.ihm.listUser.TwitupFilUser;
import com.iup.tp.twitup.ihm.listUser.TwitupResearchUser;
import com.iup.tp.twitup.ihm.menu.*;
import com.iup.tp.twitup.ihm.twit.CreateTwitForm;
import com.iup.tp.twitup.ihm.twit.CreateViewTwit;
import com.iup.tp.twitup.ihm.twit.ListTwit;
import com.iup.tp.twitup.ihm.twit.ResearchTwit;


public class MainViewController implements IObserverMainView, IDatabaseObserver {


    protected IDatabase database;
    protected TwitupMainView vue;
    protected EntityManager entityManager;

    public MainViewController(IDatabase database, TwitupMainView vue, EntityManager entityManager) {
        this.database = database;
        this.vue = vue;
        this.entityManager = entityManager;
        this.chargeConnexionComponent();
        this.chargeMenu();
    }

    public void reset(){
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

    public EntityManager getEntityManager() {
        return entityManager;
    }

    private void chargeMenu(){
        MenuController menuController = new MenuController(this);
        TwitupMenu twitupMenu = new TwitupMenu();
        this.vue.setJMenuBar(twitupMenu);
        this.chargeMenuFichier(twitupMenu);
        this.chargeMenuConnexionCreation(menuController,twitupMenu);
        this.chargeMenuInformation(twitupMenu);
    }

    private void chargeMenuWithDeconnexion(){
        MenuController menuController = new MenuController(this);
        TwitupMenu twitupMenu = new TwitupMenu();
        this.vue.setJMenuBar(twitupMenu);
        this.chargeMenuFichier(twitupMenu);
        this.chargeMenuDeconnexion(menuController,twitupMenu);
        this.chargeMenuInformation(twitupMenu);
    }

    private void chargeMenuConnexionCreation(MenuController menuController, TwitupMenu twitupMenu){
        MenuConnexionCreationController menuConnexionCreationController = new MenuConnexionCreationController(menuController);
        MenuConnexionCreation menuConnexionCreation = new MenuConnexionCreation(menuConnexionCreationController);
        twitupMenu.addMenuConnexion(menuConnexionCreation);
    }

    private void chargeMenuFichier(TwitupMenu twitupMenu){
        MenuFichier menuFichier = new MenuFichier();
        twitupMenu.addMenuFichier(menuFichier);
    }

    private void chargeMenuDeconnexion(MenuController menuController, TwitupMenu twitMenu){
        MenuDeconnexionController menuDeconnexionController = new MenuDeconnexionController(menuController);
        MenuDeconnexion menuDeconnexion = new MenuDeconnexion(this.vue,menuDeconnexionController);
        twitMenu.addMenuDeconnexion(menuDeconnexion);
    }

    private void chargeMenuInformation(TwitupMenu twitupMenu){
        MenuInformation menuInformation = new MenuInformation();
        twitupMenu.addMenuInformation(menuInformation);
    }

    public void chargeConnexionComponent(){
        LoginController loginController = new LoginController(this);
        ConnexionUser connexion = new ConnexionUser(loginController);
        loginController.setVue(connexion);
        this.vue.addTwitupConnexionUser(connexion);
    }

    public void chargeAccountManager(){
        AccountCreationController accountCreationController = new AccountCreationController(this);
        CreationCompte creationCompte = new CreationCompte(accountCreationController);
        accountCreationController.setVue(creationCompte);
        this.vue.chargeAccountManager(creationCompte);
    }

    public void chargeFond(){
        this.chargeMenuWithDeconnexion();
        BackgroundController backgroundController = new BackgroundController(this);
        Background background = new Background();
        this.vue.chargeFond(background);
        this.chargeBordereauMenu(backgroundController, background);
        this.chargeBordereau(backgroundController, background);
        this.chargeCreateViewTwit(backgroundController, background);
    }

    public void chargeFondWithMyAccount(){
        this.chargeMenuWithDeconnexion();
        BackgroundController backgroundController = new BackgroundController(this);
        Background background = new Background();
        this.vue.chargeFond(background);
        this.chargeBordereauMenu(backgroundController, background);
        BordereauController bordereauController = this.chargeBordereau(backgroundController, background);
        MyAccountController myAccountController = this.chargeMyAccount(backgroundController, background);
        myAccountController.addObserver(bordereauController);
    }

    public void chargeFondWithProfilUser(User user){
        this.chargeMenuWithDeconnexion();
        BackgroundController backgroundController = new BackgroundController(this);
        Background background = new Background();
        this.vue.chargeFond(background);
        this.chargeBordereauMenu(backgroundController, background);
        this.chargeBordereau(backgroundController, background);
        this.chargeAccountUser(backgroundController, background,user);
    }

    private void chargeAccountUser(BackgroundController backgroundController, Background background, User user){
        ConsultAccountUserController consultAccountUserController = new ConsultAccountUserController(backgroundController);
        ConsultAnUserAccount consultAnUserAccount = new ConsultAnUserAccount(user, this.database.getUserConnected(),consultAccountUserController);
        background.chargeUserAccount(consultAnUserAccount);
    }

    public void chargeFondWithListUser(){
        this.chargeMenuWithDeconnexion();
        BackgroundController backgroundController = new BackgroundController(this);
        Background background = new Background();
        this.vue.chargeFond(background);
        this.chargeBordereauMenu(backgroundController, background);
        this.chargeBordereau(backgroundController, background);
        this.chargeListUser(backgroundController, background);
    }

    public void chargeFondWithListTwitUser(String userTag){
        this.chargeMenuWithDeconnexion();
        BackgroundController backgroundController = new BackgroundController(this);
        Background background = new Background();
        this.vue.chargeFond(background);
        this.chargeBordereauMenu(backgroundController, background);
        this.chargeBordereau(backgroundController, background);
        this.chargeListTwitUser(background,userTag);
    }

    private void chargeListTwitUser(Background background, String userTag){
        ListTwitUser listTwitUser = new ListTwitUser(this.getDatabase().getTwitsByUser(userTag));
        background.chargeListTwitUser(listTwitUser);
    }

    private MyAccountController chargeMyAccount(BackgroundController backgroundController, Background background){
        MyAccountController myAccountController = new MyAccountController(backgroundController, this.getDatabase());
        ConsultAccount consultAccount = new ConsultAccount(myAccountController);
        myAccountController.setVue(consultAccount);
        background.chargeTwitupMyAccount(consultAccount);
        return myAccountController;
    }

    private void chargeListUser(BackgroundController backgroundController, Background background){
        CreateViewUserController createViewUserController = new CreateViewUserController(backgroundController);
        TwitupCreateViewUserFil twitupCreateViewUserFil = new TwitupCreateViewUserFil();
        background.chargeListUser(twitupCreateViewUserFil);

        ListUserController listUserController = new ListUserController(createViewUserController);
        TwitupFilUser twitupFilUser = new TwitupFilUser(listUserController);
        listUserController.setVue(twitupFilUser);
        twitupCreateViewUserFil.addTwitupFilUser(twitupFilUser);

        ResearchUserController researchUserController = new ResearchUserController();
        researchUserController.addObserver(listUserController);
        TwitupResearchUser twitupResearchUser = new TwitupResearchUser(researchUserController);
        twitupCreateViewUserFil.addTwitupResearchUser(twitupResearchUser);
    }

    private void chargeBordereauMenu(BackgroundController backgroundController, Background background){
        BordereauMenuController bordereauMenuController = new BordereauMenuController(backgroundController);
        TwitupBordereauMenu twitupBordereauMenu = new TwitupBordereauMenu(bordereauMenuController);
        background.chargeTwitupBordereauMenu(twitupBordereauMenu);
    }

    private BordereauController chargeBordereau(BackgroundController backgroundController, Background background){
        BordereauController bordereauController = new BordereauController(backgroundController);
        this.database.addObserverFollower(bordereauController);
        TwitupBordereau twitupBordereau = new TwitupBordereau(bordereauController, this.database.getUserConnected());
        bordereauController.setVue(twitupBordereau);
        background.chargeTwitupBordereau(twitupBordereau);
        return bordereauController;
    }

    private void chargeCreateViewTwit(BackgroundController backgroundController, Background background){
        CreateViewTwitController createViewTwitController = new CreateViewTwitController(backgroundController, this.database);
        CreateViewTwit createViewTwit = new CreateViewTwit();
        background.chargeTwitupCreateViewTwit(createViewTwit);

        CreateTwitFormController createTwitFormController = this.chargeCreateTWit(createViewTwitController, createViewTwit);
        ResearchTwitController researchTwitController = this.chargeResearch(createViewTwit);
        ListTwitController listTwitController = this.chargeFilTwit(createViewTwitController, createViewTwit);
        researchTwitController.setObserver(listTwitController);
        createTwitFormController.setViewTwit(listTwitController);

    }

    private ResearchTwitController chargeResearch(CreateViewTwit createViewTwit){
        ResearchTwitController researchTwitController = new ResearchTwitController();
        ResearchTwit researchTwit = new ResearchTwit(researchTwitController);
        createViewTwit.addTwitupResearchTwit(researchTwit);
        return researchTwitController;
    }

    private CreateTwitFormController chargeCreateTWit(CreateViewTwitController createViewTwitController, CreateViewTwit createViewTwit){
        CreateTwitFormController createTwitFormController = new CreateTwitFormController(createViewTwitController);
        CreateTwitForm createTwitForm = new CreateTwitForm(createTwitFormController);
        createViewTwit.addTwitupCreateTwit(createTwitForm);
        return createTwitFormController;
    }

    private ListTwitController chargeFilTwit(CreateViewTwitController createViewTwitController, CreateViewTwit createViewTwit){
        ListTwitController listTwitController = new ListTwitController(createViewTwitController);
        ListTwit listTwit = new ListTwit(listTwitController);
        listTwitController.setVue(listTwit);
        createViewTwit.addTwitupFilTwit(listTwit);
        return listTwitController;
    }
}
