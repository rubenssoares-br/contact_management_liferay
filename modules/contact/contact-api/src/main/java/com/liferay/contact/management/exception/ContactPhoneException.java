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
public class ContactPhoneException extends PortalException {

	public static class MustNotBeDuplicate extends ContactPhoneException {
		public MustNotBeDuplicate(long phone) {
			super("Phone " + phone + " duplicated");
		}
	}

	public static class MustOnlyContainDigits extends ContactPhoneException {
		public MustOnlyContainDigits() {
			super("Phone must only contain digits");
		}
	}

	public static class MustBeLessThan30Characters extends ContactPhoneException {
		public MustBeLessThan30Characters() {
			super(Arrays.asList(30, "phone"), "Phone must be less than 30 characters");
		}
	}

	public ContactPhoneException() {
	}

	public ContactPhoneException(String msg) {
		super(msg);
	}

	public ContactPhoneException(List<Object> argument, String message) {
		super(message);
	}

	public ContactPhoneException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactPhoneException(Throwable throwable) {
		super(throwable);
	}

}