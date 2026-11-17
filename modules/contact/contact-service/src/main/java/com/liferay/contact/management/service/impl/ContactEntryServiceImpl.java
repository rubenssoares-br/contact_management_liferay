/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;

import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.contact.management.service.base.ContactEntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Rubens Soares
 */
@Component(
	property = {
		"json.web.service.context.name=ctmg",
		"json.web.service.context.path=ContactEntry"
	},
	service = AopService.class
)
public class ContactEntryServiceImpl extends ContactEntryServiceBaseImpl {

	public ContactEntry addContactEntry(String familyRelationship, long phone, String address, long contactId, ServiceContext serviceContext) throws PortalException {

		// Adding an entry changes the parent contact

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.UPDATE);

		return contactEntryLocalService.addContactEntry(familyRelationship, phone, address, contactId, serviceContext);
	}

	public ContactEntry updateContactEntry(String familyRelationship, long entryId, long phone, String address, long contactId, ServiceContext serviceContext) throws PortalException {

		PermissionChecker permissionChecker = getPermissionChecker();

		// The current parent (loaded from the database) must allow the change.
		// Check before loading, so a missing entry fails the same way as a
		// forbidden one and the caller learns nothing about which IDs exist.

		_contactEntryModelResourcePermission.check(
			permissionChecker, entryId, ActionKeys.UPDATE);

		ContactEntry contactEntry = contactEntryLocalService.getContactEntry(
			entryId);

		// Moving the entry under another contact changes that contact too

		if (contactEntry.getContactId() != contactId) {
			_contactModelResourcePermission.check(
				permissionChecker, contactId, ActionKeys.UPDATE);
		}

		return contactEntryLocalService.updateContactEntry(familyRelationship, entryId, phone, address, contactId, serviceContext);
	}

	public void deleteContactEntry(long entryId) throws PortalException {
		_contactEntryModelResourcePermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		contactEntryLocalService.deleteContactEntry(entryId);
	}

	public ContactEntry getContactEntry(long entryId) throws PortalException {
		_contactEntryModelResourcePermission.check(
			getPermissionChecker(), entryId, ActionKeys.VIEW);

		return contactEntryLocalService.getContactEntry(entryId);
	}

	public List<ContactEntry> getAllContactsEntries() throws PortalException {
		PermissionChecker permissionChecker = getPermissionChecker();

		List<ContactEntry> contactEntries = new ArrayList<>();

		for (ContactEntry contactEntry :
				contactEntryLocalService.getAllContactEntries()) {

			if (_contactEntryModelResourcePermission.contains(
					permissionChecker, contactEntry, ActionKeys.VIEW)) {

				contactEntries.add(contactEntry);
			}
		}

		return contactEntries;
	}

	public List<ContactEntry> getEntriesByContactId(long contactId) throws PortalException {

		// All entries share one parent, so one check covers the whole list

		_contactModelResourcePermission.check(
			getPermissionChecker(), contactId, ActionKeys.VIEW);

		return contactEntryLocalService.getEntriesByContactId(contactId);
	}

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(model.class.name=com.liferay.contact.management.model.ContactEntry)"
	)
	private volatile ModelResourcePermission<ContactEntry>
		_contactEntryModelResourcePermission;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(model.class.name=com.liferay.contact.management.model.Contact)"
	)
	private volatile ModelResourcePermission<Contact>
		_contactModelResourcePermission;

}
