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
public class ContactEntryIdException extends PortalException {

	public static class MustNotBeNull extends ContactEntryIdException {
		public MustNotBeNull() {
			super("EntryId is null");
		}
	}

	public static class MustOnlyContainDigits extends ContactEntryIdException {
		public MustOnlyContainDigits() {
			super("EntryId must only contain digits");
		}
	}

	public static class MustBeLessThan30Characters extends ContactEntryIdException {
		public MustBeLessThan30Characters() {
			super(Arrays.asList(30, "entryId"), "EntryId must be less than 30 characters");
		}
	}

	public static class MustBeValid extends ContactEntryIdException {
		public MustBeValid() {
			super("EntryId not found in database");
		}
	}

	public ContactEntryIdException() {
	}

	public ContactEntryIdException(String msg) {
		super(msg);
	}

	public ContactEntryIdException(List<Object> argument, String msg) {
		super(msg);
	}

	public ContactEntryIdException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactEntryIdException(Throwable throwable) {
		super(throwable);
	}

}