/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.persistence;

import com.liferay.contact.management.model.ContactEntry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the contact entry service. This utility wraps <code>com.liferay.contact.management.service.persistence.impl.ContactEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rubens Soares
 * @see ContactEntryPersistence
 * @generated
 */
public class ContactEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ContactEntry contactEntry) {
		getPersistence().clearCache(contactEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ContactEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ContactEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ContactEntry update(ContactEntry contactEntry) {
		return getPersistence().update(contactEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ContactEntry update(
		ContactEntry contactEntry, ServiceContext serviceContext) {

		return getPersistence().update(contactEntry, serviceContext);
	}

	/**
	 * Returns all the contact entries where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact entries
	 */
	public static List<ContactEntry> findByContactId(long contactId) {
		return getPersistence().findByContactId(contactId);
	}

	/**
	 * Returns a range of all the contact entries where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of matching contact entries
	 */
	public static List<ContactEntry> findByContactId(
		long contactId, int start, int end) {

		return getPersistence().findByContactId(contactId, start, end);
	}

	/**
	 * Returns an ordered range of all the contact entries where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact entries
	 */
	public static List<ContactEntry> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactEntry> orderByComparator) {

		return getPersistence().findByContactId(
			contactId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact entries where contactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact entries
	 */
	public static List<ContactEntry> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByContactId(
			contactId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public static ContactEntry findByContactId_First(
			long contactId, OrderByComparator<ContactEntry> orderByComparator)
		throws com.liferay.contact.management.exception.
			NoSuchContactEntryException {

		return getPersistence().findByContactId_First(
			contactId, orderByComparator);
	}

	/**
	 * Returns the first contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public static ContactEntry fetchByContactId_First(
		long contactId, OrderByComparator<ContactEntry> orderByComparator) {

		return getPersistence().fetchByContactId_First(
			contactId, orderByComparator);
	}

	/**
	 * Returns the last contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public static ContactEntry findByContactId_Last(
			long contactId, OrderByComparator<ContactEntry> orderByComparator)
		throws com.liferay.contact.management.exception.
			NoSuchContactEntryException {

		return getPersistence().findByContactId_Last(
			contactId, orderByComparator);
	}

	/**
	 * Returns the last contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public static ContactEntry fetchByContactId_Last(
		long contactId, OrderByComparator<ContactEntry> orderByComparator) {

		return getPersistence().fetchByContactId_Last(
			contactId, orderByComparator);
	}

	/**
	 * Returns the contact entries before and after the current contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param entryId the primary key of the current contact entry
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public static ContactEntry[] findByContactId_PrevAndNext(
			long entryId, long contactId,
			OrderByComparator<ContactEntry> orderByComparator)
		throws com.liferay.contact.management.exception.
			NoSuchContactEntryException {

		return getPersistence().findByContactId_PrevAndNext(
			entryId, contactId, orderByComparator);
	}

	/**
	 * Removes all the contact entries where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 */
	public static void removeByContactId(long contactId) {
		getPersistence().removeByContactId(contactId);
	}

	/**
	 * Returns the number of contact entries where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact entries
	 */
	public static int countByContactId(long contactId) {
		return getPersistence().countByContactId(contactId);
	}

	/**
	 * Caches the contact entry in the entity cache if it is enabled.
	 *
	 * @param contactEntry the contact entry
	 */
	public static void cacheResult(ContactEntry contactEntry) {
		getPersistence().cacheResult(contactEntry);
	}

	/**
	 * Caches the contact entries in the entity cache if it is enabled.
	 *
	 * @param contactEntries the contact entries
	 */
	public static void cacheResult(List<ContactEntry> contactEntries) {
		getPersistence().cacheResult(contactEntries);
	}

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param entryId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	public static ContactEntry create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	 * Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public static ContactEntry remove(long entryId)
		throws com.liferay.contact.management.exception.
			NoSuchContactEntryException {

		return getPersistence().remove(entryId);
	}

	public static ContactEntry updateImpl(ContactEntry contactEntry) {
		return getPersistence().updateImpl(contactEntry);
	}

	/**
	 * Returns the contact entry with the primary key or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public static ContactEntry findByPrimaryKey(long entryId)
		throws com.liferay.contact.management.exception.
			NoSuchContactEntryException {

		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	 * Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	 */
	public static ContactEntry fetchByPrimaryKey(long entryId) {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	 * Returns all the contact entries.
	 *
	 * @return the contact entries
	 */
	public static List<ContactEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of contact entries
	 */
	public static List<ContactEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact entries
	 */
	public static List<ContactEntry> findAll(
		int start, int end, OrderByComparator<ContactEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contact entries
	 */
	public static List<ContactEntry> findAll(
		int start, int end, OrderByComparator<ContactEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the contact entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ContactEntryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ContactEntryPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ContactEntryPersistence _persistence;

}