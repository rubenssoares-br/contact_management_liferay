package com.liferay.contact.management.internal.security.permission.resource;

import com.liferay.contact.management.constants.ContactConstants;
import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.ContactLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = "model.class.name=com.liferay.contact.management.model.Contact",
        service = ModelResourcePermission.class
)
public class ContactModelResourcePermission implements ModelResourcePermission<Contact> {

    @Override
    public void check(PermissionChecker permissionChecker, Contact contact, String actionId) throws PortalException {

        if (!contains(permissionChecker, contact, actionId)) {
            throw new PrincipalException.MustHavePermission(permissionChecker, Contact.class.getName(), contact.getContactId(), actionId);
        }
    }

    @Override
    public void check(PermissionChecker permissionChecker, long contactId, String actionId) throws PortalException {

        if (!contains(permissionChecker, contactId, actionId)) {
            throw new PrincipalException.MustHavePermission(permissionChecker, Contact.class.getName(), contactId, actionId);
        }
    }

    @Override
    public boolean contains(PermissionChecker permissionChecker, Contact contact, String actionId) throws PortalException {

        if (permissionChecker.hasOwnerPermission(contact.getCompanyId(), Contact.class.getName(), contact.getContactId(), contact.getUserId(), actionId)) {
            return true;
        }

        return permissionChecker.hasPermission(contact.getGroupId(), Contact.class.getName(), contact.getContactId(), actionId);
    }

    @Override
    public boolean contains(PermissionChecker permissionChecker, long contactId, String actionId) throws PortalException {

        Contact contact = _contactLocalService.fetchContact(contactId);

        if (contact == null) {
            return false;
        }

        return contains(permissionChecker, contact, actionId);
    }

    @Override
    public String getModelName() {
        return Contact.class.getName();
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return _portletResourcePermission;
    }

    @Reference
    private ContactLocalService _contactLocalService;

    @Reference(target = "(resource.name=" + ContactConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;
}
