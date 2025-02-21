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
public class ContactEntryFamilyRelationshipException extends PortalException {

	public static class MustNotBeDuplicate extends ContactEntryFamilyRelationshipException {
		public MustNotBeDuplicate(String familyRelationship) {
			super("Family Relationship with the name " + familyRelationship + " duplicated");
		}
	}

	public static class MustNotBeNull extends ContactEntryFamilyRelationshipException {
		public MustNotBeNull() {
			super("Family Relationship is null");
		}
	}

	public static class MustOnlyContainLettersAndDigits extends ContactEntryFamilyRelationshipException {
		public MustOnlyContainLettersAndDigits() {
			super("Name of the Family Relationship must only contain letters and digits");
		}

	}

	public static class MustBeLessThan50Characters extends ContactEntryFamilyRelationshipException {
		public MustBeLessThan50Characters() {
			super(Arrays.asList(50, "familyRelationship"), "Family Relationship name must be less than 50 characters");
		}
	}

	public ContactEntryFamilyRelationshipException() {
	}

	public ContactEntryFamilyRelationshipException(String msg) {
		super(msg);
	}

	public ContactEntryFamilyRelationshipException(List<Object> argument, String msg) {
		super(msg);
	}

	public ContactEntryFamilyRelationshipException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ContactEntryFamilyRelationshipException(Throwable throwable) {
		super(throwable);
	}

}