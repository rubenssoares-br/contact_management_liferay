package contact.rest.internal.resource.v1_0;

import com.liferay.contact.management.service.ContactEntryService;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.pagination.Page;
import contact.rest.dto.v1_0.ContactEntry;
import contact.rest.resource.v1_0.ContactEntryResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.*;

/**
 * @author Rubens Soares
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/contact-entry.properties",
	scope = ServiceScope.PROTOTYPE, service = ContactEntryResource.class
)
public class ContactEntryResourceImpl extends BaseContactEntryResourceImpl {

	@Override
	public Page<ContactEntry> getAllContactEntries() throws Exception {
	List<com.liferay.contact.management.model.ContactEntry> contactsEntryService = _contactEntryService.getAllContactsEntries();

	List<ContactEntry> contactEntriesRest = new ArrayList<>();

	for (com.liferay.contact.management.model.ContactEntry contactsEntryDTO : contactsEntryService) {
		contactEntriesRest.add(_toContactEntry(contactsEntryDTO));
	}

	return Page.of(contactEntriesRest);
	}

	@Override
	public ContactEntry getContactEntryId(Integer entryId) throws Exception {
		return _toContactEntry(_contactEntryService.getContactEntry(entryId));
	}

	public void deleteContactEntry(Integer entryId) throws PortalException {
		_contactEntryService.deleteContactEntry(entryId);
	}

	@Override
	public ContactEntry postContactEntry(Integer contactId, ContactEntry contactEntry) throws Exception {
		com.liferay.contact.management.model.ContactEntry serviceBuilderContactEntry = _contactEntryService.addContactEntry(contactEntry.getFamilyRelationship(), contactEntry.getPhone(), contactEntry.getAddress(), contactId, ServiceContextFactory.getInstance(ContactEntry.class.getName(), contextHttpServletRequest));

		return _toContactEntry(serviceBuilderContactEntry);
	}

	@Override
	public ContactEntry putContactEntry(Integer entryId, ContactEntry contactEntry) throws Exception{
		com.liferay.contact.management.model.ContactEntry serviceBuilderContactEntry = _contactEntryService.updateContactEntry(contactEntry.getFamilyRelationship(), entryId, contactEntry.getPhone(), contactEntry.getAddress(), contactEntry.getContactId(), ServiceContextFactory.getInstance(ContactEntry.class.getName(), contextHttpServletRequest));

		return _toContactEntry(serviceBuilderContactEntry);
	}


	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<ContactEntry>, UnsafeFunction<ContactEntry, ContactEntry, Exception>, Exception> unsafeBiConsumer) {
	}

	private ContactEntry _toContactEntry(com.liferay.contact.management.model.ContactEntry serviceBuilderContactEntry) throws Exception {

		return _contactEntryResourceDTOConverter.toDTO(serviceBuilderContactEntry);
	}

	private static final Map<Integer, ContactEntry> _contactEntries = new Hashtable<Integer, ContactEntry>();

	@Reference(target = "(component.name=contact.rest.dto.v1_0.converter.ContactEntryResourceDTOConverter)")
	private DTOConverter<com.liferay.contact.management.model.ContactEntry, ContactEntry> _contactEntryResourceDTOConverter;

	@Reference
	private ContactEntryService _contactEntryService;
}