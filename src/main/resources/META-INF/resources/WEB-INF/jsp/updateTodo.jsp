<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Update Todo</title>

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">
</head>

<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">

		<form:form method="post" modelAttribute="todo">

			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>
			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="done" />
			<form:input type="hidden" path="id" />
			<input type="submit" value="Update Todo" class="btn btn-success" />

		</form:form>

		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		<script
			src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			$('#targetDate').datepicker({
				format : 'yyyy-mm-dd'
			});
		</script>
	</div>
</body>

</html>