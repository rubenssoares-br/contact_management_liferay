<%@ include file="../init.jsp" %>

<%
long contactId = ParamUtil.getLong(renderRequest, "contactId");

Contact contactModel = null;
if (contactId > 0) {
  contactModel = ContactLocalServiceUtil.getContact(contactId);
}
%>

<h2>EDIT CONTACT JSP</h2>

<h2>FORM TO ADD OR UPDATE CONTACT</h2>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/contactwebportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="/contact/addorupdatecontact" var="addContactURL"></portlet:actionURL>

<aui:form action="<%= addContactURL %>" name="<portlet:namespace />fm">

<aui:model-context bean="<%= contactModel %>" model="<%= com.liferay.contact.management.model.Contact.class %>" />

        <aui:fieldset>

            <aui:input name="name"></aui:input>
            <aui:input name="email"></aui:input>
            <aui:input name="phone"></aui:input>
            <aui:input name="address"></aui:input>
            <aui:input name="contactId"></aui:input>

        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit" value="Add/Update Contact"></aui:button>
            <aui:button onClick="<%= viewURL.toString() %>" value="Cancel" ></aui:button>
        </aui:button-row>
</aui:form>

<h2>DELETE CONTACT</h2>

<portlet:actionURL name="/contact/deleteContact" var="deleteContactURL"></portlet:actionURL>

<aui:form action="<%= deleteContactURL %>" name="<portlet:namespace />fm">

<aui:model-context bean="<%= contactModel %>" model="<%= com.liferay.contact.management.model.Contact.class %>" />

      <aui:input name="contactId"></aui:input>

      <aui:button-row>
         <aui:button type="submit" value="Delete"></aui:button>
      </aui:button-row>
</aui:form>