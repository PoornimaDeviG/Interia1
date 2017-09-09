<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Product Form</title>
<%@ include file="Nav.jsp"%>
<c:url value="/resources/StyleSheet" var="css"/>
<link type="text/css" rel="stylesheet" href="${css}/StyleSheet.css">
<style>
.border table,.border td,.border th{
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
<table>
<c:url value="/addpro" var="pro"/>
<form:form action="${pro}" method="post" commandName="product" enctype="multipart/form-data">
<tr><td>Product ID:</td><td><form:input type="text" path="pid" name="pID"/></td></tr>
<tr><td>Product Name:</td><td><form:input type="text" path="pname" name="pname"/></td></tr>
<tr><td>Product Discription:</td><td><form:textarea name="discription" rows="3" cols="21" path="pdiscription"/></textarea></td></tr>
<tr><td>Quantity:</td><td><form:input type="number" path="pquantity" name="quantity"/></td></tr>
<tr><td>Price:</td><td><form:input type="number" path="pprice" name="price"/></td></tr>
<tr><td>Category Id<td>
<form:select path="category.cid">
<c1:forEach items="${categories}" var="cat">
<option value="${cat.getCid()}" label="${cat.getCname()}" ></option>
</c1:forEach>
</form:select></td></tr>
<tr><td>Supplier Id<td><form:select path="supplier.sid">
<c1:forEach items="${suppliers}" var="sup">
<option value="${sup.getSid()}" label="${sup.getSname()}" ></option>
</c1:forEach>
</form:select></td></tr>
<tr><td><form:input path="pimg" type="file" name="image" value="Upload file"/></td></tr>
<tr><td><input type="submit" value="Submit" name="submit"/>
<input type="reset" value="Reset" name="reset"/></td></tr>
</form:form>
</table>
<div class="border">
<table>
<tr>
<th>Product Image</th>
<th>ProductId</th>
<th>ProductName</th>
<th>Description</th>
<th>Quantity</th>
<th>Price</th>
<th>Category Id</th>
<th>Supplier Id</th>
<th>Edit/Delete</th>
</tr>
<c1:forEach items="${products}" var="pro">
<tr>
<td><img src="<c:url value="/resources/Images/${pro.getPid()}.jpg"/>" style="width:100px; height:100px; margin-left:15px"></td>
<td>${pro.getPid()}</td>
<td>${pro.getPname()}</td>
<td>${pro.getPdiscription()}</td>
<td>${pro.getPquantity()}</td>
<td>${pro.getPprice()}</td>
<td>${pro.getCategory().getCid()}</td>
<td>${pro.getSupplier().getSid()}</td>
<td><a href="<c:url value="/editProduct/${pro.getPid()}"/>" class="button">edit</a>
<a href="<c:url value="/deleteProduct/${pro.getPid()}"/>" class="button">delete</a></td>
</tr>
</c1:forEach>
</table>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>