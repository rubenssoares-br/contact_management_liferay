package contact.rest.dto.v1_0.converter;

import com.liferay.contact.management.service.ContactService;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import contact.rest.dto.v1_0.Contact;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rubens Soares
 */
@Component(property = "dto.class.name=com.liferay.contact.management.model.Contact",
service = DTOConverter.class)
public class ContactResourceDTOConverter implements DTOConverter<com.liferay.contact.management.model.Contact, Contact> {

    @Override
    public String getContentType() {
        return Contact.class.getSimpleName();
    }   



    @Reference
    private ContactService _contactService;

}
