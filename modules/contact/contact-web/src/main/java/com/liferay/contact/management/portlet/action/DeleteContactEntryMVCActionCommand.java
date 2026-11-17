package com.liferay.contact.management.portlet.action;

import com.liferay.contact.management.constants.ContactPortletKeys;
import com.liferay.contact.management.portlet.ContactPortlet;
import com.liferay.contact.management.service.ContactEntryService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
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
                "mvc.command.name=/contact/deleteContactEntry"
        },
        service = MVCActionCommand.class
)
public class DeleteContactEntryMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long entryId = ParamUtil.getLong(actionRequest, "entryId");

        try {

            _contactEntryService.deleteContactEntry(entryId);

            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", "/contact/addorupdatecontactEntry");

            SessionMessages.add(actionRequest, "deleteContactEntry");
        }

        catch (Exception e) {
            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", "/contact/error");

            Logger.getLogger(ContactPortlet.class.getName()).log(
                    Level.SEVERE, null, e);

            SessionErrors.add(actionRequest, e.getClass().getName());
        }
    }

    @Reference
    private ContactEntryService _contactEntryService;
}
