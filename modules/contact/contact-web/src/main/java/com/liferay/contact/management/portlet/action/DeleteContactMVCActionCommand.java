package com.liferay.contact.management.portlet.action;

import com.liferay.contact.management.constants.ContactPortletKeys;
import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.portlet.ContactPortlet;
import com.liferay.contact.management.service.ContactLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component(
        property = {
                "javax.portlet.name=" + ContactPortletKeys.CONTACT,
                "mvc.command.name=/contact/deleteContact"
        },
        service = MVCActionCommand.class
)
public class DeleteContactMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long contactId = ParamUtil.getLong(actionRequest, "contactId");

        try {

            _contactLocalService.deleteContact(contactId);

            sendRedirect(actionRequest, actionResponse, "contact?p_p_id=com_liferay_contact_management_ContactPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_com_liferay_contact_management_ContactPortlet_mvcRenderCommandName=%2Fcontact%2Faddorupdatecontact");
        }

        catch (Exception e) {
            sendRedirect(actionRequest, actionResponse, "/contact/error");

            Logger.getLogger(ContactPortlet.class.getName()).log(
                    Level.SEVERE, null, e);
        }
    }

    @Reference
    private ContactLocalService _contactLocalService;
}
