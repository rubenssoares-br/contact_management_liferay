package contact.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import contact.rest.internal.graphql.mutation.v1_0.Mutation;
import contact.rest.internal.graphql.query.v1_0.Query;
import contact.rest.resource.v1_0.ContactEntryResource;
import contact.rest.resource.v1_0.ContactResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Rubens Soares
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setContactResourceComponentServiceObjects(
			_contactResourceComponentServiceObjects);
		Mutation.setContactEntryResourceComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects);

		Query.setContactResourceComponentServiceObjects(
			_contactResourceComponentServiceObjects);
		Query.setContactEntryResourceComponentServiceObjects(
			_contactEntryResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/contact-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ContactResource>
		_contactResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ContactEntryResource>
		_contactEntryResourceComponentServiceObjects;

}