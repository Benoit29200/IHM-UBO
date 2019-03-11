package com.iup.tp.twitup.controller;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.datamodel.database.IDatabase;
import com.iup.tp.twitup.datamodel.database.IDatabaseObserver;
import com.iup.tp.twitup.communicationInterface.vueController.mainView.IObserverMainView;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.menu.TwitupMenu;
import com.iup.tp.twitup.ihm.account.ConnexionUser;
import com.iup.tp.twitup.ihm.account.ConsultAccount;
import com.iup.tp.twitup.ihm.account.ConsultAnUserAccount;
import com.iup.tp.twitup.ihm.account.CreationCompte;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereau;
import com.iup.tp.twitup.ihm.background.bordereaux.TwitupBordereauMenu;
import com.iup.tp.twitup.ihm.background.TwitupFond;
import com.iup.tp.twitup.ihm.menu.MenuConnexionCreation;
import com.iup.tp.twitup.ihm.menu.MenuDeconnexion;
import com.iup.tp.twitup.ihm.menu.MenuFichier;
import com.iup.tp.twitup.ihm.menu.MenuInformation;
import com.iup.tp.twitup.ihm.listUser.TwitupCreateViewUserFil;
import com.iup.tp.twitup.ihm.listUser.TwitupFilUser;
import com.iup.tp.twitup.ihm.listUser.TwitupResearchUser;
import com.iup.tp.twitup.ihm.twit.CreateTwitForm;
import com.iup.tp.twitup.ihm.twit.CreateViewTwit;
import com.iup.tp.twitup.ihm.twit.ListTwit;
import com.iup.tp.twitup.ihm.twit.ResearchTwit;


public class MainViewController implements IObserverMainView, IDatabaseObserver {


    protected IDatabase database;
    protected TwitupMainView vue;

