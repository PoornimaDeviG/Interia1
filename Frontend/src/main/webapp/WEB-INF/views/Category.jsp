<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Category Form</title>
<%@ include file="Nav.jsp"%>
<c:url value="/resources/StyleSheet" var="css"/>
<link type="text/css" rel="stylesheet" href="${css}/StyleSheet.css">
<style>
.border table,.border td{
border-collapse: collapse;
border:1px solid black;
}
body{position: relative; 
   min-height: 100%; 
      max-width:  100%; 
   background: url(${img}/blur1.png) ; 
    background-repeat: no-repeat;
     background-size: cover; 
   overflow-x: hidden;};
</style>
</head>
<body>
<c:url value="/addcat" var="cat"/>
<form:form action="${cat}" method="post" commandName="category">
<table>
<tr>
<td>Category ID:</td>
<td><form:input type="text" path="cid" name="category_id"/></td></tr>
<tr>
<td>Category Name:</td>
<td><form:input type="text" path="cname" name="c_name"/></td></tr>
<tr><td></td>
<td><input type="submit"  name="submit"/>
<input type="reset"  value="cancel"/></td></tr>
</table>
</form:form>
<br><br><br><br>
<div class="border">
<table>
<c1:forEach items="${categories}" var="cat">
<tr>
<td>${cat.getCid()}</td>
<td>${cat.getCname()}</td>
<td><a href="<c:url value="/editCategory/${cat.getCid()}"/>" class="button">edit</a>
<a href="<c:url value="/deleteCategory/${cat.getCid()}"/>" class="button">delete</a></td>
</tr></c1:forEach>
</table>
</div>

</body>
</html>