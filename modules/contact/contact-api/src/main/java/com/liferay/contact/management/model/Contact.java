/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Contact service. Represents a row in the &quot;CTMG_Contact&quot; database table, with each column mapped to a property of this class.
 *
 * @author Rubens Soares
 * @see ContactModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.contact.management.model.impl.ContactImpl"
)
@ProviderType
public interface Contact extends ContactModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.contact.management.model.impl.ContactImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Contact, Long> CONTACT_ID_ACCESSOR =
		new Accessor<Contact, Long>() {

			@Override
			public Long get(Contact contact) {
				return contact.getContactId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Contact> getTypeClass() {
				return Contact.class;
			}

		};

}