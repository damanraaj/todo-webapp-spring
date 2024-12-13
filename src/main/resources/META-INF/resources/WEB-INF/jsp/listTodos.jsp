<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>Your Todos List</title>
	</head>

	<body>
		<div class="container">
			<div>
				Welcome ${name} <a href="logout"> Logout</a>
			</div>
			<hr>
			<h1>Your Todos are:</h1>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Description</th>
						<th>Done</th>
						<th>Target Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todo}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.done}</td>
							<td>${todo.targetDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-primary">Add Todo</a>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>

</html>