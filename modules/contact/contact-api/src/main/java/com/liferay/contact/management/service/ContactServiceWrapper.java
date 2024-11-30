/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactService}.
 *
 * @author Rubens Soares
 * @see ContactService
 * @generated
 */
public class ContactServiceWrapper
	implements ContactService, ServiceWrapper<ContactService> {

	public ContactServiceWrapper() {
		this(null);
	}

	public ContactServiceWrapper(ContactService contactService) {
		_contactService = contactService;
	}

	@Override
	public com.liferay.contact.management.model.Contact addContact(
			String name, String email, long phone, String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.addContact(
			name, email, phone, address, serviceContext);
	}

	@Override
	public com.liferay.contact.management.model.Contact getContact(
			long contactId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactService.getContact(contactId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactService.getOSGiServiceIdentifier();
	}

	@Override
	public ContactService getWrappedService() {
		return _contactService;
	}

	@Override
	public void setWrappedService(ContactService contactService) {
		_contactService = contactService;
	}

	private ContactService _contactService;

}