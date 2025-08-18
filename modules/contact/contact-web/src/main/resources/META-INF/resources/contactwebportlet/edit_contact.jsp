<%@ include file="../init.jsp" %>


<%
long contactId = ParamUtil.getLong(renderRequest, "contactId");

Contact contactModel = null;
if (contactId > 0) {
  contactModel = ContactLocalServiceUtil.getContact(contactId);
}
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/contactwebportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<p>
	<p>"lorem ipsum in edit_contact.jsp"</p>
</p>

<portlet:actionURL name="addContact" var="addContactURL"></portlet:actionURL>

<aui:form action="<%= addContactURL %>" name="<portlet:namespace />fm">

<aui:model-context bean="<%= contactModel %>" model="<%= com.liferay.contact.management.model.Contact.class %>" />

        <aui:fieldset>

            <aui:input name="name"></aui:input>
            <aui:input name="email"></aui:input>
            <aui:input name="phone"></aui:input>
            <aui:input name="address"></aui:input>
            <aui:input name="contactId" type="hidden" value='<%= contactModel == null ? contactId : contactModel.getContactId() %>'/>

        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button onClick="<%= viewURL.toString() %>" value="Cancel" ></aui:button>
        </aui:button-row>
</aui:form>