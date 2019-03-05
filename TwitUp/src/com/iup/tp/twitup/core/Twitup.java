package com.iup.tp.twitup.core;

import java.io.File;
import java.util.Properties;

import com.iup.tp.twitup.common.LOGER;
import com.iup.tp.twitup.common.PropertiesManager;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.events.file.IWatchableDirectory;
import com.iup.tp.twitup.events.file.WatchableDirectory;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.TwitupMock;

import javax.swing.*;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitup {
	/**
	 * Base de données.
	 */
	protected IDatabase mDatabase;

	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitupMainView mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

    /**
     * Properties loader.
     */
    protected Properties mProperties;

	/**
	 * Nom du look and feel à appliquer.
	 */
	protected String mLookAndFeel;

	/**
	 * Indique si le mode bouchoné est activé.
	 */
	protected boolean mIsMockEnabled = false;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;

	/**
	 * Constructeur.
	 */
	public Twitup() {

		// Initialisation des properties
        this.initProperties();

		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		// Initialisation de l'IHM
		this.initGui();
		// Initialisation du répertoire d'échange
		this.initDirectory();
	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
		LOGER.warn("-- Initialisation des styles de l'application");
		try{
			UIManager.setLookAndFeel(this.mLookAndFeel);
			LOGER.warn("✅ Succès");
		} catch (Exception e){
			LOGER.err("❌ Erreur à l'application du thème");
		}
	}

    /**
     * Initialisation du fichier de properties
     */
	protected void initProperties(){
        this.mProperties = PropertiesManager.loadProperties(getClass().getResource("/conf/configuration.properties").getPath());
        this.mExchangeDirectoryPath = this.mProperties.get("EXCHANGE_DIRECTORY").toString();
        this.mLookAndFeel = this.mProperties.get("LOOK_AND_FEEL").toString();
    }

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		LOGER.warn("-- Initialisation de l'interface graphique");
		try{
			this.mMainView = new TwitupMainView(mDatabase,mEntityManager);
			LOGER.warn("✅ Succès");
		} catch (Exception e){
			LOGER.err("❌ Erreur à l'initialisation de la vue");
		}

	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		LOGER.warn("-- Initialisation du répertoire d'échange depuis le fichier de conf");
		if(!this.isValideExchangeDirectory(new File(this.mExchangeDirectoryPath))){
		    System.exit(0);
        }
		try {
			this.initDirectory(this.mExchangeDirectoryPath);
			LOGER.warn("✅ Succès");
		} catch (Exception e){
			LOGER.err("❌ Erreur à l'initialisation du répertoire d'échange");
		}
	}

	/**
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		LOGER.warn("-- Initialisation du mock");
		try{
			TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
			mock.showGUI();
			LOGER.warn("✅ Succès");
		} catch (Exception e){
			LOGER.err("❌ Erreur à l'initialisation du mock");
		}

	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		LOGER.warn("-- Initialisation de la base de données");
		try{
			mDatabase = new Database();
			mEntityManager = new EntityManager(mDatabase);
			LOGER.warn("✅ Succès");
		} catch (Exception e){
			LOGER.err("❌ Erreur à l'initialisation de la base de données");
		}

	}

	/**
	 * Initialisation du répertoire d'échange.
	 * 
	 * @param directoryPath
	 */
	public void initDirectory(String directoryPath) {
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
	}

	public void show() {
		this.mMainView.showGUI();
	}
}
