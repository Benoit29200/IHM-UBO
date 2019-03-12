package com.iup.tp.twitup.datamodel.database;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

/**
 * Interface des observateurs des modifications de la base de données.
 * 
 * @author S.Lucas
 */
public interface IDatabaseObserver {
	/**
	 * Notification lorsqu'un TwitMother est ajouté en base de données.
	 * 
	 * @param addedTwit
	 */
	void notifyTwitAdded(Twit addedTwit);

	/**
	 * Notification lorsqu'un TwitMother est supprimé de la base de données.
	 * 
	 * @param deletedTwit
	 */
	void notifyTwitDeleted(Twit deletedTwit);

	/**
	 * Notification lorsqu'un TwitMother est modifié en base de données.
	 * 
	 * @param modifiedTwit
	 */
	void notifyTwitModified(Twit modifiedTwit);

	/**
	 * Notification lorsqu'un utilisateur est ajouté en base de données.
	 * 
	 * @param addedUser
	 */
	void notifyUserAdded(User addedUser);

	/**
	 * Notification lorsqu'un utilisateur est supprimé de la base de données.
	 * 
	 * @param deletedUser
	 */
	void notifyUserDeleted(User deletedUser);

	/**
	 * Notification lorsqu'un utilisateur est modifié en base de données.
	 *
	 * @param modifiedUser
	 */
	void notifyUserModified(User modifiedUser);


}
