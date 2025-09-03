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

	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		long contactId = ParamUtil.getLong(renderRequest, "contactId");

		renderRequest.setAttribute("contactId", contactId);

		super.render(renderRequest, renderResponse);
    }
}