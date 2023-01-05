<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Relationship Management</title>
<link type="text/css"
rel="stylesheet"
href= "${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>CRM -Customer Relation Manager</h2>
</div>
</div>

<div id="container">
<div id="content">
<!-- Input Button -->
<input type="button" value="AddCustomer"
 onclick="window.location.href='showAddForm';return false;"
 class="add-button">
<table>
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var="temp" items="${customerDetail}">

<c:url var="updateLink" value="/customer/updateCustomer">
<c:param name="customerId" value="${temp.id}"></c:param>
</c:url>
<c:url var="deleteLink" value="/customer/deleteCustomer">
<c:param name="customerId" value="${temp.id}"></c:param>
</c:url>
<tr>

<td>${temp.id}</td>
<td>${temp.firstName}</td>
<td>${temp.lastName}</td>
<td>${temp.email}</td>
<td><a href="${updateLink}">Update</a>|<a href="${deleteLink}">Delete</a></td>


</c:forEach>
</tr>

</table>
</div>
</div>

</body>
</html>