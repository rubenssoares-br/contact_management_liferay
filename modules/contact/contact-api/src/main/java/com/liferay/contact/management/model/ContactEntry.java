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
 * The extended model interface for the ContactEntry service. Represents a row in the &quot;CTMG_ContactEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Rubens Soares
 * @see ContactEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.contact.management.model.impl.ContactEntryImpl"
)
@ProviderType
public interface ContactEntry extends ContactEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.contact.management.model.impl.ContactEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ContactEntry, Long> ENTRY_ID_ACCESSOR =
		new Accessor<ContactEntry, Long>() {

			@Override
			public Long get(ContactEntry contactEntry) {
				return contactEntry.getEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ContactEntry> getTypeClass() {
				return ContactEntry.class;
			}

		};

}