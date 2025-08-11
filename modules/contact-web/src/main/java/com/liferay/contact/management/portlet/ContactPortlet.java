package com.liferay.contact.management.portlet;

import com.liferay.contact.management.constants.ContactPortletKeys;

import com.liferay.contact.management.model.Entry;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;

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
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Contact",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ContactPortletKeys.CONTACT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ContactPortlet extends MVCPortlet {

	public void addContact(ActionRequest request, ActionResponse response) {
		try {
			PortletPreferences prefs = request.getPreferences();

			String[] contactEntries = prefs.getValues("contact-entries", new String[4]);

			ArrayList<String> entries = new ArrayList<>();

			if (contactEntries[0] != null) {
				entries = new ArrayList<>(Arrays.asList(prefs.getValues("contact-entries", new String[4])));
			}

			String name = ParamUtil.getString(request, "name");
			String email = ParamUtil.getString(request, "email");
			String phone = ParamUtil.getString(request, "phone");
			String address = ParamUtil.getString(request, "address");

			String entry = name + "^" + email + "^" + phone + "^" + address;

			entries.add(entry);

			String[] array = entries.toArray(new String[entries.size()]);

			prefs.setValue("contact-entries", Arrays.toString(array));

			try {
				prefs.store();
			}
			catch (IOException e) {
				Logger.getLogger(ContactPortlet.class.getName()).log(
						Level.SEVERE, null, e);
			}
			catch (ValidatorException e) {
				Logger.getLogger(ContactPortlet.class.getName()).log(
						Level.SEVERE, null, e);
			}


		} catch (ReadOnlyException e) {
			Logger.getLogger(ContactPortlet.class.getName()).log(
					Level.SEVERE, null, e);
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
}