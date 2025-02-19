/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;


import com.liferay.contact.management.exception.ContactAddressException;
import com.liferay.contact.management.exception.ContactEmailException;
import com.liferay.contact.management.exception.ContactNameException;
import com.liferay.contact.management.exception.ContactPhoneException;
import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.base.ContactLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

/**
 * @author Rubens Soares
 */
@Component(
	property = "model.class.name=com.liferay.contact.management.model.Contact",
	service = AopService.class
)
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {

	public Contact addContact( String name, String email, long phone, String address, ServiceContext serviceContext) throws PortalException {

		_validateParameters(name, email, phone, address);

		long contactId = counterLocalService.increment();

		Contact entity = contactPersistence.create(contactId);

		entity.setUuid(serviceContext.getUuid());
		entity.setExpandoBridgeAttributes(serviceContext);
		entity.setName(name);
		entity.setEmail(email);
		entity.setPhone(phone);
		entity.setAddress(address);

		contactPersistence.update(entity);

		return entity;
	}

	public Contact updateContact( String name,long contactId, String email, long phone, String address, ServiceContext serviceContext) throws PortalException {

		_validateParameters(name, email, phone, address);

		Contact entity = contactPersistence.findByPrimaryKey(contactId);

		entity.setExpandoBridgeAttributes(serviceContext);
		entity.setName(name);
		entity.setEmail(email);
		entity.setPhone(phone);
		entity.setAddress(address);

		contactPersistence.update(entity);

		return entity;
	}

	public Contact deleteContact(Contact entity) throws PortalException {

		contactPersistence.remove(entity);

		return entity;
	}

	public Contact getContact(long contactId) throws PortalException {

		return contactPersistence.findByPrimaryKey(contactId);
	}

	private void _validateParameters(String name, String email, long phone, String address) throws PortalException {

		_validateName(name);

		_validateEmailAddress(email);

		_validateAddress(address);

		_validatePhone(phone);

	}

	private void _validateName(String name) throws PortalException {

		if (Validator.isNull(name)) {
			throw new ContactNameException.MustNotBeNull();
		}

		char[] arrayNameChar = name.toCharArray();

		for (char a : arrayNameChar) {
			if (!Validator.isChar(a) && !Validator.isDigit(a))  {
				throw new ContactNameException.MustOnlyContainLettersAndDigits();
			}
		}

		if (arrayNameChar.length > 50) {
			throw new ContactNameException.MustBeLessThan50Characters();
		}

		Contact contactName = contactPersistence.fetchByName(name);

		if (contactName != null) {
			throw new ContactNameException.MustNotBeDuplicate(name);
		}

	}

	private void _validateEmailAddress(String email) throws PortalException {

		if (Validator.isNull(email)) {
			throw new ContactEmailException("Email is null");
		}
	}

	private void _validatePhone(long phone) throws PortalException {

		if (Validator.isNull(phone)) {
			return;
		}
	}

	private void _validateAddress(String address) throws PortalException {

		if (Validator.isNull(address)) {
			throw new ContactAddressException();
		}
	}

}