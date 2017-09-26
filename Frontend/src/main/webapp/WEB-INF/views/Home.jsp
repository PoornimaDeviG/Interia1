<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
<%--     <%@ include file="Nav.jsp"%> --%>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Home</title>
    <c:url value="/resources/Images" var="img"/>
    <c:url value="/resources/StyleSheet" var="css"/>
    <c:url value="/resources/js" var="js"/>
    <link type="text/css" rel="stylesheet" href="${css}/StyleSheet.css">
    <style>
#cart-badge {
    font-size: 12px;
    background: #f8ee2e	;
    color: black;
    margin:0px 20px 0px 20pxpx;
    padding: 0 5px;
    vertical-align:top;
}
 .badge { 
 margin-left:0px;
   padding-left: 200px; 
  padding-right: 20px; 
  -webkit-border-radius: 9px; 
  border-radius: 90px; 
 } 
</style>
     </head>
     <body>
        <div class="maincontainer">
       
            <div class="main" >
            <nav>
  <ul style="background:url(${img}/pattern-07.jpg)">
  <li><a  href="<c:url value="/About"/>" >ABOUT US</a></li>
  <li><a  href="<c:url value="/Contact"/>">CONTACT US</a></li>
  <li class="sr"><input type="text" name="search" placeholder="Search.."></li>
  <c1:if test="${pageContext.request.userPrincipal.name==null}">
  <li style="float:right"><a href="<c:url value="/user"/>">Sign Up</a></li>
  <li  style="float:right"><a href="<c:url value="/login"/>" >Login</a></li>
  </c1:if>
  <c1:if test="${pageContext.request.userPrincipal.name!=null}">
  <security:authorize access="hasRole('ROLE_ADMIN')">
  <li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
  <li style="float:right;color:#f8ee2e;font-size:18px;border:none;">Welcome ${pageContext.request.userPrincipal.name}!</li>
 </security:authorize>
 <security:authorize access="hasRole('ROLE_USER')">
<li style="float:right"><a href="<c:url value="/j_spring_security_logout" />"> Logout</a></li>
<li style="float:right">
 <a href="<c:url value="/viewcart"/>"><i class="fa fa fa-shopping-cart"></i></a>
 <lavel id="cart-badge" class="badge">${items}</lavel>
</li>
  <li style="float:right;color:#f8ee2e;font-size:18px;border:none;">Welcome ${pageContext.request.userPrincipal.name}!</li>
  </security:authorize></c1:if>
</ul>
</nav></div>
<div  style="background:url(${img}/pattern-07.jpg)">
            <img class="image" src="${img}/logo.jpg" alt="Interia" ></div>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
        <li data-target="#myCarousel" data-slide-to="5"></li>
        <li data-target="#myCarousel" data-slide-to="6"></li>
        <li data-target="#myCarousel" data-slide-to="7"></li>
         <li data-target="#myCarousel" data-slide-to="8"></li>
         <li data-target="#myCarousel" data-slide-to="9"></li>
         <li data-target="#myCarousel" data-slide-to="10"></li>
    </ol>
      <div class="nav">
        <ul>
  <li><a  href="<c:url value="/Home"/>"/>HOME</a></li>
<!--   <li> Categories</li> -->
  <c1:forEach items="${lcat}" var="cat1">
  <li><a  href="<c:url value="/dispcategory/${cat1.getCid()}"/>">${cat1.getCname()}</a></li>
  
  </c1:forEach>
<!--     <li><a  href="http://localhost:8080/Frontend/Furniture" >FURNITURE</a></li> -->
<!--     <li><a  href="abtus.html" >LIGHTNING</a></li> -->
<!--     <li><a  href="abtus.html" >HOME ACCESSORIES</a></li> -->
<!--     <li><a  href="abtus.html">KITCHEN</a></li> -->
<!--     <li><a  href="abtus.html">OUT DOORS</a></li> -->
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

    <!-- Wrapper for slides -->
   <div class="carousel-inner">
      <div class="item active">
        <img src="${img}/living-room.jpg" alt="image not available" style="width:90%;height: 500px; margin-left: 75px"  >
      </div>

      
    
      <div class="item">
        <img src="${img}/home.jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
    

      <div class="item">
        <img src="${img}/living-room (2).jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
    
            <div class="item">
        <img src="${img}/living-room (1).jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
    
             <div class="item">
        <img src="${img}/img03.jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
    
             <div class="item">
        <img src="${img}/img04.jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
    
             <div class="item">
        <img src="${img}/pooja-room.jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
    
             <div class="item">
        <img src="${img}/foyer.jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
        
        <div class="item">
        <img src="${img}/Bookcase.jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
      
      <div class="item">
        <img src="${img}/study-room.jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
      <div class="item">
        <img src="${img}/living-room (3).jpg" alt="image not available" style="width:90%; height:500px; margin-left: 75px">
      </div>
    </div>
    
  </div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>
        