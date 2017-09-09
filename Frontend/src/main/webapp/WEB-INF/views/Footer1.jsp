 <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   <c:url value="/resources/Images" var="img"/>
    <c:url value="/resources/StyleSheet" var="css"/>
    <c:url value="/resources/js" var="js"/>
    <link rel="icon" href="../../../../favicon.ico">

    <title>Sticky Footer Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../../../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/sticky-footer.css" rel="stylesheet">
  </head>

  <body>

    <!-- Begin page content -->
    <div class="container">
      <div class="mt-1">
        <h1>Sticky footer</h1>
      </div>
      <p class="lead">Pin a fixed-height footer to the bottom of the viewport in desktop browsers with this custom HTML and CSS.</p>
      <p>Use <a href="../sticky-footer-navbar">the sticky footer with a fixed navbar</a> if need be, too.</p>
    </div>

    <footer class="footer">
      <div class="container">
        <span class="text-muted">Place sticky footer content here.</span>
      </div>
    </footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
