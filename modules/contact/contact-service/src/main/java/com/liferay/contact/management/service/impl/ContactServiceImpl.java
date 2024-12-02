/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;

import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.base.ContactServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionUtil;
import com.liferay.portal.kernel.service.ServiceContext;
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
		"json.web.service.context.path=Contact"
	},
	service = AopService.class
)
public class ContactServiceImpl extends ContactServiceBaseImpl {

	public Contact addContact(String name, String email, long phone, String address, ServiceContext serviceContext)
			throws PortalException {


		return contactLocalService.addContact(name, email, phone, address, serviceContext);
	}

	public Contact getContact(long contactId, ServiceContext serviceContext)
			throws PortalException {

		return contactLocalService.getContact(contactId);
	}

	public void deleteContact(long contactId) throws PortalException {
		contactLocalService.deleteContact(contactId);
	}



	@Reference
	private volatile ModelResourcePermission<Contact>
			_contactModelResourcePermission;
}