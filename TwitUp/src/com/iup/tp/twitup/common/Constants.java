package com.iup.tp.twitup.common;

import java.util.UUID;

/**
 * Classe de contantes de l'appli.
 * 
 * @author S.Lucas
 */
public interface Constants {
	/**
	 * Extension des fichiers XML des User
	 */
	public static final String USER_FILE_EXTENSION = "usr";

	/**
	 * Extension des fichiers XML des Twit
	 */
	public static final String TWIT_FILE_EXTENSION = "twt";

	/**
	 * Extension des fichiers XML des DB utilisateur
	 */
	public static final String DB_FILE_EXTENSION = "db";

	/**
	 * Répertoire des fichiers temporaires du système.
	 */
	public static final String SYSTEM_TMP_DIR = System.getProperty("java.io.tmpdir");

	/**
	 * Séparateur de fichier du système.
	 */
	public static final String SYSTEM_FILE_SEPARATOR = System.getProperty("file.separator");

	/**
	 * Caractère pour délimiter les tags référencant des utilisateurs.
	 */
	public static final String USER_TAG_DELIMITER = "@";

	/**
	 * Caractère pour délimiter les tags référencant des mots-clés.
	 */
	public static final String WORD_TAG_DELIMITER = "#";

	/**
	 * Identifiant de l'utilisateur inconnu.
	 */
	public static final UUID UNKNONWN_USER_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

	/**
	 * Fichier de configuration de l'application.
	 */
	public static final String CONFIGURATION_FILE = "src/resources/configuration.properties";

	/**
	 * Clé de configuration pour la sauvegarde du répertoire d'échange.
	 */
	public static final String CONFIGURATION_KEY_EXCHANGE_DIRECTORY = "EXCHANGE_DIRECTORY";

	/**
	 * Clé de configuration pour l'UI
	 */
	public static final String CONFIGURATION_KEY_UI_CLASS_NAME = "UI_CLASS_NAME";

	/**
	 * Clé de configuration pour le mode bouchoné
	 */
	public static final String CONFIGURATION_KEY_MOCK_ENABLED = "MOCK_ENABLED";
	
	/**
	 * Clé de configuration pour la langue pour le menu du fichier
	 */
	public static final String MENU_FICHIER = "fichier";
	
	/**
	 * Clé de configuration pour la langue pour le menu du compte
	 */
	public static final String MENU_USER_ACCOUNT = "userAccount";
	
	/**
	 * Clé de configuration pour la langue pour l'item ouvrir
	 */
	public static final String MENU_OUVRIR = "ouvrir";
	
	/**
	 * Clé de configuration pour la langue pour l'item enregistrer_sous
	 */
	public static final String MENU_ENREGISTRER_SOUS = "enregistrer_sous";
	
	/**
	 * Clé de configuration pour la langue pour l'item fermer
	 */
	public static final String MENU_FERMER = "fermer";
	
	/**
	 * Clé de configuration pour la langue pour l'item à propos
	 */
	public static final String MENU_A_PROPOS = "a_propos";
	
	/**
	 * Clé de configuration pour la langue pour l'item creation
	 */
	public static final String VIEW_CREATION_COMPTE = "creation";
	
	/**
	 * Clé de configuration pour la langue pour l'item connexion
	 */
	public static final String VIEW_CONNEXION_COMPTE = "connexion";
	
	/**
	 * Clé de configuration pour la langue pour le nom
	 */
	public static final String VIEW_NOM = "nom";
	
	/**
	 * Clé de configuration pour la langue pour le pseudo
	 */
	public static final String VIEW_PSEUDO = "pseudo";
	
    /**
     * Clé de configuration pour la langue pour le mot de passe
     */
	public static final String VIEW_MDP = "mdp";
	
	/**
	 * Clé de configuration pour la langue pour la confirmation du mot de passe
	 */
	public static final String VIEW_CMDP = "cmdp";
	
	/**
	 * Clé de configuration pour la langue pour l'erreur de connexion
	 */
	public static final String VIEW_ERREUR_CONNEXION = "erreurconnexion";
	
	/**
	 * Clé de configuration pour le fichier de configuration
	 */
	public static final String MENU = "menu";
	
	/**
	 * Clé de configuration pour la langue pour la déconnexion
	 */
	public static final String DECONNEXION = "deconnexion";
	
	/**
	 * Clé de configuration pour le lien images
	 */
	public static final String CLE_IMAGES = "/images/";
	
	/**
	 * Clé de configuration pour la sélection du fichier d'échange
	 */
	public static final String CLE_DOSSIER_ECHANGE = "dossierechange";
	
	/**
	 * Clé de configuration pour l'erreur lors de la sélection du fichier d'échange
	 */
	public static final String CLE_ERREUR_DOSSIER_ECHANGE = "erreurdossierechange";
	
	/**
	 * Clé pour la pop up
	 */
	public static final String UBO_MESSAGE = "UBO M2TIIL \\n Département Informatique";
	
	/**
	 * Clé pour créer un twit
	 */
	public static final String CREATION_TWIT = "createtwit";
	
	/**
	 * Clé pour le bouton de recherche des twits
	 */
	public static final String RESEARCH_TWIT_JBUTTON_TITLE = "research";
}
