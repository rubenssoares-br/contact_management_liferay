package com.liferay.contact.management.internal.security.permission.resource;

import com.liferay.contact.management.constants.ContactConstants;
import com.liferay.portal.kernel.security.permission.resource.BasePortletResourcePermissionWrapper;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import org.osgi.service.component.annotations.Component;

/**
 * @author Rubens Soares
 */
@Component(
        property = "resource.name=" + ContactConstants.RESOURCE_NAME,
        service = PortletResourcePermission.class
)
public class ContactPortletResourcePermissionWrapper extends BasePortletResourcePermissionWrapper {

    @Override
    protected PortletResourcePermission doGetPortletResourcePermission() {
        return PortletResourcePermissionFactory.create(
                ContactConstants.RESOURCE_NAME);
    }
}
