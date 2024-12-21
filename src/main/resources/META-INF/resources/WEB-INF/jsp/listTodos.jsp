<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Your Todos List</title>
</head>

<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Done</th>
					<th>Target Date</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todo}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.done}</td>
						<td>${todo.targetDate}</td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-warning">Update</a></td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-primary">Add Todo</a>
	</div>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>

</html>