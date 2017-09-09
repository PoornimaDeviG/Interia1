<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
 
<title></title>
<c:url value="/resources/Images" var="img"/>
    <c:url value="/resources/StyleSheet" var="css"/>
    <c:url value="/resources/js" var="js"/>
    <link type="text/css" rel="stylesheet" href="${css}/StyleSheet.css">

</head>

<div class="maincontainer">

            <div class="main" style="background:url(${img}/pattern-07.jpg)">
            <nav>
 <ul style="background:url(${img}/pattern-07.jpg)">
  <li><a  href="abtus.html" >ABOUT US</a></li>
  <li><a  href="cntact1.html">CONTACT US</a></li>
  <li class="sr"><input type="text" name="search" placeholder="Search.."></li>
  <c1:if test="${pageContext.request.userPrincipal.name==null}">
  <li style="float:right"><a href="<c:url value="/user"/>">Sign Up</a></li>
  <li  style="float:right"><a href="<c:url value="/login"/>" >Login</a></li>
  </c1:if>
  <c1:if test="${pageContext.request.userPrincipal.name!=null}">
  <li  style="float:right"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
  </c1:if>
</ul>
</nav>
<div style="background:url(${img}/pattern-07.jpg)" >
            <img class="image" src="${img}/logo.jpg" alt="Interia" ></div></div>
<div class="nav">
        <ul >
  <li><a  href="<c:url value="/Home"/>">HOME</a></li>
    <li><a  href="<c:url value="/Furniture"/>">FURNITURE</a></li>
    <li><a  href="abtus.html">LIGHTNING</a></li>
    <li><a  href="abtus.html">HOME ACCESSORIES</a></li>
    <li><a  href="abtus.html">KITCHEN</a></li>
    <li><a  href="abtus.html">OUT DOORS</a></li>
    <c1:if test="${pageContext.request.userPrincipal.name!=null}">
    <security:authorize access="hasRole('ROLE_ADMIN')">
  <li id="dropdown">
    <a href="javascript:void(0)" id="dropbtn">ADMIN</a>
    <div id="dropdown-content">
    <a  href="<c:url value="/category"/>">CATEGORY INFO</a> 
     <a  href="<c:url value="/supplier"/>">SUPPLIER INFO</a>
     <a  href="<c:url value="/product"/>">PRODUCT INFO</a>  
    </div>
  </li>
 </security:authorize></c1:if>
</ul>
</div>

</div>
<br><br>
</body>
</html>
