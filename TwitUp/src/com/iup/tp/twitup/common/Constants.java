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
    String USER_FILE_EXTENSION = "usr";

	/**
	 * Extension des fichiers XML des TwitMother
	 */
    String TWIT_FILE_EXTENSION = "twt";

	/**
	 * Extension des fichiers XML des DB utilisateur
	 */
    String DB_FILE_EXTENSION = "db";

	/**
	 * Répertoire des fichiers temporaires du système.
	 */
    String SYSTEM_TMP_DIR = System.getProperty("java.io.tmpdir");

	/**
	 * Séparateur de fichier du système.
	 */
    String SYSTEM_FILE_SEPARATOR = System.getProperty("file.separator");

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
    UUID UNKNONWN_USER_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

	/**
	 * Fichier de configuration de l'application.
	 */
    String CONFIGURATION_FILE = "src/resources/configuration.properties";

	/**
	 * Clé de configuration pour la sauvegarde du répertoire d'échange.
	 */
    String CONFIGURATION_KEY_EXCHANGE_DIRECTORY = "EXCHANGE_DIRECTORY";

	/**
	 * Clé de configuration pour l'UI
	 */
    String CONFIGURATION_KEY_UI_CLASS_NAME = "UI_CLASS_NAME";

	/**
	 * Clé de configuration pour le mode bouchoné
	 */
    String CONFIGURATION_KEY_MOCK_ENABLED = "MOCK_ENABLED";
	
	/**
	 * Clé de configuration pour la langue pour le menu du fichier
	 */
    String MENU_FICHIER = "fichier";
	
	/**
	 * Clé de configuration pour la langue pour le menu du account
	 */
    String MENU_USER_ACCOUNT = "userAccount";
	
	/**
	 * Clé de configuration pour la langue pour l'item ouvrir
	 */
    String MENU_OUVRIR = "ouvrir";
	
	/**
	 * Clé de configuration pour la langue pour l'item enregistrer_sous
	 */
    String MENU_ENREGISTRER_SOUS = "enregistrer_sous";
	
	/**
	 * Clé de configuration pour la langue pour l'item fermer
	 */
    String MENU_FERMER = "fermer";
	
	/**
	 * Clé de configuration pour la langue pour l'item à propos
	 */
    String MENU_A_PROPOS = "a_propos";
	
	/**
	 * Clé de configuration pour la langue pour l'item creation
	 */
    String VIEW_CREATION_COMPTE = "creation";
	
	/**
	 * Clé de configuration pour la langue pour l'item connexion
	 */
    String VIEW_CONNEXION_COMPTE = "connexion";

	/**
	 * Clé de configuration pour la langue pour l'item accueil
	 */
    String VIEW_ACCUEIL = "accueil";

	/**
	 * Clé de configuration pour la langue pour l'item monCompte
	 */
    String VIEW_MON_COMPTE = "monCompte";


	
	/**
	 * Clé de configuration pour la langue pour le nom
	 */
    String VIEW_NOM = "nom";
	
	/**
	 * Clé de configuration pour la langue pour le pseudo
	 */
    String VIEW_PSEUDO = "pseudo";
	
    /**
     * Clé de configuration pour la langue pour le mot de passe
     */
    String VIEW_MDP = "mdp";
	
	/**
	 * Clé de configuration pour la langue pour la confirmation du mot de passe
	 */
    String VIEW_CMDP = "cmdp";
	
	/**
	 * Clé de configuration pour la langue pour l'erreur de connexion
	 */
    String VIEW_ERREUR_CONNEXION = "erreurconnexion";
	
	/**
	 * Clé de configuration pour le fichier de configuration
	 */
    String MENU = "menu";
	
	/**
	 * Clé de configuration pour la langue pour la déconnexion
	 */
    String DECONNEXION = "deconnexion";
	
	/**
	 * Clé de configuration pour le lien images
	 */
    String CLE_IMAGES = "/images/";
	
	/**
	 * Clé de configuration pour la sélection du fichier d'échange
	 */
    String CLE_DOSSIER_ECHANGE = "dossierechange";
	
	/**
	 * Clé de configuration pour l'erreur lors de la sélection du fichier d'échange
	 */
    String CLE_ERREUR_DOSSIER_ECHANGE = "erreurdossierechange";
	
	/**
	 * Clé pour la pop up
	 */
    String UBO_MESSAGE = "UBO M2TIIL \\n Département Informatique";
	
	/**
	 * Clé pour créer un twit
	 */
    String CREATION_TWIT = "createtwit";
	
	/**
	 * Clé pour le bouton de recherche des twits
	 */
    String RESEARCH_TWIT_JBUTTON_TITLE = "research";

	/**
	 * Clé pour le label pour le chemin de l'avatar
	 */
    String VIEW_AVATAR = "avatar";
	
	/**
	 * Clé pour le label de changement de mot de passe
	 */
    String VIEW_CHANGE_PWD = "changepwd";
	
	/**
	 * Clé pour le label du bouton de déconnexion d'un utilisateur
	 */
    String DECONNECTION_TO_ACCOUNT = "deconnexionUserTag";
	
	/**
	 * Clé pour le label du bouton de connexion d'un utilisateur
	 */
    String CONNECTION_TO_ACCOUNT = "connexionUserTag";

	/**
	 * Clé pour le user tag
	 */
    String USER_TAG_FIL = "UserTag : ";
	
	/**
	 * Clé pour le bouton Accueil
	 */
    String USER_HOME = "home";
	
	/**
	 * Clé pour le bouton mon account
	 */
    String USER_ACCOUNT = "moncompte";
	
	/**
	 * Clé pour la modification du account
	 */
    String USER_MODIFICATION = "modification";

	/**
	 * Clé pour la liste des users
	 */
    String USER_LIST_USERS = "listeuser";
	
	/**
	 * Clé pour voir le profil des utilisateurs
	 */
    String USER_SEE_OTHER_USER = "seeuser";

    /**
     * Clé pour changer le chemin de son avatar
     */
	String CHANGE_PATH_AVATAR = "changepathavataruser";
	
	/**
	 * Valeur par défaut pour les images
	 */
	String AVATARDEFAULT = "/resources/images/logoIUP_50.jpg";
}
