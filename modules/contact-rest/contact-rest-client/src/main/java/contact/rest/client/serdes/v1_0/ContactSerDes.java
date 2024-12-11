package contact.rest.client.serdes.v1_0;

import contact.rest.client.dto.v1_0.Contact;
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
public class ContactSerDes {

	public static Contact toDTO(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToDTO(json);
	}

	public static Contact[] toDTOs(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Contact contact) {
		if (contact == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (contact.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(contact.getAddress()));

			sb.append("\"");
		}

		if (contact.getContactId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactId\": ");

			sb.append(contact.getContactId());
		}

		if (contact.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(contact.getEmail()));

			sb.append("\"");
		}

		if (contact.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(contact.getName()));

			sb.append("\"");
		}

		if (contact.getPhone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phone\": ");

			sb.append(contact.getPhone());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ContactJSONParser contactJSONParser = new ContactJSONParser();

		return contactJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Contact contact) {
		if (contact == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (contact.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(contact.getAddress()));
		}

		if (contact.getContactId() == null) {
			map.put("contactId", null);
		}
		else {
			map.put("contactId", String.valueOf(contact.getContactId()));
		}

		if (contact.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(contact.getEmail()));
		}

		if (contact.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(contact.getName()));
		}

		if (contact.getPhone() == null) {
			map.put("phone", null);
		}
		else {
			map.put("phone", String.valueOf(contact.getPhone()));
		}

		return map;
	}

	public static class ContactJSONParser extends BaseJSONParser<Contact> {

		@Override
		protected Contact createDTO() {
			return new Contact();
		}

		@Override
		protected Contact[] createDTOArray(int size) {
			return new Contact[size];
		}

		@Override
		protected void setField(
			Contact contact, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					contact.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "contactId")) {
				if (jsonParserFieldValue != null) {
					contact.setContactId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					contact.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					contact.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phone")) {
				if (jsonParserFieldValue != null) {
					contact.setPhone(
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