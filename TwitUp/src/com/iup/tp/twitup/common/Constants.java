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
    public static String USER_FILE_EXTENSION = "usr";

	public static String MESSAGE_CHOOSE_DIRECTORY = "MESSAGE_CHOOSE_DIRECTORY";

	/**
	 * Extension des fichiers XML des TwitMother
	 */
	public static String TWIT_FILE_EXTENSION = "twt";

	/**
	 * Extension des fichiers XML des DB utilisateur
	 */
	public static String DB_FILE_EXTENSION = "db";

	/**
	 * Répertoire des fichiers temporaires du système.
	 */
	public static String SYSTEM_TMP_DIR = System.getProperty("java.io.tmpdir");

	/**
	 * Séparateur de fichier du système.
	 */
	public static String SYSTEM_FILE_SEPARATOR = System.getProperty("file.separator");

	/**
	 * Caractère pour délimiter les tags référencant des utilisateurs.
	 */
    String USER_TAG_DELIMITER = "@";

	/**
	 * Caractère pour délimiter les tags référencant des mots-clés.
	 */
    String WORD_TAG_DELIMITER = "#";


	/**
	 * Identifiant de l'utilisateur inconnu.
	 */
	public static UUID UNKNONWN_USER_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

	/**
	 * Fichier de configuration de l'application.
	 */
	public static String CONFIGURATION_FILE = "src/resources/configuration.properties";

	/**
	 * Clé de configuration pour la sauvegarde du répertoire d'échange.
	 */
	public static String CONFIGURATION_KEY_EXCHANGE_DIRECTORY = "EXCHANGE_DIRECTORY";

	/**
	 * Clé de configuration pour l'UI
	 */
	public static String CONFIGURATION_KEY_UI_CLASS_NAME = "UI_CLASS_NAME";

	/**
	 * Clé de configuration pour le mode bouchoné
	 */
	public static String CONFIGURATION_KEY_MOCK_ENABLED = "MOCK_ENABLED";
	
	/**
	 * Clé de configuration pour la langue pour le menu du fichier
	 */
	public static String MENU_FICHIER = "fichier";
	
	/**
	 * Clé de configuration pour la langue pour le menu du account
	 */
	public static String MENU_USER_ACCOUNT = "userAccount";
	
	/**
	 * Clé de configuration pour la langue pour l'item ouvrir
	 */
	public static String MENU_OUVRIR = "ouvrir";
	
	/**
	 * Clé de configuration pour la langue pour l'item enregistrer_sous
	 */
	public static String MENU_ENREGISTRER_SOUS = "enregistrer_sous";
	
	/**
	 * Clé de configuration pour la langue pour l'item fermer
	 */
	public static String MENU_FERMER = "fermer";
	
	/**
	 * Clé de configuration pour la langue pour l'item à propos
	 */
	public static String MENU_A_PROPOS = "a_propos";
	
	/**
	 * Clé de configuration pour la langue pour l'item creation
	 */
	public static String VIEW_CREATION_COMPTE = "creation";
	
	/**
	 * Clé de configuration pour la langue pour l'item connexion
	 */
	public static String VIEW_CONNEXION_COMPTE = "connexion";

	/**
	 * Clé de configuration pour la langue pour l'item accueil
	 */
	public static String VIEW_ACCUEIL = "accueil";

	/**
	 * Clé de configuration pour la langue pour l'item monCompte
	 */
	public static String VIEW_MON_COMPTE = "monCompte";


	
	/**
	 * Clé de configuration pour la langue pour le nom
	 */
	public static String VIEW_NOM = "nom";
	
	/**
	 * Clé de configuration pour la langue pour le pseudo
	 */
	public static String VIEW_PSEUDO = "pseudo";
	
    /**
     * Clé de configuration pour la langue pour le mot de passe
     */
	public static String VIEW_MDP = "mdp";
	
	/**
	 * Clé de configuration pour la langue pour la confirmation du mot de passe
	 */
	public static String VIEW_CMDP = "cmdp";
	
	/**
	 * Clé de configuration pour la langue pour l'erreur de connexion
	 */
	public static String VIEW_ERREUR_CONNEXION = "erreurconnexion";
	
	/**
	 * Clé de configuration pour le fichier de configuration
	 */
	public static String MENU = "menu";
	
	/**
	 * Clé de configuration pour la langue pour la déconnexion
	 */
	public static String DECONNEXION = "deconnexion";
	
	/**
	 * Clé de configuration pour le lien images
	 */
	public static String CLE_IMAGES = "/images/";
	
	/**
	 * Clé de configuration pour la sélection du fichier d'échange
	 */
	public static String CLE_DOSSIER_ECHANGE = "dossierechange";
	
	/**
	 * Clé de configuration pour l'erreur lors de la sélection du fichier d'échange
	 */
	public static String CLE_ERREUR_DOSSIER_ECHANGE = "erreurdossierechange";
	
	/**
	 * Clé pour la pop up
	 */
	public static String UBO_MESSAGE = "UBO M2TIIL \\n Département Informatique";
	
	/**
	 * Clé pour créer un twit
	 */
	public static String CREATION_TWIT = "createtwit";
	
	/**
	 * Clé pour le bouton de recherche des twits
	 */
	public static String RESEARCH_TWIT_JBUTTON_TITLE = "research";

	/**
	 * Clé pour le label pour le chemin de l'avatar
	 */
	public static String VIEW_AVATAR = "avatar";
	
	/**
	 * Clé pour le label de changement de mot de passe
	 */
	public static String VIEW_CHANGE_PWD = "changepwd";
	
	/**
	 * Clé pour le label du bouton de déconnexion d'un utilisateur
	 */
	public static String DECONNECTION_TO_ACCOUNT = "deconnexionUserTag";
	
	/**
	 * Clé pour le label du bouton de connexion d'un utilisateur
	 */
	public static String CONNECTION_TO_ACCOUNT = "connexionUserTag";

	
	/**
	 * Clé pour le bouton Accueil
	 */
	public static String USER_HOME = "home";
	
	/**
	 * Clé pour le bouton mon account
	 */
	public static String USER_ACCOUNT = "moncompte";
	
	/**
	 * Clé pour la modification du account
	 */
	public static String USER_MODIFICATION = "modification";

	/**
	 * Clé pour la liste des users
	 */
	public static String USER_LIST_USERS = "listeuser";
	
	/**
	 * Clé pour voir le profil des utilisateurs
	 */
	public static String USER_SEE_OTHER_USER = "seeuser";

    /**
     * Clé pour changer le chemin de son avatar
     */
	public static String CHANGE_PATH_AVATAR = "changepathavataruser";
	
	/**
	 * Valeur par défaut pour les images
	 */
	public static String AVATARDEFAULT = "/resources/images/logoIUP_50.jpg";
}
