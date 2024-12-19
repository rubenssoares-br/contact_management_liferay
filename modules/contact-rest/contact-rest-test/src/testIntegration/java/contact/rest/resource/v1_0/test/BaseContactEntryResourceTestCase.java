package contact.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import contact.rest.client.dto.v1_0.ContactEntry;
import contact.rest.client.http.HttpInvoker;
import contact.rest.client.pagination.Page;
import contact.rest.client.resource.v1_0.ContactEntryResource;
import contact.rest.client.serdes.v1_0.ContactEntrySerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Rubens Soares
 * @generated
 */
@Generated("")
public abstract class BaseContactEntryResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_contactEntryResource.setContextCompany(testCompany);

		ContactEntryResource.Builder builder = ContactEntryResource.builder();

		contactEntryResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		ContactEntry contactEntry1 = randomContactEntry();

		String json = objectMapper.writeValueAsString(contactEntry1);

		ContactEntry contactEntry2 = ContactEntrySerDes.toDTO(json);

		Assert.assertTrue(equals(contactEntry1, contactEntry2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		ContactEntry contactEntry = randomContactEntry();

		String json1 = objectMapper.writeValueAsString(contactEntry);
		String json2 = ContactEntrySerDes.toJSON(contactEntry);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		ContactEntry contactEntry = randomContactEntry();

		contactEntry.setAddress(regex);
		contactEntry.setFamilyRelationship(regex);

		String json = ContactEntrySerDes.toJSON(contactEntry);

		Assert.assertFalse(json.contains(regex));

		contactEntry = ContactEntrySerDes.toDTO(json);

		Assert.assertEquals(regex, contactEntry.getAddress());
		Assert.assertEquals(regex, contactEntry.getFamilyRelationship());
	}

	@Test
	public void testGetContactEntries() throws Exception {
		Integer contactId = testGetContactEntries_getContactId();
		Integer irrelevantContactId =
			testGetContactEntries_getIrrelevantContactId();

		Page<ContactEntry> page = contactEntryResource.getContactEntries(
			contactId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantContactId != null) {
			ContactEntry irrelevantContactEntry =
				testGetContactEntries_addContactEntry(
					irrelevantContactId, randomIrrelevantContactEntry());

			page = contactEntryResource.getContactEntries(irrelevantContactId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantContactEntry),
				(List<ContactEntry>)page.getItems());
			assertValid(page);
		}

		ContactEntry contactEntry1 = testGetContactEntries_addContactEntry(
			contactId, randomContactEntry());

		ContactEntry contactEntry2 = testGetContactEntries_addContactEntry(
			contactId, randomContactEntry());

		page = contactEntryResource.getContactEntries(contactId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(contactEntry1, contactEntry2),
			(List<ContactEntry>)page.getItems());
		assertValid(page);
	}

	protected ContactEntry testGetContactEntries_addContactEntry(
			Integer contactId, ContactEntry contactEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Integer testGetContactEntries_getContactId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Integer testGetContactEntries_getIrrelevantContactId()
		throws Exception {

		return null;
	}

	@Test
	public void testGraphQLGetContactEntries() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPostContactEntry() throws Exception {
		ContactEntry randomContactEntry = randomContactEntry();

		ContactEntry postContactEntry = testPostContactEntry_addContactEntry(
			randomContactEntry);

		assertEquals(randomContactEntry, postContactEntry);
		assertValid(postContactEntry);
	}

	protected ContactEntry testPostContactEntry_addContactEntry(
			ContactEntry contactEntry)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteContactEntry() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteContactEntry() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetContactEntryId() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetContactEntryId() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetContactEntryIdNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutContactEntry() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(
		ContactEntry contactEntry, List<ContactEntry> contactEntries) {

		boolean contains = false;

		for (ContactEntry item : contactEntries) {
			if (equals(contactEntry, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			contactEntries + " does not contain " + contactEntry, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		ContactEntry contactEntry1, ContactEntry contactEntry2) {

		Assert.assertTrue(
			contactEntry1 + " does not equal " + contactEntry2,
			equals(contactEntry1, contactEntry2));
	}

	protected void assertEquals(
		List<ContactEntry> contactEntries1,
		List<ContactEntry> contactEntries2) {

		Assert.assertEquals(contactEntries1.size(), contactEntries2.size());

		for (int i = 0; i < contactEntries1.size(); i++) {
			ContactEntry contactEntry1 = contactEntries1.get(i);
			ContactEntry contactEntry2 = contactEntries2.get(i);

			assertEquals(contactEntry1, contactEntry2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<ContactEntry> contactEntries1,
		List<ContactEntry> contactEntries2) {

		Assert.assertEquals(contactEntries1.size(), contactEntries2.size());

		for (ContactEntry contactEntry1 : contactEntries1) {
			boolean contains = false;

			for (ContactEntry contactEntry2 : contactEntries2) {
				if (equals(contactEntry1, contactEntry2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				contactEntries2 + " does not contain " + contactEntry1,
				contains);
		}
	}

	protected void assertValid(ContactEntry contactEntry) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (contactEntry.getAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("contactId", additionalAssertFieldName)) {
				if (contactEntry.getContactId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("entryId", additionalAssertFieldName)) {
				if (contactEntry.getEntryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"familyRelationship", additionalAssertFieldName)) {

				if (contactEntry.getFamilyRelationship() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phone", additionalAssertFieldName)) {
				if (contactEntry.getPhone() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<ContactEntry> page) {
		boolean valid = false;

		java.util.Collection<ContactEntry> contactEntries = page.getItems();

		int size = contactEntries.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(contact.rest.dto.v1_0.ContactEntry.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		ContactEntry contactEntry1, ContactEntry contactEntry2) {

		if (contactEntry1 == contactEntry2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactEntry1.getAddress(),
						contactEntry2.getAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("contactId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactEntry1.getContactId(),
						contactEntry2.getContactId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("entryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactEntry1.getEntryId(),
						contactEntry2.getEntryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"familyRelationship", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						contactEntry1.getFamilyRelationship(),
						contactEntry2.getFamilyRelationship())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						contactEntry1.getPhone(), contactEntry2.getPhone())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_contactEntryResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_contactEntryResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, ContactEntry contactEntry) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("address")) {
			sb.append("'");
			sb.append(String.valueOf(contactEntry.getAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("contactId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("entryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("familyRelationship")) {
			sb.append("'");
			sb.append(String.valueOf(contactEntry.getFamilyRelationship()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phone")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected ContactEntry randomContactEntry() throws Exception {
		return new ContactEntry() {
			{
				address = StringUtil.toLowerCase(RandomTestUtil.randomString());
				contactId = RandomTestUtil.randomInt();
				entryId = RandomTestUtil.randomInt();
				familyRelationship = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				phone = RandomTestUtil.randomInt();
			}
		};
	}

	protected ContactEntry randomIrrelevantContactEntry() throws Exception {
		ContactEntry randomIrrelevantContactEntry = randomContactEntry();

		return randomIrrelevantContactEntry;
	}

	protected ContactEntry randomPatchContactEntry() throws Exception {
		return randomContactEntry();
	}

	protected ContactEntryResource contactEntryResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseContactEntryResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private contact.rest.resource.v1_0.ContactEntryResource
		_contactEntryResource;

}