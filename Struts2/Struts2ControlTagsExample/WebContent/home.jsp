<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
</head>
<body>
<h4>Struts 2 Control Tags Example</h4>

<!-- if-elseif-else example -->
<s:if test="emp.id < 100">
	<strong>User id is under 100.</strong>
</s:if>
<s:elseif test="emp.role=='Developer'">
	<strong>User is Developer and id is greater than or equal to 100.</strong>
</s:elseif>
<s:else>
	<strong>User is NOT Developer and id is greater than or equal to 100.</strong>
</s:else>
<br><br>
<!-- iterator tag example -->
Cities are:<br>
<s:iterator value="emp.citiesList" begin="0" step="1" 
				var="citiesIterator" status="iteratorStatus">
<s:if test="#iteratorStatus.first">First City = <s:property/><br></s:if>
<s:elseif test="#iteratorStatus.last">Last City = <s:property/></s:elseif>
<s:else>City <s:property value="#iteratorStatus.count"/> = <s:property/><br></s:else>
</s:iterator>
<br><br>
Properties Map table is:
<table border="1" cellspacing="0" cellpadding="1">
<tr>
  <th>Name</th><th>Value</th>
</tr>
<s:iterator value="emp.propertiesMap" status="maprowStatus">
  <tr>
    <s:if test="#maprowStatus.odd == true">
      <td style="background: grey"><s:property value="key"/></td>
      <td style="background: grey"><s:property value="value"/></td>
    </s:if>
    <s:else>
      <td><s:property value="key"/></td>
      <td><s:property value="value"/></td>
    </s:else>
  </tr>
</s:iterator>
</table>
<br><br>

Appending Cities and Countries List:<br>
<s:append var="appendedList">
	<s:param value="emp.citiesList"></s:param>
	<s:param value="emp.countryList"></s:param>
</s:append>

<s:iterator value="#appendedList" status="myListStatus">
	<s:property value="#myListStatus.count"/>. <s:property/><br>
</s:iterator>
<br><br>

Merging Cities and Countries List:<br>
<s:merge var="mergedList">
	<s:param value="emp.citiesList"></s:param>
	<s:param value="emp.countryList"></s:param>
</s:merge>
<s:iterator value="#mergedList" status="myListStatus">
	<s:property value="#myListStatus.count"/>. <s:property/><br>
</s:iterator>
<br><br>

Sorting Cities List:<br>
<s:bean name="com.journaldev.struts2.util.StringComparator" var="myComparator"></s:bean>
<s:sort comparator="#myComparator" source="emp.citiesList">
<s:iterator status="myListStatus">
	<s:property value="#myListStatus.count"/>. <s:property/><br>
</s:iterator>
</s:sort>
<br><br>

Excluding USA from the countries list:<br>
<s:subset source="emp.countryList" decider="countryDecider">
<s:iterator>
<s:property/><br>
</s:iterator>
</s:subset>
<br><br>

Generate iterator example:<br>
<s:generator val="%{'apple|banana|orange'}" separator="|" var="fruitsIterator" />
 <s:iterator value="#fruitsIterator">
     <s:property /><br/>
 </s:iterator>

</body>
</html>