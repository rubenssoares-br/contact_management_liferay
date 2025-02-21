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
public class ContactAddressException extends PortalException {

	public static class MustNotBeNull extends ContactAddressException {
		public MustNotBeNull() {
			super("Address is null");
		}

	}

	public static class MustNotBeDuplicate extends ContactAddressException {
		public MustNotBeDuplicate(String address) {
			super("Address " + address + " duplicated");
		}
	}

	public static class MustBeLessThan60Characters extends ContactAddressException {
		public MustBeLessThan60Characters() {
			super(Arrays.asList(60, "address"), "Address must be less than 60 characters");
		}
	}

	public static class MustOnlyContainLettersAndDigits extends ContactAddressException {
		public MustOnlyContainLettersAndDigits() {
			super("Address must only contain letters and digits");
		}
	}

	public ContactAddressException() {
	}

	public ContactAddressException(String msg) {
		super(msg);
	}

	public ContactAddressException(List<Object> argument, String msg) {
		super(msg);
	}

	public ContactAddressException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactAddressException(Throwable throwable) {
		super(throwable);
	}

}