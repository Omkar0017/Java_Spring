    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title> Todo Page </title>
</head

<body>

  <div> Welcome to your Todo Page ${name}</div>
  <hr>
  <h1> <div> Your Todos are </div> </h1>
  <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Done</th>
        <tr>
      </thead>
      <tbody>
          <c:forEach items="${todoList}" var="todo">
            <tr>
              <td> ${todo.id}</td>
              <td> ${todo.description}</td>
              <td> ${todo.targetDate}</td>
              <td> ${todo.done}</td>
            </tr>
          </c:forEach>
      </tbody>
</table>
</body>
</html>
