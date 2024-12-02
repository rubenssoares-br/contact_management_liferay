/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service;

import com.liferay.contact.management.model.Contact;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for Contact. This utility wraps
 * <code>com.liferay.contact.management.service.impl.ContactServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Rubens Soares
 * @see ContactService
 * @generated
 */
public class ContactServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.contact.management.service.impl.ContactServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Contact addContact(
			String name, String email, long phone, String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addContact(
			name, email, phone, address, serviceContext);
	}

	public static void deleteContact(long contactId) throws PortalException {
		getService().deleteContact(contactId);
	}

	public static Contact getContact(
			long contactId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().getContact(contactId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Contact updateContact(
			String name, long contactId, String email, long phone,
			String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateContact(
			name, contactId, email, phone, address, serviceContext);
	}

	public static ContactService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ContactService> _serviceSnapshot =
		new Snapshot<>(ContactServiceUtil.class, ContactService.class);

}