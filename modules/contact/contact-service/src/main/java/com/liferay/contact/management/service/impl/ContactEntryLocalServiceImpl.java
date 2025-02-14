/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;

import com.liferay.contact.management.exception.ContactAddressException;
import com.liferay.contact.management.exception.ContactEntryFamilyRelationshipException;
import com.liferay.contact.management.exception.ContactIdException;
import com.liferay.contact.management.exception.ContactPhoneException;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.contact.management.service.base.ContactEntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

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

		ContactEntry entity = contactEntryPersistence.findByPrimaryKey(entryId);

		entity.setExpandoBridgeAttributes(serviceContext);
		entity.setFamilyRelationship(familyRelationship);
		entity.setPhone(phone);
		entity.setAddress(address);
		entity.setContactId(contactId);

		contactEntryPersistence.update(entity);

		return entity;
	}

	public ContactEntry deleteContactEntry(ContactEntry entity) throws PortalException {

		contactEntryPersistence.remove(entity);

		return entity;
	}

	public ContactEntry getContactEntry(long entryId) throws PortalException {

		return contactEntryPersistence.findByPrimaryKey(entryId);
	}

	private void _validateParameters(String familyRelationship, long phone, String address, long contactId) throws PortalException {

		_validateFamilyRelationship(familyRelationship);

		_validatePhone(phone);

		_validateAddress(address);

		_validateContactId(contactId);

	}

	private void _validateFamilyRelationship(String familyRelationship) throws PortalException {

		if (Validator.isNull(familyRelationship)) {
			throw new ContactEntryFamilyRelationshipException("FamilyRelationship is null");
		}
	}

	private void _validatePhone(long phone) throws PortalException {

		if (Validator.isNull(phone)) {
			throw new ContactPhoneException("Phone is null");
		}
	}

	private void _validateAddress(String address) throws PortalException {

		if (Validator.isBlank(address)) {
			return;
		}
	}

	private void _validateContactId(long contactId) throws PortalException {

		if (Validator.isNull(contactId)) {
			throw new ContactIdException("contactId is null");
		}
	}
}