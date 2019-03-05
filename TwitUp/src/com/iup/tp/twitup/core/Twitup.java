package com.iup.tp.twitup.core;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import com.iup.tp.twitup.PropertyLoader;
import com.iup.tp.twitup.common.PropertiesManager;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.events.file.IWatchableDirectory;
import com.iup.tp.twitup.events.file.WatchableDirectory;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.TwitupMock;

import javax.annotation.Resource;
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
		this.mProperties = PropertiesManager.loadProperties(getClass().getResource("/resources/conf/configuration.properties").getPath());

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
		System.out.println("-- Initialisation des styles de l'application");
		try{
			UIManager.setLookAndFeel(this.mProperties.getProperty("LOOK_AND_FEEL"));
			System.out.println("✔ Succès");
		} catch (Exception e){
			System.err.println("Erreur à l'application du thème");
		}
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		System.out.println("-- Initialisation de l'interface graphique");
		this.mMainView = new TwitupMainView(mDatabase,mEntityManager);
		System.out.println("✔ Succès");
	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		System.out.println("-- Initialisation du répertoire d'échange depuis le fichier de conf");
		System.out.println("✔ Succès");
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
		System.out.println("-- Initialisation du mock");
		TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
		System.out.println("✔ Succès");
	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		System.out.println("-- Initialisation de la base de données");
		mDatabase = new Database();
		mEntityManager = new EntityManager(mDatabase);
		System.out.println("✔ Succès");
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
