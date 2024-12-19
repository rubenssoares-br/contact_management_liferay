package contact.rest.internal.resource.v1_0;

import contact.rest.resource.v1_0.ContactEntryResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Rubens Soares
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/contact-entry.properties",
	scope = ServiceScope.PROTOTYPE, service = ContactEntryResource.class
)
public class ContactEntryResourceImpl extends BaseContactEntryResourceImpl {
}