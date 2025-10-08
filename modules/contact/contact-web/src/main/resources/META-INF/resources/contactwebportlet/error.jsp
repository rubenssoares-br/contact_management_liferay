<%@ include file="../init.jsp" %>

<h2>ERROR JSP</h2>

<p>Your requested failed</p>

<portlet:renderURL var="addContactURL">
        <portlet:param name="mvcRenderCommandName" value="/contact/addorupdatecontact"></portlet:param>
</portlet:renderURL>

<aui:button onClick="<%= addContactURL.toString() %>" value="Return to Contact Page"></aui:button>

<portlet:renderURL var="addContactEntryURL">
        <portlet:param name="mvcRenderCommandName" value="/contact/addorupdatecontactentry"></portlet:param>
</portlet:renderURL>

<aui:button onClick="<%= addContactEntryURL.toString() %>" value="Return to Contact Entry Page"></aui:button>

<portlet:renderURL var="addContactEntryURL">
        <portlet:param name="mvcRenderCommandName" value="/contact/addorupdatecontactentry"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/contactwebportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
   <aui:button onClick="<%= viewURL.toString() %>" value="Return to Home Page"></aui:button>
</aui:button-row>