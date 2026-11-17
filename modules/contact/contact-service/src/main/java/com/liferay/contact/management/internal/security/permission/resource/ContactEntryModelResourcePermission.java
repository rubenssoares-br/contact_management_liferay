package com.liferay.contact.management.internal.security.permission.resource;

import com.liferay.contact.management.model.Contact;
import com.liferay.contact.management.model.ContactEntry;
import com.liferay.contact.management.service.ContactEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * A ContactEntry has no permission rows of its own. Every check is delegated
 * to the parent Contact loaded from the database: VIEW on the entry needs VIEW
 * on the contact, and any change to the entry needs UPDATE on the contact.
 */
@Component(
	property = "model.class.name=com.liferay.contact.management.model.ContactEntry",
	service = ModelResourcePermission.class
)
public class ContactEntryModelResourcePermission
	implements ModelResourcePermission<ContactEntry> {

	@Override
	public void check(
			PermissionChecker permissionChecker, ContactEntry contactEntry,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, contactEntry, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ContactEntry.class.getName(),
				contactEntry.getEntryId(), actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, entryId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, ContactEntry.class.getName(), entryId,
				actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, ContactEntry contactEntry,
			String actionId)
		throws PortalException {

		return _contactModelResourcePermission.contains(
			permissionChecker, contactEntry.getContactId(),
			_toContactActionId(actionId));
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException {

		ContactEntry contactEntry = _contactEntryLocalService.fetchContactEntry(
			entryId);

		if (contactEntry == null) {
			return false;
		}

		return contains(permissionChecker, contactEntry, actionId);
	}

	@Override
	public String getModelName() {
		return ContactEntry.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return _contactModelResourcePermission.getPortletResourcePermission();
	}

	private String _toContactActionId(String actionId) {
		if (ActionKeys.VIEW.equals(actionId)) {
			return ActionKeys.VIEW;
		}

		return ActionKeys.UPDATE;
	}

	@Reference
	private ContactEntryLocalService _contactEntryLocalService;

	@Reference(
		target = "(model.class.name=com.liferay.contact.management.model.Contact)"
	)
	private ModelResourcePermission<Contact> _contactModelResourcePermission;

}
