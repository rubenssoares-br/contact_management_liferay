<%@ include file="../init.jsp" %>

<%
long entryId = ParamUtil.getLong(renderRequest, "entryId");

ContactEntry contactEntrymodel = null;

if (contactEntrymodel != null) {
    contactEntrymodel = ContactEntryLocalServiceUtil.getContactEntry(entryId);
}
%>

<h2>EDIT CONTACTENTRY JSP</h2>

<h2>FORM TO ADD OR UPDATE CONTACTENTRY</h2>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/contactwebportlet/view.jsp"></portlet:param>
</portlet:renderURL>

 <aui:button-row>
    <aui:button onClick="<%= viewURL.toString() %>" value="Cancel" ></aui:button>
  </aui:button-row>

 <portlet:actionURL name="/contact/addorupdatecontactentry" var="addContactEntryURL"></portlet:actionURL>

 <aui:form action="<%= addContactEntryURL %>" name="<portlet:namespace />fm">

 <aui:model-context bean="<%= contactEntrymodel %>" model="<%= com.liferay.contact.management.model.ContactEntry.class %>" />

         <aui:fieldset>

             <aui:input name="familyRelationship"></aui:input>
             <aui:input name="phone"></aui:input>
             <aui:input name="address"></aui:input>
             <aui:input name="contactId"></aui:input>
             <aui:input name="entryId"></aui:input>

         </aui:fieldset>

         <aui:button-row>
             <aui:button type="submit" value="Add/Update Contact"></aui:button>
             <aui:button onClick="<%= viewURL.toString() %>" value="Cancel" ></aui:button>
         </aui:button-row>
 </aui:form>


 <h2>DELETE CONTACT ENTRY</h2>

 <portlet:actionURL name="/contact/deleteContactEntry" var="deleteContactEntryURL"></portlet:actionURL>

 <aui:form action="<%= deleteContactEntryURL %>" name="<portlet:namespace />fm">

 <aui:model-context bean="<%= contactEntrymodel %>" model="<%= com.liferay.contact.management.model.ContactEntry.class %>" />

       <aui:input name="entryId"></aui:input>

       <aui:button-row>
          <aui:button type="submit" value="Delete Contact Entry"></aui:button>
       </aui:button-row>
 </aui:form>