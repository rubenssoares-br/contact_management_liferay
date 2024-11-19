/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CTMG_ContactEntry&quot; database table.
 *
 * @author Rubens Soares
 * @see ContactEntry
 * @generated
 */
public class ContactEntryTable extends BaseTable<ContactEntryTable> {

	public static final ContactEntryTable INSTANCE = new ContactEntryTable();

	public final Column<ContactEntryTable, Long> entryId = createColumn(
		"entryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ContactEntryTable, String> familyRelationship =
		createColumn(
			"familyRelationship", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ContactEntryTable, Long> phone = createColumn(
		"phone", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactEntryTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactEntryTable, Long> contactId = createColumn(
		"contactId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ContactEntryTable() {
		super("CTMG_ContactEntry", ContactEntryTable::new);
	}

}