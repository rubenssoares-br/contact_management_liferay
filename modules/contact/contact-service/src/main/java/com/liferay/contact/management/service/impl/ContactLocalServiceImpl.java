/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;


import com.liferay.contact.management.exception.*;
import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.base.ContactLocalServiceBaseImpl;
import com.liferay.contact.management.service.persistence.ContactUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;


import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;


import java.util.Date;
import java.util.List;

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

		_validateUniqueParametersForNewContacts(name, email, phone, address);

		User user = userLocalService.getUser(serviceContext.getUserId());

		Date date = new Date();

		long contactId = counterLocalService.increment();

		long groupId = serviceContext.getScopeGroupId();

		Contact contact = contactPersistence.create(contactId);

		contact.setGroupId(groupId);
		contact.setCompanyId(user.getCompanyId());
		contact.setUserId(user.getUserId());
		contact.setUserName(user.getFullName());
		contact.setCreateDate(serviceContext.getCreateDate(date));
		contact.setModifiedDate(serviceContext.getModifiedDate(date));
		contact.setUuid(serviceContext.getUuid());
		contact.setExpandoBridgeAttributes(serviceContext);
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setAddress(address);

		contactPersistence.update(contact);

		resourceLocalService.addModelResources(contact, serviceContext);

		return contact;
	}

	public Contact updateContact( String name,long contactId, String email, long phone, String address, ServiceContext serviceContext) throws PortalException {

		_validateParameters(name, email, phone, address);

		_validateUniqueParametersForExistingContacts(name, email, phone, address, contactId);

		Contact contact = contactPersistence.findByPrimaryKey(contactId);

		contact.setExpandoBridgeAttributes(serviceContext);
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setAddress(address);
		contact.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		contactPersistence.update(contact);

		return contact;
	}

	public Contact deleteContact(long contactId) throws PortalException {

		_validateContactId(contactId);

		Contact contact = contactPersistence.findByPrimaryKey(contactId);

		contactPersistence.remove(contact);

		resourceLocalService.deleteResource(contact.getCompanyId(), Contact.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, contactId);
		
		return contact;
	}

	public Contact getContact(long contactId) throws PortalException {

		_validateContactId(contactId);

		return contactPersistence.findByPrimaryKey(contactId);
	}
	public List<Contact> getAllContacts() throws PortalException{

		return contactPersistence.findAll();
	}

	private void _validateParameters(String name, String email, long phone, String address) throws PortalException {

		_validateName(name);

		_validateEmailAddress(email);

		_validateAddress(address);

		_validatePhone(phone);

	}

	private void _validateUniqueParametersForNewContacts(String name, String email, long phone, String address) throws PortalException {

		_validateUniqueName(name);

		_validateUniqueEmail(email);

		_validateUniquePhone(phone);
	}

	private void _validateUniqueParametersForExistingContacts(String name, String email, long phone, String address, long contactId) throws PortalException {

		_validateNameMustNotBeDuplicate(name, contactId);

		_validateEmailMustNotBeDuplicate(email, contactId);

		_validatePhoneMustNotBeDuplicate(phone, contactId);
	}

	private void _validateName(String name) throws PortalException {

		if (Validator.isNull(name)) {
			throw new ContactNameException.MustNotBeNull();
		}

		char[] arrayNameChar = name.toCharArray();

		if (arrayNameChar.length > 50) {
			throw new ContactNameException.MustBeLessThan50Characters();
		}

		for (char a : arrayNameChar) {
			if (!Validator.isChar(a) && !Validator.isDigit(a))  {
				throw new ContactNameException.MustOnlyContainLettersAndDigits();
			}
		}
	}

	private void _validateUniqueName(String name) throws PortalException {
		if (ContactUtil.fetchByName(name) != null) {
			throw new ContactNameException.MustNotBeDuplicate(name);
		}
	}

	private void _validateUniqueEmail(String email) throws PortalException {
		if (ContactUtil.fetchByEmail(email) != null) {
			throw new ContactEmailException.MustNotBeDuplicate(email);
		}
	}

	private void _validateUniquePhone(long phone) throws PortalException {
		if (ContactUtil.fetchByPhone(phone) != null) {
			throw new ContactPhoneException.MustNotBeDuplicate(phone);
		}
	}

	private void _validateNameMustNotBeDuplicate(String name, long contactId) throws PortalException {

		if (name.equals(ContactUtil.findByPrimaryKey(contactId).getName())) {
			return;
		}

		_validateUniqueName(name);
	}

	private void _validateEmailMustNotBeDuplicate(String email, long contactId) throws PortalException {

		if (email.equals(ContactUtil.findByPrimaryKey(contactId).getEmail())) {
			return;
		}

		_validateUniqueEmail(email);
	}

	private void _validatePhoneMustNotBeDuplicate(long phone, long contactId) throws PortalException {

		if (phone == (ContactUtil.findByPrimaryKey(contactId).getPhone())) {
			return;
		}

		_validateUniquePhone(phone);
	}

	private void _validateEmailAddress(String email) throws PortalException {

		if (Validator.isNull(email)) {
			throw new ContactEmailException.MustNotBeNull();
		}

		if (!Validator.isEmailAddress(email)) {
			throw new ContactEmailException.MustHaveValidAddressFormat(email);
		}

		char[] arrayEmailChar = email.toCharArray();

		if (arrayEmailChar.length > 70) {
			throw new ContactEmailException.MustBeLessThan70Characters();
		}
	}

	private void _validatePhone(long phone) throws PortalException {

		if (Validator.isNull(phone)) {
			return;
		}

		char[] arrayPhoneChar = Long.toString(phone).toCharArray();

		if (arrayPhoneChar.length > 30) {
			throw new ContactPhoneException.MustBeLessThan30Characters();
		}

		for (char a : arrayPhoneChar) {
			if (!Validator.isDigit(a)) {
				throw new ContactPhoneException.MustOnlyContainDigits();
			}
		}
	}

	private void _validateAddress(String address) throws PortalException {

		if (Validator.isNull(address)) {
			throw new ContactAddressException.MustNotBeNull();
		}

		char[] arrayAddressChar = address.toCharArray();

		if (arrayAddressChar.length > 60) {
			throw new ContactAddressException.MustBeLessThan60Characters();
		}

		for (char a : arrayAddressChar) {
			if (!Validator.isChar(a) && !Validator.isDigit(a))  {
				throw new ContactAddressException.MustOnlyContainLettersAndDigits();
			}
		}
	}

	private void _validateContactId(long contactId) throws PortalException {

		if (Validator.isNull(contactId)) {
			throw new ContactIdException.MustNotBeNull();
		}

		char[] arrayContactIdChar = Long.toString(contactId).toCharArray();

		if (arrayContactIdChar.length > 30) {
			throw new ContactIdException.MustBeLessThan30Characters();
		}

		for (char a : arrayContactIdChar) {
			if (!Validator.isDigit(a)) {
				throw new ContactIdException.MustOnlyContainDigits();
			}
		}

		if (ContactUtil.findByPrimaryKey(contactId) == null) {
			throw new ContactIdException.MustBeValid();
		}
	}

}