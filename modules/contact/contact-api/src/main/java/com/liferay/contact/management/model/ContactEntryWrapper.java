/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContactEntry}.
 * </p>
 *
 * @author Rubens Soares
 * @see ContactEntry
 * @generated
 */
public class ContactEntryWrapper
	extends BaseModelWrapper<ContactEntry>
	implements ContactEntry, ModelWrapper<ContactEntry> {

	public ContactEntryWrapper(ContactEntry contactEntry) {
		super(contactEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("familyRelationship", getFamilyRelationship());
		attributes.put("phone", getPhone());
		attributes.put("address", getAddress());
		attributes.put("contactId", getContactId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		String familyRelationship = (String)attributes.get(
			"familyRelationship");

		if (familyRelationship != null) {
			setFamilyRelationship(familyRelationship);
		}

		Long phone = (Long)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}
	}

	@Override
	public ContactEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this contact entry.
	 *
	 * @return the address of this contact entry
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the contact ID of this contact entry.
	 *
	 * @return the contact ID of this contact entry
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the entry ID of this contact entry.
	 *
	 * @return the entry ID of this contact entry
	 */
	@Override
	public long getEntryId() {
		return model.getEntryId();
	}

	/**
	 * Returns the family relationship of this contact entry.
	 *
	 * @return the family relationship of this contact entry
	 */
	@Override
	public String getFamilyRelationship() {
		return model.getFamilyRelationship();
	}

	/**
	 * Returns the phone of this contact entry.
	 *
	 * @return the phone of this contact entry
	 */
	@Override
	public long getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this contact entry.
	 *
	 * @return the primary key of this contact entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this contact entry.
	 *
	 * @param address the address of this contact entry
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the contact ID of this contact entry.
	 *
	 * @param contactId the contact ID of this contact entry
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the entry ID of this contact entry.
	 *
	 * @param entryId the entry ID of this contact entry
	 */
	@Override
	public void setEntryId(long entryId) {
		model.setEntryId(entryId);
	}

	/**
	 * Sets the family relationship of this contact entry.
	 *
	 * @param familyRelationship the family relationship of this contact entry
	 */
	@Override
	public void setFamilyRelationship(String familyRelationship) {
		model.setFamilyRelationship(familyRelationship);
	}

	/**
	 * Sets the phone of this contact entry.
	 *
	 * @param phone the phone of this contact entry
	 */
	@Override
	public void setPhone(long phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this contact entry.
	 *
	 * @param primaryKey the primary key of this contact entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ContactEntryWrapper wrap(ContactEntry contactEntry) {
		return new ContactEntryWrapper(contactEntry);
	}

}