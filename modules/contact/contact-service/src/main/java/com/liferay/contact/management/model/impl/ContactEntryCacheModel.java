/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.model.impl;

import com.liferay.contact.management.model.ContactEntry;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactEntry in entity cache.
 *
 * @author Rubens Soares
 * @generated
 */
public class ContactEntryCacheModel
	implements CacheModel<ContactEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContactEntryCacheModel)) {
			return false;
		}

		ContactEntryCacheModel contactEntryCacheModel =
			(ContactEntryCacheModel)object;

		if (entryId == contactEntryCacheModel.entryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", familyRelationship=");
		sb.append(familyRelationship);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", address=");
		sb.append(address);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactEntry toEntityModel() {
		ContactEntryImpl contactEntryImpl = new ContactEntryImpl();

		contactEntryImpl.setEntryId(entryId);

		if (familyRelationship == null) {
			contactEntryImpl.setFamilyRelationship("");
		}
		else {
			contactEntryImpl.setFamilyRelationship(familyRelationship);
		}

		contactEntryImpl.setPhone(phone);

		if (address == null) {
			contactEntryImpl.setAddress("");
		}
		else {
			contactEntryImpl.setAddress(address);
		}

		contactEntryImpl.setContactId(contactId);

		contactEntryImpl.resetOriginalValues();

		return contactEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		entryId = objectInput.readLong();
		familyRelationship = objectInput.readUTF();

		phone = objectInput.readLong();
		address = objectInput.readUTF();

		contactId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(entryId);

		if (familyRelationship == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(familyRelationship);
		}

		objectOutput.writeLong(phone);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeLong(contactId);
	}

	public long entryId;
	public String familyRelationship;
	public long phone;
	public String address;
	public long contactId;

}