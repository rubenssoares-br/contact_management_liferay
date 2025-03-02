package contact.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import contact.rest.dto.v1_0.Contact;
import contact.rest.dto.v1_0.ContactEntry;
import contact.rest.resource.v1_0.ContactEntryResource;
import contact.rest.resource.v1_0.ContactResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Rubens Soares
 * @generated
 */
@Generated("")
public class Mutation {

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

	@GraphQLField
	public Contact createContact(@GraphQLName("contact") Contact contact)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.postContact(contact));
	}

	@GraphQLField
	public Response createContactBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.postContactBatch(
				callbackURL, object));
	}

	@GraphQLField
	public boolean deleteContact(@GraphQLName("contactId") Integer contactId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.deleteContact(contactId));

		return true;
	}

	@GraphQLField
	public Response deleteContactBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.deleteContactBatch(
				callbackURL, object));
	}

	@GraphQLField
	public Contact updateContact(
			@GraphQLName("contactId") Integer contactId,
			@GraphQLName("contact") Contact contact)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.putContact(contactId, contact));
	}

	@GraphQLField
	public Response updateContactBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactResource -> contactResource.putContactBatch(
				callbackURL, object));
	}

	@GraphQLField
	public ContactEntry createContactEntry(
			@GraphQLName("contactId") Integer contactId,
			@GraphQLName("contactEntry") ContactEntry contactEntry)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactEntryResource -> contactEntryResource.postContactEntry(
				contactId, contactEntry));
	}

	@GraphQLField
	public boolean deleteContactEntry(@GraphQLName("entryId") Integer entryId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactEntryResource -> contactEntryResource.deleteContactEntry(
				entryId));

		return true;
	}

	@GraphQLField
	public Response deleteContactEntryBatch(
			@GraphQLName("entryId") Integer entryId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactEntryResource ->
				contactEntryResource.deleteContactEntryBatch(
					entryId, callbackURL, object));
	}

	@GraphQLField
	public ContactEntry updateContactEntry(
			@GraphQLName("entryId") Integer entryId,
			@GraphQLName("contactEntry") ContactEntry contactEntry)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactEntryResource -> contactEntryResource.putContactEntry(
				entryId, contactEntry));
	}

	@GraphQLField
	public Response updateContactEntryBatch(
			@GraphQLName("entryId") Integer entryId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects,
			this::_populateResourceContext,
			contactEntryResource -> contactEntryResource.putContactEntryBatch(
				entryId, callbackURL, object));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}