    public MainViewController(IDatabase database, TwitupMainView vue) {
        this.database = database;
        this.vue = vue;
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

    private void chargeMenu(){
        MenuController menuController = new MenuController(this);
        TwitupMenu twitupMenu = new TwitupMenu();
        menuController.setVue(twitupMenu);
        this.vue.setJMenuBar(twitupMenu);
        this.chargeMenuFichier(menuController,twitupMenu);
        this.chargeMenuConnexionCreation(menuController,twitupMenu);
        this.chargeMenuInformation(menuController,twitupMenu);
    }

    private void chargeMenuWithDeconnexion(){
        MenuController menuController = new MenuController(this);
        TwitupMenu twitupMenu = new TwitupMenu();
        menuController.setVue(twitupMenu);
        this.vue.setJMenuBar(twitupMenu);
        this.chargeMenuFichier(menuController,twitupMenu);
        this.chargeMenuDeconnexion(menuController,twitupMenu);
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

    private void chargeMenuDeconnexion(MenuController menuController, TwitupMenu twitMenu){
        MenuDeconnexionController menuDeconnexionController = new MenuDeconnexionController(menuController);
        MenuDeconnexion menuDeconnexion = new MenuDeconnexion(this.vue,menuDeconnexionController);
        menuDeconnexionController.setVue(menuDeconnexion);
        twitMenu.addMenuDeconnexion(menuDeconnexion);
    }

    private void chargeMenuInformation(MenuController menuController, TwitupMenu twitupMenu){
        MenuInformationController menuInformationController = new MenuInformationController(menuController);
        MenuInformation menuInformation = new MenuInformation(menuInformationController);
        menuInformationController.setVue(menuInformation);
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
        FondController fondController = new FondController(this);
        TwitupFond twitupFond = new TwitupFond(fondController);
        fondController.setVue(twitupFond);
        this.vue.chargeFond(twitupFond);
        this.chargeBordereauMenu(fondController,twitupFond);
        this.chargeBordereau(fondController,twitupFond);
        this.chargeCreateViewTwit(fondController,twitupFond);
    }

    public void chargeFondWithMyAccount(){
        this.chargeMenuWithDeconnexion();
        FondController fondController = new FondController(this);
        TwitupFond twitupFond = new TwitupFond(fondController);
        fondController.setVue(twitupFond);
        this.vue.chargeFond(twitupFond);
        this.chargeBordereauMenu(fondController,twitupFond);
        BordereauController bordereauController = this.chargeBordereau(fondController,twitupFond);
        MyAccountController myAccountController = this.chargeMyAccount(fondController,twitupFond);
        myAccountController.addObserver(bordereauController);
    }

    public void chargeFondWithProfilUser(User user){
        this.chargeMenuWithDeconnexion();
        FondController fondController = new FondController(this);
        TwitupFond twitupFond = new TwitupFond(fondController);
        fondController.setVue(twitupFond);
        this.vue.chargeFond(twitupFond);
        this.chargeBordereauMenu(fondController,twitupFond);
        this.chargeBordereau(fondController,twitupFond);
        this.chargeAccountUser(fondController,twitupFond,user);
    }

    private void chargeAccountUser(FondController fondController, TwitupFond twitupFond, User user){
        ConsultAccountUserController consultAccountUserController = new ConsultAccountUserController(fondController);
        ConsultAnUserAccount consultAnUserAccount = new ConsultAnUserAccount(user, this.database.getUserConnected(),consultAccountUserController);
        consultAccountUserController.setVue(consultAnUserAccount);
        twitupFond.chargeUserAccount(consultAnUserAccount);
    }

    public void chargeFondWithListUser(){
        this.chargeMenuWithDeconnexion();
        FondController fondController = new FondController(this);
        TwitupFond twitupFond = new TwitupFond(fondController);
        fondController.setVue(twitupFond);
        this.vue.chargeFond(twitupFond);
        this.chargeBordereauMenu(fondController,twitupFond);
        this.chargeBordereau(fondController,twitupFond);
        chargeListUser(fondController,twitupFond);
    }

    private MyAccountController chargeMyAccount(FondController fondController, TwitupFond twitupFond){
        MyAccountController myAccountController = new MyAccountController(fondController, this.getDatabase());
        ConsultAccount consultAccount = new ConsultAccount(myAccountController);
        myAccountController.setVue(consultAccount);
        twitupFond.chargeTwitupMyAccount(consultAccount);
        return myAccountController;
    }

    private void chargeListUser(FondController fondController, TwitupFond twitupFond){
        CreateViewUserController createViewUserController = new CreateViewUserController(fondController);
        TwitupCreateViewUserFil twitupCreateViewUserFil = new TwitupCreateViewUserFil(createViewUserController);
        createViewUserController.setVue(twitupCreateViewUserFil);
        twitupFond.chargeListUser(twitupCreateViewUserFil);

        ListUserController listUserController = new ListUserController(createViewUserController);
        TwitupFilUser twitupFilUser = new TwitupFilUser(listUserController);
        listUserController.setVue(twitupFilUser);
        twitupCreateViewUserFil.addTwitupFilUser(twitupFilUser);

        ResearchUserController researchUserController = new ResearchUserController(createViewUserController);
        researchUserController.addObserver(listUserController);
        TwitupResearchUser twitupResearchUser = new TwitupResearchUser(researchUserController);
        researchUserController.setVue(twitupResearchUser);
        twitupCreateViewUserFil.addTwitupResearchUser(twitupResearchUser);
    }

    private void chargeBordereauMenu(FondController fondController, TwitupFond twitupFond){
        BordereauMenuController bordereauMenuController = new BordereauMenuController(fondController);
        TwitupBordereauMenu twitupBordereauMenu = new TwitupBordereauMenu(bordereauMenuController);
        bordereauMenuController.setVue(twitupBordereauMenu);
        twitupFond.chargeTwitupBordereauMenu(twitupBordereauMenu);
    }

    private BordereauController chargeBordereau(FondController fondController, TwitupFond twitupFond){
        BordereauController bordereauController = new BordereauController(fondController);
        TwitupBordereau twitupBordereau = new TwitupBordereau(bordereauController, this.database.getUserConnected());
        bordereauController.setVue(twitupBordereau);
        twitupFond.chargeTwitupBordereau(twitupBordereau);
        return bordereauController;
    }

    private void chargeCreateViewTwit(FondController fondController, TwitupFond twitupFond){
        CreateViewTwitController createViewTwitController = new CreateViewTwitController(fondController, this.database);
        CreateViewTwit createViewTwit = new CreateViewTwit(createViewTwitController);
        createViewTwitController.setVue(createViewTwit);
        twitupFond.chargeTwitupCreateViewTwit(createViewTwit);

        CreateTwitController createTwitController = this.chargeCreateTWit(createViewTwitController, createViewTwit);
        ResearchController  researchController= this.chargeResearch(createViewTwitController, createViewTwit);
        TwitupFilTwitController twitupFilTwitController = this.chargeFilTwit(createViewTwitController, createViewTwit);
        researchController.setObserver(twitupFilTwitController);
        createTwitController.setViewTwit(twitupFilTwitController);

    }

    private ResearchController chargeResearch(CreateViewTwitController createViewTwitController, CreateViewTwit createViewTwit){
        ResearchController researchController = new ResearchController(createViewTwitController);
        ResearchTwit researchTwit = new ResearchTwit(researchController);
        researchController.setVue(researchTwit);
        createViewTwit.addTwitupResearchTwit(researchTwit);
        return researchController;
    }

    private CreateTwitController chargeCreateTWit(CreateViewTwitController createViewTwitController, CreateViewTwit createViewTwit){
        CreateTwitController createTwitController = new CreateTwitController(createViewTwitController);
        CreateTwitForm createTwitForm = new CreateTwitForm(createTwitController);
        createTwitController.setVue(createTwitForm);
        createViewTwit.addTwitupCreateTwit(createTwitForm);
        return createTwitController;
    }

    private TwitupFilTwitController chargeFilTwit(CreateViewTwitController createViewTwitController, CreateViewTwit createViewTwit){
        TwitupFilTwitController twitupFilTwitController = new TwitupFilTwitController(createViewTwitController);
        ListTwit listTwit = new ListTwit(twitupFilTwitController);
        twitupFilTwitController.setVue(listTwit);
        createViewTwit.addTwitupFilTwit(listTwit);
        return twitupFilTwitController;
    }
}
