<%@ include file="../init.jsp" %>

<%
long contactId = Long.valueOf((Long) renderRequest.getAttribute("contactId"));
%>

<p>VIEW JSP</p>

<p>ALL REGISTERED CONTACTS - LIST</p>

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

<aui:button-row cssClass="contact-buttons">

    <portlet:renderURL var="addContactURL">
        <portlet:param name="mvcPath" value="/contactwebportlet/edit_contact.jsp"></portlet:param>
        <portlet:param name="contactId"
            value="<%=String.valueOf(contactId)%>" />
    </portlet:renderURL>

    <aui:button onClick="<%= addContactURL.toString() %>" value="Go to Add Contact"></aui:button>

</aui:button-row>





