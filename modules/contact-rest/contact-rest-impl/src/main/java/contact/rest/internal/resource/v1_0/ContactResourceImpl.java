package contact.rest.internal.resource.v1_0;

import com.liferay.contact.management.service.ContactService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;

import contact.rest.dto.v1_0.Contact;
import contact.rest.resource.v1_0.ContactResource;

import java.util.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
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
	public Page<Contact> getAllContacts() throws Exception {
		List<com.liferay.contact.management.model.Contact> contactsService = _contactService.getAllContacts();

		List<Contact> contactsRest = new ArrayList<>();

		for (com.liferay.contact.management.model.Contact contactDto : contactsService) {
			contactsRest.add(_contactResourceDTOConverter.toDTO(contactDto));
		}

		return Page.of(contactsRest);
	}

	@Override
	public Contact getIdContact(Integer contactId) throws Exception {
		return _toContact(_contactService.getContact(contactId));
	}

	@Override
	public void deleteContact(Integer contactId) throws Exception {
		_contactService.deleteContact(contactId);
    }
	@Override
	public Contact postContact(Contact contact) throws Exception {
		com.liferay.contact.management.model.Contact serviceBuilderContact = _contactService.addContact(contact.getName(), contact.getEmail(), contact.getPhone(), contact.getAddress(), ServiceContextFactory.getInstance(Contact.class.getName(), contextHttpServletRequest));

		return _toContact(serviceBuilderContact);
	}

	@Override
	public Contact putContact(Integer contactId, Contact contact) {
		if (_contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Duplicate contact ID " + contact.getContactId());
		}

		_contacts.put(contactId, contact);
		
		return contact;
	}

	private Contact _toContact(com.liferay.contact.management.model.Contact serviceBuilderContact) throws Exception {

		return _contactResourceDTOConverter.toDTO(serviceBuilderContact);
	}

	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Contact>, UnsafeFunction<Contact, Contact, Exception>, Exception> unsafeBiConsumer) {
	}

	private static final Map<Integer, Contact> _contacts = new Hashtable<Integer, Contact>();

	@Reference(target = "(component.name=contact.rest.dto.v1_0.converter.ContactResourceDTOConverter)")
	private DTOConverter<com.liferay.contact.management.model.Contact, Contact> _contactResourceDTOConverter;

	@Reference
	private ContactService _contactService;

}