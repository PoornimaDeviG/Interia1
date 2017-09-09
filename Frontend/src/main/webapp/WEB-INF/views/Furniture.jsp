<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Furniture</title>
<%@ include file="Nav.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:url value="/resources/Images" var="img"/>
    <c:url value="/resources/StyleSheet" var="css1"/>
    <c:url value="/resources/js" var="js"/>
    <link type="text/css" rel="stylesheet" href="${css1}/Products_StyleSheet.css">
</head>
<body>
<c1:forEach var="pro" items="${products}">
<div class="responsive">
  <div class="gallery">
    <a target="_blank" href="${img}/${pro.getPid()}.jpg">
      <img src="${img}/${pro.getPid()}.jpg" alt="Image not found" width="313" height="277"  >
    </a>
    <div class="desc">
    <h3>${pro.getPname()}&nbsp;&nbsp;&nbsp;&nbsp;${pro.getPprice()}</h3>
   <a href="<c:url value="/addtocart/${pro.getPid()}"/>">Add to cart</a>
   <a href="c:url value="">view</a> 
    </div>
  </div>
</div>
</c1:forEach><br><br><br><br>
<%-- <%@ include file="Footer.jsp"%> --%>
</body>
</html>
