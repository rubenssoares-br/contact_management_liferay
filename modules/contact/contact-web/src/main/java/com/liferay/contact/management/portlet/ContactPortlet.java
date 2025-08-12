package com.liferay.contact.management.portlet;

import com.liferay.contact.management.constants.ContactPortletKeys;

import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.model.Entry;
import com.liferay.contact.management.service.ContactEntryLocalService;
import com.liferay.contact.management.service.ContactLocalService;
import com.liferay.contact.management.service.impl.ContactEntryLocalServiceImpl;
import com.liferay.contact.management.service.impl.ContactLocalServiceImpl;
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

	public void addContact(ActionRequest request, ActionResponse response) {

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

	private List<Entry> parseEntries(String[] contactEntries) {
		List<Entry> entries = new ArrayList<>();

		for (String entry : contactEntries) {
			String[] parts = entry.split("\\^", 4);
			Entry gbEntry  = new Entry(parts[0], parts[1], parts[2], parts[3]);
			entries.add(gbEntry);
		}

		return entries;
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		PortletPreferences prefs = renderRequest.getPreferences();

		String[] contactEntries = prefs.getValues("contact-entries", new String[4]);

		if (contactEntries[0] != null) {
			List<Entry> entries = parseEntries(contactEntries);
			renderRequest.setAttribute("entries", entries);
		}

		super.render(renderRequest, renderResponse);
	}


	@Reference
	private ContactLocalService _contactLocalService;

	@Reference
	private ContactEntryLocalService _contactEntryLocalService;


}