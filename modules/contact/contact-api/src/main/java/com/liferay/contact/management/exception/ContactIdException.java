/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.contact.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Rubens Soares
 */
public class ContactIdException extends PortalException {

	public static class MustNotBeNull extends ContactIdException {
		public MustNotBeNull() {
			super("ContactId is null");
		}
	}

	public static class MustOnlyContainDigits extends ContactIdException {
		public MustOnlyContainDigits() {
			super("ContactId must only contain digits");
		}
	}

	public static class MustBeLessThan30Characters extends ContactIdException {
		public MustBeLessThan30Characters() {
			super(Arrays.asList(30, "contactId"), "ContactId must be less than 30 characters");
		}
	}

	public static class MustBeValid extends ContactIdException {
		public MustBeValid() {
			super("ContactId not found in database");
		}
	}

	public ContactIdException() {
	}

	public ContactIdException(String msg) {
		super(msg);
	}

	public ContactIdException(List<Object> argument, String msg) {
		super(msg);
	}

	public ContactIdException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactIdException(Throwable throwable) {
		super(throwable);
	}

}