/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CTMG_Contact&quot; database table.
 *
 * @author Rubens Soares
 * @see Contact
 * @generated
 */
public class ContactTable extends BaseTable<ContactTable> {

	public static final ContactTable INSTANCE = new ContactTable();

	public final Column<ContactTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactTable, Long> contactId = createColumn(
		"contactId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ContactTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactTable, Long> phone = createColumn(
		"phone", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ContactTable() {
		super("CTMG_Contact", ContactTable::new);
	}

}