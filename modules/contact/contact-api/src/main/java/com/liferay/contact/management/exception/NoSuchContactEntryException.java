/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.contact.management.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Rubens Soares
 */
public class NoSuchContactEntryException extends NoSuchModelException {

	public NoSuchContactEntryException() {
	}

	public NoSuchContactEntryException(String msg) {
		super(msg);
	}

	public NoSuchContactEntryException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchContactEntryException(Throwable throwable) {
		super(throwable);
	}

}