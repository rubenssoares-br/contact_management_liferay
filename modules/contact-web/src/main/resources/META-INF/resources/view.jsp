<%@ include file="/init.jsp" %>

<portlet:renderURL var="addContactURL">
    <portlet:param name="mvcPath" value="/edit_contact.jsp"></portlet:param>
</portlet:renderURL>

<p>
	<b><liferay-ui:message key="contact.caption"/></b>

	<p>"lorem ipsum"</p>

	 <aui:button-row>
           <aui:button onClick="<%= addContactURL.toString() %>" value="Add Contact"></aui:button>
     </aui:button-row>
</p>