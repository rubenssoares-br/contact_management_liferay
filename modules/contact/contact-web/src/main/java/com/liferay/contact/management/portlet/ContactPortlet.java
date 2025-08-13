package com.liferay.contact.management.portlet;

import com.liferay.contact.management.constants.ContactPortletKeys;

import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.service.ContactEntryLocalService;
import com.liferay.contact.management.service.ContactLocalService;
import com.liferay.contact.management.service.impl.ContactEntryLocalServiceImpl;
import com.liferay.contact.management.service.impl.ContactLocalServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author me
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.social",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Contact",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/contactwebportlet/view.jsp",
		"javax.portlet.name=" + ContactPortletKeys.CONTACT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ContactPortlet extends MVCPortlet {

	public void addContact(ActionRequest request, ActionResponse response) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Contact.class.getName(), request);

		String name = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		long phone = ParamUtil.getLong(request, "phone");
		String address = ParamUtil.getString(request, "address");
		long contactId = ParamUtil.getLong(request, "contactId");

		if (contactId > 0) {

			try {
				_contactLocalService.updateContact(
						name, contactId, email, phone, address, serviceContext);

				response.setRenderParameter("contactId", Long.toString(contactId));
			}
			catch (Exception e) {
				System.out.println(e);

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter(
						"mvcPath", "contactwebportlet/edit_contact.jsp");
			}
		} else {

			try {
				_contactLocalService.addContact(
						name, email, phone, address, serviceContext);

				SessionMessages.add(request, "contactAdded");

				response.setRenderParameter("contactId", Long.toString(contactId));

			}
			catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter(
						"mvcPath", "contactwebportlet/edit_contact.jsp");
			}
		}
    }

	public void deleteContact(ActionRequest request, ActionResponse response) throws PortalException {

		long contactId = ParamUtil.getLong(request, "contactId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Contact.class.getName(), request);

		try {
			response.setRenderParameter(
					"contactId", Long.toString(contactId));

			_contactLocalService.deleteContact(contactId);
		}

		catch (Exception e) {
			Logger.getLogger(ContactPortlet.class.getName()).log(
					Level.SEVERE, null, e);
		}
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Contact.class.getName(), renderRequest);

			String name = ParamUtil.getString(renderRequest, "name");
			String email = ParamUtil.getString(renderRequest, "email");
			long phone = ParamUtil.getLong(renderRequest, "phone");
			String address = ParamUtil.getString(renderRequest, "address");
			long contactId = ParamUtil.getLong(renderRequest, "contactId");

			List<Contact> contacts = _contactLocalService.getAllContacts();

			if (contacts.isEmpty()) {
				Contact contact = _contactLocalService.addContact(name, email, phone, address, serviceContext);

				contactId = contact.getContactId();
			}

			if (contactId == 0) {
				contactId = contacts.get(0).getContactId();
			}

			renderRequest.setAttribute("contactId", contactId);

		} catch (PortalException e) {
            throw new RuntimeException(e);
        }

        super.render(renderRequest, renderResponse);
	}


	@Reference
	private ContactLocalService _contactLocalService;

	@Reference
	private ContactEntryLocalService _contactEntryLocalService;


}