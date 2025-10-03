<%@ include file="../init.jsp" %>

<%
long entryId = ParamUtil.getLong(renderRequest, "entryId");

ContactEntry contactEntrymodel = null;

if (contactEntrymodel > 0) {
    contactEntrymodel = ContactEntryLocalServiceUtil.getContactEntry(entryId);
}
%>

<p>EDIT CONTACTENTRY JSP</p>

<p>FORM TO ADD OR UPDATE CONTACTENTRY</p>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/contactwebportlet/view.jsp"></portlet:param>
</portlet:renderURL>

 <aui:button-row>
    <aui:button onClick="<%= viewURL.toString() %>" value="Cancel" ></aui:button>
  </aui:button-row>