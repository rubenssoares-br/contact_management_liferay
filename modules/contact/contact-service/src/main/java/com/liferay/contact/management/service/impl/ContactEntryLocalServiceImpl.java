/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;

import com.liferay.contact.management.exception.*;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.contact.management.service.base.ContactEntryLocalServiceBaseImpl;
import com.liferay.contact.management.service.persistence.ContactEntryUtil;
import com.liferay.contact.management.service.persistence.ContactUtil;
import com.liferay.petra.executor.PortalExecutorConfig;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Rubens Soares
 */
@Component(
	property = "model.class.name=com.liferay.contact.management.model.ContactEntry",
	service = AopService.class
)
public class ContactEntryLocalServiceImpl
	extends ContactEntryLocalServiceBaseImpl {

	public ContactEntry addContactEntry(String familyRelationship, long phone, String address, long contactId, ServiceContext serviceContext) throws PortalException {

		_validateParameters(familyRelationship, phone, address, contactId);

		long entryId = counterLocalService.increment();

		ContactEntry entity = contactEntryPersistence.create(entryId);

		entity.setExpandoBridgeAttributes(serviceContext);
		entity.setFamilyRelationship(familyRelationship);
		entity.setPhone(phone);
		entity.setAddress(address);
		entity.setContactId(contactId);

		contactEntryPersistence.update(entity);

		return entity;
	}

	public ContactEntry updateContactEntry( String familyRelationship, long entryId, long phone, String address, long contactId, ServiceContext serviceContext) throws PortalException {

		_validateEntryId(entryId);

		_validateParameters(familyRelationship, phone, address, contactId);

		ContactEntry entity = contactEntryPersistence.findByPrimaryKey(entryId);

		entity.setExpandoBridgeAttributes(serviceContext);
		entity.setFamilyRelationship(familyRelationship);
		entity.setPhone(phone);
		entity.setAddress(address);
		entity.setContactId(contactId);

		contactEntryPersistence.update(entity);

		return entity;
	}

	public ContactEntry deleteContactEntry(long entryId) throws PortalException {

		_validateEntryId(entryId);

		return contactEntryPersistence.remove(entryId);
	}

	public ContactEntry getContactEntry(long entryId) throws PortalException {
		_validateEntryId(entryId);

		return contactEntryPersistence.findByPrimaryKey(entryId);
	}

	public List<ContactEntry> getAllContactEntries() throws PortalException {

		return contactEntryPersistence.findAll();
	}

	private void _validateParameters(String familyRelationship, long phone, String address, long contactId) throws PortalException {

		_validateFamilyRelationship(familyRelationship);

		_validatePhone(phone);

		_validateAddress(address);

		_validateContactId(contactId);

	}

	private void _validateFamilyRelationship(String familyRelationship) throws PortalException {

		if (Validator.isNull(familyRelationship)) {
			throw new ContactEntryFamilyRelationshipException.MustNotBeNull();
		}

		char[] arrayFamilyRelationshipChar = familyRelationship.toCharArray();

		for (char a : arrayFamilyRelationshipChar) {
			if (!Validator.isChar(a) && !Validator.isDigit(a)) {
				throw new ContactEntryFamilyRelationshipException.MustOnlyContainLettersAndDigits();
			}
		}

		if (arrayFamilyRelationshipChar.length > 50) {
			throw new ContactEntryFamilyRelationshipException.MustBeLessThan50Characters();
		}

		if (ContactEntryUtil.fetchByFamilyRelationship(familyRelationship) != null) {
			throw new ContactEntryFamilyRelationshipException.MustNotBeDuplicate(familyRelationship);
		}

	}

	private void _validatePhone(long phone) throws PortalException {

		if (Validator.isNull(phone)) {
			return;
		}

		char[] arrayPhoneChar = Long.toString(phone).toCharArray();

		for (char a : arrayPhoneChar) {
			if (!Validator.isDigit(a)) {
				throw new ContactPhoneException.MustOnlyContainDigits();
			}
		}

		if (arrayPhoneChar.length > 30) {
			throw new ContactPhoneException.MustBeLessThan30Characters();
		}

		if (ContactUtil.fetchByPhone(phone) != null) {
			throw new ContactPhoneException.MustNotBeDuplicate(phone);
		}

	}

	private void _validateAddress(String address) throws PortalException {

		if (Validator.isNull(address)) {
			throw new ContactAddressException.MustNotBeNull();
		}

		char[] arrayAddressChar = address.toCharArray();

		for (char a : arrayAddressChar) {
			if (!Validator.isChar(a) && !Validator.isDigit(a))  {
				throw new ContactAddressException.MustOnlyContainLettersAndDigits();
			}
		}

		if (arrayAddressChar.length > 60) {
			throw new ContactAddressException.MustBeLessThan60Characters();
		}

	}

	private void _validateContactId(long contactId) throws PortalException {

		if (Validator.isNull(contactId)) {
			throw new ContactIdException.MustNotBeNull();
		}

		char[] arrayContactIdChar = Long.toString(contactId).toCharArray();

		for (char a : arrayContactIdChar) {
			if (!Validator.isDigit(a)) {
				throw new ContactIdException.MustOnlyContainDigits();
			}
		}

		if (arrayContactIdChar.length > 30) {
			throw new ContactIdException.MustBeLessThan30Characters();
		}

		if (ContactEntryUtil.fetchByContactId(contactId) == null) {
			throw new ContactIdException.MustBeValid();
		}
		
	}

	private void _validateEntryId(long entryId) throws PortalException {

		if (Validator.isNull(entryId)) {
			throw new ContactEntryIdException.MustNotBeNull();
		}

		char[] arrayEntryIdChar = Long.toString(entryId).toCharArray();

		for (char a : arrayEntryIdChar) {
			if (!Validator.isDigit(a)) {
				throw new ContactEntryIdException.MustOnlyContainDigits();
			}
		}

		if (arrayEntryIdChar.length > 30) {
			throw new ContactEntryIdException.MustBeLessThan30Characters();
		}

		if (ContactEntryUtil.fetchByPrimaryKey(entryId) == null) {
			throw new ContactEntryIdException.MustBeValid();
		}

	}

}