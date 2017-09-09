<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Supplier Form</title>
<%@ include file="Nav.jsp"%>
<c:url value="/resources/StyleSheet" var="css"/>
<link type="text/css" rel="stylesheet" href="${css}/StyleSheet.css">
<style>
body{position: relative; 
   min-height: 100%; 
      max-width:  100%; 
   background: url(${img}/blur1.png) ; 
    background-repeat: no-repeat;
     background-size: cover; 
   overflow-x: hidden;};
.border table,.border td{
border-collapse: collapse;
border:2px solid black;
}</style>
</head>
<body>
<table>
<c:url value="/addsup" var="sup"/>
<form:form action="${sup}" method="post" commandName="supplier">
<tr><td>Supplier ID:</td><td><form:input type="text" path="sid" name="sID"/></td></tr>
<tr><td>Supplier Name:</td><td><form:input type="text" path="sname" name="sname"/></td></tr>
<tr><td>Supplier Address:</td><td><form:textarea name="address" path="saddress" rows="5" cols="21"/></td></tr>
<tr><td>Supplier Mobile No:</td><td><form:input type="tel" name="mobile"  path="sph" pattern=".{10-12}" /></td></tr>
<tr><td><input type="submit" value="Submit" name="submit"/>
<input type="reset" value="Reset" name="reset"/></td></tr>
</form:form>
</table><br><br>
<div class="border">
<table border="1px solid black"]>
<tr><th>Supplier Id</th>
<th> Name</th>
<th> Address</th>
<th> Phone Number</th>
<th>Edit/Delete</th>
</tr>
<c1:forEach items="${suppliers}" var="sup">

<tr>
<td>${sup.getSid()}</td>
<td>${sup.getSname()}</td>
<td>${sup.getSaddress()}</td>
<td>${sup.getSph()}</td>
<td><a href="<c:url value="/editsupplier/${sup.getSid()}"/>" class="button">edit</a>
<a href="<c:url value="/deletesupplier/${sup.getSid()}"/>" class="button">delete</a></td>
</tr></c1:forEach>
</table>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>