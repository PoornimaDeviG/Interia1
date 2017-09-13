<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<c:url value="/resources/Images" var="img"/>
<c:url value="/resources/StyleSheet" var="css"/>
<c:url value="/resources/js" var="js"/>
<link href="${css}/bootstrap.min.css">
  <meta charset="UTF-8">
  <title>Payment Form</title>
  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
  <link rel="stylesheet" href="${css}/style.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>
 var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope, $http){
$http.get("http://localhost:8080/Frontend/SendMail")
});
 </script>
 <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
 
</head>
<body>
  <div class="container">
  <div id="Checkout" class="inline">
      <h1>Pay Invoice</h1>
      <div class="card-row">
      <span class="visa"></span>
      <span class="mastercard"></span>
      <span class="amex"></span>
      <span class="discover"></span>
      </div>
      <c:url value="/payment" var="payb2"/>
      <form:form action="${payb2}" method="post" id="myForm">
          <div class="form-group">
              <label for="NameOnCard">Name on card</label>
              <input id="NameOnCard" class="form-control" type="text" maxlength="255"></input>
          </div>
          <div class="form-group">
              <label for="CreditCardNumber">Card number</label>
              <input id="CreditCardNumber" class="null card-image form-control" type="text"></input>
          </div>
          <div class="expiry-date-group form-group">
              <label for="ExpiryDate">Expiry date</label>
              <input id="ExpiryDate" class="form-control" type="text" placeholder="MM / YY" maxlength="7"></input>
          </div>
          <div class="security-code-group form-group">
              <label for="SecurityCode">Security code</label>
              <div class="input-container" >
                  <input id="SecurityCode" class="form-control" type="text" ></input>
                  <i id="cvc" class="fa fa-question-circle"></i>
              </div>
              <div class="cvc-preview-container two-card hide">
                  <div class="amex-cvc-preview"></div>
                  <div class="visa-mc-dis-cvc-preview"></div>
              </div>
          </div>
          <div class="zip-code-group form-group">
              <label for="ZIPCode">ZIP/Postal code</label>
              <div class="input-container">
                  <input id="ZIPCode" class="form-control" type="text" maxlength="10"></input>
                  <a tabindex="0" role="button" data-toggle="popover" data-trigger="focus" data-placement="left" data-content="Enter the ZIP/Postal code for your credit card billing address."><i class="fa fa-question-circle"></i></a>
              </div>
          </div>
          
        
    
        <div class="container">
<!--    <div class="panel-group"> -->
    <div class="panel panel-default"  style= width:150px>
      <div class="panel-heading" style= width:150px>
        <h6 class="panel-title" style= width:150px>
          <a data-toggle="collapse" href="#collapse1">  <input type="submit" class="btn btn-primary" value="Pay"/></a>
<!--               <button id="PayButton" class="btn btn-block btn-success submit-button" type="submit"> -->
<!--               <span class="submit-button-lock"></span> -->
<!--               <span class="align-middle"> -->
             
<!--               </span> -->
               </h6>
      </div>
      
      <div id="collapse1" class="panel-collapse collapse">
      Please enter your otp:
        <center><div class="panel-body"><input type="text" ng-app="myApp" ng-controller="myCtrl" name="otp"/></div></center>
<!--         <div class="panel-footer">Panel Footer</div> -->
<%-- <form action="/Thankyou" method="post"> --%>
<input type="submit" value="done"/>
      </div>
    </div>
  </div>
</div>
</div>
</form:form>
          </button>
         
      
  </div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>

    <script src="${js}/index.js"></script>

</body>
</html>
