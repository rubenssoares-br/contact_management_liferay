package com.liferay.contact.management.portlet.action;

import com.liferay.contact.management.constants.ContactPortletKeys;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.contact.management.service.ContactEntryLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        property = {
                "javax.portlet.name=" + ContactPortletKeys.CONTACT,
                "mvc.command.name=/contact/addorupdatecontactentry"
        },
        service = MVCActionCommand.class
)
public class AddOrUpdateContactEntryMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(ContactEntry.class.getName(), actionRequest);

        String familyRelationship = ParamUtil.getString(actionRequest, "name");
        long phone = ParamUtil.getLong(actionRequest, "phone");
        String address = ParamUtil.getString(actionRequest, "address");
        long contactId = ParamUtil.getLong(actionRequest, "contactId");
        long entryId = ParamUtil.getLong(actionRequest, "entryId");

        if (entryId > 0) {

            try {
                _contactEntryLocalService.updateContactEntry(
                        familyRelationship, entryId, phone, address, contactId, serviceContext);

                actionResponse.setRenderParameter(
                        "mvcRenderCommandName", "/contact/addorupdatecontactentry");
            }
            catch (Exception e) {
                System.out.println(e);

                actionResponse.setRenderParameter(
                        "mvcRenderCommandName", "/contact/error");
            }
        } else {

            try {
                _contactEntryLocalService.addContactEntry(familyRelationship, phone, address, contactId, serviceContext);

                actionResponse.setRenderParameter(
                        "mvcRenderCommandName", "/contact/addorupdatecontactentry");
            }
            catch (Exception e) {
                System.out.println(e);

                actionResponse.setRenderParameter(
                        "mvcRenderCommandName", "/contact/error");
            }

        }

    }

    @Reference
    private ContactEntryLocalService _contactEntryLocalService;
}
