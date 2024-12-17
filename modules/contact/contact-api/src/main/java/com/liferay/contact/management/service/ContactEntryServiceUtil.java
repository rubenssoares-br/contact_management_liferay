/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service;

import com.liferay.contact.management.model.ContactEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for ContactEntry. This utility wraps
 * <code>com.liferay.contact.management.service.impl.ContactEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Rubens Soares
 * @see ContactEntryService
 * @generated
 */
public class ContactEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.contact.management.service.impl.ContactEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ContactEntry addContactEntry(
			String familyRelationship, long phone, String address,
			long contactId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addContactEntry(
			familyRelationship, phone, address, contactId, serviceContext);
	}

	public static void deleteContactEntry(long entryId) throws PortalException {
		getService().deleteContactEntry(entryId);
	}

	public static ContactEntry getContactEntry(
			long entryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().getContactEntry(entryId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ContactEntry updateContactEntry(
			String familyRelationship, long entryId, long phone, String address,
			long contactId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateContactEntry(
			familyRelationship, entryId, phone, address, contactId,
			serviceContext);
	}

	public static ContactEntryService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ContactEntryService> _serviceSnapshot =
		new Snapshot<>(
			ContactEntryServiceUtil.class, ContactEntryService.class);

}