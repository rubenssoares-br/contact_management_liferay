/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.contact.management.exception.NoSuchContactException;
import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.ContactLocalServiceUtil;
import com.liferay.contact.management.service.persistence.ContactPersistence;
import com.liferay.contact.management.service.persistence.ContactUtil;
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
public class ContactPersistenceTest {

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
		_persistence = ContactUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Contact> iterator = _contacts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Contact contact = _persistence.create(pk);

		Assert.assertNotNull(contact);

		Assert.assertEquals(contact.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Contact newContact = addContact();

		_persistence.remove(newContact);

		Contact existingContact = _persistence.fetchByPrimaryKey(
			newContact.getPrimaryKey());

		Assert.assertNull(existingContact);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addContact();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Contact newContact = _persistence.create(pk);

		newContact.setUuid(RandomTestUtil.randomString());

		newContact.setName(RandomTestUtil.randomString());

		newContact.setEmail(RandomTestUtil.randomString());

		newContact.setPhone(RandomTestUtil.nextLong());

		newContact.setAddress(RandomTestUtil.randomString());

		_contacts.add(_persistence.update(newContact));

		Contact existingContact = _persistence.findByPrimaryKey(
			newContact.getPrimaryKey());

		Assert.assertEquals(existingContact.getUuid(), newContact.getUuid());
		Assert.assertEquals(
			existingContact.getContactId(), newContact.getContactId());
		Assert.assertEquals(existingContact.getName(), newContact.getName());
		Assert.assertEquals(existingContact.getEmail(), newContact.getEmail());
		Assert.assertEquals(existingContact.getPhone(), newContact.getPhone());
		Assert.assertEquals(
			existingContact.getAddress(), newContact.getAddress());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testCountByEmail() throws Exception {
		_persistence.countByEmail("");

		_persistence.countByEmail("null");

		_persistence.countByEmail((String)null);
	}

	@Test
	public void testCountByPhone() throws Exception {
		_persistence.countByPhone(RandomTestUtil.nextLong());

		_persistence.countByPhone(0L);
	}

	@Test
	public void testCountByAddress() throws Exception {
		_persistence.countByAddress("");

		_persistence.countByAddress("null");

		_persistence.countByAddress((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Contact newContact = addContact();

		Contact existingContact = _persistence.findByPrimaryKey(
			newContact.getPrimaryKey());

		Assert.assertEquals(existingContact, newContact);
	}

	@Test(expected = NoSuchContactException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Contact> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CTMG_Contact", "uuid", true, "contactId", true, "name", true,
			"email", true, "phone", true, "address", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Contact newContact = addContact();

		Contact existingContact = _persistence.fetchByPrimaryKey(
			newContact.getPrimaryKey());

		Assert.assertEquals(existingContact, newContact);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Contact missingContact = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingContact);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Contact newContact1 = addContact();
		Contact newContact2 = addContact();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newContact1.getPrimaryKey());
		primaryKeys.add(newContact2.getPrimaryKey());

		Map<Serializable, Contact> contacts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, contacts.size());
		Assert.assertEquals(
			newContact1, contacts.get(newContact1.getPrimaryKey()));
		Assert.assertEquals(
			newContact2, contacts.get(newContact2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Contact> contacts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(contacts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Contact newContact = addContact();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newContact.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Contact> contacts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, contacts.size());
		Assert.assertEquals(
			newContact, contacts.get(newContact.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Contact> contacts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(contacts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Contact newContact = addContact();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newContact.getPrimaryKey());

		Map<Serializable, Contact> contacts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, contacts.size());
		Assert.assertEquals(
			newContact, contacts.get(newContact.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ContactLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Contact>() {

				@Override
				public void performAction(Contact contact) {
					Assert.assertNotNull(contact);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Contact newContact = addContact();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Contact.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("contactId", newContact.getContactId()));

		List<Contact> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Contact existingContact = result.get(0);

		Assert.assertEquals(existingContact, newContact);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Contact.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("contactId", RandomTestUtil.nextLong()));

		List<Contact> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Contact newContact = addContact();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Contact.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("contactId"));

		Object newContactId = newContact.getContactId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"contactId", new Object[] {newContactId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingContactId = result.get(0);

		Assert.assertEquals(existingContactId, newContactId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Contact.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("contactId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"contactId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Contact newContact = addContact();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newContact.getPrimaryKey()));
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

		Contact newContact = addContact();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Contact.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("contactId", newContact.getContactId()));

		List<Contact> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Contact contact) {
		Assert.assertEquals(
			contact.getName(),
			ReflectionTestUtil.invoke(
				contact, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));

		Assert.assertEquals(
			contact.getEmail(),
			ReflectionTestUtil.invoke(
				contact, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "email"));

		Assert.assertEquals(
			Long.valueOf(contact.getPhone()),
			ReflectionTestUtil.<Long>invoke(
				contact, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "phone"));

		Assert.assertEquals(
			contact.getAddress(),
			ReflectionTestUtil.invoke(
				contact, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "address"));
	}

	protected Contact addContact() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Contact contact = _persistence.create(pk);

		contact.setUuid(RandomTestUtil.randomString());

		contact.setName(RandomTestUtil.randomString());

		contact.setEmail(RandomTestUtil.randomString());

		contact.setPhone(RandomTestUtil.nextLong());

		contact.setAddress(RandomTestUtil.randomString());

		_contacts.add(_persistence.update(contact));

		return contact;
	}

	private List<Contact> _contacts = new ArrayList<Contact>();
	private ContactPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}