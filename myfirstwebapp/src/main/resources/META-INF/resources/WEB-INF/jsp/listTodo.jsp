
  <%@ include file="common/header.jspf"%>
  <%@ include file="common/navigation.jspf"%>
  <div class="container">

        <div> Welcome to your Todo Page ${name}</div>
        <hr>
        <h1> <div> Your Todos are </div> </h1>
        <table class="table">
            <thead>
              <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done</th>
                <th>Delete Todo </th>
                <th>Update Todo </th>
              <tr>
            </thead>
            <tbody>
                <c:forEach items="${todoList}" var="todo">
                  <tr>
                    <td> ${todo.id}</td>
                    <td> ${todo.description}</td>
                    <td> ${todo.targetDate}</td>
                    <td> ${todo.done}</td>
                    <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete ${todo.id}</a> </td>
                    <td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update ${todo.id}</a> </td>
                  </tr>
                </c:forEach>
            </tbody>
      </table>

      <a href="add-todo" class="btn btn-success"> Add new Todo</a>
  </div>

  <%@ include file="common/footer.jspf"%>

