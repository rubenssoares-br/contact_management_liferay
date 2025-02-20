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
public class ContactEmailException extends PortalException {

	public static class MustNotBeNull extends ContactEmailException {
		public MustNotBeNull() {
			super("Email is null");
		}

	}

	public static class MustHaveValidAddressFormat extends ContactEmailException {
		public MustHaveValidAddressFormat(String email) {
			super("The email " + email + " is not in a valid email address format");
		}

	}

	public static class MustBeLessThan70Characters extends ContactEmailException {
		public MustBeLessThan70Characters() {
			super(Arrays.asList(70, "email"), "Email must be less than 70 characters");
		}
	}

	public ContactEmailException() {
	}

	public ContactEmailException(String msg) {
		super(msg);
	}

	public ContactEmailException(List<Object> argument, String message) {
		super(message);
	}

	public ContactEmailException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactEmailException(Throwable throwable) {
		super(throwable);
	}

}