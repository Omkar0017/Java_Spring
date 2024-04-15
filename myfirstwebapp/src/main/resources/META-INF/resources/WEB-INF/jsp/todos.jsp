
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title> Add new Todo </title>
  </head>

  <body>
    <div class="container">
    <h1> Enter Todo details </h1>
    <form:form method="POST" modelAttribute="todo">
      Description : <form:input type="text"  path="description" required="required"/>
      <input type="submit" class="btn btn-success"/>
      <br>
      <form:errors   path="description" cssClass="text-warning" />
      <form:input type="hidden"  path="id" required="required"/>
      <form:input type="hidden"  path="done" required="required"/>

    </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>