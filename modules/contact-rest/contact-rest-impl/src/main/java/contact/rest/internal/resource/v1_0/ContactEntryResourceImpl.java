package contact.rest.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.vulcan.pagination.Page;
import contact.rest.dto.v1_0.ContactEntry;
import contact.rest.resource.v1_0.ContactEntryResource;

import org.osgi.service.component.annotations.Component;
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
	public Page<ContactEntry> getContactEntries(Integer contactId) throws PortalException {
		List<ContactEntry> contactsEntries = new ArrayList<>();

		for (ContactEntry contactEntry : _contactEntries.values()) {
			if (Objects.equals(contactId, contactEntry.getContactId())) {
				contactsEntries.add(contactEntry);
			}
		}
		return Page.of(contactsEntries);
	}

	@Override
	public ContactEntry getContactEntryId(Integer entryId) throws PortalException {
		return _contactEntries.get(entryId);
	}

	public void deleteContactEntry(Integer entryId) throws PortalException {
		_contactEntries.remove(entryId);
	}

	@Override
	public ContactEntry postContactEntry(Integer contactId, ContactEntry contactEntry) throws PortalException {
		if (_contactEntries.containsKey(contactEntry.getEntryId())) {
			throw new IllegalArgumentException("Duplicate entry ID" + contactEntry.getEntryId());
		}

		contactEntry.setContactId(contactId);

		_contactEntries.put(contactEntry.getEntryId(), contactEntry);

		return contactEntry;
	}

	public ContactEntry putContactEntry(Integer entryId, ContactEntry contactEntry) throws PortalException{
		_contactEntries.put(entryId, contactEntry);

		return contactEntry;
	}


	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<ContactEntry>, UnsafeFunction<ContactEntry, ContactEntry, Exception>, Exception> unsafeBiConsumer) {
	}

	private static final Map<Integer, ContactEntry> _contactEntries = new Hashtable<Integer, ContactEntry>();
}