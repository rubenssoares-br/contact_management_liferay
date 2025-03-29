package contact.rest.dto.v1_0.converter;

import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;
import contact.rest.dto.v1_0.Contact;
import org.osgi.service.component.annotations.Component;

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

    public Contact toDTO(DTOConverterContext dtoConverterContext,com.liferay.contact.management.model.Contact serviceBuilderContact) throws Exception {
        return new Contact() {
            {
               setName(serviceBuilderContact::getName);
               setEmail(serviceBuilderContact::getEmail);
               setPhone(Math.toIntExact(serviceBuilderContact.getPhone()));
               setAddress(serviceBuilderContact::getAddress);
               setContactId(Math.toIntExact(serviceBuilderContact.getContactId()));
            }
        };
    }

}
