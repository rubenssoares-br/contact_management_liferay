/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.contact.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rubens Soares
 */
public class ContactEmailException extends PortalException {

	public ContactEmailException() {
	}

	public ContactEmailException(String msg) {
		super(msg);
	}

	public ContactEmailException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactEmailException(Throwable throwable) {
		super(throwable);
	}

}