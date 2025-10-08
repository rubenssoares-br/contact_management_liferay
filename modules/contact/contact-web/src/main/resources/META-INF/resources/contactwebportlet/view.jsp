<%@ include file="../init.jsp" %>


<h2>VIEW JSP</h2>

<h2>ALL REGISTERED CONTACTS - LIST</h2>

 <%
 int totalContacts = ContactLocalServiceUtil.getContactsCount();
 %>
<liferay-ui:search-container total="<%= totalContacts %>">
    <%
    List<com.liferay.contact.management.model.Contact> contacts = com.liferay.contact.management.service.ContactLocalServiceUtil.getContacts(searchContainer.getStart(), searchContainer.getEnd());
    %>

<liferay-ui:search-container-results  results="<%= contacts %>"/>

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
 int totalContactEntries = ContactEntryLocalServiceUtil.getContactEntriesCount();
%>

<liferay-ui:search-container total="<%= totalContactEntries %>">
    <%
    List<com.liferay.contact.management.model.ContactEntry> contactEntries = com.liferay.contact.management.service.ContactEntryLocalServiceUtil.getContactEntries(searchContainer.getStart(), searchContainer.getEnd());
    %>

<liferay-ui:search-container-results  results="<%= contactEntries %>"/>

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





