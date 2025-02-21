/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.persistence;

import com.liferay.contact.management.exception.NoSuchContactException;
import com.liferay.contact.management.model.Contact;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rubens Soares
 * @see ContactUtil
 * @generated
 */
@ProviderType
public interface ContactPersistence extends BasePersistence<Contact> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the contacts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contacts
	 */
	public java.util.List<Contact> findByUuid(String uuid);

	/**
	 * Returns a range of all the contacts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @return the range of matching contacts
	 */
	public java.util.List<Contact> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the contacts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts
	 */
	public java.util.List<Contact> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contacts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contacts
	 */
	public java.util.List<Contact> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact
	 * @throws NoSuchContactException if a matching contact could not be found
	 */
	public Contact findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Contact>
				orderByComparator)
		throws NoSuchContactException;

	/**
	 * Returns the first contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Contact>
			orderByComparator);

	/**
	 * Returns the last contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact
	 * @throws NoSuchContactException if a matching contact could not be found
	 */
	public Contact findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Contact>
				orderByComparator)
		throws NoSuchContactException;

	/**
	 * Returns the last contact in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Contact>
			orderByComparator);

	/**
	 * Returns the contacts before and after the current contact in the ordered set where uuid = &#63;.
	 *
	 * @param contactId the primary key of the current contact
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact
	 * @throws NoSuchContactException if a contact with the primary key could not be found
	 */
	public Contact[] findByUuid_PrevAndNext(
			long contactId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Contact>
				orderByComparator)
		throws NoSuchContactException;

	/**
	 * Removes all the contacts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of contacts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contacts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the contact where name = &#63; or throws a <code>NoSuchContactException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching contact
	 * @throws NoSuchContactException if a matching contact could not be found
	 */
	public Contact findByName(String name) throws NoSuchContactException;

	/**
	 * Returns the contact where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByName(String name);

	/**
	 * Returns the contact where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the contact where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the contact that was removed
	 */
	public Contact removeByName(String name) throws NoSuchContactException;

	/**
	 * Returns the number of contacts where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching contacts
	 */
	public int countByName(String name);

	/**
	 * Returns the contact where email = &#63; or throws a <code>NoSuchContactException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching contact
	 * @throws NoSuchContactException if a matching contact could not be found
	 */
	public Contact findByEmail(String email) throws NoSuchContactException;

	/**
	 * Returns the contact where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByEmail(String email);

	/**
	 * Returns the contact where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByEmail(String email, boolean useFinderCache);

	/**
	 * Removes the contact where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the contact that was removed
	 */
	public Contact removeByEmail(String email) throws NoSuchContactException;

	/**
	 * Returns the number of contacts where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching contacts
	 */
	public int countByEmail(String email);

	/**
	 * Returns the contact where phone = &#63; or throws a <code>NoSuchContactException</code> if it could not be found.
	 *
	 * @param phone the phone
	 * @return the matching contact
	 * @throws NoSuchContactException if a matching contact could not be found
	 */
	public Contact findByPhone(long phone) throws NoSuchContactException;

	/**
	 * Returns the contact where phone = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param phone the phone
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByPhone(long phone);

	/**
	 * Returns the contact where phone = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param phone the phone
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByPhone(long phone, boolean useFinderCache);

	/**
	 * Removes the contact where phone = &#63; from the database.
	 *
	 * @param phone the phone
	 * @return the contact that was removed
	 */
	public Contact removeByPhone(long phone) throws NoSuchContactException;

	/**
	 * Returns the number of contacts where phone = &#63;.
	 *
	 * @param phone the phone
	 * @return the number of matching contacts
	 */
	public int countByPhone(long phone);

	/**
	 * Returns the contact where address = &#63; or throws a <code>NoSuchContactException</code> if it could not be found.
	 *
	 * @param address the address
	 * @return the matching contact
	 * @throws NoSuchContactException if a matching contact could not be found
	 */
	public Contact findByAddress(String address) throws NoSuchContactException;

	/**
	 * Returns the contact where address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param address the address
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByAddress(String address);

	/**
	 * Returns the contact where address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param address the address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 */
	public Contact fetchByAddress(String address, boolean useFinderCache);

	/**
	 * Removes the contact where address = &#63; from the database.
	 *
	 * @param address the address
	 * @return the contact that was removed
	 */
	public Contact removeByAddress(String address)
		throws NoSuchContactException;

	/**
	 * Returns the number of contacts where address = &#63;.
	 *
	 * @param address the address
	 * @return the number of matching contacts
	 */
	public int countByAddress(String address);

	/**
	 * Caches the contact in the entity cache if it is enabled.
	 *
	 * @param contact the contact
	 */
	public void cacheResult(Contact contact);

	/**
	 * Caches the contacts in the entity cache if it is enabled.
	 *
	 * @param contacts the contacts
	 */
	public void cacheResult(java.util.List<Contact> contacts);

	/**
	 * Creates a new contact with the primary key. Does not add the contact to the database.
	 *
	 * @param contactId the primary key for the new contact
	 * @return the new contact
	 */
	public Contact create(long contactId);

	/**
	 * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact
	 * @return the contact that was removed
	 * @throws NoSuchContactException if a contact with the primary key could not be found
	 */
	public Contact remove(long contactId) throws NoSuchContactException;

	public Contact updateImpl(Contact contact);

	/**
	 * Returns the contact with the primary key or throws a <code>NoSuchContactException</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact
	 * @return the contact
	 * @throws NoSuchContactException if a contact with the primary key could not be found
	 */
	public Contact findByPrimaryKey(long contactId)
		throws NoSuchContactException;

	/**
	 * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact
	 * @return the contact, or <code>null</code> if a contact with the primary key could not be found
	 */
	public Contact fetchByPrimaryKey(long contactId);

	/**
	 * Returns all the contacts.
	 *
	 * @return the contacts
	 */
	public java.util.List<Contact> findAll();

	/**
	 * Returns a range of all the contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @return the range of contacts
	 */
	public java.util.List<Contact> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contacts
	 */
	public java.util.List<Contact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact>
			orderByComparator);

	/**
	 * Returns an ordered range of all the contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contacts
	 */
	public java.util.List<Contact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the contacts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of contacts.
	 *
	 * @return the number of contacts
	 */
	public int countAll();

}