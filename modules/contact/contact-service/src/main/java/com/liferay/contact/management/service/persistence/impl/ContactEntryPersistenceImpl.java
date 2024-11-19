/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.persistence.impl;

import com.liferay.contact.management.exception.NoSuchContactEntryException;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.contact.management.model.ContactEntryTable;
import com.liferay.contact.management.model.impl.ContactEntryImpl;
import com.liferay.contact.management.model.impl.ContactEntryModelImpl;
import com.liferay.contact.management.service.persistence.ContactEntryPersistence;
import com.liferay.contact.management.service.persistence.ContactEntryUtil;
import com.liferay.contact.management.service.persistence.impl.constants.CTMGPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rubens Soares
 * @generated
 */
@Component(service = ContactEntryPersistence.class)
public class ContactEntryPersistenceImpl
	extends BasePersistenceImpl<ContactEntry>
	implements ContactEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ContactEntryUtil</code> to access the contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ContactEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByContactId;
	private FinderPath _finderPathWithoutPaginationFindByContactId;
	private FinderPath _finderPathCountByContactId;

	/**
	 * Returns all the contact entries where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the matching contact entries
	 */
	@Override
	public List<ContactEntry> findByContactId(long contactId) {
		return findByContactId(
			contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ContactEntry> findByContactId(
		long contactId, int start, int end) {

		return findByContactId(contactId, start, end, null);
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
	@Override
	public List<ContactEntry> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactEntry> orderByComparator) {

		return findByContactId(contactId, start, end, orderByComparator, true);
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
	@Override
	public List<ContactEntry> findByContactId(
		long contactId, int start, int end,
		OrderByComparator<ContactEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContactId;
				finderArgs = new Object[] {contactId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContactId;
			finderArgs = new Object[] {
				contactId, start, end, orderByComparator
			};
		}

		List<ContactEntry> list = null;

		if (useFinderCache) {
			list = (List<ContactEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ContactEntry contactEntry : list) {
					if (contactId != contactEntry.getContactId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CONTACTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ContactEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contactId);

				list = (List<ContactEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	@Override
	public ContactEntry findByContactId_First(
			long contactId, OrderByComparator<ContactEntry> orderByComparator)
		throws NoSuchContactEntryException {

		ContactEntry contactEntry = fetchByContactId_First(
			contactId, orderByComparator);

		if (contactEntry != null) {
			return contactEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contactId=");
		sb.append(contactId);

		sb.append("}");

		throw new NoSuchContactEntryException(sb.toString());
	}

	/**
	 * Returns the first contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	@Override
	public ContactEntry fetchByContactId_First(
		long contactId, OrderByComparator<ContactEntry> orderByComparator) {

		List<ContactEntry> list = findByContactId(
			contactId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry
	 * @throws NoSuchContactEntryException if a matching contact entry could not be found
	 */
	@Override
	public ContactEntry findByContactId_Last(
			long contactId, OrderByComparator<ContactEntry> orderByComparator)
		throws NoSuchContactEntryException {

		ContactEntry contactEntry = fetchByContactId_Last(
			contactId, orderByComparator);

		if (contactEntry != null) {
			return contactEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contactId=");
		sb.append(contactId);

		sb.append("}");

		throw new NoSuchContactEntryException(sb.toString());
	}

	/**
	 * Returns the last contact entry in the ordered set where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 */
	@Override
	public ContactEntry fetchByContactId_Last(
		long contactId, OrderByComparator<ContactEntry> orderByComparator) {

		int count = countByContactId(contactId);

		if (count == 0) {
			return null;
		}

		List<ContactEntry> list = findByContactId(
			contactId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ContactEntry[] findByContactId_PrevAndNext(
			long entryId, long contactId,
			OrderByComparator<ContactEntry> orderByComparator)
		throws NoSuchContactEntryException {

		ContactEntry contactEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			ContactEntry[] array = new ContactEntryImpl[3];

			array[0] = getByContactId_PrevAndNext(
				session, contactEntry, contactId, orderByComparator, true);

			array[1] = contactEntry;

			array[2] = getByContactId_PrevAndNext(
				session, contactEntry, contactId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactEntry getByContactId_PrevAndNext(
		Session session, ContactEntry contactEntry, long contactId,
		OrderByComparator<ContactEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONTACTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ContactEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(contactId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(contactEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ContactEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact entries where contactId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 */
	@Override
	public void removeByContactId(long contactId) {
		for (ContactEntry contactEntry :
				findByContactId(
					contactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(contactEntry);
		}
	}

	/**
	 * Returns the number of contact entries where contactId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @return the number of matching contact entries
	 */
	@Override
	public int countByContactId(long contactId) {
		FinderPath finderPath = _finderPathCountByContactId;

		Object[] finderArgs = new Object[] {contactId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONTACTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CONTACTID_CONTACTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(contactId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTACTID_CONTACTID_2 =
		"contactEntry.contactId = ?";

	public ContactEntryPersistenceImpl() {
		setModelClass(ContactEntry.class);

		setModelImplClass(ContactEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ContactEntryTable.INSTANCE);
	}

	/**
	 * Caches the contact entry in the entity cache if it is enabled.
	 *
	 * @param contactEntry the contact entry
	 */
	@Override
	public void cacheResult(ContactEntry contactEntry) {
		entityCache.putResult(
			ContactEntryImpl.class, contactEntry.getPrimaryKey(), contactEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the contact entries in the entity cache if it is enabled.
	 *
	 * @param contactEntries the contact entries
	 */
	@Override
	public void cacheResult(List<ContactEntry> contactEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (contactEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ContactEntry contactEntry : contactEntries) {
			if (entityCache.getResult(
					ContactEntryImpl.class, contactEntry.getPrimaryKey()) ==
						null) {

				cacheResult(contactEntry);
			}
		}
	}

	/**
	 * Clears the cache for all contact entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ContactEntryImpl.class);

		finderCache.clearCache(ContactEntryImpl.class);
	}

	/**
	 * Clears the cache for the contact entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactEntry contactEntry) {
		entityCache.removeResult(ContactEntryImpl.class, contactEntry);
	}

	@Override
	public void clearCache(List<ContactEntry> contactEntries) {
		for (ContactEntry contactEntry : contactEntries) {
			entityCache.removeResult(ContactEntryImpl.class, contactEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ContactEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ContactEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param entryId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	@Override
	public ContactEntry create(long entryId) {
		ContactEntry contactEntry = new ContactEntryImpl();

		contactEntry.setNew(true);
		contactEntry.setPrimaryKey(entryId);

		return contactEntry;
	}

	/**
	 * Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	@Override
	public ContactEntry remove(long entryId)
		throws NoSuchContactEntryException {

		return remove((Serializable)entryId);
	}

	/**
	 * Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	@Override
	public ContactEntry remove(Serializable primaryKey)
		throws NoSuchContactEntryException {

		Session session = null;

		try {
			session = openSession();

			ContactEntry contactEntry = (ContactEntry)session.get(
				ContactEntryImpl.class, primaryKey);

			if (contactEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(contactEntry);
		}
		catch (NoSuchContactEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ContactEntry removeImpl(ContactEntry contactEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactEntry)) {
				contactEntry = (ContactEntry)session.get(
					ContactEntryImpl.class, contactEntry.getPrimaryKeyObj());
			}

			if (contactEntry != null) {
				session.delete(contactEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (contactEntry != null) {
			clearCache(contactEntry);
		}

		return contactEntry;
	}

	@Override
	public ContactEntry updateImpl(ContactEntry contactEntry) {
		boolean isNew = contactEntry.isNew();

		if (!(contactEntry instanceof ContactEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(contactEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					contactEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in contactEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ContactEntry implementation " +
					contactEntry.getClass());
		}

		ContactEntryModelImpl contactEntryModelImpl =
			(ContactEntryModelImpl)contactEntry;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(contactEntry);
			}
			else {
				contactEntry = (ContactEntry)session.merge(contactEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ContactEntryImpl.class, contactEntryModelImpl, false, true);

		if (isNew) {
			contactEntry.setNew(false);
		}

		contactEntry.resetOriginalValues();

		return contactEntry;
	}

	/**
	 * Returns the contact entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact entry
	 * @return the contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	@Override
	public ContactEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactEntryException {

		ContactEntry contactEntry = fetchByPrimaryKey(primaryKey);

		if (contactEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return contactEntry;
	}

	/**
	 * Returns the contact entry with the primary key or throws a <code>NoSuchContactEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry
	 * @throws NoSuchContactEntryException if a contact entry with the primary key could not be found
	 */
	@Override
	public ContactEntry findByPrimaryKey(long entryId)
		throws NoSuchContactEntryException {

		return findByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	 */
	@Override
	public ContactEntry fetchByPrimaryKey(long entryId) {
		return fetchByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns all the contact entries.
	 *
	 * @return the contact entries
	 */
	@Override
	public List<ContactEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ContactEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ContactEntry> findAll(
		int start, int end, OrderByComparator<ContactEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ContactEntry> findAll(
		int start, int end, OrderByComparator<ContactEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ContactEntry> list = null;

		if (useFinderCache) {
			list = (List<ContactEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONTACTENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTENTRY;

				sql = sql.concat(ContactEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ContactEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the contact entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ContactEntry contactEntry : findAll()) {
			remove(contactEntry);
		}
	}

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CONTACTENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "entryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONTACTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ContactEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the contact entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByContactId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"contactId"}, true);

		_finderPathWithoutPaginationFindByContactId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactId",
			new String[] {Long.class.getName()}, new String[] {"contactId"},
			true);

		_finderPathCountByContactId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactId",
			new String[] {Long.class.getName()}, new String[] {"contactId"},
			false);

		ContactEntryUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ContactEntryUtil.setPersistence(null);

		entityCache.removeCache(ContactEntryImpl.class.getName());
	}

	@Override
	@Reference(
		target = CTMGPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CTMGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CTMGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CONTACTENTRY =
		"SELECT contactEntry FROM ContactEntry contactEntry";

	private static final String _SQL_SELECT_CONTACTENTRY_WHERE =
		"SELECT contactEntry FROM ContactEntry contactEntry WHERE ";

	private static final String _SQL_COUNT_CONTACTENTRY =
		"SELECT COUNT(contactEntry) FROM ContactEntry contactEntry";

	private static final String _SQL_COUNT_CONTACTENTRY_WHERE =
		"SELECT COUNT(contactEntry) FROM ContactEntry contactEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "contactEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ContactEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ContactEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ContactEntryPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}