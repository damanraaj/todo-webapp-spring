<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Your Todos List Page</title>
</head>

<body>
	<div>
		Welcome ${name} <a href="login">Logout</a>
	</div>
	<hr>
	<h1>Your Todos are:</h1>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>description</th>
				<th>done</th>
				<th>targetDate</th>
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
</body>

</html>