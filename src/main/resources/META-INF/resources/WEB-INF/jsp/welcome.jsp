<html>

<head>
<title>Welcome</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<%@ include file="common/navigation.jspf"%>

	<div class="container">
		<h1>Welcome ${name}</h1>
		<a href="/list-todos">Manage Todos</a>
	</div>
</body>

</html>