/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.contact.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Rubens Soares
 */
public class ContactEntryIdException extends PortalException {

	public ContactEntryIdException() {
	}

	public ContactEntryIdException(String msg) {
		super(msg);
	}

	public ContactEntryIdException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactEntryIdException(Throwable throwable) {
		super(throwable);
	}

}