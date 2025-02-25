/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ContactEntryLocalService}.
 *
 * @author Rubens Soares
 * @see ContactEntryLocalService
 * @generated
 */
public class ContactEntryLocalServiceWrapper
	implements ContactEntryLocalService,
			   ServiceWrapper<ContactEntryLocalService> {

	public ContactEntryLocalServiceWrapper() {
		this(null);
	}

	public ContactEntryLocalServiceWrapper(
		ContactEntryLocalService contactEntryLocalService) {

		_contactEntryLocalService = contactEntryLocalService;
	}

	/**
	 * Adds the contact entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was added
	 */
	@Override
	public com.liferay.contact.management.model.ContactEntry addContactEntry(
		com.liferay.contact.management.model.ContactEntry contactEntry) {

		return _contactEntryLocalService.addContactEntry(contactEntry);
	}

	@Override
	public com.liferay.contact.management.model.ContactEntry addContactEntry(
			String familyRelationship, long phone, String address,
			long contactId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.addContactEntry(
			familyRelationship, phone, address, contactId, serviceContext);
	}

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param entryId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	@Override
	public com.liferay.contact.management.model.ContactEntry createContactEntry(
		long entryId) {

		return _contactEntryLocalService.createContactEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the contact entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was removed
	 */
	@Override
	public com.liferay.contact.management.model.ContactEntry deleteContactEntry(
		com.liferay.contact.management.model.ContactEntry contactEntry) {

		return _contactEntryLocalService.deleteContactEntry(contactEntry);
	}

	/**
	 * Deletes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws PortalException if a contact entry with the primary key could not be found
	 */
	@Override
	public com.liferay.contact.management.model.ContactEntry deleteContactEntry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.deleteContactEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _contactEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _contactEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _contactEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.contact.management.model.impl.ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _contactEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.contact.management.model.impl.ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _contactEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _contactEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _contactEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.contact.management.model.ContactEntry fetchContactEntry(
		long entryId) {

		return _contactEntryLocalService.fetchContactEntry(entryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _contactEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.contact.management.model.ContactEntry>
			getAllContactEntries()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.getAllContactEntries();
	}

	/**
	 * Returns a range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.contact.management.model.impl.ContactEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of contact entries
	 */
	@Override
	public java.util.List<com.liferay.contact.management.model.ContactEntry>
		getContactEntries(int start, int end) {

		return _contactEntryLocalService.getContactEntries(start, end);
	}

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 */
	@Override
	public int getContactEntriesCount() {
		return _contactEntryLocalService.getContactEntriesCount();
	}

	/**
	 * Returns the contact entry with the primary key.
	 *
	 * @param entryId the primary key of the contact entry
	 * @return the contact entry
	 * @throws PortalException if a contact entry with the primary key could not be found
	 */
	@Override
	public com.liferay.contact.management.model.ContactEntry getContactEntry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.getContactEntry(entryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _contactEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was updated
	 */
	@Override
	public com.liferay.contact.management.model.ContactEntry updateContactEntry(
		com.liferay.contact.management.model.ContactEntry contactEntry) {

		return _contactEntryLocalService.updateContactEntry(contactEntry);
	}

	@Override
	public com.liferay.contact.management.model.ContactEntry updateContactEntry(
			String familyRelationship, long entryId, long phone, String address,
			long contactId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactEntryLocalService.updateContactEntry(
			familyRelationship, entryId, phone, address, contactId,
			serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _contactEntryLocalService.getBasePersistence();
	}

	@Override
	public ContactEntryLocalService getWrappedService() {
		return _contactEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ContactEntryLocalService contactEntryLocalService) {

		_contactEntryLocalService = contactEntryLocalService;
	}

	private ContactEntryLocalService _contactEntryLocalService;

}