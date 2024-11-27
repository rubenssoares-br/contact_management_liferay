/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;

import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.base.ContactLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
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

		Contact entity = contactPersistence.findByPrimaryKey(contactId);

		entity.setExpandoBridgeAttributes(serviceContext);
		entity.setName(name);
		entity.setEmail(email);
		entity.setPhone(phone);
		entity.setAddress(address);

		contactPersistence.update(entity);

		return entity;
	}
}