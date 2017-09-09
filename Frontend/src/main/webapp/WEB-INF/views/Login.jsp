<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="bg">
<head>
<%@ include file="Nav.jsp"%>
<title>Login page</title>
<c:url value="/resources/Images" var="img"/>
    <c:url value="/resources/StyleSheet" var="css"/>
    <c:url value="/resources/js" var="js"/>
    <link type="text/css" rel="stylesheet" href="${css}/StyleSheet.css">
<style>

@media screen {
.bg{
  position: relative;
  min-height: 100%;
  max-width:  100%;
   background: url(${img}/blur.jpg) ;
   background-repeat: no-repeat;
    background-size: cover;
  overflow-x: hidden;
}

}

input[type=text],[type=password] {
    
    padding: 12px 20px;
    margin: 8px 15px;
    box-sizing: border-box;
}
input[type=text]:focus {
    background-color: lightblue;
}
input[type=password]:focus {
    background-color: lightblue;
}
fieldset{
margin-left:500px;
width:250px;
height:300px;
}
</style>
</head>
<body>
<c:url value="/j_spring_security_check" var="log"/>
<fieldset>
 <form action="${log}" method="post" >
  <label for="uname">Username</label>
  <input type="text" name="j_username"  placeholder="enter user name"><br>
  <label for="pwd">Password</label>
  <input type="password"  name="j_password"  placeholder="enter password">
<div style="padding-left:50px"><br>
<input type="submit" name="submit" >
<input type="reset" name="reset" value="reset">
</div>
</form><br><br>
<a href="forgot.html">forgot password</a>
</fieldset>
</body>
</html>
