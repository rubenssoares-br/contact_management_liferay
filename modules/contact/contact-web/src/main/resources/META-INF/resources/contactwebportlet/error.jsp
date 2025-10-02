<%@ include file="../init.jsp" %>

<h2>ERROR JSP</h2>

<p>Your requested failed</p>

<portlet:renderURL var="addContactURL">
        <portlet:param name="mvcRenderCommandName" value="/contact/addorupdatecontact"></portlet:param>
</portlet:renderURL>

<aui:button onClick="<%= addContactURL.toString() %>" value="Return to Contact Page"></aui:button>