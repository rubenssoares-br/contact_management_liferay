/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.contact.management.exception.NoSuchContactEntryException;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.contact.management.service.ContactEntryLocalServiceUtil;
import com.liferay.contact.management.service.persistence.ContactEntryPersistence;
import com.liferay.contact.management.service.persistence.ContactEntryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ContactEntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferay.contact.management.service"));

	@Before
	public void setUp() {
		_persistence = ContactEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ContactEntry> iterator = _contactEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ContactEntry contactEntry = _persistence.create(pk);

		Assert.assertNotNull(contactEntry);

		Assert.assertEquals(contactEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ContactEntry newContactEntry = addContactEntry();

		_persistence.remove(newContactEntry);

		ContactEntry existingContactEntry = _persistence.fetchByPrimaryKey(
			newContactEntry.getPrimaryKey());

		Assert.assertNull(existingContactEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addContactEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ContactEntry newContactEntry = _persistence.create(pk);

		newContactEntry.setFamilyRelationship(RandomTestUtil.randomString());

		newContactEntry.setPhone(RandomTestUtil.nextLong());

		newContactEntry.setAddress(RandomTestUtil.randomString());

		newContactEntry.setContactId(RandomTestUtil.nextLong());

		_contactEntries.add(_persistence.update(newContactEntry));

		ContactEntry existingContactEntry = _persistence.findByPrimaryKey(
			newContactEntry.getPrimaryKey());

		Assert.assertEquals(
			existingContactEntry.getEntryId(), newContactEntry.getEntryId());
		Assert.assertEquals(
			existingContactEntry.getFamilyRelationship(),
			newContactEntry.getFamilyRelationship());
		Assert.assertEquals(
			existingContactEntry.getPhone(), newContactEntry.getPhone());
		Assert.assertEquals(
			existingContactEntry.getAddress(), newContactEntry.getAddress());
		Assert.assertEquals(
			existingContactEntry.getContactId(),
			newContactEntry.getContactId());
	}

	@Test
	public void testCountByFamilyRelationship() throws Exception {
		_persistence.countByFamilyRelationship("");

		_persistence.countByFamilyRelationship("null");

		_persistence.countByFamilyRelationship((String)null);
	}

	@Test
	public void testCountByContactId() throws Exception {
		_persistence.countByContactId(RandomTestUtil.nextLong());

		_persistence.countByContactId(0L);
	}

	@Test
	public void testCountByAllContactIds() throws Exception {
		_persistence.countByAllContactIds(RandomTestUtil.nextLong());

		_persistence.countByAllContactIds(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ContactEntry newContactEntry = addContactEntry();

		ContactEntry existingContactEntry = _persistence.findByPrimaryKey(
			newContactEntry.getPrimaryKey());

		Assert.assertEquals(existingContactEntry, newContactEntry);
	}

	@Test(expected = NoSuchContactEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ContactEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CTMG_ContactEntry", "entryId", true, "familyRelationship", true,
			"phone", true, "address", true, "contactId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ContactEntry newContactEntry = addContactEntry();

		ContactEntry existingContactEntry = _persistence.fetchByPrimaryKey(
			newContactEntry.getPrimaryKey());

		Assert.assertEquals(existingContactEntry, newContactEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ContactEntry missingContactEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingContactEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ContactEntry newContactEntry1 = addContactEntry();
		ContactEntry newContactEntry2 = addContactEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newContactEntry1.getPrimaryKey());
		primaryKeys.add(newContactEntry2.getPrimaryKey());

		Map<Serializable, ContactEntry> contactEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, contactEntries.size());
		Assert.assertEquals(
			newContactEntry1,
			contactEntries.get(newContactEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newContactEntry2,
			contactEntries.get(newContactEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ContactEntry> contactEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(contactEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ContactEntry newContactEntry = addContactEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newContactEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ContactEntry> contactEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, contactEntries.size());
		Assert.assertEquals(
			newContactEntry,
			contactEntries.get(newContactEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ContactEntry> contactEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(contactEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ContactEntry newContactEntry = addContactEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newContactEntry.getPrimaryKey());

		Map<Serializable, ContactEntry> contactEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, contactEntries.size());
		Assert.assertEquals(
			newContactEntry,
			contactEntries.get(newContactEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ContactEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ContactEntry>() {

				@Override
				public void performAction(ContactEntry contactEntry) {
					Assert.assertNotNull(contactEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ContactEntry newContactEntry = addContactEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ContactEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"entryId", newContactEntry.getEntryId()));

		List<ContactEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ContactEntry existingContactEntry = result.get(0);

		Assert.assertEquals(existingContactEntry, newContactEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ContactEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("entryId", RandomTestUtil.nextLong()));

		List<ContactEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ContactEntry newContactEntry = addContactEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ContactEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entryId"));

		Object newEntryId = newContactEntry.getEntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("entryId", new Object[] {newEntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEntryId = result.get(0);

		Assert.assertEquals(existingEntryId, newEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ContactEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"entryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ContactEntry newContactEntry = addContactEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newContactEntry.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		ContactEntry newContactEntry = addContactEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ContactEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"entryId", newContactEntry.getEntryId()));

		List<ContactEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(ContactEntry contactEntry) {
		Assert.assertEquals(
			contactEntry.getFamilyRelationship(),
			ReflectionTestUtil.invoke(
				contactEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "familyRelationship"));

		Assert.assertEquals(
			Long.valueOf(contactEntry.getContactId()),
			ReflectionTestUtil.<Long>invoke(
				contactEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "contactId"));
	}

	protected ContactEntry addContactEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ContactEntry contactEntry = _persistence.create(pk);

		contactEntry.setFamilyRelationship(RandomTestUtil.randomString());

		contactEntry.setPhone(RandomTestUtil.nextLong());

		contactEntry.setAddress(RandomTestUtil.randomString());

		contactEntry.setContactId(RandomTestUtil.nextLong());

		_contactEntries.add(_persistence.update(contactEntry));

		return contactEntry;
	}

	private List<ContactEntry> _contactEntries = new ArrayList<ContactEntry>();
	private ContactEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}