package com.liferay.contact.management.internal.security.permission.resource;

import com.liferay.contact.management.model.Contact;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Reference;

public class ContactModelResourcePermission implements ModelResourcePermission<Contact> {

    @Override
    public void check(PermissionChecker permissionChecker, long l, String s) throws PortalException {

    }

    @Override
    public void check(PermissionChecker permissionChecker, Contact contact, String s) throws PortalException {

    }

    @Override
    public boolean contains(PermissionChecker permissionChecker, long l, String s) throws PortalException {
        return false;
    }

    @Override
    public boolean contains(PermissionChecker permissionChecker, Contact contact, String s) throws PortalException {
        return false;
    }

    @Override
    public String getModelName() {
        return null;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return null;
    }
}
