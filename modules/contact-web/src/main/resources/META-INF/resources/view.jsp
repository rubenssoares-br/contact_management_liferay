<%@ include file="/init.jsp" %>

<portlet:renderURL var="addContactURL">
    <portlet:param name="mvcPath" value="/edit_contact.jsp"></portlet:param>
</portlet:renderURL>

<p>
	<b><liferay-ui:message key="contact.caption"/></b>

	<p>"lorem ipsum in view.jsp"</p>

	<jsp:useBean id="entries" class="java.util.ArrayList" scope="request"/>

	<liferay-ui:search-container>
	    <liferay-ui:search-container-results results="<%= entries %>" />

	    <liferay-ui:search-container-row
	        className="com.liferay.contact.management.model.Entry"
	        modelVar="entry"
	    >
	        <liferay-ui:search-container-column-text property="_name" />

	        <liferay-ui:search-container-column-text property="_email" />

	        <liferay-ui:search-container-column-text property="_phone" />

	        <liferay-ui:search-container-column-text property="_address" />
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator />
    </liferay-ui:search-container>

	 <aui:button-row>
           <aui:button onClick="<%= addContactURL.toString() %>" value="Add Contact"></aui:button>
     </aui:button-row>
</p>