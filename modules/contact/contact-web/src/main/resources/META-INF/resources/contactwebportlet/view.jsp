<%@ include file="../init.jsp" %>

<liferay-ui:success key="contactAdded" message="contact-added/updated" />
<liferay-ui:success key="contactUpdated" message="contact-added/updated" />
<liferay-ui:success key="deleteContact" message="contact-deleted" />
<liferay-ui:success key="contactEntryUpdated" message="contact-entry-added/updated" />
<liferay-ui:success key="contactEntryAdded" message="contact-entry-added/updated" />
<liferay-ui:success key="deleteContactEntry" message="contact-entry-deleted" />

<h2>VIEW JSP</h2>

<h2>ALL REGISTERED CONTACTS - LIST</h2>

 <%
 List<Contact> contacts = ContactServiceUtil.getAllContacts();
 %>
<liferay-ui:search-container total="<%= contacts.size() %>">

  <liferay-ui:search-container-results results="<%= ListUtil.subList(contacts, searchContainer.getStart(), searchContainer.getEnd()) %>" />

<liferay-ui:search-container-row className="com.liferay.contact.management.model.Contact" modelVar="contactModel">

     <liferay-ui:search-container-column-text property="name" />

     <liferay-ui:search-container-column-text property="email" />

     <liferay-ui:search-container-column-text property="phone" />

     <liferay-ui:search-container-column-text property="address" />

     <liferay-ui:search-container-column-text property="contactId" />

</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>

<h2>ALL REGISTERED CONTACT ENTRIES - LIST</h2>

<%
List<ContactEntry> contactEntries = ContactEntryServiceUtil.getAllContactsEntries();
%>

<liferay-ui:search-container total="<%= contactEntries.size() %>">

  <liferay-ui:search-container-results results="<%= ListUtil.subList(contactEntries, searchContainer.getStart(), searchContainer.getEnd()) %>" />

<liferay-ui:search-container-row className="com.liferay.contact.management.model.ContactEntry" modelVar="contactEntryModel">

     <liferay-ui:search-container-column-text property="familyRelationship" />

     <liferay-ui:search-container-column-text property="phone" />

     <liferay-ui:search-container-column-text property="address" />

     <liferay-ui:search-container-column-text property="contactId" />

     <liferay-ui:search-container-column-text property="entryId" />

</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>

<aui:button-row cssClass="contact-buttons">

    <portlet:renderURL var="addContactURL">
        <portlet:param name="mvcRenderCommandName" value="/contact/addorupdatecontact"></portlet:param>
    </portlet:renderURL>

    <portlet:renderURL var="addContactEntryURL">
            <portlet:param name="mvcRenderCommandName" value="/contact/addorupdatecontactentry"></portlet:param>
        </portlet:renderURL>

    <aui:button onClick="<%= addContactURL.toString() %>" value="Go to Add Contact"></aui:button>

    <aui:button onClick="<%= addContactEntryURL.toString() %>" value="Go to Add Contact Entry"></aui:button>

</aui:button-row>





