package contact.rest.client.serdes.v1_0;

import contact.rest.client.dto.v1_0.ContactEntry;
import contact.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Rubens Soares
 * @generated
 */
@Generated("")
public class ContactEntrySerDes {

	public static ContactEntry toDTO(String json) {
		ContactEntryJSONParser contactEntryJSONParser =
			new ContactEntryJSONParser();

		return contactEntryJSONParser.parseToDTO(json);
	}

	public static ContactEntry[] toDTOs(String json) {
		ContactEntryJSONParser contactEntryJSONParser =
			new ContactEntryJSONParser();

		return contactEntryJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ContactEntry contactEntry) {
		if (contactEntry == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (contactEntry.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(contactEntry.getAddress()));

			sb.append("\"");
		}

		if (contactEntry.getContactId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactId\": ");

			sb.append(contactEntry.getContactId());
		}

		if (contactEntry.getEntryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"entryId\": ");

			sb.append(contactEntry.getEntryId());
		}

		if (contactEntry.getFamilyRelationship() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"familyRelationship\": ");

			sb.append("\"");

			sb.append(_escape(contactEntry.getFamilyRelationship()));

			sb.append("\"");
		}

		if (contactEntry.getPhone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phone\": ");

			sb.append(contactEntry.getPhone());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ContactEntryJSONParser contactEntryJSONParser =
			new ContactEntryJSONParser();

		return contactEntryJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ContactEntry contactEntry) {
		if (contactEntry == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (contactEntry.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(contactEntry.getAddress()));
		}

		if (contactEntry.getContactId() == null) {
			map.put("contactId", null);
		}
		else {
			map.put("contactId", String.valueOf(contactEntry.getContactId()));
		}

		if (contactEntry.getEntryId() == null) {
			map.put("entryId", null);
		}
		else {
			map.put("entryId", String.valueOf(contactEntry.getEntryId()));
		}

		if (contactEntry.getFamilyRelationship() == null) {
			map.put("familyRelationship", null);
		}
		else {
			map.put(
				"familyRelationship",
				String.valueOf(contactEntry.getFamilyRelationship()));
		}

		if (contactEntry.getPhone() == null) {
			map.put("phone", null);
		}
		else {
			map.put("phone", String.valueOf(contactEntry.getPhone()));
		}

		return map;
	}

	public static class ContactEntryJSONParser
		extends BaseJSONParser<ContactEntry> {

		@Override
		protected ContactEntry createDTO() {
			return new ContactEntry();
		}

		@Override
		protected ContactEntry[] createDTOArray(int size) {
			return new ContactEntry[size];
		}

		@Override
		protected void setField(
			ContactEntry contactEntry, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					contactEntry.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "contactId")) {
				if (jsonParserFieldValue != null) {
					contactEntry.setContactId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "entryId")) {
				if (jsonParserFieldValue != null) {
					contactEntry.setEntryId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "familyRelationship")) {

				if (jsonParserFieldValue != null) {
					contactEntry.setFamilyRelationship(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phone")) {
				if (jsonParserFieldValue != null) {
					contactEntry.setPhone(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}