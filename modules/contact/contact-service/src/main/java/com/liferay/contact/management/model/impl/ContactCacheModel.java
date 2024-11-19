/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.model.impl;

import com.liferay.contact.management.model.Contact;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author Rubens Soares
 * @generated
 */
public class ContactCacheModel implements CacheModel<Contact>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContactCacheModel)) {
			return false;
		}

		ContactCacheModel contactCacheModel = (ContactCacheModel)object;

		if (contactId == contactCacheModel.contactId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contactId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contact toEntityModel() {
		ContactImpl contactImpl = new ContactImpl();

		if (uuid == null) {
			contactImpl.setUuid("");
		}
		else {
			contactImpl.setUuid(uuid);
		}

		contactImpl.setContactId(contactId);

		if (name == null) {
			contactImpl.setName("");
		}
		else {
			contactImpl.setName(name);
		}

		if (email == null) {
			contactImpl.setEmail("");
		}
		else {
			contactImpl.setEmail(email);
		}

		contactImpl.setPhone(phone);

		if (address == null) {
			contactImpl.setAddress("");
		}
		else {
			contactImpl.setAddress(address);
		}

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		contactId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();

		phone = objectInput.readLong();
		address = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(contactId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(phone);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public String uuid;
	public long contactId;
	public String name;
	public String email;
	public long phone;
	public String address;

}