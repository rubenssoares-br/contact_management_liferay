package contact.rest.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import contact.rest.dto.v1_0.Contact;
import contact.rest.resource.v1_0.ContactResource;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Rubens Soares
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/contact.properties",
	scope = ServiceScope.PROTOTYPE, service = ContactResource.class
)
public class ContactResourceImpl extends BaseContactResourceImpl {

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Contact>, UnsafeFunction<Contact, Contact, Exception>, Exception> unsafeBiConsumer) {

	}
}