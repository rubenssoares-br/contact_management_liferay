/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.persistence;

import com.liferay.contact.management.exception.NoSuchContactEntryException;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rubens Soares
 * @see ContactEntryUtil
 * @generated
 */
@ProviderType
public interface ContactEntryPersistence extends BasePersistence<ContactEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactEntryUtil} to access the contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the contact entry where familyRelationship = &#63; or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param familyRelationship the family relationship
	 * @return the matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByFamilyRelationship(String familyRelationship)
		throws NoSuchContactEntryException;

	/**
	 * Returns the contact entry where familyRelationship = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param familyRelationship the family relationship
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByFamilyRelationship(String familyRelationship);

	/**
	 * Returns the contact entry where familyRelationship = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param familyRelationship the family relationship
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByFamilyRelationship(
		String familyRelationship, boolean useFinderCache);

	/**
	 * Removes the contact entry where familyRelationship = &#63; from the database.
	 *
	 * @param familyRelationship the family relationship
	 * @return the contact entry that was removed
	 */
	public ContactEntry removeByFamilyRelationship(String familyRelationship)
		throws NoSuchContactEntryException;

	/**
	 * Returns the number of contact entries where familyRelationship = &#63;.
	 *
	 * @param familyRelationship the family relationship
	 * @return the number of matching contact entries
	 */
	public int countByFamilyRelationship(String familyRelationship);

	/**
	 * Returns the contact entry where contactId = &#63; or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByContactId(long contactId)
		throws NoSuchContactEntryException;

	/**
	 * Returns the contact entry where contactId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByContactId(long contactId);

	/**
	 * Returns the contact entry where contactId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactId the contact ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByContactId(
		long contactId, boolean useFinderCache);

	/**
	 * Removes the contact entry where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @return the contact entry that was removed
	 */
	public ContactEntry removeByContactId(long contactId)
		throws NoSuchContactEntryException;

	/**
	 * Returns the number of contact entries where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact entries
	 */
	public int countByContactId(long contactId);

	/**
	 * Returns all the contact entries where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact entries
	 */
	public java.util.List<ContactEntry> findByAllContactIds(long contactId);

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
	public java.util.List<ContactEntry> findByAllContactIds(
		long contactId, int start, int end);

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
	public java.util.List<ContactEntry> findByAllContactIds(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

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
	public java.util.List<ContactEntry> findByAllContactIds(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByAllContactIds_First(
			long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Returns the first contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByAllContactIds_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns the last contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	public ContactEntry findByAllContactIds_Last(
			long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Returns the last contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	public ContactEntry fetchByAllContactIds_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

	/**
	 * Returns the contact entries before and after the current contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param entryId the primary key of the current contact entry
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public ContactEntry[] findByAllContactIds_PrevAndNext(
			long entryId, long contactId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
				orderByComparator)
		throws NoSuchContactEntryException;

	/**
	 * Removes all the contact entries where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 */
	public void removeByAllContactIds(long contactId);

	/**
	 * Returns the number of contact entries where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact entries
	 */
	public int countByAllContactIds(long contactId);

	/**
	 * Caches the contact entry in the entity cache if it is enabled.
	 *
	 * @param contactEntry the contact entry
	 */
	public void cacheResult(ContactEntry contactEntry);

	/**
	 * Caches the contact entries in the entity cache if it is enabled.
	 *
	 * @param contactEntries the contact entries
	 */
	public void cacheResult(java.util.List<ContactEntry> contactEntries);

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param entryId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	public ContactEntry create(long entryId);

	/**
	 * Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public ContactEntry remove(long entryId) throws NoSuchContactEntryException;

	public ContactEntry updateImpl(ContactEntry contactEntry);

	/**
	 * Returns the contact entry with the primary key or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	public ContactEntry findByPrimaryKey(long entryId)
		throws NoSuchContactEntryException;

	/**
	 * Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	 */
	public ContactEntry fetchByPrimaryKey(long entryId);

	/**
	 * Returns all the contact entries.
	 *
	 * @return the contact entries
	 */
	public java.util.List<ContactEntry> findAll();

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
	public java.util.List<ContactEntry> findAll(int start, int end);

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
	public java.util.List<ContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator);

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
	public java.util.List<ContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the contact entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 */
	public int countAll();

}