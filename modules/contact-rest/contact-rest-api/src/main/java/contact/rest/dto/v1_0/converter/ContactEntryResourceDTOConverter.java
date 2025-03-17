package contact.rest.dto.v1_0.converter;

import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import contact.rest.dto.v1_0.ContactEntry;
import org.osgi.service.component.annotations.Component;

/**
 * @author Rubens Soares
 */
@Component(property = "dto.class.name=com.liferay.contact.management.model.ContactEntry",
        service = DTOConverter.class)
public class ContactEntryResourceDTOConverter implements DTOConverter<com.liferay.contact.management.model.ContactEntry, ContactEntry> {

    @Override
    public String getContentType() {
        return ContactEntry.class.getSimpleName();
    }
}
