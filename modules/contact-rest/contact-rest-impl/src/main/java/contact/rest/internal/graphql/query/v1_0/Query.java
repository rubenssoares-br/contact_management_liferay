package contact.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;

import contact.rest.dto.v1_0.Contact;
import contact.rest.dto.v1_0.ContactEntry;
import contact.rest.resource.v1_0.ContactEntryResource;
import contact.rest.resource.v1_0.ContactResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Rubens Soares
 * @generated
 */
@Generated("")
public class Query {

	public static void setContactResourceComponentServiceObjects(
		ComponentServiceObjects<ContactResource>
			contactResourceComponentServiceObjects) {

		_contactResourceComponentServiceObjects =
			contactResourceComponentServiceObjects;
	}

	public static void setContactEntryResourceComponentServiceObjects(
		ComponentServiceObjects<ContactEntryResource>
			contactEntryResourceComponentServiceObjects) {

		_contactEntryResourceComponentServiceObjects =
			contactEntryResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {contact{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ContactPage contact() throws Exception {
		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> new ContactPage(contactResource.getContact()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {idContact(contactId: ___){contactId, name, email, phone, address}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Contact idContact(@GraphQLName("contactId") Integer contactId)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.getIdContact(contactId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {contactEntries(contactId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ContactEntryPage contactEntries(
			@GraphQLName("contactId") Integer contactId)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactEntryResource -> new ContactEntryPage(
				contactEntryResource.getContactEntries(contactId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {contactEntryId(entryId: ___){entryId, familyRelationship, phone, address, contactId}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ContactEntry contactEntryId(@GraphQLName("entryId") Integer entryId)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactEntryResource -> contactEntryResource.getContactEntryId(
				entryId));
	}

	@GraphQLTypeExtension(ContactEntry.class)
	public class GetContactEntryIdTypeExtension {

		public GetContactEntryIdTypeExtension(ContactEntry contactEntry) {
			_contactEntry = contactEntry;
		}

		@GraphQLField
		public ContactEntry id() throws Exception {
			return _applyComponentServiceObjects(
				_contactEntryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				contactEntryResource -> contactEntryResource.getContactEntryId(
					_contactEntry.getEntryId()));
		}

		private ContactEntry _contactEntry;

	}

	@GraphQLTypeExtension(Contact.class)
	public class GetContactEntriesTypeExtension {

		public GetContactEntriesTypeExtension(Contact contact) {
			_contact = contact;
		}

		@GraphQLField
		public ContactEntryPage entries() throws Exception {
			return _applyComponentServiceObjects(
				_contactEntryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				contactEntryResource -> new ContactEntryPage(
					contactEntryResource.getContactEntries(
						_contact.getContactId())));
		}

		private Contact _contact;

	}

	@GraphQLTypeExtension(ContactEntry.class)
	public class GetIdContactTypeExtension {

		public GetIdContactTypeExtension(ContactEntry contactEntry) {
			_contactEntry = contactEntry;
		}

		@GraphQLField
		public Contact idContact() throws Exception {
			return _applyComponentServiceObjects(
				_contactResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				contactResource -> contactResource.getIdContact(
					_contactEntry.getContactId()));
		}

		private ContactEntry _contactEntry;

	}

	@GraphQLName("ContactPage")
	public class ContactPage {

		public ContactPage(Page contactPage) {
			actions = contactPage.getActions();

			items = contactPage.getItems();
			lastPage = contactPage.getLastPage();
			page = contactPage.getPage();
			pageSize = contactPage.getPageSize();
			totalCount = contactPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Contact> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ContactEntryPage")
	public class ContactEntryPage {

		public ContactEntryPage(Page contactEntryPage) {
			actions = contactEntryPage.getActions();

			items = contactEntryPage.getItems();
			lastPage = contactEntryPage.getLastPage();
			page = contactEntryPage.getPage();
			pageSize = contactEntryPage.getPageSize();
			totalCount = contactEntryPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<ContactEntry> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(ContactResource contactResource)
		throws Exception {

		contactResource.setContextAcceptLanguage(_acceptLanguage);
		contactResource.setContextCompany(_company);
		contactResource.setContextHttpServletRequest(_httpServletRequest);
		contactResource.setContextHttpServletResponse(_httpServletResponse);
		contactResource.setContextUriInfo(_uriInfo);
		contactResource.setContextUser(_user);
		contactResource.setGroupLocalService(_groupLocalService);
		contactResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			ContactEntryResource contactEntryResource)
		throws Exception {

		contactEntryResource.setContextAcceptLanguage(_acceptLanguage);
		contactEntryResource.setContextCompany(_company);
		contactEntryResource.setContextHttpServletRequest(_httpServletRequest);
		contactEntryResource.setContextHttpServletResponse(
			_httpServletResponse);
		contactEntryResource.setContextUriInfo(_uriInfo);
		contactEntryResource.setContextUser(_user);
		contactEntryResource.setGroupLocalService(_groupLocalService);
		contactEntryResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<ContactResource>
		_contactResourceComponentServiceObjects;
	private static ComponentServiceObjects<ContactEntryResource>
		_contactEntryResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}