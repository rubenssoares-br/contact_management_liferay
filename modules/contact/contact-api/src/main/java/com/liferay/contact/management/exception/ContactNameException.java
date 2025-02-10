/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.contact.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rubens Soares
 */
public class ContactNameException extends PortalException {

	public ContactNameException() {
	}

	public ContactNameException(String msg) {
		super(msg);
	}

	public ContactNameException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactNameException(Throwable throwable) {
		super(throwable);
	}

}