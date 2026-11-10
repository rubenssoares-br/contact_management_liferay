/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author Rubens Soares
 * @see Contact
 * @generated
 */
public class ContactWrapper
	extends BaseModelWrapper<Contact>
	implements Contact, ModelWrapper<Contact> {

	public ContactWrapper(Contact contact) {
		super(contact);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("address", getAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long phone = (Long)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	@Override
	public Contact cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this contact.
	 *
	 * @return the address of this contact
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the company ID of this contact.
	 *
	 * @return the company ID of this contact
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact ID of this contact.
	 *
	 * @return the contact ID of this contact
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the create date of this contact.
	 *
	 * @return the create date of this contact
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this contact.
	 *
	 * @return the email of this contact
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this contact.
	 *
	 * @return the group ID of this contact
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this contact.
	 *
	 * @return the modified date of this contact
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this contact.
	 *
	 * @return the name of this contact
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phone of this contact.
	 *
	 * @return the phone of this contact
	 */
	@Override
	public long getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this contact.
	 *
	 * @return the primary key of this contact
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this contact.
	 *
	 * @return the user ID of this contact
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this contact.
	 *
	 * @return the user name of this contact
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this contact.
	 *
	 * @return the user uuid of this contact
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this contact.
	 *
	 * @return the uuid of this contact
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this contact.
	 *
	 * @param address the address of this contact
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the company ID of this contact.
	 *
	 * @param companyId the company ID of this contact
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact ID of this contact.
	 *
	 * @param contactId the contact ID of this contact
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the create date of this contact.
	 *
	 * @param createDate the create date of this contact
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this contact.
	 *
	 * @param email the email of this contact
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this contact.
	 *
	 * @param groupId the group ID of this contact
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this contact.
	 *
	 * @param modifiedDate the modified date of this contact
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this contact.
	 *
	 * @param name the name of this contact
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone of this contact.
	 *
	 * @param phone the phone of this contact
	 */
	@Override
	public void setPhone(long phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this contact.
	 *
	 * @param primaryKey the primary key of this contact
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this contact.
	 *
	 * @param userId the user ID of this contact
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this contact.
	 *
	 * @param userName the user name of this contact
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this contact.
	 *
	 * @param userUuid the user uuid of this contact
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this contact.
	 *
	 * @param uuid the uuid of this contact
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ContactWrapper wrap(Contact contact) {
		return new ContactWrapper(contact);
	}

}