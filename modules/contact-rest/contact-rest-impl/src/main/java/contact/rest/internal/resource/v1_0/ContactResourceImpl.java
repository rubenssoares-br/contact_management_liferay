package contact.rest.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
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
	public Page<Contact> getContact() throws Exception {
		return Page.of(_contacts.values());
	}

	@Override
	public Contact getIdContact(Integer contactId) {
		return _contacts.get(contactId);
	}

	@Override
	public void deleteContact(Integer contactId) throws Exception {
         _contacts.remove(contactId);
    }
	@Override
	public Contact postContact(Contact contact) {
		if (_contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Duplicate contact ID " + contact.getContactId());
		}

		_contacts.put(contact.getContactId(), contact);

		return contact;
	}

	@Override
	public Contact putContact(Integer contactId, Contact contact) {
		if (_contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Duplicate contact ID " + contact.getContactId());
		}

		_contacts.put(contactId, contact);
		
		return contact;
	}

	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Contact>, UnsafeFunction<Contact, Contact, Exception>, Exception> unsafeBiConsumer) {
	}

	private static final Map<Integer, Contact> _contacts = new Hashtable<Integer, Contact>();

}