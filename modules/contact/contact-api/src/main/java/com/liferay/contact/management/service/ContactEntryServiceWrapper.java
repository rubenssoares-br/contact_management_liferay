/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactEntryService}.
 *
 * @author Rubens Soares
 * @see ContactEntryService
 * @generated
 */
public class ContactEntryServiceWrapper
	implements ContactEntryService, ServiceWrapper<ContactEntryService> {

	public ContactEntryServiceWrapper() {
		this(null);
	}

	public ContactEntryServiceWrapper(ContactEntryService contactEntryService) {
		_contactEntryService = contactEntryService;
	}

	@Override
	public com.liferay.contact.management.model.ContactEntry addContactEntry(
			String familyRelationship, long phone, String address,
			long contactId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryService.addContactEntry(
			familyRelationship, phone, address, contactId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public ContactEntryService getWrappedService() {
		return _contactEntryService;
	}

	@Override
	public void setWrappedService(ContactEntryService contactEntryService) {
		_contactEntryService = contactEntryService;
	}

	private ContactEntryService _contactEntryService;

}