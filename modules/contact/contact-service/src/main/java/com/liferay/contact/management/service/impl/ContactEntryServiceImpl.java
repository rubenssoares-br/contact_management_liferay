/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.impl;

import com.liferay.contact.management.service.base.ContactEntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

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
}