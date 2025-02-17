/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.contact.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rubens Soares
 */
public class ContactNameException extends PortalException {

	public static class MustNotBeNull extends ContactNameException {

		public MustNotBeNull() {
			super("Name is null");
		}

	}

	public static class MustOnlyContainLettersAndDigits extends ContactNameException {

		public MustOnlyContainLettersAndDigits() {
			super("Name must only contain letters and digits");
		}

	}

	public static class MustBeLessThan50Characters extends ContactNameException {
		public MustBeLessThan50Characters() {
			super(Arrays.asList(50, "name"), "Name must be less than 50 characters");
		}
	}

	public ContactNameException() {
	}

	public ContactNameException(String msg) {
		super(msg);
	}

	public ContactNameException(List<Object> argument, String message) {
		super(message);
	}

	public ContactNameException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactNameException(Throwable throwable) {
		super(throwable);
	}

}