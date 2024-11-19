/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contact.management.service.persistence.impl;

import com.liferay.contact.management.model.ContactEntryTable;
import com.liferay.contact.management.model.impl.ContactEntryImpl;
import com.liferay.contact.management.model.impl.ContactEntryModelImpl;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from ContactEntry.
 *
 * @author Rubens Soares
 * @generated
 */
@Component(
	property = {
		"class.name=com.liferay.contact.management.model.impl.ContactEntryImpl",
		"table.name=CTMG_ContactEntry"
	},
	service = ArgumentsResolver.class
)
public class ContactEntryModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		ContactEntryModelImpl contactEntryModelImpl =
			(ContactEntryModelImpl)baseModel;

		long columnBitmask = contactEntryModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(contactEntryModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					contactEntryModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(ContactEntryPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(contactEntryModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ContactEntryImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ContactEntryTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ContactEntryModelImpl contactEntryModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = contactEntryModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = contactEntryModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= ContactEntryModelImpl.getColumnBitmask(
			"familyRelationship");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}