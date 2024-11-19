/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;

import com.liferay.contact.management.service.base.ContactLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rubens Soares
 */
@Component(
	property = "model.class.name=com.liferay.contact.management.model.Contact",
	service = AopService.class
)
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {
}