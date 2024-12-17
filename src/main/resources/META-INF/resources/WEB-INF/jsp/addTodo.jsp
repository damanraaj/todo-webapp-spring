<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Add Todo</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<div>
			Welcome ${name} <a href="list-todos">Your Todos</a> <a href="logout">
				Logout</a>
		</div>
		<hr>
		<h1>Add a Todo</h1>
		<form:form method="post" modelAttribute="todo">
			<form:input type="text" path="description" placeholder="description"
				required="required" />
			<form:errors path="description" cssClass="text-warning" />
			<form:input type="date" path="targetDate" />
			<form:input type="hidden" path="done" />
			<form:input type="hidden" path="id" />
			<input type="submit" value="Add Todo" class="btn btn-success" />
		</form:form>
	</div>
</body>

</html>