package com.liferay.contact.management.portlet.action;

import com.liferay.contact.management.constants.ContactPortletKeys;
import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.ContactEntryLocalService;
import com.liferay.contact.management.service.ContactLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        property = {
            "javax.portlet.name=" + ContactPortletKeys.CONTACT,
            "mvc.command.name=/contact/addorupdatecontact"
        },
        service = MVCActionCommand.class
)
public class AddOrUpdateContactMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Contact.class.getName(), actionRequest);

        String name = ParamUtil.getString(actionRequest, "name");
        String email = ParamUtil.getString(actionRequest, "email");
        long phone = ParamUtil.getLong(actionRequest, "phone");
        String address = ParamUtil.getString(actionRequest, "address");
        long contactId = ParamUtil.getLong(actionRequest, "contactId");

        if (contactId > 0) {

            try {
                _contactLocalService.updateContact(
                        name, contactId, email, phone, address, serviceContext);

                sendRedirect(actionRequest, actionResponse, "https://www.terra.com/");
            }
            catch (Exception e) {
                System.out.println(e);

                PortalUtil.copyRequestParameters(actionRequest, actionResponse);

                sendRedirect(actionRequest, actionResponse, "/contact/error");

            }
        } else {

            try {
                _contactLocalService.addContact(
                        name, email, phone, address, serviceContext);

                SessionMessages.add(actionRequest, "contactAdded");


                sendRedirect(actionRequest, actionResponse, "/contact/addorupdatecontact");

            }
            catch (Exception e) {
                SessionErrors.add(actionRequest, e.getClass().getName());

                PortalUtil.copyRequestParameters(actionRequest, actionResponse);

                sendRedirect(actionRequest, actionResponse, "/contact/error");
            }
        }
    }

    @Reference
    private ContactLocalService _contactLocalService;

    @Reference
    private ContactEntryLocalService _contactEntryLocalService;
}
