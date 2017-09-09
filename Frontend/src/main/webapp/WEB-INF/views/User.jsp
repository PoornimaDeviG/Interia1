<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration page</title>

<%@ include file="Nav.jsp"%>
<c:url value="/resources/Images" var="img"/>
<c:url value="/resources/js" var="js"/>
<c:url value="/resources/StyleSheet" var="css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

table{
font-size:20px;}
input{
font-size:15px;
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
<body class="maincontainer">
<div>
<c:url value="/adduser" var="user"/>
<fieldset style="width:380px ;height:400px">
<form:form action="${user}" method="post" commandName="user"  >
<table >
<tr><td>User Id:</td>
<td><form:input type="text" name="uid" path="uid" /></td>
</tr>
<tr><td>User Name:</td>
<td><form:input type="text" name="name" path="uname" /></td>
</tr>
<tr>
<td>User Address:</td>
<td> <form:textarea name="address" rows="4" cols="24" path="uaddress"/></td></tr>
<tr><td>Phone Number:</td><td><form:input type="tel" name="usrtel" path="uph"/></td></tr>
    <tr><td>Email Address:</td><td><form:input type="text" name="email" path="uemail"/></td></tr>
<tr><td>Password</td><td><form:input type="password" name="pwd" path="upwd"/></td></tr>
<tr><td>Billing_Id:</td>
<td><form:input type="text" path="billing.Bill_Id" name="bid" /></td>
</tr>
<tr><td>House Number:</td>
<td><form:input type="text"  path="billing.House_No" name="hn"/></td>
</tr>
<tr><td>Country:</td><td><form:input type="text" path="billing.Country" name="country"/></td></tr>
<tr><td>City:</td><td><form:input type="text" path="billing.City" name="city"/></td></tr>
<tr><td>Pincode:</td><td><form:input type="text" path="billing.PinCode" name="pin" /></td></tr>

<tr><td>Phone Number:</td><td><form:input type="tel" path="billing.Mobile_No" name="usrtel"/></td></tr>
<tr><td><td><input type="submit" value="Submit" name="submit"/>
<input type="reset" value="Reset" name="reset"/></td></tr>
</table>
</form:form>
</fieldset>
</div>
<%-- <%@ include file="Footer.jsp"%> --%>
</body>
</html>